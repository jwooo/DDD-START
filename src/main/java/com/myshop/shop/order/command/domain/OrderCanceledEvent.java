package com.myshop.shop.order.command.domain;

import com.myshop.shop.common.event.Event;

public class OrderCanceledEvent extends Event {
    private String orderNumber;

    public OrderCanceledEvent(String number) {
        super();
        this.orderNumber = number;
    }

    public String getOrderNumber() {
        return orderNumber;
    }
}
