package com.nevercome.jpetstore.web.servlets.account;

import com.nevercome.jpetstore.domain.model.Account;
import com.nevercome.jpetstore.domain.model.Product;
import com.nevercome.jpetstore.service.AccountService;
import com.nevercome.jpetstore.service.CatalogService;
import com.nevercome.jpetstore.service.impl.AccountServiceImpl;
import com.nevercome.jpetstore.service.impl.CatalogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/account/signIn")
public class SignInServlet extends HttpServlet {

    private static final String SIGNIN = "/WEB-INF/views/modules/account/SignInForm.jsp";

    private AccountService accountService = AccountServiceImpl.getInstance();
    private CatalogService catalogService = CatalogServiceImpl.getInstance();
    //    private Account account;
    private List<Product> myList;

    public void doPost(Account account, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(Account account, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        account = accountService.getAccount(account.getUserId(), account.getPassword());
        if (account == null) {
            String value = "Invalid username or password.  SignIn failed.";
            request.setAttribute("message", value);
            request.getRequestDispatcher(SIGNIN).forward(request, response);
        } else {
            account.setPassword(null);
            myList = catalogService.getProductListByCategory(account.getFavouriteCategoryId());
            account.setAuthenticated(true);
            HttpSession session = request.getSession();
            session.setAttribute("account", account);
            session.setAttribute("myList", myList);
            response.sendRedirect("/main");
        }
    }
}
