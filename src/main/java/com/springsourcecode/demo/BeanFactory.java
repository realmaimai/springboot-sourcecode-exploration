package com.springsourcecode.demo;

public interface BeanFactory {

    /**
     * register a type into Spring container
     * @param clz
     */
    void register(Class<?> clz);

    <T> T getBean(Class<T> clz);

    void autowire(Object obj);
}
