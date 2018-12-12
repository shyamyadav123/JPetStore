package com.nevercome.jpetstore.persistence.dao.impl;

import com.nevercome.jpetstore.domain.model.Item;
import com.nevercome.jpetstore.domain.model.Product;
import com.nevercome.jpetstore.persistence.dao.ItemDAO;
import com.nevercome.jpetstore.persistence.db.DBUtil;
import com.nevercome.jpetstore.utils.Global;

import java.math.BigDecimal;
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
        String sql = "select qty from inventory where itemid=?";
        List<Object> bindArgs = new ArrayList<>();
        bindArgs.add(itemId);
        int qty = 0;
        try {
            ResultSet rs = DBUtil.executeQuery(sql, bindArgs);
            while (rs.next()) {
                qty = rs.getInt(Global.COL_ITEM_QTY);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return qty;
    }

    @Override
    public List<Item> getItemListByProduct(String productId) {
        String sql = "select a.*,b.*,c.qty from item a, product b, inventory c where a.productid=b.productid and a.itemid=c.itemid and a.productid=?";
        List<Object> bindArgs = new ArrayList<>();
        bindArgs.add(productId);
        List<Item> itemList = new ArrayList<>();
        try {
            ResultSet rs = DBUtil.executeQuery(sql, bindArgs);
            while (rs.next()) {
                Item item = new Item();
                Product product = new Product();
                product.setProductId(rs.getString(Global.COL_PRODUCT_ID));
                product.setName(rs.getString(Global.COL_PRODUCT_NAME));
                product.setCategoryId(rs.getString(Global.COL_PRODUCT_CATEGORY));
                product.setDescription(rs.getString(Global.COL_CATEGORY_DESCN));
                item.setProduct(product);
                item.setItemId(rs.getString(Global.COL_ITEM_ID));
                item.setProductId(rs.getString(Global.COL_ITEM_PRODUCTID));
                item.setListPrice(new BigDecimal(rs.getString(Global.COL_ITEM_LISTPRICE)));
                item.setUnitCost(new BigDecimal(rs.getString(Global.COL_ITEM_UNITCOST)));
                item.setSupplierId(rs.getInt(Global.COL_ITEM_SUPPLIER));
                item.setStatus(rs.getString(Global.COL_ITEM_STATUS));
                item.setAttribute1(rs.getString(Global.COL_ITEM_ATTR1));
                item.setAttribute2(rs.getString(Global.COL_ITEM_ATTR2));
                item.setAttribute3(rs.getString(Global.COL_ITEM_ATTR3));
                item.setAttribute4(rs.getString(Global.COL_ITEM_ATTR4));
                item.setAttribute5(rs.getString(Global.COL_ITEM_ATTR5));
                item.setQuantity(rs.getInt(Global.COL_ITEM_QTY));
                itemList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    @Override
    public Item getItem(String itemId) {
        String sql = "select a.*,b.*,c.qty from item a, product b, inventory c where a.productid=b.productid and a.itemid=c.itemid and a.itemid=?";
        List<Object> bindArgs = new ArrayList<>();
        bindArgs.add(itemId);
        Item item = new Item();
        try {
            ResultSet rs = DBUtil.executeQuery(sql, bindArgs);
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString(Global.COL_PRODUCT_ID));
                product.setName(rs.getString(Global.COL_PRODUCT_NAME));
                product.setCategoryId(rs.getString(Global.COL_PRODUCT_CATEGORY));
                product.setDescription(rs.getString(Global.COL_CATEGORY_DESCN));
                item.setProduct(product);
                item.setItemId(rs.getString(Global.COL_ITEM_ID));
                item.setProductId(rs.getString(Global.COL_ITEM_PRODUCTID));
                item.setListPrice(new BigDecimal(rs.getString(Global.COL_ITEM_LISTPRICE)));
                item.setUnitCost(new BigDecimal(rs.getString(Global.COL_ITEM_UNITCOST)));
                item.setSupplierId(rs.getInt(Global.COL_ITEM_SUPPLIER));
                item.setStatus(rs.getString(Global.COL_ITEM_STATUS));
                item.setAttribute1(rs.getString(Global.COL_ITEM_ATTR1));
                item.setAttribute2(rs.getString(Global.COL_ITEM_ATTR2));
                item.setAttribute3(rs.getString(Global.COL_ITEM_ATTR3));
                item.setAttribute4(rs.getString(Global.COL_ITEM_ATTR4));
                item.setAttribute5(rs.getString(Global.COL_ITEM_ATTR5));
                item.setQuantity(rs.getInt(Global.COL_ITEM_QTY));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }
}
