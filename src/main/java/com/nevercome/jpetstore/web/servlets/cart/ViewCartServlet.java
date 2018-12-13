package com.nevercome.jpetstore.web.servlets.cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cart/viewCart")
public class ViewCartServlet extends HttpServlet {
    private static final String VIEW_CART = "/WEB-INF/views/modules/cart/Cart.jsp";


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(VIEW_CART).forward(request, response);
    }
}
