package com.nevercome.jpetstore.web.servlets.account;

import com.nevercome.jpetstore.domain.model.Account;
import com.nevercome.jpetstore.domain.model.Product;
import com.nevercome.jpetstore.service.AccountService;
import com.nevercome.jpetstore.service.CatalogService;
import com.nevercome.jpetstore.service.impl.AccountServiceImpl;
import com.nevercome.jpetstore.service.impl.CatalogServiceImpl;
import com.nevercome.jpetstore.utils.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/account/ajax_login")
public class AjaxLoginServlet extends HttpServlet {

    private AccountService accountService = AccountServiceImpl.getInstance();
    private CatalogService catalogService = CatalogServiceImpl.getInstance();
    private Account account;
    private List<Product> myList;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String userCode = request.getParameter("verifyCode");
        HttpSession session = request.getSession();
        StringBuffer codeBuffer = (StringBuffer) session.getAttribute("code");

        PrintWriter out = response.getWriter();

        if (VerifyCode.checkVerify(userCode, codeBuffer.toString())) {
            account = accountService.getAccount(userId, password);
            if (account == null) {
                out.println("{\"status\": false,\"msg\":\"Invalid userId or password. SignIn failed.\"}");
            } else {
                account.setPassword(null);
                myList = catalogService.getProductListByCategory(account.getFavouriteCategoryId());
                account.setAuthenticated(true);
                session.setAttribute("account", account);
//                System.err.println(session.getAttribute("account"));
                session.setAttribute("myList", myList);
                out.println("{\"status\": true}");
            }
        } else {
            out.println("{\"status\": false,\"msg\":\"Incorrect Verify Code\"}");
        }

        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
