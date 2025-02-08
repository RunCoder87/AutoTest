package com.djk.testng;

import org.testng.annotations.Test;

/**
 * 异常测试
 */
public class ExpectedException {
    @Test(expectedExceptions = ArithmeticException.class)
    public void test1() {
        int i = 1 / 0;
    }
}
