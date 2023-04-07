package com.myshop.shop.order.command.domain;

public interface OrderRepository {
    Order findByNumber(OrderNo orderNo);
    void save(Order order);
    void delete(Order order);
}
