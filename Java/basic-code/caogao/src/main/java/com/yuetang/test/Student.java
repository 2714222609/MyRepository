package com.yuetang.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Student {
    private int age;
    private String name;

    public Student() {
    }

    public Student(int a, String name) {
        this.age = a;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int a) {
        this.age = a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


