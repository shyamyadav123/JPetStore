package com.nevercome.jpetstore.web.servlets.account;

import com.nevercome.jpetstore.domain.model.Account;
import com.nevercome.jpetstore.domain.model.Product;
import com.nevercome.jpetstore.service.AccountService;
import com.nevercome.jpetstore.service.CatalogService;
import com.nevercome.jpetstore.service.impl.AccountServiceImpl;
import com.nevercome.jpetstore.service.impl.CatalogServiceImpl;
import com.nevercome.jpetstore.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/account/editAccount")
public class EditAccountServlet extends HttpServlet {

    private AccountService accountService = AccountServiceImpl.getInstance();
    private CatalogService catalogService = CatalogServiceImpl.getInstance();
    private Account account;
    private List<Product> myList;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        account = new Account();
        account.setUserId(request.getParameter("account.userId"));
        account.setEmail(request.getParameter("account.email"));
        account.setPhone(request.getParameter("account.phone"));
        account.setFavouriteCategoryId(request.getParameter("account.favCategory"));
        account.setFirstName(request.getParameter("account.firstName"));
        account.setLastName(request.getParameter("account.lastName"));
        account.setLanguagePreference(request.getParameter("account.languagePreference"));
        account.setFavouriteCategoryId("account.favouriteCategoryId");
        account.setCity(request.getParameter("account.city"));
        account.setZip(request.getParameter("account.zip"));
//        account.setStatus(request.getParameter("status"));
        account.setState(request.getParameter("account.state"));
        account.setCountry(request.getParameter("account.country"));
        String listOption = request.getParameter("account.listOption");
        String bannerOption = request.getParameter("account.bannerOption");
        account.setAddress1(request.getParameter("account.address1"));
        account.setAddress2(request.getParameter("account.address2"));
        if(StringUtils.isNoneBlank(listOption)) {
            account.setListOption(true);
        }
        if(StringUtils.isNoneBlank(bannerOption)) {
            account.setBannerOption(true);
        }
        accountService.updateAccount(account);
        account = accountService.getAccount(account.getUserId());
        myList = catalogService.getProductListByCategory(account.getFavouriteCategoryId());
        HttpSession session = request.getSession();
        session.setAttribute("account", account);
        session.setAttribute("myList", myList);
        String redirect = request.getContextPath() + "/main";
        response.sendRedirect(redirect);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        doPost(request, response);
    }
}
