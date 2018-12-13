package com.nevercome.jpetstore.web.servlets.order;

import com.nevercome.jpetstore.domain.model.Account;
import com.nevercome.jpetstore.domain.model.Order;
import com.nevercome.jpetstore.service.OrderService;
import com.nevercome.jpetstore.service.impl.OrderServiceImpl;
import com.nevercome.jpetstore.utils.StringUtils;
import javafx.scene.layout.VBox;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/order/listOrders")
public class ListOrdersServlet extends HttpServlet {

    private static final String VIEW_ORDER = "/WEB-INF/views/modules/order/ViewOrder.jsp";

    private OrderService orderService = OrderServiceImpl.getInstance();

    private List<Order> orderList;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account)session.getAttribute("account");
        if(account != null) {
            orderList = orderService.getOrdersByUserId(account.getUserId());
            request.getRequestDispatcher(VIEW_ORDER).forward(request, response);
        }
    }
}
