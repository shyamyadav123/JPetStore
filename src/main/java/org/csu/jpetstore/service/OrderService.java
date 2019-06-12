package org.csu.jpetstore.service;

import org.csu.jpetstore.domain.Order;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: sun
 * @date: 2019/6/12
 */
public interface OrderService {
    void insertOrder(Order order);

    @Transactional
    Order getOrder(int orderId);

    List<Order> getOrdersByUsername(String username);

    int getNextId(String name);
}

