<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%--<%@ include file="/WEB-INF/views/modules/common/IncludeTop.jsp" %>--%>
<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
    <%--<stripes:link--%>
    <%--beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean">--%>
    <%--Return to Main Menu</stripes:link>--%>
    <a href="main">Return to Main</a>
</div>

<div id="Catalog">

    <h2>${requestScope.category.name}</h2>
    <table>
        <tr>
            <th>Product ID</th>
            <th>Name</th>
        </tr>
        <c:forEach var="product" items="${requestScope.productList}">
            <tr>
                <td>
                        <%--<stripes:link--%>
                        <%--beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"--%>
                        <%--event="viewProduct">--%>
                        <%--<stripes:param name="productId" value="${product.productId}" />--%>
                        <%--${product.productId}--%>
                        <%--</stripes:link>--%>
                    <a href="catalog/viewProduct?productId=${product.productId}">${product.productId}</a>
                </td>
                <td>${product.name}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<%--<%@ include file="/WEB-INF/views/modules/common/IncludeBottom.jsp" %>--%>
<%@ include file="../common/IncludeButtom.jsp"%>

