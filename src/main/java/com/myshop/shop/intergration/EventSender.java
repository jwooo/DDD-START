package com.myshop.shop.intergration;

import com.myshop.shop.eventstore.api.EventEntry;

public interface EventSender {
    void send(EventEntry event);
}
