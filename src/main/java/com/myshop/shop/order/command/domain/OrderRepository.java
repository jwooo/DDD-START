package com.myshop.shop.order.command.domain;

public interface OrderRepository {
    Order findById(OrderNo no);
    void save(Order order);
    void delete(Order order);
}
