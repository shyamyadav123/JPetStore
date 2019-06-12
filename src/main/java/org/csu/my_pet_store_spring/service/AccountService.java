package org.csu.my_pet_store_spring.service;

import org.csu.my_pet_store_spring.domain.Account;

public interface AccountService {

    public Account getAccount(String username);

    public Account getAccount(String username, String password);

    public void insertAccount(Account account);

    public void updateAccount(Account account);
}
