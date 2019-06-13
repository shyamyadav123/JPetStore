package org.csu.jpetstore.controller;

import org.csu.jpetstore.common.result.PlatformResult;
import org.csu.jpetstore.common.result.ResponseResult;
import org.csu.jpetstore.service.CartService;
import org.csu.jpetstore.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: sun
 * @date: 2019/6/13
 */
@ResponseResult
@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartController {

    @Autowired
    private CatalogService catalogService;
    @Autowired
    private CartService cartService;

    @GetMapping("/{id}")
    public PlatformResult getCart(@PathVariable("id") String cartId) {
        return PlatformResult.success(cartService.getCart(cartId));
    }

}
