package com.myshop.shop.order.command.domain;

import lombok.Getter;

/**
 * 주문할 상품, 상품의 가격, 구매 개수를 포함해야 한다.
 * 추가로 각 구매 항목의 구매 가격도 제공해야 한다.
 */

@Getter
public class OrderLine {

    private Product product;
    private Money price;
    private int quantity;
    private Money amounts;

    public OrderLine(Product product, Money price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    private Money calculateAmounts() {
        return  price.multiply(quantity);
    }
}
