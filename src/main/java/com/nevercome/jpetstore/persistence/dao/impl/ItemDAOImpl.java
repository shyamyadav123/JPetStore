package com.nevercome.jpetstore.persistence.dao.impl;

import com.nevercome.jpetstore.domain.model.Item;
import com.nevercome.jpetstore.domain.model.Product;
import com.nevercome.jpetstore.persistence.dao.ItemDAO;
import com.nevercome.jpetstore.persistence.db.DBConnectionPool;
import com.nevercome.jpetstore.persistence.db.DBUtil;
import com.nevercome.jpetstore.utils.Global;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemDAOImpl implements ItemDAO {

    private static class SingletonHolder {
        private static final ItemDAO INSTANCE = new ItemDAOImpl();
    }
    private ItemDAOImpl() {}
    public static final ItemDAO getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void updateInventoryQuantity(Map<String, Object> param) {
        String sql = "update inventory set qty=qty-? where itemid=?";
        try {
            int count = DBUtil.update("inventory", param, param);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getInventoryQuantity(String itemId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select qty from inventory where itemid=?";
        List<Object> bindArgs = new ArrayList<>();
        bindArgs.add(itemId);
        int qty = 0;
        try {
            connection = DBConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < bindArgs.size(); i++) {
                preparedStatement.setObject(i + 1, bindArgs.get(i));
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                qty = resultSet.getInt(Global.COL_ITEM_QTY);
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
        return qty;
    }

    @Override
    public List<Item> getItemListByProduct(String productId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select a.*,b.*,c.qty from item a, product b, inventory c where a.productid=b.productid and a.itemid=c.itemid and a.productid=?";
        List<Object> bindArgs = new ArrayList<>();
        bindArgs.add(productId);
        List<Item> itemList = new ArrayList<>();
        try {
            connection = DBConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < bindArgs.size(); i++) {
                preparedStatement.setObject(i + 1, bindArgs.get(i));
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Item item = new Item();
                Product product = new Product();
                product.setProductId(resultSet.getString(Global.COL_PRODUCT_ID));
                product.setName(resultSet.getString(Global.COL_PRODUCT_NAME));
                product.setCategoryId(resultSet.getString(Global.COL_PRODUCT_CATEGORY));
                product.setDescription(resultSet.getString(Global.COL_CATEGORY_DESCN));
                item.setProduct(product);
                item.setItemId(resultSet.getString(Global.COL_ITEM_ID));
                item.setProductId(resultSet.getString(Global.COL_ITEM_PRODUCTID));
                item.setListPrice(new BigDecimal(resultSet.getString(Global.COL_ITEM_LISTPRICE)));
                item.setUnitCost(new BigDecimal(resultSet.getString(Global.COL_ITEM_UNITCOST)));
                item.setSupplierId(resultSet.getInt(Global.COL_ITEM_SUPPLIER));
                item.setStatus(resultSet.getString(Global.COL_ITEM_STATUS));
                item.setAttribute1(resultSet.getString(Global.COL_ITEM_ATTR1));
                item.setAttribute2(resultSet.getString(Global.COL_ITEM_ATTR2));
                item.setAttribute3(resultSet.getString(Global.COL_ITEM_ATTR3));
                item.setAttribute4(resultSet.getString(Global.COL_ITEM_ATTR4));
                item.setAttribute5(resultSet.getString(Global.COL_ITEM_ATTR5));
                item.setQuantity(resultSet.getInt(Global.COL_ITEM_QTY));
                itemList.add(item);
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
        return itemList;
    }

    @Override
    public Item getItem(String itemId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select a.*,b.*,c.qty from item a, product b, inventory c where a.productid=b.productid and a.itemid=c.itemid and a.itemid=?";
        List<Object> bindArgs = new ArrayList<>();
        bindArgs.add(itemId);
        Item item = new Item();
        try {
            connection = DBConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < bindArgs.size(); i++) {
                preparedStatement.setObject(i + 1, bindArgs.get(i));
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getString(Global.COL_PRODUCT_ID));
                product.setName(resultSet.getString(Global.COL_PRODUCT_NAME));
                product.setCategoryId(resultSet.getString(Global.COL_PRODUCT_CATEGORY));
                product.setDescription(resultSet.getString(Global.COL_CATEGORY_DESCN));
                item.setProduct(product);
                item.setItemId(resultSet.getString(Global.COL_ITEM_ID));
                item.setProductId(resultSet.getString(Global.COL_ITEM_PRODUCTID));
                item.setListPrice(new BigDecimal(resultSet.getString(Global.COL_ITEM_LISTPRICE)));
                item.setUnitCost(new BigDecimal(resultSet.getString(Global.COL_ITEM_UNITCOST)));
                item.setSupplierId(resultSet.getInt(Global.COL_ITEM_SUPPLIER));
                item.setStatus(resultSet.getString(Global.COL_ITEM_STATUS));
                item.setAttribute1(resultSet.getString(Global.COL_ITEM_ATTR1));
                item.setAttribute2(resultSet.getString(Global.COL_ITEM_ATTR2));
                item.setAttribute3(resultSet.getString(Global.COL_ITEM_ATTR3));
                item.setAttribute4(resultSet.getString(Global.COL_ITEM_ATTR4));
                item.setAttribute5(resultSet.getString(Global.COL_ITEM_ATTR5));
                item.setQuantity(resultSet.getInt(Global.COL_ITEM_QTY));
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
        return item;
    }
}
