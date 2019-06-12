package org.csu.jpetstore.service;

import org.csu.jpetstore.domain.Account;

/**
 * @author: sun
 * @date: 2019/6/12
 */
public interface AccountService {

    Account getAccount(String username);

    Account getAccount(String username, String password);

    void insertAccount(Account account);

    void updateAccount(Account account);
}
