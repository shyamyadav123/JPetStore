package org.csu.jpetstore.controller;

import org.csu.jpetstore.common.exception.BusinessException;
import org.csu.jpetstore.common.exception.DataConflictException;
import org.csu.jpetstore.common.result.PlatformResult;
import org.csu.jpetstore.common.result.ResponseResult;
import org.csu.jpetstore.common.security.Authorization;
import org.csu.jpetstore.common.validation.groups.CreateGroup;
import org.csu.jpetstore.domain.Account;
import org.csu.jpetstore.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
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
    @ResponseStatus(HttpStatus.OK)
    public PlatformResult getAccountStatus(@PathVariable("id") String id) {
        Account account = accountService.getAccount(id);
        if (account != null) {
            return PlatformResult.failure("Account is exist");
        } else {
            return PlatformResult.success("Account is available");
        }
    }

//    @Authorization
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PlatformResult updateAccount(@PathVariable("id") String id, @RequestBody Account account) {
        accountService.updateAccount(account);
        return PlatformResult.success(accountService.getAccount(account.getUsername()));
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public PlatformResult createAccount(@Validated(CreateGroup.class) @RequestBody Account account) {
        if(accountService.getAccount(account.getUsername()) != null) {
            throw new DataConflictException("Account is exist");
        }
        account.setFavouriteCategoryId("CATS");
        account.setLanguagePreference("english");
        accountService.insertAccount(account);
        return PlatformResult.success(accountService.getAccount(account.getUsername()));
    }
}
