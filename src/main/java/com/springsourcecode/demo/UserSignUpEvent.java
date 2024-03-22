package com.springsourcecode.demo;

import org.springframework.context.ApplicationEvent;

public class UserSignUpEvent extends ApplicationEvent {
    public UserSignUpEvent(Object source) {
        super(source);
    }
}
