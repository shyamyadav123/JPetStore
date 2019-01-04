package com.nevercome.jpetstore.service;

import com.nevercome.jpetstore.domain.model.Account;

public interface AccountService {

    Account getAccount(String userId);

    Account getAccount(String userId, String password);

    void insertAccount(Account account);

    void updateAccount(Account account);

    String checkUserId(String userId);

}
