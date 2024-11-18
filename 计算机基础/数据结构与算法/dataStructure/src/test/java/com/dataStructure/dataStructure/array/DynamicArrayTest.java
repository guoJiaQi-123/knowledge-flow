package com.dataStructure.dataStructure.array;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DynamicArrayTest {
    //测试添加元素
    @Test
    public void test1(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.add(2,5);

        for(int i=0;i<5;i++){
            System.out.println(dynamicArray.get(i));
        }
    }

    //测试遍历方式1
    @Test
    public void test2(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);

        dynamicArray.foreach(System.out::println);
    }

    //测试遍历方式2
    @Test
    public void test3(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        for(Integer element : dynamicArray){
            System.out.println(element);
        }
    }

    //测试遍历方式3
    @Test
    public void test4(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.stream().forEach( element -> {
            System.out.println(element);
        });
    }

    //测试删除元素
    @Test
    public void test5(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);

        int remove = dynamicArray.remove(2);
        assertEquals(3,remove);
        dynamicArray.stream().forEach(ele->{
            System.out.println(ele);
        });
    }
}

