package com.nevercome.jpetstore.persistence.dao.impl;

import com.nevercome.jpetstore.domain.model.LineItem;
import com.nevercome.jpetstore.persistence.dao.LineItemDAO;

import java.util.List;

public class LineItemDAOImpl implements LineItemDAO {

    private static class SingletonHolder {
        private static final LineItemDAO INSTANCE = new LineItemDAOImpl();
    }
    private LineItemDAOImpl() {}
    public static final LineItemDAO getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public List<LineItem> getLineItemsByOrderId(int orderId) {
        return null;
    }

    @Override
    public void insertLineItem(LineItem lineItem) {

    }
}
