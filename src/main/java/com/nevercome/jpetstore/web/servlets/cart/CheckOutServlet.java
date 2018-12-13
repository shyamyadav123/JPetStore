package com.nevercome.jpetstore.web.servlets.cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cart/checkOut")
public class CheckOutServlet {

    private static final String CHECK_OUT = "/WEB-INF/views/modules/cart/Checkout.jsp";

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(CHECK_OUT).forward(request, response);
    }
}
