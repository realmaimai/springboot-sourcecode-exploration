package com.springsourcecode.demo.minispring;

import java.lang.reflect.Field;

public class ResourceBeanPostProcessor implements BeanPostProcessor{
    @Override
    public void enhance(BeanFactory beanFactory, Object bean) {
        for (Field field : bean.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Resource.class)) {
                Class<?> type = field.getType();
                Object bean1 = beanFactory.getBean(type);
                try {
                    field.set(bean, bean1);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
