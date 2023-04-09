package com.myshop.shop.order.infra;

import com.myshop.shop.order.command.domain.Order;
import com.myshop.shop.order.command.domain.OrderNo;
import com.myshop.shop.order.command.domain.OrderRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JpaOrderRepository implements OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Order findById(OrderNo no) {
        return entityManager.find(Order.class, no);
    }

    @Override
    public void save(Order order) {
        entityManager.persist(order);
    }

    @Override
    public void delete(Order order) {
        entityManager.remove(order);
    }
}
