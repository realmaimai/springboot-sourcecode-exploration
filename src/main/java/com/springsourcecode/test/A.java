package com.springsourcecode.test;

import com.springsourcecode.demo.minispring.Autowired;
import com.springsourcecode.demo.minispring.Component;

@Component
public class A {
    @Autowired
    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}
