<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/views/modules/common/IncludeTop.jsp" %>

<div id="Catalog">
    <%--<stripes:form--%>
            <%--beanclass="org.mybatis.jpetstore.web.actions.AccountActionBean"--%>
            <%--focus="">--%>

        <%--<p>Please enter your username and password.</p>--%>
        <%--<p>Username:<stripes:text name="username" value="j2ee"/> <br/>--%>
            <%--Password:<stripes:password name="password" value="j2ee"/></p>--%>
        <%--<stripes:submit name="signon" value="Login"/>--%>
    <%--</stripes:form>--%>

    <form action="${ctx}/account/signIn">
        <p>Please enter your username and password.</p>
        <p>Username:<input type="text" name="userId" value="j2ee"/> <br/>
            Password:<input type="password" name="password" value="j2ee"/></p>
        <input type="submit" value="Login"/>
    </form>
    Need a user name and password?
    <%--<stripes:link--%>
        <%--beanclass="org.mybatis.jpetstore.web.actions.AccountActionBean"--%>
        <%--event="newAccountForm">Register Now!--%>
        <%--</stripes:link>--%>
    <a href="/account/newAccountForm">Register Now!</a>
</div>

<%@ include file="/WEB-INF/views/modules/common/IncludeBottom.jsp" %>


