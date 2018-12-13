package com.nevercome.jpetstore.persistence.dao.impl;

import com.nevercome.jpetstore.domain.model.Sequence;
import com.nevercome.jpetstore.persistence.dao.SequenceDAO;
import com.nevercome.jpetstore.persistence.db.DBConnectionPool;
import com.nevercome.jpetstore.persistence.db.DBUtil;
import com.nevercome.jpetstore.utils.Global;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SequenceDAOImpl implements SequenceDAO {

    private static class SingletonHolder {
        private static final SequenceDAO INSTANCE = new SequenceDAOImpl();
    }
    private SequenceDAOImpl() {}
    public static final SequenceDAO getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public Sequence getSequence(Sequence sequence) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from sequence where `name`=?";
        List<Object> bindArgs = new ArrayList<>();
        bindArgs.add(sequence.getName());
        Sequence sequence1 = new Sequence();
        try {
            connection = DBConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < bindArgs.size(); i++) {
                preparedStatement.setObject(i + 1, bindArgs.get(i));
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                sequence1.setName(resultSet.getString(Global.COL_SEQUENCE_NAME));
                sequence1.setNextId(resultSet.getInt(Global.COL_SEQUENCE_NEXITID));
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
        return sequence1;
    }

    @Override
    public void updateSequence(Sequence sequence) {
        Map<String, Object> valMap = new HashMap<>();
        Map<String ,Object> whereMap = new HashMap<>();
        valMap.put(Global.COL_SEQUENCE_NEXITID, sequence.getNextId());
        whereMap.put(Global.COL_SEQUENCE_NAME, sequence.getName());
        try {
            int count = DBUtil.update("sequence", valMap, whereMap);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
