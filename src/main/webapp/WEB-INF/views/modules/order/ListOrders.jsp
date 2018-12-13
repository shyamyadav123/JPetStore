<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/views/modules/common/IncludeTop.jsp" %>

<h2>My Orders</h2>

<table>
	<tr>
		<th>Order ID</th>
		<th>Date</th>
		<th>Total Price</th>
	</tr>

	<c:forEach var="order" items="${requestScope.orderList}">
		<tr>
			<td>
				<%--<stripes:link--%>
					<%--beanclass="org.mybatis.jpetstore.web.actions.OrderActionBean"--%>
					<%--event="viewOrder">--%>
					<%--<stripes:param name="orderId" value="${order.orderId}" />--%>
					<%--${order.orderId}--%>
					<%--</stripes:link>--%>
				<a href="${ctx}/order/viewOrder?${order.orderId}">${order.orderId}</a>
			</td>
			<td><fmt:formatDate value="${order.orderDate}"
				pattern="yyyy/MM/dd hh:mm:ss" /></td>
			<td><fmt:formatNumber value="${order.totalPrice}"
				pattern="$#,##0.00" /></td>
		</tr>
	</c:forEach>
</table>

<%@ include file="/WEB-INF/views/modules/common/IncludeBottom.jsp" %>



