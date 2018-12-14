package com.nevercome.jpetstore.web.servlets.order;

import com.nevercome.jpetstore.domain.model.Account;
import com.nevercome.jpetstore.domain.model.Cart;
import com.nevercome.jpetstore.domain.model.Order;
import com.nevercome.jpetstore.service.OrderService;
import com.nevercome.jpetstore.service.impl.OrderServiceImpl;

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

@WebServlet("/order/newOrderForm")
public class NewOrderFormServlet extends HttpServlet {
    private static final String NEW_ORDER = "/WEB-INF/views/modules/order/NewOrderForm.jsp";


    private static final String SIGNIN = "/WEB-INF/views/modules/account/SignInForm.jsp";
    private static final String ERROR = "/WEB-INF/views/modules/common/Error.jsp";

    private OrderService orderService = OrderServiceImpl.getInstance();

    private Order order = new Order();

    private static final List<String> CARD_TYPE_LIST;

    static {
        List<String> cardList = new ArrayList<String>();
        cardList.add("Visa");
        cardList.add("MasterCard");
        cardList.add("American Express");
        CARD_TYPE_LIST = Collections.unmodifiableList(cardList);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("creditCardTypes") == null) {
            session.setAttribute("creditCardTypes", CARD_TYPE_LIST);
        }
        String message = "";
        Account account = (Account) session.getAttribute("account");
        Cart cart = (Cart) session.getAttribute("cart");
        if (account == null || !account.isAuthenticated()) {
            message = "You must sign on before attempting to check out.  Please sign on and try checking out again.";
            request.setAttribute("message", message);
            request.getRequestDispatcher(SIGNIN).forward(request, response);
        } else if(cart != null) {
            order.initOrder(account, cart);
            request.getRequestDispatcher(NEW_ORDER).forward(request, response);
        } else {
            message = "You must sign on before attempting to check out.  Please sign on and try checking out again.";
            request.setAttribute("message", message);
            request.getRequestDispatcher(ERROR).forward(request, response);
        }
    }
}
