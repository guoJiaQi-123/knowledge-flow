from scapy.all import *
import random
import time

from scapy.layers.dhcp import DHCP, BOOTP
from scapy.layers.inet import IP, UDP
from scapy.layers.l2 import Ether


def build_dns_option(dns_servers):
    """
    手动构建 DNS 服务器 DHCP 选项的字节串
    """
    option_code = 6  # domain_name_server 的 DHCP 选项代码
    option_data = b''.join([socket.inet_aton(server) for server in dns_servers.split(',')])
    option_length = len(option_data) + 1  # 长度包括选项代码本身
    return bytes([option_code]) + bytes([option_length]) + option_data


def respond_to_dhcp_discover(pkt):
    if DHCP in pkt and pkt[DHCP].options[0][1] == 1:
        client_mac = pkt[Ether].src
        print(f"\n发现discover请求,mac地址为：{client_mac}")
        client_ip = "192.168.1." + str(random.randint(100, 200))  # 随机分配ip给客户端
        global clien_t_ip  # 定义全局变量存client的ip
        clien_t_ip = client_ip
        dns_option = build_dns_option("8.8.8.8,8.8.4.4")  # 构建 DNS 服务器 DHCP 选项的字节串

        dhcp_offer = Ether(src=get_if_hwaddr(conf.iface), dst=client_mac) / \
                     IP(src="192.168.1.1", dst="255.255.255.255") / \
                     UDP(sport=67, dport=68) / \
                     BOOTP(op=2, chaddr=client_mac, yiaddr=client_ip) / \
                     DHCP(options=[
                         ("message-type", "offer"),
                         ("server_id", "192.168.1.1"),
                         ("lease_time", 43200),
                         ("subnet_mask", "255.255.255.0"),
                         ("router", "192.168.1.1"),
                         (b'\x06' + bytes([len(dns_option)]) + dns_option),  # 添加 DNS 服务器选项
                         "end"
                     ])

        sendp(dhcp_offer, iface="WLAN", verbose=0)
        print(f"发送DHCP Offer给:客户端mac: {client_mac} 随机分配客户端IP为： {client_ip}")
        print(" 为DHCP 客户端可以提供 IP 地址中……")


def respond_to_dhcp_request(pkt):
    if DHCP in pkt and pkt[DHCP].options[0][1] == 3:
        print("发现request请求报文")
        requested_ip = pkt[DHCP].options[2][1]  #
        client_mac = pkt[Ether].src
        print(f"对方mac地址为：{client_mac}")
        server_id = pkt[DHCP].options[2][1]

        # print(f"requested_ip{requested_ip}\n")
        print(f"确认是本服务器id：{server_id}")

        if server_id == "192.168.1.1":
            dns_option = build_dns_option("8.8.8.8,8.8.4.4")  # 构建 DNS 服务器 DHCP 选项的字节串
            # print("22222222222")
            dhcp_ack = Ether(src=get_if_hwaddr(conf.iface), dst=client_mac) / \
                       IP(src="192.168.1.1", dst="255.255.255.255") / \
                       UDP(sport=67, dport=68) / \
                       BOOTP(op=2, chaddr=client_mac, yiaddr=clien_t_ip) / \
                       DHCP(options=[
                           ("message-type", "ack"),
                           ("server_id", server_id),
                           ("lease_time", 43200),
                           ("subnet_mask", "255.255.255.0"),
                           ("router", "192.168.1.1"),
                           (b'\x06' + bytes([len(dns_option)]) + dns_option),  # 手动添加 DNS 服务器选项
                           ("end")
                       ])
            # print("33333333333")
            sendp(dhcp_ack, verbose=0)
            print(f"发送DHCP ACK 确认 to {client_mac} for IP {clien_t_ip}")
            print("分配IP成功！\n\n")


if __name__ == '__main__':
    # 监听并同时响应DISCOVER和REQUEST报文
    while True:
        filter_str = "udp and (port 67 or port 68)"
        print("DHCP Server Start ... ")
        sniff(prn=lambda x: respond_to_dhcp_discover(x) or respond_to_dhcp_request(x), filter=filter_str, store=0,
              iface="WLAN")  # WLAN是网卡
