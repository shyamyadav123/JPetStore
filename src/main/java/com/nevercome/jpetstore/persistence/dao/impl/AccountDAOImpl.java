package com.nevercome.jpetstore.persistence.dao.impl;

import com.nevercome.jpetstore.domain.model.Account;
import com.nevercome.jpetstore.persistence.dao.AccountDAO;
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

public class AccountDAOImpl implements AccountDAO {

    private static class SingletonHolder {
        private static final AccountDAO INSTANCE = new AccountDAOImpl();
    }

    private AccountDAOImpl() {
    }

    public static final AccountDAO getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public Account getAccountByUserId(String userId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select a.*,b.*,c.*,d.* from account a, profile b, signon c, bannerdata d " +
                "where a.userid=b.userid and a.userid=c.username and b.favcategory=d.favcategory and a.userid=?";
        List<Object> bindArgs = new ArrayList<>();
        bindArgs.add(userId);
        Account account = new Account();
        try {
            connection = DBConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < bindArgs.size(); i++) {
                preparedStatement.setObject(i + 1, bindArgs.get(i));
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                account.setUserId(resultSet.getString(Global.COL_ACCOUNT_ID));
                account.setEmail(resultSet.getString(Global.COL_ACCOUNT_EMAIL));
                account.setFirstName(resultSet.getString(Global.COL_ACCOUNT_FIRSTNAME));
                account.setLastName(resultSet.getString(Global.COL_ACCOUNT_LASTNAME));
                account.setAddress1(resultSet.getString(Global.COL_ACCOUNT_ADDR1));
                account.setAddress2(resultSet.getString(Global.COL_ACCOUNT_ADDR2));
                account.setStatus(resultSet.getString(Global.COL_ACCOUNT_STATUS));
                account.setCity(resultSet.getString(Global.COL_ACCOUNT_CITY));
                account.setState(resultSet.getString(Global.COL_ACCOUNT_STATE));
                account.setZip(resultSet.getString(Global.COL_ACCOUNT_ZIP));
                account.setCountry(resultSet.getString(Global.COL_ACCOUNT_COUNTRY));
                account.setPhone(resultSet.getString(Global.COL_ACCOUNT_PHONE));
                account.setBannerName(resultSet.getString(Global.COL_BANNERDATA_FAVCATEGORY));
                account.setLanguagePreference(resultSet.getString(Global.COL_PROFILE_LANGPREF));
                account.setFavouriteCategoryId(resultSet.getString(Global.COL_PROFILE_MYLISTOPT));
                account.setPassword(resultSet.getString(Global.COL_SIGNON_PASSWORD));
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
        return account;
    }

    @Override
    public Account getAccountByUserIdAndPassword(Account account1) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select a.*,b.*,c.*,d.* from account a, profile b, signon c, bannerdata d " +
                "where a.userid=b.userid and a.userid=c.username and b.favcategory=d.favcategory and a.userid=? and c.password=?";
        List<Object> bindArgs = new ArrayList<>();
        bindArgs.add(account1.getUserId());
        bindArgs.add(account1.getPassword());
        Account account = new Account();
        try {
            connection = DBConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < bindArgs.size(); i++) {
                preparedStatement.setObject(i + 1, bindArgs.get(i));
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                account.setUserId(resultSet.getString(Global.COL_ACCOUNT_ID));
                account.setEmail(resultSet.getString(Global.COL_ACCOUNT_EMAIL));
                account.setFirstName(resultSet.getString(Global.COL_ACCOUNT_FIRSTNAME));
                account.setLastName(resultSet.getString(Global.COL_ACCOUNT_LASTNAME));
                account.setAddress1(resultSet.getString(Global.COL_ACCOUNT_ADDR1));
                account.setAddress2(resultSet.getString(Global.COL_ACCOUNT_ADDR2));
                account.setStatus(resultSet.getString(Global.COL_ACCOUNT_STATUS));
                account.setCity(resultSet.getString(Global.COL_ACCOUNT_CITY));
                account.setState(resultSet.getString(Global.COL_ACCOUNT_STATE));
                account.setZip(resultSet.getString(Global.COL_ACCOUNT_ZIP));
                account.setCountry(resultSet.getString(Global.COL_ACCOUNT_COUNTRY));
                account.setPhone(resultSet.getString(Global.COL_ACCOUNT_PHONE));
                account.setBannerName(resultSet.getString(Global.COL_BANNERDATA_FAVCATEGORY));
                account.setLanguagePreference(resultSet.getString(Global.COL_PROFILE_LANGPREF));
                account.setFavouriteCategoryId(resultSet.getString(Global.COL_PROFILE_MYLISTOPT));
                account.setPassword(resultSet.getString(Global.COL_SIGNON_PASSWORD));
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
        return account;
    }

    @Override
    public void insertAccount(Account account) {
        Map<String, Object> valMap = new HashMap<>();
        valMap.put(Global.COL_ACCOUNT_ID, account.getUserId());
        valMap.put(Global.COL_ACCOUNT_EMAIL, account.getEmail());
        valMap.put(Global.COL_ACCOUNT_FIRSTNAME, account.getFirstName());
        valMap.put(Global.COL_ACCOUNT_LASTNAME, account.getLastName());
        valMap.put(Global.COL_ACCOUNT_STATUS, account.getStatus());
        valMap.put(Global.COL_ACCOUNT_ADDR1, account.getAddress1());
        valMap.put(Global.COL_ACCOUNT_ADDR2, account.getAddress2());
        valMap.put(Global.COL_ACCOUNT_CITY, account.getCity());
        valMap.put(Global.COL_ACCOUNT_STATE, account.getState());
        valMap.put(Global.COL_ACCOUNT_ZIP, account.getZip());
        valMap.put(Global.COL_ACCOUNT_COUNTRY, account.getCountry());
        valMap.put(Global.COL_ACCOUNT_PHONE, account.getPhone());
        try {
            int count = DBUtil.insert("account", valMap);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertProfile(Account account) {
        Map<String, Object> valMap = new HashMap<>();
        valMap.put(Global.COL_PROFILE_ID, account.getUserId());
        valMap.put(Global.COL_PROFILE_LANGPREF, account.getLanguagePreference());
        valMap.put(Global.COL_PROFILE_FAVCATEGORY, account.getFavouriteCategoryId());
        try {
            int count = DBUtil.insert("profile", valMap);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertSignIn(Account account) {
        Map<String, Object> valMap = new HashMap<>();
        valMap.put(Global.COL_SIGNON_USERNAME, account.getUserId());
        valMap.put(Global.COL_SIGNON_PASSWORD, account.getPassword());
        try {
            int count = DBUtil.insert("signon", valMap);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAccount(Account account) {
        Map<String, Object> valMap = new HashMap<>();
        Map<String, Object> whereMap = new HashMap<>();
        valMap.put(Global.COL_ACCOUNT_EMAIL, account.getEmail());
        valMap.put(Global.COL_ACCOUNT_FIRSTNAME, account.getFirstName());
        valMap.put(Global.COL_ACCOUNT_LASTNAME, account.getLastName());
        valMap.put(Global.COL_ACCOUNT_STATUS, account.getStatus());
        valMap.put(Global.COL_ACCOUNT_ADDR1, account.getAddress1());
        valMap.put(Global.COL_ACCOUNT_ADDR2, account.getAddress2());
        valMap.put(Global.COL_ACCOUNT_CITY, account.getCity());
        valMap.put(Global.COL_ACCOUNT_STATE, account.getState());
        valMap.put(Global.COL_ACCOUNT_ZIP, account.getZip());
        valMap.put(Global.COL_ACCOUNT_COUNTRY, account.getCountry());
        valMap.put(Global.COL_ACCOUNT_PHONE, account.getPhone());
        whereMap.put(Global.COL_ACCOUNT_ID, account.getUserId());
        try {
            int count = DBUtil.update("account", valMap, whereMap);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProfile(Account account) {
        Map<String, Object> valMap = new HashMap<>();
        Map<String, Object> whereMap = new HashMap<>();
        valMap.put(Global.COL_PROFILE_LANGPREF, account.getLanguagePreference());
        valMap.put(Global.COL_PROFILE_FAVCATEGORY, account.getFavouriteCategoryId());
        whereMap.put(Global.COL_PROFILE_ID, account.getUserId());
        try {
            int count = DBUtil.update("profile", valMap, whereMap);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSignIn(Account account) {
        Map<String, Object> valMap = new HashMap<>();
        Map<String, Object> whereMap = new HashMap<>();
        valMap.put(Global.COL_PROFILE_LANGPREF, account.getLanguagePreference());
        whereMap.put(Global.COL_SIGNON_USERNAME, account.getUserId());
        try {
            int count = DBUtil.update("signon", valMap, whereMap);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
