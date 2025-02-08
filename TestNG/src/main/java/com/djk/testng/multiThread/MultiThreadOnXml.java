package com.djk.testng.multiThread;

import org.testng.annotations.Test;

/**
 * 多线程测试：通过xml配置多线程
 */
public class MultiThreadOnXml {
    @Test
    public void test1() {
        System.out.println("thread-id：" + Thread.currentThread().getId());

    }

    @Test
    public void test3() {
        System.out.println("thread-id：" + Thread.currentThread().getId());

    }

    @Test
    public void test2() {
        System.out.println("thread-id：" + Thread.currentThread().getId());
    }
}
