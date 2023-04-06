package com.myshop.shop.order.command;

import lombok.Getter;

@Getter
public class ShippingInfo {
    private String receiverName;
    private String receiverPhoneNumber;
    private String shippingAddress1;
    private String shippingAddress2;
    private String shippingZipCode;
}
