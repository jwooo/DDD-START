package com.myshop.shop.order.command;

import lombok.Getter;

@Getter
public class OrderNo {
    private String number;

    public OrderNo(String number) {
        this.number = number;
    }
}
