package com.springsourcecode.demo.minispring;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class BeanFactoryImpl implements BeanFactory{

    // as we learned before, there are 3 levels cache inside Spring, this hashmap is the first cache
    private Map<Class<?>, Object> hashMap = new HashMap<>();
    @Override
    public void register(Class<?> clz) {
        try {
            // create class object instance -> store in map (lvl1 cache)
            Object newInstance = clz.getDeclaredConstructor().newInstance();
            hashMap.put(clz, newInstance);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T getBean(Class<T> clz) {
        // get object from map (lvl1 cache)
        Object obj = hashMap.get(clz);
        return clz.cast(obj);
    }

    @Override
    public void autowire(Object obj) {
        // scan object
        for (Field field : obj.getClass().getDeclaredFields()) {
            // find the field that has @autowire annotation
            if (field.isAnnotationPresent(Autowired.class)) {
                // dependency injection: check if the field type is in the level 1 cache
                field.setAccessible(true);
                Class<?> fieldType = field.getType();
                if (hashMap.containsKey(fieldType)) {
                    Object o = hashMap.get(fieldType);
                    try {
                        field.set(obj, o);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    }
}
