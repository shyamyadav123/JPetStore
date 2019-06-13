package org.csu.jpetstore.service;

import org.csu.jpetstore.domain.Cart;

/**
 * @author: sun
 * @date: 2019/6/13
 */
public interface CartService {

    Cart getCart(String cartId);

}
