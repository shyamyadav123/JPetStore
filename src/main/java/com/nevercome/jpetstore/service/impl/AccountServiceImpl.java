package com.nevercome.jpetstore.service.impl;

import com.nevercome.jpetstore.domain.model.Account;
import com.nevercome.jpetstore.persistence.dao.AccountDAO;
import com.nevercome.jpetstore.persistence.dao.impl.AccountDAOImpl;
import com.nevercome.jpetstore.service.AccountService;
import com.nevercome.jpetstore.utils.StringUtils;

public class AccountServiceImpl implements AccountService {

    private static class SingletonHolder {
        private static final AccountService INSTANCE = new AccountServiceImpl();
    }
    private AccountServiceImpl() {}
    public static final AccountService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private AccountDAO accountDAO = AccountDAOImpl.getInstance();

    @Override
    public Account getAccount(String userId) {
        return accountDAO.getAccountByUserId(userId);
    }

    @Override
    public Account getAccount(String userId, String password) {
        Account account = new Account();
        account.setUserId(userId);
        account.setPassword(password);
        return accountDAO.getAccountByUserIdAndPassword(account);
    }

    @Override
    // 我们这里的没办法把它们作为事务放在一起啊...
    // 多表更新的事务问题...
    public void insertAccount(Account account) {
        accountDAO.insertAccount(account);
        accountDAO.insertProfile(account);
        accountDAO.insertSignIn(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDAO.updateAccount(account);
        accountDAO.updateProfile(account);
        if(StringUtils.isNoneBlank(account.getPassword())) {
            accountDAO.updateSignIn(account);
        }
    }
}
