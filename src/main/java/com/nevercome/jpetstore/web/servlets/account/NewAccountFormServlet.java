package com.nevercome.jpetstore.web.servlets.account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet("/account/newAccountForm")
public class NewAccountFormServlet extends HttpServlet {

    private static final String NEW_ACCOUNT = "/WEB-INF/views/modules/account/NewAccountForm.jsp";

    private static final List<String> LANGUAGE_LIST;
    private static final List<String> CATEGORY_LIST;

    static {
        List<String> langList = new ArrayList<String>();
        langList.add("english");
        langList.add("japanese");
        LANGUAGE_LIST = Collections.unmodifiableList(langList);

        List<String> catList = new ArrayList<String>();
        catList.add("FISH");
        catList.add("DOGS");
        catList.add("REPTILES");
        catList.add("CATS");
        catList.add("BIRDS");
        CATEGORY_LIST = Collections.unmodifiableList(catList);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        HttpSession session = request.getSession();
        List<String> langList = (List<String>) session.getAttribute("languages");
        if (langList == null) {
            session.setAttribute("languages", LANGUAGE_LIST);
        }
        List<String> categoryList = (List<String>) session.getAttribute("category");
        if (categoryList == null) {
            session.setAttribute("category", CATEGORY_LIST);
        }
        request.getRequestDispatcher(NEW_ACCOUNT).forward(request, response);
    }
}
