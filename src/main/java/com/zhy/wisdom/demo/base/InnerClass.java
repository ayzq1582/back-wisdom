package com.zhy.wisdom.demo.base;

public class InnerClass {

    public class inner{

    }

    public static void main(String[] args) {
        inner inner = new InnerClass().new inner();

    }
}
