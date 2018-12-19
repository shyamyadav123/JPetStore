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

@WebServlet("/order/newOrder")
public class NewOrderServlet extends HttpServlet {

    private static final String SHIPPING = "/WEB-INF/views/modules/order/ShippingForm.jsp";
    private static final String CONFIRM_ORDER = "/WEB-INF/views/modules/order/ConfirmOrder.jsp";
    private static final String VIEW_ORDER = "/WEB-INF/views/modules/order/ViewOrder.jsp";

    private OrderService orderService = OrderServiceImpl.getInstance();

    private Order order = new Order();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (StringUtils.isNotBlank(request.getParameter("confirmed"))) {
            order.setConfirmed(true);
        } else {
            order.setConfirmed(false);
            order = (Order) request.getSession().getAttribute("order");
            if (order == null) {
                order = new Order();
            }
            order.setCardType(request.getParameter("order.cardType"));
            order.setBillAddress1(request.getParameter("order.billAddress1"));
            order.setBillAddress2(request.getParameter("order.billAddress2"));
            order.setBillCity(request.getParameter("order.billCity"));
            order.setBillCountry(request.getParameter("order.billCountry"));
            order.setBillState(request.getParameter("order.billState"));
            order.setBillToFirstName(request.getParameter("order.billToFirstName"));
            order.setBillToLastName(request.getParameter("order.billToLastName"));
            order.setBillZip(request.getParameter("order.billZip"));
            order.setCourier(request.getParameter("order.courier"));
            order.setCreditCard(request.getParameter("order.creditCard"));
            order.setExpiryDate(request.getParameter("order.expiryDate"));
            request.getSession().setAttribute("order", order);
        }
        if (StringUtils.isNotBlank(request.getParameter("shippingAddressRequired"))) {
            order = (Order) request.getSession().getAttribute("order");
            if (order == null) {
                order = new Order();
            }
            order.setShippingAddressRequired(true);
            order.setShipAddress1(request.getParameter("order.shipAddress1"));
            order.setShipAddress2(request.getParameter("order.shipAddress2"));
            order.setShipCity(request.getParameter("order.shipCity"));
            order.setShipCountry(request.getParameter("order.shipCountry"));
            order.setShipState(request.getParameter("order.shipState"));
            order.setShipToFirstName(request.getParameter("order.shipToFirstName"));
            order.setShipToLastName(request.getParameter("order.shipToLastName"));
            order.setShipZip(request.getParameter("order.shipZip"));
            order = (Order) request.getSession().getAttribute("order");
        } else if (StringUtils.isBlank(request.getParameter("confirmed"))) {
            order = (Order) request.getSession().getAttribute("order");
            if (order == null) {
                order = new Order();
            }
            order.setShippingAddressRequired(false);
            order.setShipAddress1(request.getParameter("order.billAddress1"));
            order.setShipAddress2(request.getParameter("order.billAddress2"));
            order.setShipCity(request.getParameter("order.billCity"));
            order.setShipCountry(request.getParameter("order.billCountry"));
            order.setShipState(request.getParameter("order.billState"));
            order.setShipToFirstName(request.getParameter("order.billToFirstName"));
            order.setShipToLastName(request.getParameter("order.billToLastName"));
            order.setShipZip(request.getParameter("order.billZip"));
            request.getSession().setAttribute("order", order);
        }
        if (order.isShippingAddressRequired()) {
            request.getRequestDispatcher(SHIPPING).forward(request, response);
        } else if (!order.isConfirmed()) {
            order = (Order) request.getSession().getAttribute("order");
            request.setAttribute("order", order);
            request.getRequestDispatcher(CONFIRM_ORDER).forward(request, response);
        } else {
            Account account = (Account) request.getSession().getAttribute("account");
            order = (Order) request.getSession().getAttribute("order");
            order.setUsername(account.getUserId());
            Cart cart = (Cart) request.getSession().getAttribute("cart");
            order.setTotalPrice(cart.getSubTotal());
            request.setAttribute("order", order);
            orderService.insertOrder(order);
            request.getSession().setAttribute("cart", null);
            request.getSession().setAttribute("order", order);
            String message = "Thank you, your order has been submitted.";
            request.setAttribute("message", message);
            request.getRequestDispatcher(VIEW_ORDER).forward(request, response);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
