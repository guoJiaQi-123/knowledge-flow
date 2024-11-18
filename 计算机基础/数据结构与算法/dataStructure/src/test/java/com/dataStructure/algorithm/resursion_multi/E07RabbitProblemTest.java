package com.dataStructure.algorithm.resursion_multi;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class E07RabbitProblemTest {

    @Test
    void test(){

        Assert.assertEquals(8,E07RabbitProblem.f(6));

    }

    @Test
    void test1(){

        Assert.assertEquals(1,E06Fibonacci.fibonacci(2));
        Assert.assertEquals(2,E06Fibonacci.fibonacci(3));
        Assert.assertEquals(3,E06Fibonacci.fibonacci(4));
    }
}
