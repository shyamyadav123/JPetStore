package com.nevercome.jpetstore.persistence.dao.impl;

import com.nevercome.jpetstore.domain.model.Product;
import com.nevercome.jpetstore.persistence.dao.ProductDAO;
import com.nevercome.jpetstore.persistence.db.DBUtil;
import com.nevercome.jpetstore.utils.Global;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    private static class SingletonHolder {
        private static final ProductDAO INSTANCE = new ProductDAOImpl();
    }

    private ProductDAOImpl() {
    }

    public static final ProductDAO getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public List<Product> getProductListByCategory(String categoryId) {
        String sql = "select * from product where category=?";
        List<Object> bindArgs = new ArrayList<>();
        bindArgs.add(categoryId);
        List<Product> productList = new ArrayList<>();
        try {
            ResultSet rs = DBUtil.executeQuery(sql, bindArgs);
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString(Global.COL_PRODUCT_ID));
                product.setCategoryId(rs.getString(Global.COL_PRODUCT_CATEGORY));
                product.setName(rs.getString(Global.COL_PRODUCT_NAME));
                product.setDescription(rs.getString(Global.COL_PRODUCT_DESCN));
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product getProduct(String productId) {
        String sql = "select * from product where productid=?";
        List<Object> bindArgs = new ArrayList<>();
        bindArgs.add(productId);
        Product product = new Product();
        try {
            ResultSet rs = DBUtil.executeQuery(sql, bindArgs);
            while (rs.next()) {
                product.setProductId(rs.getString(Global.COL_PRODUCT_ID));
                product.setCategoryId(rs.getString(Global.COL_PRODUCT_CATEGORY));
                product.setName(rs.getString(Global.COL_PRODUCT_NAME));
                product.setDescription(rs.getString(Global.COL_PRODUCT_DESCN));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> searchProductList(String keywords) {
        String sql = "select * from product where lower(name) like ?";
        List<Object> bindArgs = new ArrayList<>();
        bindArgs.add(keywords);
        List<Product> productList = new ArrayList<>();
        try {
            ResultSet rs = DBUtil.executeQuery(sql, bindArgs);
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString(Global.COL_PRODUCT_ID));
                product.setCategoryId(rs.getString(Global.COL_PRODUCT_CATEGORY));
                product.setName(rs.getString(Global.COL_PRODUCT_NAME));
                product.setDescription(rs.getString(Global.COL_PRODUCT_DESCN));
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
