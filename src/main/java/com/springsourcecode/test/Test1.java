package com.springsourcecode.test;

import com.springsourcecode.demo.minispring.BeanFactory;
import com.springsourcecode.demo.minispring.BeanFactoryImpl;

public class Test1 {
    public static void main(String[] args) throws Exception {
        BeanFactory beanFactory = new BeanFactoryImpl(MyConfig.class);

        System.out.println(beanFactory.getBean(A.class));
        System.out.println(beanFactory.getBean(B.class));

        A a = new A();
        beanFactory.autowire(a);
        System.out.println(a.getB());
    }
}
