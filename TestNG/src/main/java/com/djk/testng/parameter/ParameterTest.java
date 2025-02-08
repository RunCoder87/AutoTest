package com.djk.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * 参数化测试
 * 1. 来自xml配置文件
 * 2. 来自java代码
 */
public class ParameterTest {
    @Test(dataProvider = "data")
    @Parameters({"name", "age"})
    public void paramTest1(String name, int age) {
        System.out.println("name=" + name + ",age=" + age);
    }

    @Test(dataProvider = "data")
    @Parameters({"name", "age"})
    public void paramTest2(String name) {
        System.out.println("name=" + name);
    }

    // 参数化测试数据源
    @DataProvider(name = "data")
    public Object[][] dataProvider(Method method) {
        if (method.getName().equals("paramTest1")) {
            return new Object[][]{
                    {"zhangsan", 20},
                    {"lisi", 30},
                    {"wangwu", 40}
            };
        }
        return new Object[][]{
                {"zhangsan"},
                {"lisi"},
                {"wangwu"}
        };
    }

}
