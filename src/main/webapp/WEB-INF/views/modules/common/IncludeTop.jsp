<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <link rel="StyleSheet" href="${ctxCss}/jpetstore.css" type="text/css"
          media="screen"/>

    <meta name="generator"
          content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org"/>
    <title>JPetStore Demo</title>
    <meta content="text/html; charset=windows-1252"
          http-equiv="Content-Type"/>
    <meta http-equiv="Cache-Control" content="max-age=0"/>
    <meta http-equiv="Cache-Control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT"/>
    <meta http-equiv="Pragma" content="no-cache"/>
</head>

<body>

<div id="Header">

    <div id="Logo">
        <div id="LogoContent">
            <%--<stripes:link--%>
            <%--beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean">--%>
            <%--<img src="${ctxImg}/logo-topbar.gif" />--%>
            <%--</stripes:link>--%>
            <a href="${ctx}/main"><img src="${ctxImg}/logo-topbar.gif" alt=""/></a>
        </div>
    </div>

    <div id="Menu">
        <div id="MenuContent">
            <%--<stripes:link--%>
            <%--beanclass="org.mybatis.jpetstore.web.actions.CartActionBean"--%>
            <%--event="viewCart">--%>
            <%--<img align="middle" name="img_cart" src="${ctxImg}/cart.gif" />--%>
            <%--</stripes:link> --%>
            <a href="${ctx}/cart/viewCart"><img align="middle" name="img_cart" src="${ctxImg}/cart.gif" alt=""/></a>
            <img align="middle" src="${ctxImg}/separator.gif" alt=""/>
            <c:if test="${sessionScope.account == null}">
                <%--<stripes:link--%>
                <%--beanclass="org.mybatis.jpetstore.web.actions.AccountActionBean"--%>
                <%--event="signonForm">--%>
                <%--Sign In--%>
                <%--</stripes:link>--%>
                <a href="${ctx}/account/signInForm">Sign In</a>
            </c:if>

            <c:if test="${sessionScope.accountBean != null}">
                <c:if test="${!sessionScope.account.authenticated}">
                    <%--<stripes:link--%>
                    <%--beanclass="org.mybatis.jpetstore.web.actions.AccountActionBean"--%>
                    <%--event="signonForm">--%>
                    <%--Sign In--%>
                    <%--</stripes:link>--%>
                    <a href="${ctx}/account/signInForm">Sign In</a>
                </c:if>
            </c:if>
            <c:if test="${sessionScope.account != null}">
                <c:if test="${sessionScope.account.authenticated}">
                    <%--<stripes:link--%>
                    <%--beanclass="org.mybatis.jpetstore.web.actions.AccountActionBean"--%>
                    <%--event="signoff">--%>
                    <%--Sign Out--%>
                    <%--</stripes:link>--%>
                    <a href="${ctx}/account/signOff">Sign Out</a>
                    <img align="middle" src="${ctxImg}/separator.gif" alt=""/>
                    <%--<stripes:link--%>
                    <%--beanclass="org.mybatis.jpetstore.web.actions.AccountActionBean"--%>
                    <%--event="editAccountForm">--%>
                    <%--My Account--%>
                    <%--</stripes:link>--%>
                    <a href="${ctx}/account/editAccountForm">My Account</a>
                </c:if>
            </c:if>
            <img align="middle" src="${ctxImg}/separator.gif" alt=""/>
            <a href="../../../../help.html">?</a></div>
    </div>

    <div id="Search">
        <div id="SearchContent">
            <%--<stripes:form--%>
            <%--beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean">--%>
            <%--<stripes:text name="keyword" size="14"/>--%>
            <%--<stripes:submit name="searchProducts" value="Search"/>--%>
            <%--</stripes:form>--%>
            <form action="${ctx}/catalog/searchProducts">
                <input type="text" name="keyword" style="font-size: 14px"/>
                <input type="submit" value="Search"/>
            </form>
        </div>
    </div>

    <div id="QuickLinks">
        <%--<stripes:link--%>
        <%--beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"--%>
        <%--event="viewCategory">--%>
        <%--<stripes:param name="categoryId" value="FISH"/>--%>
        <%--</stripes:link>--%>
        <a href="${ctx}/catalog/viewCategory?categoryId=FISH"><img src="${ctxImg}/sm_fish.gif" alt=""/></a>
        <img src="${ctxImg}/separator.gif" alt=""/>
        <%--<stripes:link--%>
        <%--beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"--%>
        <%--event="viewCategory">--%>
        <%--<stripes:param name="categoryId" value="DOGS"/>--%>
        <%--<img src="${ctxImg}/sm_dogs.gif"/>--%>
        <%--</stripes:link>--%>
        <a href="${ctx}/catalog/viewCategory?categoryId=DOGS"><img src="${ctxImg}/sm_dogs.gif" alt=""/></a>
        <img src="${ctxImg}/separator.gif" alt=""/>
        <%--<stripes:link--%>
        <%--beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"--%>
        <%--event="viewCategory">--%>
        <%--<stripes:param name="categoryId" value="REPTILES"/>--%>
        <%--<img src="${ctxImg}/sm_reptiles.gif"/>--%>
        <%--</stripes:link>--%>
        <a href="${ctx}/catalog/viewCategory?categoryId=REPTILES"><img src="${ctxImg}/sm_reptiles.gif" alt=""/></a>
        <img src="${ctxImg}/separator.gif" alt=""/>
        <%--<stripes:link--%>
        <%--beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"--%>
        <%--event="viewCategory">--%>
        <%--<stripes:param name="categoryId" value="CATS"/>--%>
        <%--<img src="${ctxImg}/sm_cats.gif"/>--%>
        <%--</stripes:link>--%>
        <a href="${ctx}/catalog/viewCategory?categoryId=CATS"><img src="${ctxImg}/sm_cats.gif" alt=""/></a>
        <img src="${ctxImg}/separator.gif"/>
        <%--<stripes:link--%>
        <%--beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"--%>
        <%--event="viewCategory">--%>
        <%--<stripes:param name="categoryId" value="BIRDS"/>--%>
        <%--<img src="${ctxImg}/sm_birds.gif"/>--%>
        <%--</stripes:link>--%>
        <a href="${ctx}/catalog/viewCategory?categoryId=BIRDS"><img src="${ctxImg}/sm_birds.gif" alt=""/></a>
    </div>
</div>
<div id="Content">${requestScope.message}
