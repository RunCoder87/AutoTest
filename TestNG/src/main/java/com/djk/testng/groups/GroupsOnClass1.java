package com.djk.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass1 {
    @Test
    public void stu1() {
        System.out.println("GroupsOnClass1 stu1执行...");
    }
    @Test
    public void stu2() {
        System.out.println("GroupsOnClass1 stu2执行...");
    }
}
