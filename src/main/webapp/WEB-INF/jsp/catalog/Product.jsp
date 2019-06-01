<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%--<%@ include file="/WEB-INF/views/modules/common/IncludeTop.jsp" %>--%>
<%--<jsp:useBean id="catalog" class="org.mybatis.jpetstore.web.actions.CatalogActionBean" />--%>
<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
	<%--<stripes:link--%>
	<%--beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"--%>
	<%--event="viewCategory">--%>
	<%--<stripes:param name="categoryId"--%>
		<%--value="${actionBean.product.categoryId}" />--%>
	<%--Return to ${actionBean.product.categoryId}--%>
<%--</stripes:link>--%>
	<a href="=catalog/viewCategory?categoryId=${requestScope.product.categoryId}">Return to ${requestScope.product.categoryId}</a>
</div>

<div id="Catalog">

<h2>${requestScope.product.name}</h2>
<table>
	<tr>
		<th>Item ID</th>
		<th>Product ID</th>
		<th>Description</th>
		<th>List Price</th>
		<th>&nbsp;</th>
	</tr>
	<c:forEach var="item" items="${requestScope.itemList}">
		<tr>
			<td>
				<a href="viewItem?itemId=${item.itemId}">${item.itemId}</a>
			</td>
			<td>${item.product.productId}</td>
			<td>${item.attribute1} ${item.attribute2} ${item.attribute3}
			${item.attribute4} ${item.attribute5} ${requestScope.product.name}</td>
			<td><fmt:formatNumber value="${item.listPrice}"
				pattern="$#,##0.00" /></td>
			<td>
				<a href="addItemToCart?workingItemId=${item.itemId}">Add to Cart</a>
			</td>
		</tr>
	</c:forEach>
</table>
</div>

<%--<%@ include file="/WEB-INF/views/modules/common/IncludeBottom.jsp" %>--%>
<%@ include file="../common/IncludeButtom.jsp"%>





