package org.csu.jpetstore.controller;

import org.csu.jpetstore.common.exception.BusinessException;
import org.csu.jpetstore.common.result.PlatformResult;
import org.csu.jpetstore.common.result.ResponseResult;
import org.csu.jpetstore.common.security.Authorization;
import org.csu.jpetstore.domain.Account;
import org.csu.jpetstore.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: sun
 * @date: 2019/6/12
 */
@ResponseResult
@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Authorization
    @GetMapping("/{id}")
    public PlatformResult getAccount(@PathVariable("id") String id) {
        return PlatformResult.success(accountService.getAccount(id));
    }

    @GetMapping("/{id}/status")
    public PlatformResult getAccountStatus(@PathVariable("id") String id) {
        Account account = accountService.getAccount(id);
        if (account != null) {
            return PlatformResult.failure("Account is exist");
        } else {
            return PlatformResult.success("Account is available");
        }
    }

    @Authorization
    @PutMapping("/{id}")
    public PlatformResult updateAccount(@PathVariable("id") String id, @RequestBody Account account) {
        accountService.updateAccount(account);
        return PlatformResult.success(accountService.getAccount(account.getUsername()));
    }

    @PostMapping("")
    public PlatformResult createAccount(@RequestParam("username") String username,
                                        @RequestParam("password") String password) {
        if(accountService.getAccount(username) != null) {
            throw new BusinessException("Account is exist");
        }
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        accountService.insertAccount(account);
        return PlatformResult.success(accountService.getAccount(account.getUsername()));
    }

}
