package com.djk.testng;

import org.testng.annotations.Test;

/**
 * 超时测试
 */
public class TimeoutTest {
    @Test(timeOut = 1000)
    public void test() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("超时了");
        }
    }
}
