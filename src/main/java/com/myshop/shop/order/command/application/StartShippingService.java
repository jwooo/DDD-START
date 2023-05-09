package com.myshop.shop.order.command.application;

import com.myshop.shop.common.VersionConflictException;
import com.myshop.shop.order.command.NoOrderException;
import com.myshop.shop.order.command.domain.Order;
import com.myshop.shop.order.command.domain.OrderNo;
import com.myshop.shop.order.command.domain.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StartShippingService {
    private OrderRepository orderRepository;

    public StartShippingService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void startShipping(StartShippingRequest req) {
        Optional<Order> orderOpt = orderRepository.findById(new OrderNo(req.getOrderNumber()));
        Order order = orderOpt.orElseThrow(NoOrderException::new);
        if (order.matchVersion(req.getVersion())) {
            throw new VersionConflictException();
        }
        order.startShipping();
    }
}
