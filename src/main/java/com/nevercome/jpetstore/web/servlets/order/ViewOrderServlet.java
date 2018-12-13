package com.nevercome.jpetstore.web.servlets.order;

import com.nevercome.jpetstore.domain.model.Account;
import com.nevercome.jpetstore.domain.model.Cart;
import com.nevercome.jpetstore.domain.model.Order;
import com.nevercome.jpetstore.service.OrderService;
import com.nevercome.jpetstore.service.impl.OrderServiceImpl;
import com.nevercome.jpetstore.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/order/viewOrder")
public class ViewOrderServlet extends HttpServlet {
    private static final String VIEW_ORDER = "/WEB-INF/views/modules/order/ViewOrder.jsp";

    private static final String ERROR = "/WEB-INF/views/modules/common/Error.jsp";

    private OrderService orderService = OrderServiceImpl.getInstance();

    private Order order = new Order();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        order = orderService.getOrder(StringUtils.toInteger(orderId));

        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");

        if (account.getUserId().equals(order.getUsername())) {
            request.getRequestDispatcher(VIEW_ORDER).forward(request, response);
        } else {
            order = null;
            String message = "You may only view your own orders.";
            request.setAttribute("message", message);
            request.getRequestDispatcher(ERROR).forward(request, response);
        }
    }
}
