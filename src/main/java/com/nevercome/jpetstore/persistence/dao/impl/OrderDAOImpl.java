package com.nevercome.jpetstore.persistence.dao.impl;

import com.nevercome.jpetstore.domain.model.Order;
import com.nevercome.jpetstore.domain.model.Sequence;
import com.nevercome.jpetstore.persistence.dao.OrderDAO;
import com.nevercome.jpetstore.persistence.db.DBConnectionPool;
import com.nevercome.jpetstore.persistence.db.DBUtil;
import com.nevercome.jpetstore.utils.Global;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

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
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select a.*, b.* from orders a, orderstatus b where a.orderid=b.orderid and a.orderid=?";
        List<Object> bindArgs = new ArrayList<>();
        bindArgs.add(orderId);
        Order order = new Order();
        try {
            connection = DBConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < bindArgs.size(); i++) {
                preparedStatement.setObject(i + 1, bindArgs.get(i));
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                order.setUsername(resultSet.getString("userid"));
                order.setExpiryDate(resultSet.getString("exprdate"));
                order.setCreditCard(resultSet.getString("creditcard"));
                order.setCourier(resultSet.getString("courier"));
                order.setBillZip(resultSet.getString("billzip"));
                order.setBillToLastName(resultSet.getString("billtolastname"));
                order.setBillToFirstName(resultSet.getString("billtofirstname"));
                order.setBillState(resultSet.getString("billstate"));
                order.setBillCountry(resultSet.getString("billcountry"));
                order.setBillCity(resultSet.getString("billcity"));
                order.setBillAddress2(resultSet.getString("billaddr2"));
                order.setBillAddress1(resultSet.getString("billaddr1"));
                order.setCardType(resultSet.getString("cardtype"));
                order.setLocale(resultSet.getString("locale"));
                order.setOrderDate(resultSet.getDate("orderdate"));
                order.setOrderId(resultSet.getShort("orderid"));
                order.setShipAddress1(resultSet.getString("shipaddr1"));
                order.setShipAddress2(resultSet.getString("shipaddr2"));
                order.setShipCity(resultSet.getString("shipcity"));
                order.setShipCountry(resultSet.getString("shipcountry"));
                order.setShipState(resultSet.getString("shipstate"));
                order.setShipToFirstName(resultSet.getString("shiptofirstname"));
                order.setShipToLastName(resultSet.getString("shiptolastname"));
                order.setShipZip(resultSet.getString("shipzip"));
                order.setStatus(resultSet.getString("status"));
                order.setTotalPrice(new BigDecimal(resultSet.getString("totalprice")));
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
        return order;
    }

    @Override
    public void insertOrder(Order order) {
        Map<String, Object> valMap = new HashMap<>();
        valMap.put(Global.COL_ORDER_BILLADDR1, order.getBillAddress1());
        valMap.put(Global.COL_ORDER_BILLADDR2, order.getBillAddress2());
        valMap.put(Global.COL_ORDER_BILLCITY, order.getBillCity());
        valMap.put(Global.COL_ORDER_BILLCOUNTRY, order.getBillCountry());
        valMap.put(Global.COL_ORDER_BILLSTATE, order.getBillState());
        valMap.put(Global.COL_ORDER_BILLTOFIRSTNAME, order.getBillToFirstName());
        valMap.put(Global.COL_ORDER_BILLTOLASTNAME, order.getBillToLastName());
        valMap.put(Global.COL_ORDER_BILLZIP, order.getBillZip());
        valMap.put(Global.COL_ORDER_CARDTYPE, order.getCardType());
        valMap.put(Global.COL_ORDER_COURIER, order.getCourier());
        valMap.put(Global.COL_ORDER_CREDITCARD, order.getCreditCard());
        valMap.put(Global.COL_ORDER_EXPIREDATE, order.getExpiryDate());
        valMap.put(Global.COL_ORDER_LOCALE, order.getLocale());
        valMap.put(Global.COL_ORDER_ORDERDATE, order.getOrderDate());
        valMap.put(Global.COL_ORDER_ORDERID, order.getOrderId());
        valMap.put(Global.COL_ORDER_SHIPADDR1, order.getShipAddress1());
        valMap.put(Global.COL_ORDER_SHIPADDR2, order.getShipAddress2());
        valMap.put(Global.COL_ORDER_SHIPCITY, order.getShipCity());
        valMap.put(Global.COL_ORDER_SHIPCOUNTRY, order.getShipCountry());
        valMap.put(Global.COL_ORDER_SHIPSTATE, order.getShipState());
        valMap.put(Global.COL_ORDER_SHIPTOFIRSTNAME, order.getShipToFirstName());
        valMap.put(Global.COL_ORDER_SHIPTOLASTNAME, order.getShipToLastName());
        valMap.put(Global.COL_ORDER_SHIPZIP, order.getShipZip());
        valMap.put(Global.COL_ORDER_STATUS, order.getStatus());
        valMap.put(Global.COL_ORDER_TOTALPRICE, order.getTotalPrice());
        valMap.put(Global.COL_ORDER_USERNAME, order.getUsername());
        try {
            int count = DBUtil.insert("orders", valMap);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertOrderStatus(Order order) {
        Map<String, Object> valMap = new HashMap<>();
        valMap.put(Global.COL_ORDERSTATUS_STATUS, order.getStatus());
        valMap.put(Global.COL_ORDERSTATUS_ORDERID, order.getOrderId());
        valMap.put(Global.COL_ORDERSTATUS_LINENUM, order.getLineItems().size());
        Timestamp timestamp = new Timestamp(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND, 1);
        valMap.put(Global.COL_ORDERSTATUS_TIMESTAMP, timestamp);
        try {
            int count = DBUtil.insert("orderstatus", valMap);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
