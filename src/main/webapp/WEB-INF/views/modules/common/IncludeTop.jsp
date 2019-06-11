<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

    <%--<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>--%>

    <meta name="generator"
          content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org"/>
    <title>JPetStore Demo</title>
    <meta content="text/html; charset=utf-8"
          http-equiv="Content-Type"/>
    <meta http-equiv="Cache-Control" content="max-age=0"/>
    <meta http-equiv="Cache-Control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT"/>
    <meta http-equiv="Pragma" content="no-cache"/>

    <script type="text/javascript" src="${ctxStatic}/plugins/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${ctxStatic}/plugins/json/jquery.json.min.js"></script>
    <script type="text/javascript" src="${ctxJs}/catalog/search.js"></script>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
    <link rel="StyleSheet" href="${ctxCss}/jpetstore.css" type="text/css"
          media="screen"/>
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

            <a href="${ctx}/cart/viewCart"><img align="middle" name="img_cart" src="${ctxImg}/cart.gif" alt=""/></a>
            <img align="middle" src="${ctxImg}/separator.gif" alt=""/>
            <c:if test="${sessionScope.account == null}">

                <a href="${ctx}/account/signInForm">Sign In</a>
            </c:if>

            <c:if test="${sessionScope.accountBean != null}">
                <c:if test="${!sessionScope.account.authenticated}">

                    <a href="${ctx}/account/signInForm">Sign In</a>
                </c:if>
            </c:if>
            <c:if test="${sessionScope.account != null}">
                <c:if test="${sessionScope.account.authenticated}">

                    <a href="${ctx}/account/signOff">Sign Out</a>
                    <img align="middle" src="${ctxImg}/separator.gif" alt=""/>

                    <a href="${ctx}/account/editAccountForm">My Account</a>
                </c:if>
            </c:if>
            <img align="middle" src="${ctxImg}/separator.gif" alt=""/>
            <a href="../../../../help.html">?</a></div>
    </div>

    <div id="Search">
        <div id="SearchContent">
            <form action="searchProduct" method="post">
                <div id="inputWrapper">
                    <input id="searchInput" type="text" name="keyword" size="14"  style="line-height: normal"/>
                    <div id="searchItem">
                        <ul class="list-group" id="itemList">
                            <%--<li class="list-group-item" ></li>--%>
                        </ul>
                    </div>
                </div>
                <input type="submit" name="searchProducts" value="Search" style="line-height: normal"/>
            </form>
        </div>
    </div>

    <div id="QuickLinks">
        <a href="${ctx}/catalog/viewCategory?categoryId=FISH"><img src="${ctxImg}/sm_fish.gif" alt=""/></a>
        <img src="${ctxImg}/separator.gif" alt=""/>

        <a href="${ctx}/catalog/viewCategory?categoryId=DOGS"><img src="${ctxImg}/sm_dogs.gif" alt=""/></a>
        <img src="${ctxImg}/separator.gif" alt=""/>

        <a href="${ctx}/catalog/viewCategory?categoryId=REPTILES"><img src="${ctxImg}/sm_reptiles.gif" alt=""/></a>
        <img src="${ctxImg}/separator.gif" alt=""/>

        <a href="${ctx}/catalog/viewCategory?categoryId=CATS"><img src="${ctxImg}/sm_cats.gif" alt=""/></a>
        <img src="${ctxImg}/separator.gif"/>

        <a href="${ctx}/catalog/viewCategory?categoryId=BIRDS"><img src="${ctxImg}/sm_birds.gif" alt=""/></a>
    </div>
</div>
<div id="Content">${requestScope.message}
