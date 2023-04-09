package com.myshop.shop.order.command.application;

import com.myshop.shop.order.command.domain.Order;
import com.myshop.shop.order.command.domain.OrderNo;
import com.myshop.shop.order.command.domain.OrderRepository;

public class CancelOrderService {

    private OrderRepository orderRepository;

    public void cancel(OrderNo orderNo) {
        Order order = orderRepository.findById(orderNo);
        if (order == null) throw new RuntimeException(orderNo.getNumber());
        order.cancel();
    }
}
