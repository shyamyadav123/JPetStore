package com.nevercome.jpetstore.web.servlets.cart;

import com.nevercome.jpetstore.domain.model.Cart;
import com.nevercome.jpetstore.domain.model.CartItem;
import com.nevercome.jpetstore.service.AccountService;
import com.nevercome.jpetstore.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

@WebServlet("/cart/ajax_updateCart")
public class AjaxCartQuantityServlet extends HttpServlet {

    private static final String VIEW_CART = "/WEB-INF/views/modules/cart/Cart.jsp";
    private Cart cart;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            cart = (Cart) session.getAttribute("cart");
            Iterator<CartItem> cartItems = cart.getAllCartItems();
            while (cartItems.hasNext()) {
                CartItem cartItem = cartItems.next();
                String itemId = cartItem.getItem().getItemId();
                try {
                    String s = request.getParameter(itemId);
                    if (s != null) {
                        int quantity = Integer.parseInt(request.getParameter(itemId));
                        cart.setQuantityByItemId(itemId, quantity);
                        if (quantity < 1) {
                            cartItems.remove();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            request.getRequestDispatcher(VIEW_CART).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
