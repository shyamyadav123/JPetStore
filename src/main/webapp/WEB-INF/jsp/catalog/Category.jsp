
<%--<%@ include file="/WEB-INF/views/modules/common/IncludeTop.jsp" %>--%>
<%@ include file="../common/IncludeTop.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="BackLink">
    <%--<stripes:link--%>
    <%--beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean">--%>
    <%--Return to Main Menu</stripes:link>--%>
    <a href="main">Return to Main</a>
</div>

<div id="Catalog">

    <h2>${requestScope.category.name}</h2>
    <%--<h2>${sessionScope.category.name}</h2>--%>
    <%--<h2><s:property value="#request.category.name"/></h2>--%>
    <%--<h2><s:property value="#session.category.name"/></h2>--%>
    <%--<h2><s:property value="#category.name"/></h2>--%>
    <%--<h2><s:property value="#catalogAction.category.name"/></h2>--%>
    <%--<h2><s:property value="#actionBean.category.name"/></h2>--%>
    <%--<h2>${actionBean.category.name}</h2>--%>
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
                    <a href="viewProduct?productId=${product.productId}">${product.productId}</a>
                </td>
                <td>${product.name}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<%--<%@ include file="/WEB-INF/views/modules/common/IncludeBottom.jsp" %>--%>
<%@ include file="../common/IncludeButtom.jsp"%>

