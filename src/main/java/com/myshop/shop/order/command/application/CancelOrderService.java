package com.myshop.shop.order.command.application;

import com.myshop.shop.order.command.domain.Order;
import com.myshop.shop.order.command.domain.OrderNo;
import com.myshop.shop.order.command.domain.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CancelOrderService {

    private OrderRepository orderRepository;

    public CancelOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void cancel(OrderNo orderNo) {

        Order order = orderRepository.findById(orderNo)
                .orElseThrow(RuntimeException::new);
        order.cancel();
    }
}
