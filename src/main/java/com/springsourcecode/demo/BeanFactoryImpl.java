package com.springsourcecode.demo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class BeanFactoryImpl implements BeanFactory{

    private Map<Class<?>, Object> map = new HashMap<>();
    @Override
    public void register(Class<?> clz) {
        try {
            Object obj = clz.getDeclaredConstructor().newInstance();
            map.put(clz, obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T getBean(Class<T> clz) {
        Object o = map.get(clz);
        return clz.cast(o);
    }

    @Override
    public void autowire(Object obj) {
        for (Field field: obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Autowired.class)) {
                field.setAccessible(true);
                Class<?> type = field.getType();
                Object b = map.get(type);
                field.set(obj, b);
            }
        }
    }
}
