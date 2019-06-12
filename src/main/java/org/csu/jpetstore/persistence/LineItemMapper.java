package org.csu.jpetstore.persistence;

import org.csu.jpetstore.domain.LineItem;

import java.util.List;

/**
 * @author: sun
 * @date: 2019/6/12
 */
public interface LineItemMapper {

    List<LineItem> getLineItemsByOrderId(int orderId);

    void insertLineItem(LineItem lineItem);

}
