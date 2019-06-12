package org.csu.my_pet_store_spring.service;

import org.csu.my_pet_store_spring.domain.Order;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface OrderService {
    public void insertOrder(Order order);

    @Transactional
    public Order getOrder(int orderId);

    public List<Order> getOrdersByUsername(String username);

    public int getNextId(String name);
}
