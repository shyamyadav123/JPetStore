package com.nevercome.jpetstore.web.servlets.account;

import com.nevercome.jpetstore.domain.model.Account;
import com.nevercome.jpetstore.domain.model.Product;
import com.nevercome.jpetstore.persistence.dao.ProductDAO;
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

@WebServlet("/account/newAccount")
public class NewAccountServlet extends HttpServlet {
    private static final String MAIN = "/WEB-INF/views/modules/catalog/Main.jsp";

    private AccountService accountService = AccountServiceImpl.getInstance();
    private CatalogService catalogService = CatalogServiceImpl.getInstance();
//    private Account account;
    private List<Product> myList;

    public void doPost(Account account, HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        doGet(account, request, response);
    }

    public void doGet(Account account, HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        accountService.insertAccount(account);
        account = accountService.getAccount(account.getUserId());
        myList = catalogService.getProductListByCategory(account.getFavouriteCategoryId());
        account.setAuthenticated(true);
        request.getRequestDispatcher(MAIN).forward(request, response);
    }
}
