package com.springsourcecode.demo.minispring;

public interface BeanFactory {

    /**
     * register a class
     * @param clz
     */
    void register(Class<?> clz);

    /**
     * get bean instance
     * @param clz
     * @return
     * @param <T>
     */
    <T> T getBean(Class<T> clz);

    void autowire(Object obj);
}
