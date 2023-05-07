package com.myshop.shop.order.command.application;

import com.myshop.shop.order.command.domain.ShippingInfo;

public class ChangeShippingInfoRequest {
    private String number;
    private ShippingInfo shippingInfo;

    public ChangeShippingInfoRequest(String number, ShippingInfo shippingInfo) {
        this.number = number;
        this.shippingInfo = shippingInfo;
    }

    public String getNumber() {
        return number;
    }

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }
}
