package com.myshop.shop.order.command.application;

import com.myshop.shop.order.command.NoOrderException;
import com.myshop.shop.order.command.domain.Order;
import com.myshop.shop.order.command.domain.OrderNo;
import com.myshop.shop.order.command.domain.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ChangeShippingService {
    private OrderRepository orderRepository;

    public ChangeShippingService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void changeShipping(ChangeShippingInfoRequest changeReq) {
        Optional<Order> orderOpt = orderRepository.findById(new OrderNo(changeReq.getNumber()));
        Order order = orderOpt.orElseThrow(() -> new NoOrderException());
        order.changeShippingInfo(changeReq.getShippingInfo());
    }


}
