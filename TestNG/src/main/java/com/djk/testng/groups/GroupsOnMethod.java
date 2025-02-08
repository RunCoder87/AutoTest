package com.djk.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * 组测试
 */
public class GroupsOnMethod {
    @Test(groups = "student")
    public void test1() {
        System.out.println("student组测试...");
    }
    @Test(groups = "teacher")
    public void test2() {
        System.out.println("teacher组测试...");
    }
    @Test(groups = "other")
    public void test3() {
        System.out.println("other组测试...");
    }
    @BeforeGroups("student")
    public void beforeGroupsOnStudent() {
        System.out.println("beforeGroupsOnStudent...");
    }
    @BeforeGroups("teacher")
    public void beforeGroupsOnTeacher() {
        System.out.println("beforeGroupsOnTeacher...");
    }
    @AfterGroups("student")
    public void afterGroupsOnStudent() {
        System.out.println("afterGroupsOnStudent...");
        System.out.println("===================================");
    }
    @AfterGroups("teacher")
    public void afterGroupsOnTeacher() {
        System.out.println("afterGroupsOnTeacher...");
        System.out.println("===================================");
    }
}
