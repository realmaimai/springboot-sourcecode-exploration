package com.springsourcecode.test;

import com.springsourcecode.demo.minispring.Component;
import com.springsourcecode.demo.minispring.Resource;

@Component
public class A {
    @Resource
    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}
