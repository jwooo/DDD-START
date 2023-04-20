package com.myshop.shop.order.command.domain;

import com.myshop.shop.catalog.command.domain.product.Product;
import com.myshop.shop.catalog.command.domain.product.ProductId;
import com.myshop.shop.common.jpa.MoneyConverter;
import com.myshop.shop.common.model.Money;

import javax.persistence.*;

/**
 * 주문할 상품, 상품의 가격, 구매 개수를 포함해야 한다.
 * 추가로 각 구매 항목의 구매 가격도 제공해야 한다.
 */

@Embeddable
public class OrderLine {

    @Embedded
    private ProductId productId;

    @Convert(converter = MoneyConverter.class)
    @Column(name = "price")
    private Money price;

    @Column(name = "quantity")
    private int quantity;

    @Convert(converter = MoneyConverter.class)
    @Column(name = "amounts")
    private Money amounts;

    protected OrderLine() {}

    public OrderLine(ProductId productId, Money price, int quantity) {
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    private Money calculateAmounts() {
        return  price.multiply(quantity);
    }

    public Money getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
