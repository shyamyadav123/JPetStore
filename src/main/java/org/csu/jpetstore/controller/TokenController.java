package org.csu.jpetstore.controller;

import org.csu.jpetstore.common.result.PlatformResult;
import org.csu.jpetstore.common.result.ResponseResult;
import org.csu.jpetstore.common.security.Authorization;
import org.csu.jpetstore.common.security.TokenManager;
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
@CrossOrigin
public class TokenController {

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private AccountService accountService;

    @PostMapping("/token")
    public PlatformResult login(@RequestParam("username") String username,
                                @RequestParam("password") String password) {
        Account account = accountService.getAccount(username, password);
        if (account == null) {
            return PlatformResult.failure("Invalid username or password.  Login failed.");
        }
        return PlatformResult.success(tokenManager.createToken(username));
    }

    @Authorization
    @DeleteMapping("/token/{id}")
    public PlatformResult logout(@PathVariable("id") String id) {
        tokenManager.deleteToken(id);
        return PlatformResult.success();
    }

    /**
     * 这里会有一个问题就是没登录操作的时候会不同的抛出异常
     * @param id
     * @return
     */
    @Authorization
    @PutMapping("/token/{id}")
    public PlatformResult update(@PathVariable("id") String id) {
        return PlatformResult.success();
    }

}
