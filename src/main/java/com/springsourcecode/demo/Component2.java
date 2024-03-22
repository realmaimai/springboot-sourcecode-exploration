package com.springsourcecode.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Component2 {

    @EventListener
    public void sendMsg(UserSignUpEvent event){
        log.info("send msg");
    }
}
