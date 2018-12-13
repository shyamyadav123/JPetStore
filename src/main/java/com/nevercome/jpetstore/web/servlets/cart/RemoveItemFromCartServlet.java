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

@WebServlet("/cart/removeItemFromCart")
public class RemoveItemFromCartServlet extends HttpServlet {

    private static final String VIEW_CART = "/WEB-INF/views/modules/cart/Cart.jsp";
    private static final String ERROR = "/WEB-INF/views/modules/common/Error.jsp";

    private CatalogService catalogService = CatalogServiceImpl.getInstance();

    private Cart cart;
    private String workingItemId;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        workingItemId = request.getParameter("workingItemId");
        cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }
        Item item = cart.removeItemById(workingItemId);
        request.getSession().setAttribute("cart", cart);
        if (item == null) {
            String message = "Attempted to remove null CartItem from Cart.";
            request.setAttribute("message", message);
            request.getRequestDispatcher(ERROR).forward(request, response);
        } else {
            request.getRequestDispatcher(VIEW_CART).forward(request, response);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
