package web;

import com.opensymphony.xwork2.ActionSupport;
import domain.Order;
import service.OrderService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: sun
 * @date: 2019/5/23
 */
public class OrderAction extends ActionSupport {

    private static final long serialVersionUID = -6171288227470176272L;

    private static final String CONFIRM_ORDER = "/WEB-INF/jsp/order/ConfirmOrder.jsp";
    private static final String LIST_ORDERS = "/WEB-INF/jsp/order/ListOrders.jsp";
    private static final String NEW_ORDER = "/WEB-INF/jsp/order/NewOrderForm.jsp";
    private static final String SHIPPING = "/WEB-INF/jsp/order/ShippingForm.jsp";
    private static final String VIEW_ORDER = "/WEB-INF/jsp/order/ViewOrder.jsp";

    private static final List<String> CARD_TYPE_LIST;

    private OrderService orderService;

    private Order order = new Order();
    private boolean shippingAddressRequired;
    private boolean confirmed;
    private List<Order> orderList;

    static {
        List<String> cardList = new ArrayList<>();
        cardList.add("Visa");
        cardList.add("MasterCard");
        cardList.add("American Express");
        CARD_TYPE_LIST = Collections.unmodifiableList(cardList);
    }

    public OrderAction() {
        orderService = new OrderService();
    }

    public int getOrderId() {
        return order.getOrderId();
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public boolean isShippingAddressRequired() {
        return shippingAddressRequired;
    }

    public void setShippingAddressRequired(boolean shippingAddressRequired) {
        this.shippingAddressRequired = shippingAddressRequired;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public List<String> getCreditCardTypes() {
        return CARD_TYPE_LIST;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public String listOrders() {
//        HttpSession session = context.getRequest().getSession();
//        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");
//        orderList = orderService.getOrdersByUsername(accountBean.getAccount().getUsername());
        return "LIST_ORDERS";
    }

    public String newOrderForm() {
//        HttpSession session = context.getRequest().getSession();
//        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");
//        CartActionBean cartBean = (CartActionBean) session.getAttribute("/actions/Cart.action");

        clear();
//        if (accountBean == null || !accountBean.isAuthenticated()) {
//            setMessage("You must sign on before attempting to check out.  Please sign on and try checking out again.");
//            return new ForwardResolution(AccountActionBean.class);
//        } else if (cartBean != null) {
//            order.initOrder(accountBean.getAccount(), cartBean.getCart());
//            return new ForwardResolution(NEW_ORDER);
//        } else {
//            setMessage("An order could not be created because a cart could not be found.");
//            return new ForwardResolution(ERROR);
//        }
        return "";
    }

//    public Resolution newOrder() {
//        HttpSession session = context.getRequest().getSession();
//
//        if (shippingAddressRequired) {
//            shippingAddressRequired = false;
//            return new ForwardResolution(SHIPPING);
//        } else if (!isConfirmed()) {
//            return new ForwardResolution(CONFIRM_ORDER);
//        } else if (getOrder() != null) {
//
//            orderService.insertOrder(order);
//
//            CartActionBean cartBean = (CartActionBean) session.getAttribute("/actions/Cart.action");
//            cartBean.clear();
//
//            setMessage("Thank you, your order has been submitted.");
//
//            return new ForwardResolution(VIEW_ORDER);
//        } else {
//            setMessage("An error occurred processing your order (order was null).");
//            return new ForwardResolution(ERROR);
//        }
//    }
//
//    public Resolution viewOrder() {
//        HttpSession session = context.getRequest().getSession();
//
//        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("accountBean");
//
//        order = orderService.getOrder(order.getOrderId());
//
//        if (accountBean.getAccount().getUsername().equals(order.getUsername())) {
//            return new ForwardResolution(VIEW_ORDER);
//        } else {
//            order = null;
//            setMessage("You may only view your own orders.");
//            return new ForwardResolution(ERROR);
//        }
//    }

    public void clear() {
        order = new Order();
        shippingAddressRequired = false;
        confirmed = false;
        orderList = null;
    }

}
