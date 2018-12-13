package com.nevercome.jpetstore.persistence.dao.impl;

import com.nevercome.jpetstore.domain.model.Product;
import com.nevercome.jpetstore.persistence.dao.ProductDAO;
import com.nevercome.jpetstore.persistence.db.DBConnectionPool;
import com.nevercome.jpetstore.persistence.db.DBUtil;
import com.nevercome.jpetstore.utils.Global;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from product where category=?";
        List<Object> bindArgs = new ArrayList<>();
        bindArgs.add(categoryId);
        List<Product> productList = new ArrayList<>();
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
                product.setCategoryId(resultSet.getString(Global.COL_PRODUCT_CATEGORY));
                product.setName(resultSet.getString(Global.COL_PRODUCT_NAME));
                product.setDescription(resultSet.getString(Global.COL_PRODUCT_DESCN));
                productList.add(product);
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
        return productList;
    }

    @Override
    public Product getProduct(String productId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from product where productid=?";
        List<Object> bindArgs = new ArrayList<>();
        bindArgs.add(productId);
        Product product = new Product();
        try {
            connection = DBConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < bindArgs.size(); i++) {
                preparedStatement.setObject(i + 1, bindArgs.get(i));
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product.setProductId(resultSet.getString(Global.COL_PRODUCT_ID));
                product.setCategoryId(resultSet.getString(Global.COL_PRODUCT_CATEGORY));
                product.setName(resultSet.getString(Global.COL_PRODUCT_NAME));
                product.setDescription(resultSet.getString(Global.COL_PRODUCT_DESCN));
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
        return product;
    }

    @Override
    public List<Product> searchProductList(String keywords) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from product where lower(name) like ?";
        List<Object> bindArgs = new ArrayList<>();
        bindArgs.add(keywords);
        List<Product> productList = new ArrayList<>();
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
                product.setCategoryId(resultSet.getString(Global.COL_PRODUCT_CATEGORY));
                product.setName(resultSet.getString(Global.COL_PRODUCT_NAME));
                product.setDescription(resultSet.getString(Global.COL_PRODUCT_DESCN));
                productList.add(product);
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
        return productList;
    }
}
