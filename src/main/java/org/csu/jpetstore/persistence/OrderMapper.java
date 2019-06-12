package org.csu.jpetstore.persistence;

import org.csu.jpetstore.domain.Order;

import java.util.List;

/**
 * @author: sun
 * @date: 2019/6/12
 */
public interface OrderMapper {

    List<Order> getOrdersByUsername(String username);

    Order getOrder(int orderId);

    void insertOrder(Order order);

    void insertOrderStatus(Order order);

}
