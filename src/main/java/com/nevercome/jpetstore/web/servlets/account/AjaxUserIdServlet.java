package com.nevercome.jpetstore.web.servlets.account;

import com.nevercome.jpetstore.service.AccountService;
import com.nevercome.jpetstore.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/account/ajax_checkUserId")
public class AjaxUserIdServlet extends HttpServlet {

    private AccountService accountService = AccountServiceImpl.getInstance();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String userId = request.getParameter("userId");

            String result = accountService.checkUserId(userId);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            System.out.println(result);
            out.print(result);
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
