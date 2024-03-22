package com.springsourcecode.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Component3 {

    @EventListener
    public void sendEmail(UserSignUpEvent event) {
        log.info("send email");
    }
}
