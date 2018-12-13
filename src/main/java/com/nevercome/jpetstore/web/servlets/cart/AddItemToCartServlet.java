package com.nevercome.jpetstore.web.servlets.cart;

import com.nevercome.jpetstore.domain.model.Cart;
import com.nevercome.jpetstore.domain.model.Item;
import com.nevercome.jpetstore.service.CatalogService;
import com.nevercome.jpetstore.service.impl.CatalogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cart/addItemToCart")
public class AddItemToCartServlet extends HttpServlet {

    private static final String VIEW_CART = "/WEB-INF/views/modules/cart/Cart.jsp";

    private CatalogService catalogService = CatalogServiceImpl.getInstance();

    private Cart cart;
    private String workingItemId;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        workingItemId = request.getParameter("workingItemId");
//        System.out.println(workingItemId+"#");
        cart = (Cart) request.getSession().getAttribute("cart");
//        System.out.println(workingItemId+"##");
        if (cart == null) {
            cart = new Cart();
        }
        if (cart.containsItemId(workingItemId)) {
            cart.incrementQuantityByItemId(workingItemId);
        } else {
            boolean isInStock = catalogService.isItemInStock(workingItemId);
            Item item = catalogService.getItem(workingItemId);
            cart.addItem(item, isInStock);
        }
//        System.out.println(workingItemId+"###");
        request.getSession().setAttribute("cart", cart);
//        System.out.println(workingItemId+"####");
        request.getRequestDispatcher(VIEW_CART).forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
