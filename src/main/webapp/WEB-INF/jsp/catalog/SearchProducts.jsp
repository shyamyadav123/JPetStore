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

    <table>
        <tr>
            <th>&nbsp;</th>
            <th>Product ID</th>
            <th>Name</th>
        </tr>
        <c:forEach var="product" items="${requestScope.productList}">
            <tr>
                <td>
                    <a href="viewProduct?productId=${product.productId}">${product.description}</a>
                </td>
                <td>
                    <b>
                        <a href="viewProduct?productId=${product.productId}">
                            <font color="BLACK"> ${product.productId} </font></a>
                    </b>
                </td>
                <td>${product.name}</td>
            </tr>
        </c:forEach>
        <tr>
            <td></td>
        </tr>
    </table>

</div>

<%--<%@ include file="/WEB-INF/views/modules/common/IncludeBottom.jsp" %>--%>
<%@ include file="../common/IncludeButtom.jsp"%>



