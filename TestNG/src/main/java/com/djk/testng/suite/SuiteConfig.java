package com.djk.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * suite 配置类
 *
 */
public class SuiteConfig {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite运行...");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite运行...");
    }
}
