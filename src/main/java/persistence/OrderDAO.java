package persistence;

import domain.Order;

import java.util.List;

/**
 * @author: sun
 * @date: 2019/5/23
 */
public interface OrderDAO {

    List<Order> getOrdersByUsername(String username);

    Order getOrder(int orderId);

    void insertOrder(Order order);

    void insertOrderStatus(Order order);

}
