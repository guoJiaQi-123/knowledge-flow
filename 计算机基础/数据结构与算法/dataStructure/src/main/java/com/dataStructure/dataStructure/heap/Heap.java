package com.dataStructure.dataStructure.heap;

/**
 * 自动扩容 大小堆
 */
public class Heap {

    int[] array;
    int size;
    boolean max;

    public int getSize() {
        return size;
    }

    public Heap(int capacity, Boolean max) {
        array = new int[capacity];
        this.max = max;
    }

    /**
     * 如果传入一个普通数组，要执行建堆操作，将当前数组转换为堆数组
     */
    public Heap(int[] array, Boolean max) {
        this.array = array;
        this.size = array.length;
        this.max = max;
        heapify();
    }

    /**
     * 返回堆顶元素
     */
    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        return array[0];
    }

    /**
     * 删除堆顶元素
     */
    public Integer poll() {
        if (isEmpty()) {
            return null;
        }
        /*
                   1.先记录当前堆顶元素，方便返回结果值
                   2.将堆顶元素与堆中最后一个元素交换
                   3.删除最后一个元素
                   4.将推顶元素进行下潜down操作
         */
        int top = array[0];
        swap(0, size - 1);
        size--;
        down(0);
        return top;
    }

    /**
     * 删除指定索引位置的元素
     */
    public Integer poll(int index) {
        if (isEmpty()) {
            return null;
        }
        int deleted = array[index];
        swap(index, size - 1);
        size--;
        down(index);
        return deleted;
    }

    /**
     * 替换堆顶元素
     */
    public boolean replace(int replaced) {
        if (isEmpty()) {
            return false;
        }
        array[0] = replaced;
        down(0);
        return true;
    }

    /**
     * 向推中添加元素
     */
    public boolean offer(int offered) {
        if (isFull()) {
            //扩容
            grow();
        }
        /*
                   1.判断推是否已满
                   2.调用上浮up方法，将待添加元素加入到堆中合适位置
                   3.堆元素个数size ＋ 1
         */
        up(offered, size);
        size++;
        return true;
    }

    /**
     * 扩容
     */
    private void grow() {
        //新建堆容量         原来的1.5倍
        int newCapacity = size + (size >> 1);
        int[] newArray = new int[newCapacity];
        //将旧堆中的数据移入新堆中
        System.arraycopy(array, 0, newArray, 0, size);
        //更新旧的堆
        array = newArray;
    }

    /**
     * 上浮
     *
     * @param offered 待添加元素值
     * @param index   向哪个索引位置添加
     */
    private void up(int offered, int index) {
        int child = index;
        while (child > 0) {
            int parent = (child - 1) / 2;

            boolean temp = max ? offered > array[parent] : offered < array[parent];
            if (temp) {
                array[child] = array[parent];
            } else {
                break;
            }
            child = parent;
        }
        array[child] = offered;
    }

    /**
     * 建推
     */
    public void heapify() {
        /*
                1.找到完全二叉树的最后一个非叶子节点     公式： size / 2 - 1
                2.从后向前，依次对每个飞非叶子节点调用下潜down方法
         */
        for (int i = (size >> 1) - 1; i >= 0; i--) {
            down(i);
        }
    }

    /**
     * 下潜
     */
    private void down(int parent) {

        int left = parent * 2 + 1;
        int right = left + 1;
        int maxOrMin = parent;
        if (left < size && (max ? array[left] > array[maxOrMin] : array[left] < array[maxOrMin])) {
            maxOrMin = left;
        }
        if (right < size && (max ? array[right] > array[maxOrMin] : array[right] < array[maxOrMin])) {
            maxOrMin = right;
        }
        if (maxOrMin != parent) {
            swap(maxOrMin, parent);
            down(maxOrMin);
        }

    }

    /**
     * 交换
     */
    private void swap(int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    /**
     * 判空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判满
     */
    public boolean isFull() {
        return size == array.length;
    }
}
