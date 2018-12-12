package com.nevercome.jpetstore.persistence.dao.impl;

import com.nevercome.jpetstore.domain.model.Order;
import com.nevercome.jpetstore.persistence.dao.OrderDAO;

import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    private static class SingletonHolder {
        private static final OrderDAO INSTANCE = new OrderDAOImpl();
    }
    private OrderDAOImpl() {}
    public static final OrderDAO getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public List<Order> getOrdersByUsername(String username) {
        return null;
    }

    @Override
    public Order getOrder(int orderId) {
        return null;
    }

    @Override
    public void insertOrder(Order order) {

    }

    @Override
    public void insertOrderStatus(Order order) {

    }
}
