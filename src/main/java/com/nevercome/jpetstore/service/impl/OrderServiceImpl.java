package com.nevercome.jpetstore.service.impl;

import com.nevercome.jpetstore.domain.model.Item;
import com.nevercome.jpetstore.domain.model.LineItem;
import com.nevercome.jpetstore.domain.model.Order;
import com.nevercome.jpetstore.domain.model.Sequence;
import com.nevercome.jpetstore.persistence.dao.ItemDAO;
import com.nevercome.jpetstore.persistence.dao.LineItemDAO;
import com.nevercome.jpetstore.persistence.dao.OrderDAO;
import com.nevercome.jpetstore.persistence.dao.SequenceDAO;
import com.nevercome.jpetstore.persistence.dao.impl.ItemDAOImpl;
import com.nevercome.jpetstore.persistence.dao.impl.LineItemDAOImpl;
import com.nevercome.jpetstore.persistence.dao.impl.OrderDAOImpl;
import com.nevercome.jpetstore.persistence.dao.impl.SequenceDAOImpl;
import com.nevercome.jpetstore.service.OrderService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    private static class SingletonHolder {
        private static final OrderService INSTANCE = new OrderServiceImpl();
    }

    private OrderServiceImpl() {
    }

    public static final OrderService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private ItemDAO itemDAO = ItemDAOImpl.getInstance();
    private OrderDAO orderDAO = OrderDAOImpl.getInstance();
    private SequenceDAO sequenceDAO = SequenceDAOImpl.getInstance();
    private LineItemDAO lineItemDAO = LineItemDAOImpl.getInstance();

    @Override
    public void insertOrder(Order order) {
        order.setOrderId(getNextId("ordernum"));
        for (int i = 0; i < order.getLineItems().size(); i++) {
            LineItem lineItem = order.getLineItems().get(i);
            String itemId = lineItem.getItemId();
            Integer increment = lineItem.getQuantity();
            Map<String, Object> param = new HashMap<String, Object>(2);
            param.put("itemId", itemId);
            param.put("increment", increment);
            itemDAO.updateInventoryQuantity(param);
        }

        orderDAO.insertOrder(order);
        orderDAO.insertOrderStatus(order);
        for (int i = 0; i < order.getLineItems().size(); i++) {
            LineItem lineItem = order.getLineItems().get(i);
            lineItem.setOrderId(order.getOrderId());
            lineItemDAO.insertLineItem(lineItem);
        }
    }

    @Override
    public Order getOrder(int orderId) {
        Order order = orderDAO.getOrder(orderId);
        order.setLineItems(lineItemDAO.getLineItemsByOrderId(orderId));
        for (int i = 0; i < order.getLineItems().size(); i++) {
            LineItem lineItem = order.getLineItems().get(i);
            Item item = itemDAO.getItem(lineItem.getItemId());
            item.setQuantity(itemDAO.getInventoryQuantity(lineItem.getItemId()));
            lineItem.setItem(item);
        }
        return order;
    }

    @Override
    public List<Order> getOrdersByUserId(String userId) {
        return orderDAO.getOrdersByUsername(userId);
    }

    @Override
    public int getNextId(String name) {
        Sequence sequence = new Sequence(name, -1);
        sequence = sequenceDAO.getSequence(sequence);
        if (sequence == null) {
            throw new RuntimeException("Error: A null sequence was returned from the database (could not get next " + name
                    + " sequence).");
        }
        Sequence parameterObject = new Sequence(name, sequence.getNextId() + 1);
        sequenceDAO.updateSequence(parameterObject);
        return sequence.getNextId();
    }


}
