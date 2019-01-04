<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/views/modules/common/IncludeTop.jsp" %>

<jsp:useBean id="account" class="com.nevercome.jpetstore.domain.model.Account"/>

<script type="text/javascript" src="${ctxJs}/account/checkUserId.js"></script>

<div id="Catalog">
    <%--<stripes:form beanclass="org.mybatis.jpetstore.web.actions.AccountActionBean" focus="">--%>
    <%--<h3>User Information</h3>--%>
    <%--<table>--%>
    <%--<tr>--%>
    <%--<td>User ID:</td>--%>
    <%--<td><stripes:text name="username"/></td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
    <%--<td>New password:</td>--%>
    <%--<td><stripes:text name="password"/></td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
    <%--<td>Repeat password:</td>--%>
    <%--<td><stripes:text name="repeatedPassword"/></td>--%>
    <%--</tr>--%>
    <%--</table>--%>
    <%--<%@ include file="IncludeAccountFields.jsp" %>--%>
    <%--<stripes:submit name="newAccount" value="Save Account Information"/>--%>
    <%--</stripes:form>--%>
    <form action="${ctx}/account/newAccount">
        <h3>User Information</h3>
        <table>
            <tr>
                <td>User ID:</td>
                <td><input type="text" name="account.userId" id="userId"/>
                    <label id="id_result" style="display: none">用户名可以使用</label></td>
            </tr>
            <tr>
                <td>New password:</td>
                <td><input type="text" name="account.password"/></td>
            </tr>
            <tr>
                <td>Repeat password:</td>
                <td><input type="text" name="repeatedPassword"/></td>
            </tr>
            <tr>
                <td>VerifyCode:</td>
                <td><input type="text" name="verifyCode"></td>
            </tr>
            <tr>
                <td><img src="${ctx}/account/verify"></td>
                <td><a href="#" onclick="change()">Change Another</a></td>
            </tr>
        </table>
        <%@ include file="IncludeAccountFields.jsp" %>
        <input type="submit" value="Save Account Information"/>
    </form>
</div>

<%@ include file="/WEB-INF/views/modules/common/IncludeBottom.jsp" %>
