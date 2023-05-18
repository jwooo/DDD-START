package com.myshop.shop.intergration.infra;

import com.myshop.shop.eventstore.api.EventEntry;
import com.myshop.shop.intergration.EventSender;
import org.springframework.stereotype.Component;

@Component
public class SysoutEventSender implements EventSender {
    @Override
    public void send(EventEntry event) {
        System.out.println("EventSender send event : " + event);
    }
}
