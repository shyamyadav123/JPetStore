package persistence;

import domain.LineItem;

import java.util.List;

/**
 * @author: sun
 * @date: 2019/5/23
 */
public interface LineItemDAO {

    List<LineItem> getLineItemsByOrderId(int orderId);

    void insertLineItem(LineItem lineItem);
}
