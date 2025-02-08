package com.djk.testng;

import org.testng.annotations.Test;

/**
 * 忽略测试用例
 */
public class IgnoreTest {
    @Test
    public void ignoreTest1() {
        System.out.println("ignoreTest1执行...");
    }
    @Test(enabled = false)
    public void ignoreTest2() {
        System.out.println("ignoreTest2执行...");
    }
}
