package com.nevercome.jpetstore.service.impl;

import com.nevercome.jpetstore.domain.model.Order;
import com.nevercome.jpetstore.persistence.dao.ItemDAO;
import com.nevercome.jpetstore.persistence.dao.LineItemDAO;
import com.nevercome.jpetstore.persistence.dao.OrderDAO;
import com.nevercome.jpetstore.persistence.dao.SequenceDAO;
import com.nevercome.jpetstore.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private static class SingletonHolder {
        private static final OrderService INSTANCE = new OrderServiceImpl();
    }
    private OrderServiceImpl() {}
    public static final OrderService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private ItemDAO itemDAO;
    private OrderDAO orderDAO;
    private SequenceDAO sequenceDAO;
    private LineItemDAO lineItemDAO;

    @Override
    public void insertOrder(Order order) {

    }

    @Override
    public Order getOrder(int orderId) {
        return null;
    }

    @Override
    public List<Order> getOrdersByUserId(String userId) {
        return null;
    }

    @Override
    public int getNextId(String name) {
        return 0;
    }
}
