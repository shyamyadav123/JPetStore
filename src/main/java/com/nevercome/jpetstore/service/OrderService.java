package com.nevercome.jpetstore.service;

import com.nevercome.jpetstore.domain.model.Order;

import java.util.List;

public interface OrderService {
    void insertOrder(Order order);

    Order getOrder(int orderId);

    List<Order> getOrdersByUserId(String userId);

    int getNextId(String name);
}
