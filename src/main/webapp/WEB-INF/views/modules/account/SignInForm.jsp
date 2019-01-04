<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/views/modules/common/IncludeTop.jsp" %>

<jsp:useBean id="account" class="com.nevercome.jpetstore.domain.model.Account"/>

<script type="text/javascript" src="${ctxJs}/account/login.js"></script>

<script type="text/javascript">
    function change() {

    }
</script>

<div id="Catalog">
    <%--<stripes:form--%>
    <%--beanclass="org.mybatis.jpetstore.web.actions.AccountActionBean"--%>
    <%--focus="">--%>

    <%--<p>Please enter your username and password.</p>--%>
    <%--<p>Username:<stripes:text name="username" value="j2ee"/> <br/>--%>
    <%--Password:<stripes:password name="password" value="j2ee"/></p>--%>
    <%--<stripes:submit name="signon" value="Login"/>--%>
    <%--</stripes:form>--%>

    <form action="${ctx}/account/signIn" method="post">
        <span id="SignInInfo" style="color: red;font-weight: bold"></span>
        <p>Please enter your username and password.</p>
        <p>Username:<input type="text" name="userId" value="j2ee" id="userId"/> <br/>
            Password:<input type="password" name="password" value="j2ee" id="password"/><br/>
            VerifyCode:<input type="text" name="verifyCode" id="verifyCode"> <br/>
            <img src="${ctx}/account/verify">
            <a href="#" onclick="change()">Change Another</a>
        </p>
        <input id="submitForm" type="button" value="Login"/>
    </form>
    Need a user name and password?
    <a href="${ctx}/account/newAccountForm">Register Now!</a>

</div>

<%@ include file="/WEB-INF/views/modules/common/IncludeBottom.jsp" %>


