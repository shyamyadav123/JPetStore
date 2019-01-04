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
    <meta content="text/html; charset=windows-1252"
          http-equiv="Content-Type"/>
    <meta http-equiv="Cache-Control" content="max-age=0"/>
    <meta http-equiv="Cache-Control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT"/>
    <meta http-equiv="Pragma" content="no-cache"/>

    <script type="text/javascript" src="${ctxStatic}/plugins/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${ctxStatic}/plugins/json/jquery.json.min.js"></script>
    <%--<script type="text/javascript" src="${ctxJs}/catalog/search.js"></script>--%>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
    <link rel="StyleSheet" href="${ctxCss}/jpetstore.css" type="text/css"
          media="screen"/>

    <script type="text/javascript">
        $(document).ready(function () {
            $("#searchInput").on("input propertychange", function (e) {
                var keyword = $(this).val();
                if (keyword) {
                    $.ajax({
                        url: "${ctx}/catalog/ajax_search",
                        type: "get",
                        data: {
                            keyword: keyword
                        },
                        success: function (res) {
                            if (res !== "[]") {
                                res = res.substring(1, res.length - 1);
                                var resArr = res.split(", ");
                                setItems(resArr)
                            } else {
                                $("#searchItem").hide();
                            }
                        }
                    })
                } else {
                    $("#searchItem").hide();
                }

            }).blur(function () {
                //防止失去焦点隐藏 和 点击事件 冲突
                setTimeout(function () {
                    $("#searchItem").hide();
                }, 100)
            });
        });

        function setItems(a) {
            $("#itemList").html("");
            for (var i in a) {
                $("#itemList").append("<li class=\"list-group-item\" onmouseover=\"selectItem(this)\" >" + a[i] + "</li>");
                $("#searchItem").show();
            }
        }

        function selectItem(target) {
            $("#searchInput").val(target.innerText);

        }
    </script>

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
                <div id="inputWrapper">
                    <input id="searchInput" type="text" name="keyword" size="14"  style="line-height: normal"/>
                    <div id="searchItem">
                        <ul class="list-group" id="itemList">
                            <li class="list-group-item" ></li>
                        </ul>
                    </div>
                </div>
                <input type="submit" name="searchProducts" value="Search" style="line-height: normal"/>
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
