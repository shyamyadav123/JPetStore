<%@ include file="../common/IncludeTop.jsp" %>

<div id="Catalog">
    <%--<form action="editAccount" method="post">--%>
    <s:form action="editAccount" method="post">
        <h3>User Information</h3>

        <table>
            <tr>
                <td>User ID:</td>
                <td><s:property value="#session.account.username"/></td>
            </tr>
            <tr>
                <td>New password:</td>
                <td>
                    <%--<input type="text" name="account.password"/>--%>
                    <s:textfield name="account.password" />
                </td>
            </tr>
            <tr>
                <td>Repeat password:</td>
                <td>
                    <%--<input type="text" name="repeatedPassword"/>--%>
                    <s:textfield name="repeatedPassword" />
                </td>
            </tr>
        </table>

        <%@ include file="IncludeAccountFields.jsp" %>
        <%--<input type="submit" name="editAccount" value="Save Account Information"/>--%>
        <s:submit value="Save Account Information" theme="simple" />
        <s:reset value="Reset" theme="simple" />
    <%--</form>--%>
    </s:form>
    <a href="listOrders">My Orders</a>
</div>
<%@ include file="../common/IncludeButtom.jsp" %>
