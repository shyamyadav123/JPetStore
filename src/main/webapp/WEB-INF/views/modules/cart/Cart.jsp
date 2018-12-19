<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/views/modules/common/IncludeTop.jsp" %>

<div id="BackLink">
    <%--<stripes:link--%>
    <%--beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean">--%>
    <%--Return to Main Menu</stripes:link>--%>
    <a href="${ctx}/main">Return to Main</a>
</div>

<div id="Catalog">

    <div id="Cart">

        <h2>Shopping Cart</h2>
        <form action="${ctx}/cart/updateCartQuantities" method="post">
            <table>
                <tr>
                    <th><b>Item ID</b></th>
                    <th><b>Product ID</b></th>
                    <th><b>Description</b></th>
                    <th><b>In Stock?</b></th>
                    <th><b>Quantity</b></th>
                    <th><b>List Price</b></th>
                    <th><b>Total Cost</b></th>
                    <th>&nbsp;</th>
                </tr>
                <%--根据项目特点 购物车的信息是保存在session中的--%>
                <c:if test="${sessionScope.cart.numberOfItems == 0}">
                    <tr>
                        <td colspan="8"><b>Your cart is empty.</b></td>
                    </tr>
                </c:if>
                <%--<c:forEach var="cartItem" items="${actionBean.cart.cartItems}">--%>
                <%--jsp的取值感觉真的还是有很大的学问在里面啊...是set和get的注入...那么这里的话cartItemList应该也是可以的--%>
                <c:forEach var="cartItem" items="${sessionScope.cart.cartItems}">
                <%--<c:forEach var="cartItem" items="${sessionScope.cart.cartItemList}">--%>
                    <tr>
                        <td>
                            <a href="${ctx}/catalog/viewItem?itemId=${cartItem.item.itemId}">${cartItem.item.itemId}</a>
                        </td>
                        <td>${cartItem.item.product.productId}</td>
                        <td>${cartItem.item.attribute1} ${cartItem.item.attribute2}
                                ${cartItem.item.attribute3} ${cartItem.item.attribute4}
                                ${cartItem.item.attribute5} ${cartItem.item.product.name}</td>
                        <td>${cartItem.inStock}</td>
                        <td><input type="text" size="3" name="${cartItem.item.itemId}"
                                   value="${cartItem.quantity}"/>
                        </td>
                        <td><fmt:formatNumber value="${cartItem.item.listPrice}"
                                              pattern="$#,##0.00"/></td>
                        <td><fmt:formatNumber value="${cartItem.total}"
                                              pattern="$#,##0.00"/></td>
                        <td>
                                <%--<stripes:link class="Button"--%>
                                <%--beanclass="org.mybatis.jpetstore.web.actions.CartActionBean"--%>
                                <%--event="removeItemFromCart">--%>
                                <%--<stripes:param name="cartItem" value="${cartItem.item.itemId}"/>--%>
                                <%--Remove--%>
                                <%--</stripes:link>--%>
                            <a href="${ctx}/cart/removeItemFromCart?cartItem=${cartItem.item.itemId}">Remove</a>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="7">Sub Total:
                        <fmt:formatNumber
                                value="${sessionScope.cart.subTotal}" pattern="$#,##0.00"/>
                        <input type="submit" value="Update Cart"/>
                    </td>
                    <td>&nbsp;</td>
                </tr>
            </table>
            <%--</stripes:form>--%>
        </form>
        <c:if test="${sessionScope.cart.numberOfItems > 0}">
            <%--<stripes:link class="Button"--%>
            <%--beanclass="org.mybatis.jpetstore.web.actions.OrderActionBean"--%>
            <%--event="newOrderForm">--%>
            <%--Proceed to Checkout--%>
            <%--</stripes:link>--%>
            <a href="${ctx}/order/newOrderForm">Proceed to Checkout</a>
        </c:if>
    </div>

    <%--<div id="MyList">--%>
    <%--<c:if test="${sessionScope.accountBean != null}">--%>
    <%--<c:if test="${!sessionScope.accountBean.authenticated}">--%>
    <%--<c:if test="${!empty sessionScope.accountBean.account.listOption}">--%>
    <%--<%@ include file="IncludeMyList.jsp" %>--%>
    <%--</c:if>--%>
    <%--</c:if>--%>
    <%--</c:if>--%>
    <%--</div>--%>
    <div id="MyList">
        <c:if test="${sessionScope.account != null}">
            <c:if test="${!sessionScope.account.authenticated}">
                <c:if test="${!empty sessionScope.account.listOption}">
                    <%@ include file="IncludeMyList.jsp" %>
                </c:if>
            </c:if>
        </c:if>
    </div>

    <div id="Separator">&nbsp;</div>
</div>

<%@ include file="/WEB-INF/views/modules/common/IncludeBottom.jsp" %>
