package com.springsourcecode.demo.minispring;

public interface BeanPostProcessor {
    void enhance(BeanFactory beanFactory, Object bean);
}
