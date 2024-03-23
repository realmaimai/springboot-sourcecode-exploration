package com.springsourcecode.test;

import com.springsourcecode.demo.minispring.BeanFactory;
import com.springsourcecode.demo.minispring.BeanFactoryImpl;
import com.springsourcecode.demo.minispring.ResourceBeanPostProcessor;

public class Test1 {
    public static void main(String[] args) throws Exception {
        BeanFactory beanFactory = new BeanFactoryImpl(MyConfig.class, new ResourceBeanPostProcessor());

        System.out.println(beanFactory.getBean(A.class));
        System.out.println(beanFactory.getBean(B.class));

        A bean = beanFactory.getBean(A.class);
        System.out.println("---");
        System.out.println(bean.getB());
    }
}
