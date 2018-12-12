package com.nevercome.jpetstore.persistence.dao.impl;

import com.nevercome.jpetstore.domain.model.Category;
import com.nevercome.jpetstore.persistence.dao.CategoryDAO;
import com.nevercome.jpetstore.persistence.db.DBConnectionPool;
import com.nevercome.jpetstore.persistence.db.DBUtil;
import com.nevercome.jpetstore.utils.Global;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {

    private static class SingletonHolder {
        private static final CategoryDAO INSTANCE = new CategoryDAOImpl();
    }

    private CategoryDAOImpl() {
    }

    public static final CategoryDAO getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public List<Category> getCategoryList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from category";
        List<Category> categoryList = new ArrayList<>();
        try {
            connection = DBConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setCategoryId(resultSet.getString(Global.COL_CATEGORY_ID));
                category.setName(resultSet.getString(Global.COL_CATEGORY_NAME));
                category.setDescription(resultSet.getString(Global.COL_CATEGORY_DESCN));
                categoryList.add(category);
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
        return categoryList;
    }

    // 真的是噩梦一般的try catch啊
    @Override
    public Category getCategory(String categoryId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from category where catid=?";
        List<Object> bindArgs = new ArrayList<>();
        bindArgs.add(categoryId);
        Category category = new Category();
        try {
            connection = DBConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < bindArgs.size(); i++) {
                preparedStatement.setObject(i + 1, bindArgs.get(i));
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                category.setCategoryId(resultSet.getString(Global.COL_CATEGORY_ID));
                category.setName(resultSet.getString(Global.COL_CATEGORY_NAME));
                category.setDescription(resultSet.getString(Global.COL_CATEGORY_DESCN));
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
        return category;
    }
}
