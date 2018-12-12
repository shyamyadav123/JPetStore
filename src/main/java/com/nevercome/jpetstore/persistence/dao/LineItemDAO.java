package com.nevercome.jpetstore.persistence.dao;

import com.nevercome.jpetstore.domain.model.LineItem;

import java.util.List;

public interface LineItemDAO {
    List<LineItem> getLineItemsByOrderId(int orderId);

    void insertLineItem(LineItem lineItem);
}
