package com.nevercome.jpetstore.web.servlets.account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/account/newAccountForm")
public class NewAccountFormServlet extends HttpServlet {

    private static final String NEW_ACCOUNT = "/WEB-INF/views/modules/account/NewAccountForm.jsp";

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        request.getRequestDispatcher(NEW_ACCOUNT).forward(request, response);
    }
}
