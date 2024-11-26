from scapy.all import *
import random
import time
import binascii

from scapy.layers.dhcp import BOOTP, DHCP
from scapy.layers.inet import IP, UDP
from scapy.layers.l2 import Ether


def send_dhcp_discover(interface="WLAN"):
    """
    发送DHCP DISCOVER报文
    """
    # 使用 binascii.hexlify 转换MAC地址字符串为原始字节
    mac_bytes = binascii.unhexlify("00:11:22:33:44:55".replace(':', ''))  # 这里修改客户端mac地址
    # global clien_t_mac  #定义全局变量用来存client_mac地址
    # clien_t_mac = mac_bytes
    # print(f"本地客户端mac为：{mac_bytes}")
    dhcp_discover = Ether(src=mac_bytes, dst="ff:ff:ff:ff:ff:ff") \
                    / IP(src="0.0.0.0", dst="255.255.255.255") \
                    / UDP(sport=68, dport=67) \
                    / BOOTP(chaddr=mac_bytes) \
                    / DHCP(options=[("message-type", "discover"), ("end")])
    sendp(dhcp_discover, iface=interface, verbose=0)
    print("客户端已发送discover广播请求：src=\"0.0.0.0\", dst=\"255.255.255.255\"")


def respond_to_dhcp_offer(pkt):
    """
    响应接收到的DHCP OFFER报文
    """
    if DHCP in pkt and pkt[DHCP].options[0][1] == 2:  # 检查是否为DHCP OFFER报文
        print("发现一个offer报文")
        server_id = pkt[DHCP].options[1][1]  # 服务器ID
        offered_ip = pkt[BOOTP].yiaddr  # 提供的IP地址
        client_mac = pkt[Ether].src  # 客户端MAC地址
        print(f"确认与本机mac地址相同：{client_mac}")
        print(f"客户端接收到offer响应报文:服务器ID:{server_id} offer提供的ip:{offered_ip}")
        # 使用正确的方法处理MAC地址
        mac_bytes = binascii.unhexlify("00:11:22:33:44:55".replace(':', ''))

        # 构造DHCP REQUEST报文
        dhcp_request = Ether(src=mac_bytes, dst="ff:ff:ff:ff:ff:ff") / \
                       IP(src="0.0.0.0", dst="255.255.255.255") / \
                       UDP(sport=68, dport=67) / \
                       BOOTP(chaddr=mac_bytes, yiaddr=offered_ip) / \
                       DHCP(options=[
                           ("message-type", "request"),
                           ("requested_addr", offered_ip),
                           ("server_id", server_id),
                           "end"
                       ])

        sendp(dhcp_request, verbose=0)  # 发送DHCP REQUEST报文
        print(f"向服务器发送广播(request)请求ip地址： {offered_ip}  服务器ip: {server_id}")


def ack_ack(pkt):
    if DHCP in pkt and pkt[DHCP].options[0][1] == 5:
        client_ip = pkt[BOOTP].yiaddr  # 分配给客户端的IP地址
        subnet_mask = next((opt[1] for opt in pkt[DHCP].options if opt[0] == 'subnet_mask'), None)  # 子网掩码
        router_ip = next((opt[1] for opt in pkt[DHCP].options if opt[0] == 'router'), None)  # 默认网关
        dns_servers = [opt[1] for opt in pkt[DHCP].options if opt[0] == 6]  # DNS服务器列表

        print(f"客户端接收到DHCP ACK包：")
        print(f" - 分配的IP地址: {client_ip}")
        if subnet_mask:
            print(f" - 子网掩码: {subnet_mask}")
        if router_ip:
            print(f" - 默认网关: {router_ip}")


if __name__ == '__main__':
    filter_str = "udp and (port 67 or port 68)"  # 设置过滤器，只捕获DHCP流量
    send_dhcp_discover()  # 先发送一个DHCP DISCOVER报文
    # 然后开始监听并响应OFFER报文
    sniff(prn=lambda x: respond_to_dhcp_offer(x) or ack_ack(x), filter=filter_str, store=0, iface="WLAN")
    print("....")
