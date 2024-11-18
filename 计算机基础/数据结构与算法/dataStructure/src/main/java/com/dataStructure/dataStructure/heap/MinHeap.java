package com.dataStructure.dataStructure.heap;

/**
 * 小顶堆
 */
public class MinHeap {
    private final int[] array;
    private int size;

    public int getSize() {
        return size;
    }

    public MinHeap(int capacity) {
        array = new int[capacity];
    }

    /**
     * 如果传入一个普通数组，要执行建堆操作，将当前数组转换为堆数组
     */
    public MinHeap(int[] array) {
        this.array = array;
        this.size = array.length;
        heapify();
    }

    /**
     * 返回堆顶元素
     */
    public Integer peek() {
        if(isEmpty()){
            return null;
        }
        return array[0];
    }

    /**
     * 删除堆顶元素
     */
    public Integer poll() {
        if(isEmpty()){
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
        if(isEmpty()){
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
        if(isEmpty()){
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
        if(isFull()){
            return false;
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
     * 上浮
     * @param offered 待添加元素值
     * @param index 向哪个索引位置添加
     */
    private void up(int offered, int index) {
        /*
                   1.记录孩子的索引位置
                   2.通过孩子的索引找到父亲的索引位置     公式： parent = (child - 1) / 2;
                   3.比较添加元素与其父亲节点元素的值
                   4.如果添加元素小于父亲节点元素的值，将父亲节点元素的值下移，如果大于，则直接在孩子索引位置插入元素
                   5.将孩子索引指向其父亲索引
                   6.循环操作 2,3,4,5 直到孩子索引为推顶索引0，或者添加元素大于父亲节点元素的值
         */
        int child = index;
        while (child > 0) {
            int parent = (child - 1) >> 1;
            if (offered < array[parent]) {
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
        /*
               1.找到当前节点的左孩子节点和右孩子节点
               2.将当前节点的值和左孩子，右孩子的值进行比较
               3.定义一个变量min，用于存放当前节点与其左右孩子中最小的值的下标
               4.默认最小值先为当前节点，如果左孩子的值小于当前节点，更新min指针为左孩子下标，右孩子类似
               5.如果min指针不等于当前节点的下标（左右孩子中有小于当前节点的值），交换当前节点与min下标对应节点的值，递归调用下潜down方法，将原节点继续下潜
         */
        int left = parent * 2 + 1;
        int right = left + 1;
        int min = parent;
        if (left < size && array[left] < array[min]) {
            min = left;
        }
        if (right < size && array[right] < array[min]) {
            min = right;
        }
        if (min != parent) {
            swap(min, parent);
            down(min);
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
