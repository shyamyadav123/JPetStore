<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/views/modules/common/IncludeTop.jsp" %>

<div id="BackLink">
    <%--<stripes:link--%>
    <%--beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean">--%>
    <%--Return to Main Menu</stripes:link>--%>
    <a href="${ctx}/main">Return to Main</a>
</div>

<div id="Catalog">Please confirm the information below and then
    press continue...

    <table>
        <tr>
            <th align="center" colspan="2"><font size="4"><b>Order</b></font>
                <br/>
                <font size="3"><b> <fmt:formatDate
                        value="${requestScope.order.orderDate}" pattern="yyyy/MM/dd hh:mm:ss"/></b></font>
            </th>
        </tr>

        <tr>
            <th colspan="2">Billing Address</th>
        </tr>
        <tr>
            <td>First name:</td>
            <td><c:out value="${requestScope.order.billToFirstName}"/></td>
        </tr>
        <tr>
            <td>Last name:</td>
            <td><c:out value="${requestScope.order.billToLastName}"/></td>
        </tr>
        <tr>
            <td>Address 1:</td>
            <td><c:out value="${requestScope.order.billAddress1}"/></td>
        </tr>
        <tr>
            <td>Address 2:</td>
            <td><c:out value="${requestScope.order.billAddress2}"/></td>
        </tr>
        <tr>
            <td>City:</td>
            <td><c:out value="${requestScope.order.billCity}"/></td>
        </tr>
        <tr>
            <td>State:</td>
            <td><c:out value="${requestScope.order.billState}"/></td>
        </tr>
        <tr>
            <td>Zip:</td>
            <td><c:out value="${requestScope.order.billZip}"/></td>
        </tr>
        <tr>
            <td>Country:</td>
            <td><c:out value="${requestScope.order.billCountry}"/></td>
        </tr>
        <tr>
            <th colspan="2">Shipping Address</th>
        </tr>
        <tr>
            <td>First name:</td>
            <td><c:out value="${requestScope.order.shipToFirstName}"/></td>
        </tr>
        <tr>
            <td>Last name:</td>
            <td><c:out value="${requestScope.order.shipToLastName}"/></td>
        </tr>
        <tr>
            <td>Address 1:</td>
            <td><c:out value="${requestScope.order.shipAddress1}"/></td>
        </tr>
        <tr>
            <td>Address 2:</td>
            <td><c:out value="${requestScope.order.shipAddress2}"/></td>
        </tr>
        <tr>
            <td>City:</td>
            <td><c:out value="${requestScope.order.shipCity}"/></td>
        </tr>
        <tr>
            <td>State:</td>
            <td><c:out value="${requestScope.order.shipState}"/></td>
        </tr>
        <tr>
            <td>Zip:</td>
            <td><c:out value="${requestScope.order.shipZip}"/></td>
        </tr>
        <tr>
            <td>Country:</td>
            <td><c:out value="${requestScope.order.shipCountry}"/></td>
        </tr>

    </table>

    <%--<stripes:link class="Button"--%>
    <%--beanclass="org.mybatis.jpetstore.web.actions.OrderrequestScope"--%>
    <%--event="newOrder">--%>
    <%--<stripes:param name="confirmed" value="true"/>--%>
    <%--Confirm--%>
    <%--</stripes:link>--%>
    <a href="${ctx}/order/newOrder?confirmed=true">Confirm</a>
</div>

<%@ include file="/WEB-INF/views/modules/common/IncludeBottom.jsp" %>






