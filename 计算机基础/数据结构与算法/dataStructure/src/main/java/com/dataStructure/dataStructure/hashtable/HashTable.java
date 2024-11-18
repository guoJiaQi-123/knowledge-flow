package com.dataStructure.dataStructure.hashtable;


/**
 * <h2>哈希表</h2>
 * <p>给每份数据分配一个编号，放入表格（数组）。</p>
 * <p>建立编号与表格索引的关系，将来就可以通过编号快速查找数据</p>
 * <ol>
 *  <li>理想情况编号当唯一，数组能容纳所有数据</li>
 *  <li>现实是不能说为了容纳所有数据造一个超大数组，编号也有可能重复</li>
 * </ol>
 * <p>
 * 解决
 * <ol>
 *     <li>有限长度的数组，以【拉链】方式存储数据</li>
 *     <li>允许编号适当重复，通过数据自身来进行区分</li>
 * </ol>
 */
public class HashTable {

    //哈希表
    Entry[] table = new Entry[16];
    // 哈希表中元素个数
    int size;
    // 负载因子
    float loadFactor = 0.75f;
    // 阈值
    int threshold = (int) (loadFactor * table.length);


    /**
     * <b>求模运算替换为位运算</b>（效率更高）<br></br>
     * - 前提：数组长度是2的 n 次方<br></br>
     * - hash % 数组长度 = hash & （数组长度 - 1）
     */

    // 根据 hash 码获取 value
    Object get(int hash, Object key) {
        int index = hash & (table.length - 1);
        if (table[index] == null) {
            return null;
        }
        Entry p = table[index];
        while (p != null) {
            if (p.key.equals(key)) {
                return p.value;
            }
            p = p.next;
        }
        return null;
    }

    //向hash表中存入新的key 和 value ,如果key重复，则更新value
    void put(int hash, Object key, Object value) {
        int index = hash & (table.length - 1);
        if (table[index] == null) {
            // 1. index 处有空位, 直接新增
            table[index] = new Entry(hash, key, value);
        } else {
            // 2. index 处无空位, 沿链表查找 有重复key更新，否则新增
            Entry p = table[index];
            while (true) {
                if (p.key.equals(key)) {
                    p.value = value;//更新逻辑
                    return;
                }
                if (p.next == null) {
                    break;
                }
                p = p.next;
            }
            p.next = new Entry(hash, key, value); //新增
        }
        size++;
        if (size > threshold) {
            //如果元素个数超过阈值，扩容哈希表
            resize();
        }
    }

    //当哈希表中元素个数超过阈值，将哈希表进行扩容，可以一定程度上保证查询效率和内存空间的平衡
    private void resize() {
        Entry[] newTable = new Entry[table.length << 1];//扩容为原来长度的一倍
        //遍历旧的哈希表，取每一个哈希表的链表头
        for (int i = 0; i < table.length; i++) {
            Entry p = table[i];
            if (p != null) {
                //拆分链表
                /*
                拆分链表，移动到新数组，拆分规律
                * 一个链表最多拆成两个链表
                * hash & table.length == 0 的一组
                * hash & table.length != 0 的一组
                                          p
                0->8->16->24->32->40->48->null
                            a
                0->16->32->48->null
                        b
                8->24->40->null
                */
                Entry a = null;
                Entry b = null;
                Entry aHead = null;
                Entry bHead = null;
                //遍历链表拆分为新哈希表中的两个链表
                while (p != null) {
                    if ((p.hash & table.length) == 0) {
                        if (a != null) {
                            a.next = p;
                        } else { //当a为空时，将此时的p赋值给aHead作为a链表头结点
                            aHead = p;
                        }
                        a = p;
                    } else if ((p.hash & table.length) != 0) {
                        if (b != null) {
                            b.next = p;
                        } else { //当a为空时，将此时的p赋值给bHead作为b链表头结点
                            bHead = p;
                        }
                        b = p;
                    }
                    p = p.next;
                }
                //将根据拆分逻辑生成的新链表加入到新哈希表中，并将链表尾部的next指针置为null
                // 规律： a 链表保持索引位置不变，b 链表索引位置+table.length
                if (a != null) {
                    a.next = null;
                    newTable[i] = aHead;
                }
                if (b != null) {
                    b.next = null;
                    newTable[i + table.length] = bHead;
                }
            }
        }
        //将成员变量table更新为扩容之后的新哈希表
        table = newTable;
        //根据扩容后的新表长度计算新的阈值并重新赋值
        threshold = (int) (table.length * loadFactor);
    }

    //根据hash码删除，返回删除的value
    Object remove(int hash, Object key) {
        int index = hash & (table.length - 1);
        if (table[index] == null) {
            return null;
        }
        Entry p = table[index];
        Entry prev = null;
        while (p != null) {
            if (p.key.equals(key)) {
                //删除
                if (prev == null) {
                    table[index] = p.next;// 链表头
                } else {// 非链表头
                    prev.next = p.next;
                }
                size--;
                return p.value;
            }
            prev = p;
            p = p.next;
        }
        return null;
    }

    Object remove(Object key) {
        int hash = hash(key);
        return remove(hash, key);
    }

    void put(Object key, Object value) {
        int hash = hash(key);
        put(hash, key, value);
    }

    Object get(Object key) {
        int hash = hash(key);
        return get(hash, key);
    }

    /**
     * 根据对象的hashcode方法获取 hash码
     *
     * @return key根据hashcode方法获取的 hash 码
     */
    private static int hash(Object key) {
        return key.hashCode();
    }

    // string.hashCode()
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(s.hashCode());
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hash = (hash << 5) - hash + c;
        }
        System.out.println(hash);

    }

}

//节点类
class Entry {
    int hash; // 哈希码
    Object key; // 键
    Object value; // 值
    Entry next;

    public Entry(int hash, Object key, Object value) {
        this.hash = hash;
        this.key = key;
        this.value = value;
    }
}