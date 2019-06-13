package org.csu.jpetstore.controller;

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

    @Authorization
    @PutMapping("/{id}")
    public PlatformResult updateAccount(@PathVariable("id") String id, @RequestBody Account account) {
        accountService.updateAccount(account);
        return PlatformResult.success(accountService.getAccount(account.getUsername()));
    }

}
