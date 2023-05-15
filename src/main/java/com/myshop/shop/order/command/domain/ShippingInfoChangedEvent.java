package com.myshop.shop.order.command.domain;

public class ShippingInfoChangedEvent {
    private final OrderNo number;
    private final ShippingInfo newShippingInfo;
    private long timestamp;

    public ShippingInfoChangedEvent(OrderNo number, ShippingInfo newShippingInfo) {
        this.number = number;
        this.newShippingInfo = newShippingInfo;
    }

    public OrderNo getNumber() {
        return number;
    }

    public ShippingInfo getNewShippingInfo() {
        return newShippingInfo;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
