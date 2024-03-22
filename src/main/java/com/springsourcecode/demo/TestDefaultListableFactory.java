package com.springsourcecode.demo;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.util.Map;

public class TestDefaultListableFactory {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(MyBean.class)
                .setScope("singleton")
                .setInitMethodName("init")
                .getBeanDefinition();

        beanFactory.registerBeanDefinition("myBean", beanDefinition);

        for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        MyBean bean = beanFactory.getBean(MyBean.class);
        System.out.println(bean);

        bean = beanFactory.getBean(MyBean.class);
        System.out.println(bean);

        bean = beanFactory.getBean(MyBean.class);
        System.out.println(bean);
    }

    static class MyBean {
        MyBean () {
            System.out.println("constructor");
        }

        private void init() {
            System.out.println("init...");
        }
    }
}
