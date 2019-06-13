package org.csu.jpetstore.service.impl;

import org.csu.jpetstore.domain.Cart;
import org.csu.jpetstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * @author: sun
 * @date: 2019/6/13
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ValueOperations valueOperations;

    @Override
    public Cart getCart(String cartId) {
        Cart cart = (Cart) valueOperations.get(cartId);
        return cart;
    }
}
