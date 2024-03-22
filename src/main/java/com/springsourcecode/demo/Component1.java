package com.springsourcecode.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Component1 {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void userSignUp() {
        log.info("finished sign up");
        eventPublisher.publishEvent(new UserSignUpEvent(this));
    }
}
