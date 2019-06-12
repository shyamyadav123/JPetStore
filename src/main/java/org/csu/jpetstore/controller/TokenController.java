package org.csu.jpetstore.controller;

import org.csu.jpetstore.common.result.PlatformResult;
import org.csu.jpetstore.common.result.ResponseResult;
import org.csu.jpetstore.common.security.Authorization;
import org.csu.jpetstore.common.security.TokenManager;
import org.csu.jpetstore.domain.Account;
import org.csu.jpetstore.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * @author: sun
 * @date: 2019/6/12
 */
@ResponseResult
@RestController
@CrossOrigin
public class TokenController {

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private AccountService accountService;

    @PostMapping("/token")
    public PlatformResult login(@RequestParam("username") String username,
                                @RequestParam("password") String password) {
        Account account = accountService.getAccount(username,password);
        if(account == null) {
            return PlatformResult.failure("Invalid username or password.  Login failed.");
        }
        return PlatformResult.success(tokenManager.createToken(username));
    }

    @Authorization
    @DeleteMapping("/token")
    public PlatformResult logout(@RequestParam("username") String username) {
        tokenManager.deleteToken(username);
        return PlatformResult.success();
    }

}
