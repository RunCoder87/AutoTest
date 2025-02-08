package com.djk.ep;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethodsDemo {
    @Test
    public void test1() {
        Assert.assertEquals(1, 2);
    }
    @Test
    public void test2() {
        Assert.assertEquals(1, 1);
    }

    @Test
    public void test3() {
        Assert.assertEquals("aa","aa");
    }
    @Test
    public void logTest(){
        Reporter.log("日志测试...");
        throw new RuntimeException();
    }
}
