package com.nevercome.jpetstore.web.servlets.catalog;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

    private static final String MAIN = "/WEB-INF/views/modules/catalog/Main.jsp";

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        request.getRequestDispatcher(MAIN).forward(request, response);
    }
}
