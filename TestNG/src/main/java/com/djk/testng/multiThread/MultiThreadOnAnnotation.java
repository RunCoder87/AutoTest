package com.djk.testng.multiThread;

import org.testng.annotations.Test;

/**
 * 多线程测试
 */
public class MultiThreadOnAnnotation {
    @Test(invocationCount = 6, threadPoolSize = 3)
    public void test() {
        System.out.println("Thread id："+ Thread.currentThread().getId());
    }
}
