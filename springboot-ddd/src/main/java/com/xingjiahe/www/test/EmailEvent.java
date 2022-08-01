package com.xingjiahe.www.test;


import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/7/26 5:22 PM
 */
@Component

public class EmailEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     * which the event is associated (never {@code null})
     */
    private static final long serialVersionUID = 1L;
    public String address;
    public String text;

    public EmailEvent(Object source, String address, String text) {
        super(source);
        this.address = address;
        this.text = text;
    }


    public void print() {
        System.out.println("hello spring event!");
    }


    public EmailEvent(Object source) {
        super(source);
    }


    public EmailEvent() {
        super(serialVersionUID);
    }


}
