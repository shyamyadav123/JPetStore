package com.nevercome.jpetstore.persistence.db;

import java.sql.*;
import java.util.*;

public final class DBUtil {

    /***
     * sun
     * 数据库查询
     * 反射机制的自动转换下次有空再自己写吧
     * @param sql
     * @param bindArgs
     * @return
     * @throws SQLException
     */
    public static ResultSet executeQuery(String sql, List<Object> bindArgs) throws SQLException {
        List<Map<String, Object>> data = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            if (bindArgs != null) {
                for (int i = 0; i < bindArgs.size(); i++) {
                    preparedStatement.setObject(i + 1, bindArgs.get(i));
                }
            }
//            System.out.println(getExecSQL(sql, bindArgs));
            resultSet = preparedStatement.executeQuery();
//            data = getData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return resultSet;
    }

    /***
     * sun
     * 执行增删改操作
     * @param sql
     * @param bindArgs
     * @return
     * @throws SQLException
     */
    public static int executeUpdate(String sql, Object[] bindArgs) throws SQLException {
        int affectRowCount = -1;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            // 禁止默认提交
            connection.setAutoCommit(false);
//            System.out.println(getExecSQL(sql, bindArgs));
            if (bindArgs != null) {
                for (int i = 0; i < bindArgs.length; i++) {
                    preparedStatement.setObject(i + 1, bindArgs[i]);
                }
            }
            affectRowCount = preparedStatement.executeUpdate();
            connection.commit();
//            String operate;
//            if (sql.toUpperCase().indexOf("DELETE FROM") != -1) {
//                operate = "删除";
//            } else if (sql.toUpperCase().indexOf("INSERT INTO") != -1) {
//                operate = "新增";
//            } else {
//                operate = "修改";
//            }
//            System.out.println("成功" + operate + "了" + affectRowCount + "行");
//            System.out.println();
        } catch (Exception e) {
            if (connection != null) {
                // 事务回滚
                connection.rollback();
            }
            e.printStackTrace();
            throw e;
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return affectRowCount;
    }

    /***
     * sun
     * 简化的插入操作
     * @param tableName
     * @param valueMap
     * @return
     * @throws SQLException
     */
    public static int insert(String tableName, Map<String, Object> valueMap) throws SQLException {

        Set<String> keySet = valueMap.keySet();
        Iterator<String> iterator = keySet.iterator();
        StringBuilder columnSql = new StringBuilder();
        StringBuilder unknownMarkSql = new StringBuilder();
        Object[] bindArgs = new Object[valueMap.size()];
        int i = 0;
        while (iterator.hasNext()) {
            String key = iterator.next();
            columnSql.append(i == 0 ? "" : ",");
            columnSql.append(key);

            unknownMarkSql.append(i == 0 ? "" : ",");
            unknownMarkSql.append("?");
            bindArgs[i] = valueMap.get(key);
            i++;
        }

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ");
        sql.append(tableName);
        sql.append(" (");
        sql.append(columnSql);
        sql.append(" )  VALUES (");
        sql.append(unknownMarkSql);
        sql.append(" )");

        return executeUpdate(sql.toString(), bindArgs);
    }

    /***
     * sun
     * 进行更新的简化操作
     * @param tableName
     * @param valueMap
     * @param whereMap
     * @return
     * @throws SQLException
     */
    public static int update(String tableName, Map<String, Object> valueMap, Map<String, Object> whereMap) throws SQLException {
        Set<String> keySet = valueMap.keySet();
        Iterator<String> iterator = keySet.iterator();
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE ");
        sql.append(tableName);
        sql.append(" SET ");

        StringBuilder columnSql = new StringBuilder();
        int i = 0;
        List<Object> objects = new ArrayList<>();
        while (iterator.hasNext()) {
            String key = iterator.next();
            columnSql.append(i == 0 ? "" : ",");
            columnSql.append(key + " = ? ");
            objects.add(valueMap.get(key));
            i++;
        }
        sql.append(columnSql);

        StringBuilder whereSql = new StringBuilder();
        int j = 0;
        if (whereMap != null && whereMap.size() > 0) {
            whereSql.append(" WHERE ");
            iterator = whereMap.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                whereSql.append(j == 0 ? "" : " AND ");
                whereSql.append(key + " = ? ");
                objects.add(whereMap.get(key));
                j++;
            }
            sql.append(whereSql);
        }
        return executeUpdate(sql.toString(), objects.toArray());
    }

    /***
     * sun
     * 删除的简化操作
     * @param tableName
     * @param whereMap
     * @return
     * @throws SQLException
     */
    public static int delete(String tableName, Map<String, Object> whereMap) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM ");
        sql.append(tableName);

        StringBuilder whereSql = new StringBuilder();
        Object[] bindArgs = null;
        if (whereMap != null && whereMap.size() > 0) {
            bindArgs = new Object[whereMap.size()];
            whereSql.append(" WHERE ");
            Set<String> keySet = whereMap.keySet();
            Iterator<String> iterator = keySet.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                String key = iterator.next();
                whereSql.append(i == 0 ? "" : " AND ");
                whereSql.append(key + " = ? ");
                bindArgs[i] = whereMap.get(key);
                i++;
            }
            sql.append(whereSql);
        }
        return executeUpdate(sql.toString(), bindArgs);
    }
}
