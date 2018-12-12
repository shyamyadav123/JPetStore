package com.nevercome.jpetstore.persistence.dao.impl;

import com.nevercome.jpetstore.domain.model.Account;
import com.nevercome.jpetstore.persistence.dao.AccountDAO;

import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {

    private static class SingletonHolder {
        private static final AccountDAO INSTANCE = new AccountDAOImpl();
    }

    private AccountDAOImpl() {}
    public static final AccountDAO getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public Account getAccountByUserId(String userId) {
        String sql = "";
        List<Object> bindArgs = new ArrayList<>();
        return null;
    }

    @Override
    public Account getAccountByUserIdAndPassword(Account account) {
        return null;
    }

    @Override
    public void insertAccount(Account account) {

    }

    @Override
    public void insertProfile(Account account) {

    }

    @Override
    public void insertSignIn(Account account) {

    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public void updateProfile(Account account) {

    }

    @Override
    public void updateSignIn(Account account) {

    }
}
