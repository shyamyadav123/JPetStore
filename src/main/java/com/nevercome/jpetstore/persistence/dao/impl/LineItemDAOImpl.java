package com.nevercome.jpetstore.persistence.dao.impl;

import com.nevercome.jpetstore.domain.model.LineItem;
import com.nevercome.jpetstore.domain.model.Sequence;
import com.nevercome.jpetstore.persistence.dao.LineItemDAO;
import com.nevercome.jpetstore.persistence.db.DBConnectionPool;
import com.nevercome.jpetstore.persistence.db.DBUtil;
import com.nevercome.jpetstore.utils.Global;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LineItemDAOImpl implements LineItemDAO {

    private static class SingletonHolder {
        private static final LineItemDAO INSTANCE = new LineItemDAOImpl();
    }

    private LineItemDAOImpl() {
    }

    public static final LineItemDAO getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public List<LineItem> getLineItemsByOrderId(int orderId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from lineitem where `orderid`=?";
        List<Object> bindArgs = new ArrayList<>();
        bindArgs.add(orderId);
        List<LineItem> lineItemList = new ArrayList<>();
        try {
            connection = DBConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < bindArgs.size(); i++) {
                preparedStatement.setObject(i + 1, bindArgs.get(i));
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                LineItem lineItem = new LineItem();
                lineItem.setOrderId(resultSet.getInt(Global.COL_LINEITEM_ORDERID));
                lineItem.setItemId(resultSet.getString(Global.COL_ITEM_ID));
                lineItem.setLineNumber(resultSet.getInt(Global.COL_LINEITEM_LINENUM));
                lineItem.setQuantity(resultSet.getInt(Global.COL_LINEITEM_QUANTITY));
                lineItem.setUnitPrice(new BigDecimal(resultSet.getString(Global.COL_LINEITEM_UNITPRICE)));
                lineItemList.add(lineItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return lineItemList;
    }

    @Override
    public void insertLineItem(LineItem lineItem) {
        Map<String, Object> valMap = new HashMap<>();
        valMap.put(Global.COL_LINEITEM_ORDERID, lineItem.getOrderId());
        valMap.put(Global.COL_LINEITEM_ITEMID, lineItem.getItemId());
        valMap.put(Global.COL_LINEITEM_LINENUM, lineItem.getLineNumber());
        valMap.put(Global.COL_LINEITEM_QUANTITY, lineItem.getQuantity());
        valMap.put(Global.COL_LINEITEM_UNITPRICE, lineItem.getUnitPrice());
        try {
            int count = DBUtil.insert("lineitem", valMap);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
