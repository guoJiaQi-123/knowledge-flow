package com.dataStructure.dataStructure.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * 动态数组
 */
public class DynamicArray implements Iterable<Integer> {
    private int size = 0;     //有效元素个数
    private int capacity = 8; //容量
    private int[] array = {};  //懒加载

    /**
     * 向数组的最后位置添加元素
     *
     * @param element 待添加元素
     */
    public void addLast(int element) {
        add(size, element);
    }

    /**
     * 向数组任意位置插入元素
     *
     * @param index   索引位置
     * @param element 待插入元素
     */
    public void add(int index, int element) {
        //容量检查及扩容
        checkAndGrow();

        // 添加逻辑
        if (index >= 0 && index < size) {
            // 向后挪动, 空出待插入位置
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    /**
     * 数组扩容方法,该动态数组实现懒加载模式，
     * 并且如果数组满了，以1.5倍进行数组扩容
     */
    private void checkAndGrow() {
        //容量检查
        if (size == 0) {
            array = new int[capacity];//初始化数组长度
        } else if (size == capacity) {
            //进行1.5倍扩容
            capacity += capacity >> 1;
            //创建一个容量为之前容量1.5倍的新数组
            int[] newArray = new int[capacity];
            //将原来数组中的元素拷贝到新数组中去
            System.arraycopy(array, 0, newArray, 0, size);
            //将新数组赋给全局变量
            array = newArray;
        }
    }

    /**
     * 删除元素
     *
     * @param index 待删除元素索引
     * @return 删除元素
     */
    public int remove(int index) {
        int removedElement = array[index];
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        size--;
        return removedElement;
    }

    /**
     * 查询元素
     *
     * @param index 索引位置，在[0,size)区间内
     * @return 该索引位置的元素
     */
    public int get(int index) {
        if (index >= 0 && index < size) {
            return array[index];
        } else throw new ArrayStoreException();
    }

    /**
     * 遍历方式 1
     *
     * @param consumer 函数式接口
     */
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }

    /**
     * 遍历方法2—迭代器遍历
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Integer next() {
                return array[i++];
            }
        };
    }

    /**
     * 遍历方法3—Stream流
     *
     * @return 有效数组的流对象
     */
    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }
}
