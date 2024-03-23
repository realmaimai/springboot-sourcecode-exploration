package com.springsourcecode.test;

import com.springsourcecode.demo.minispring.BeanFactory;
import com.springsourcecode.demo.minispring.BeanFactoryImpl;

public class Test1 {
    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactoryImpl();
        beanFactory.register(A.class);
        beanFactory.register(B.class);

        System.out.println(beanFactory.getBean(A.class));
        System.out.println(beanFactory.getBean(B.class));

        A a = new A();
        beanFactory.autowire(a);
        System.out.println(a.getB());
    }
}
