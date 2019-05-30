<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
	<form action="signIn" method="post">
		<p>${sessionScope.message}</p>
	<p>Please enter your username and password.</p>
	<p>
		Username:<input type="text" name="account.username" value="j2ee"/><br />
	    Password:<input type="text" name="account.password" value="j2ee"/>
    </p>
		<input type="submit" name="signon" value="Login"/>
	</form>

	Need a user name and password?
	<a href="toRegister">Register Now!</a>
</div>
<%@ include file="../common/IncludeButtom.jsp"%>

