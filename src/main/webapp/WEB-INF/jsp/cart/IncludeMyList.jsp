<%--<c:if test="${!empty accountBean.myList}">--%>
<c:if test="${!empty sessionScope.myList}">
	<p>Pet Favorites <br />
	Shop for more of your favorite pets here.</p>
	<ul>
		<c:forEach var="product" items="${sessionScope.myList}">
			<li>
				<%--<stripes:link--%>
					<%--beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"--%>
					<%--event="viewProduct">--%>
					<%--<stripes:param name="productId" value="${product.productId}" />--%>
					<%--${product.name}--%>
					<%--</stripes:link> (${product.productId})--%>
				<a href="viewProduct?productId=${product.productId}">${product.name}</a>
				(${product.productId})
			</li>
		</c:forEach>
	</ul>
</c:if>
