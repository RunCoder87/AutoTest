package com.djk.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass2 {
    public void stu1() {
        System.out.println("GroupsOnClass2 stu1执行...");
    }
    public void stu2() {
        System.out.println("GroupsOnClass2 stu2执行...");
    }
}
