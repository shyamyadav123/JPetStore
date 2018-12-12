package com.nevercome.jpetstore.persistence.dao;

import com.nevercome.jpetstore.domain.model.Account;

public interface AccountDAO {
    Account getAccountByUserId(String userId);

    Account getAccountByUserIdAndPassword(Account account);

    void insertAccount(Account account);

    void insertProfile(Account account);

    void insertSignIn(Account account);

    void updateAccount(Account account);

    void updateProfile(Account account);

    void updateSignIn(Account account);
}
