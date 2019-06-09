<%@ include file="../common/IncludeTop.jsp" %>

<div id="Catalog">
    <%--<form action="signIn" method="post">--%>
    <%--<s:token/>--%>
    <%--<p><s:property value="#request.message"/>--%>
    <%--<p>Please enter your username and password.</p>--%>
    <%--<p>--%>
    <%--Username:<input type="text" name="account.username" value="j2ee"/><br/>--%>
    <%--Password:<input type="text" name="account.password" value="j2ee"/><br/>--%>
    <%--Verification Code:<input type="text" name="VerificationCode"/>--%>
    <%--<s:fielderror value="error1"></s:fielderror>--%>
    <%--<br/>--%>
    <%--<img src="verifyCode?" id="Verify" border="0" style="cursor:hand;"/>--%>
    <%--<a href="javascript:changeImg();">Vague? Change it</a><font color="red">${sessionScope.imageMess}</font>--%>
    <%--</p>--%>
    <%--<input type="submit" name="signon" value="Login"/>--%>
    <%--</form>--%>
    <p><s:property value="#request.message"/>
    <p>Please enter your username and password.</p>
    <s:form action="signIn" method="post">
        <s:token/>
        <s:textfield name="account.username" value="j2ee" label="Username"/>
        <s:password name="account.password" value="j2ee" label="Password"/>
        <s:textfield name="VerificationCode" label="Verification Code"/>
        <s:fielderror value="error1"/>
    </s:form>
    <p>
        <img src="verifyCode?" id="Verify" border="0" style="cursor:hand;"/>
        <a href="javascript:changeImg();">Vague? Change it</a>
        <font color="red"><s:property value="#session.imageMess"/> </font>
    </p>

    Need a user name and password?
    <%--<a href="toRegister">Register Now!</a>--%>
    <s:a href="toRegister">Register Now!</s:a>
    <script type="text/javascript">
        function changeImg() {
            var myImg = document.getElementById("Verify");
            var now = new Date();
            myImg.src = "verifyCode?timestamp=" + now.getTime();
        }
    </script>
</div>
<%@ include file="../common/IncludeButtom.jsp" %>

