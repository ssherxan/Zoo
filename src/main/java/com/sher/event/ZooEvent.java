package com.sher.event;

import org.springframework.context.ApplicationEvent;

public class ZooEvent extends ApplicationEvent {

    private String message;

    public ZooEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
