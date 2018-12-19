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
import java.util.List;

@WebServlet("/account/signIn")
public class SignInServlet extends HttpServlet {

    private static final String SIGNIN = "/WEB-INF/views/modules/account/SignInForm.jsp";

    private AccountService accountService = AccountServiceImpl.getInstance();
    private CatalogService catalogService = CatalogServiceImpl.getInstance();
    private Account account;
    private List<Product> myList;

    //    这样子的bean入参...需要自己去写反射啊...我又..
//    一定要去学习一下反射
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String userCode = request.getParameter("verifyCode");
        HttpSession session = request.getSession();
        StringBuffer codeBuffer = (StringBuffer) session.getAttribute("code");
        if (VerifyCode.checkVerify(userCode, codeBuffer.toString())) {
            account = accountService.getAccount(userId, password);
            if (account == null) {
                String value = "Invalid username or password.  SignIn failed.";
                request.setAttribute("message", value);
                request.getRequestDispatcher(SIGNIN).forward(request, response);
            } else {
                account.setPassword(null);
                myList = catalogService.getProductListByCategory(account.getFavouriteCategoryId());
                account.setAuthenticated(true);
                session.setAttribute("account", account);
//                System.err.println(session.getAttribute("account"));
                session.setAttribute("myList", myList);
                String redirect = request.getContextPath() + "/main";
                response.sendRedirect(redirect);
            }
        } else {
            String value = "Wrong verification code. Please try again";
            request.setAttribute("message", value);
            request.getRequestDispatcher(SIGNIN).forward(request, response);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
//        account = accountService.getAccount(account.getUserId(), account.getPassword());
//        if (account == null) {
//            String value = "Invalid username or password.  SignIn failed.";
//            request.setAttribute("message", value);
//            request.getRequestDispatcher(SIGNIN).forward(request, response);
//        } else {
//            account.setPassword(null);
//            myList = catalogService.getProductListByCategory(account.getFavouriteCategoryId());
//            account.setAuthenticated(true);
//            HttpSession session = request.getSession();
//            session.setAttribute("account", account);
//            session.setAttribute("myList", myList);
//            response.sendRedirect("/main");
//        }
    }
}
