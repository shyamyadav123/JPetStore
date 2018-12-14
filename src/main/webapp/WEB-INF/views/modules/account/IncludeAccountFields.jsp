<h3>Account Information</h3>
<table>
    <tr>
        <td>First name:</td>
        <%--<td><stripes:text name="account.firstName" /></td>--%>
        <td><input type="text" name="account.firstName"value="${sessionScope.account.firstName}"></td>
    </tr>
    <tr>
        <td>Last name:</td>
        <%--<td><stripes:text name="account.lastName" /></td>--%>
        <td><input type="text" name="account.lastName"value="${sessionScope.account.lastName}"/></td>
    </tr>
    <tr>
        <td>Email:</td>
        <%--<td><stripes:text size="40" name="account.email" /></td>--%>
        <td><input type="text" size="40" name="account.email"value="${sessionScope.account.email}"/></td>
    </tr>
    <tr>
        <td>Phone:</td>
        <td><input type="text" name="account.phone"value="${sessionScope.account.phone}"/></td>
    </tr>
    <tr>
        <td>Address 1:</td>
        <td><input type="text" size="40" name="account.address1"value="${sessionScope.account.address1}"/></td>
    </tr>
    <tr>
        <td>Address 2:</td>
        <td><input type="text" size="40" name="account.address2"value="${sessionScope.account.address2}"/></td>
    </tr>
    <tr>
        <td>City:</td>
        <td><input type="text" name="account.city" value="${sessionScope.account.city}"/></td>
    </tr>
    <tr>
        <td>State:</td>
        <td><input type="text" size="4" name="account.state" value="${sessionScope.account.state}"/></td>
    </tr>
    <tr>
        <td>Zip:</td>
        <td><input type="text" size="10" name="account.zip" value="${sessionScope.account.zip}"/></td>
    </tr>
    <tr>
        <td>Country:</td>
        <td><input type="text" size="15" name="account.country" value="${sessionScope.account.zip}"/></td>
    </tr>
</table>

<h3>Profile Information</h3>

<table>
    <tr>
        <td>Language Preference:</td>
        <td>
            <%--<stripes:select name="account.languagePreference">--%>
            <%--<stripes:options-collection collection="${actionBean.languages}"/>--%>
            <%--</stripes:select>--%>
            <select name="account.languagePreference">
                <%--应该是在一开始就被放入缓存之中的--%>
                <c:forEach items="${sessionScope.languages}" var="language">
                    <option value="${language}" label="${language}"></option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <td>Favourite Category:</td>
        <td>
            <%--<stripes:select name="account.favouriteCategoryId">--%>
            <%--<stripes:options-collection collection="${actionBean.categories}"/>--%>
            <%--</stripes:select>--%>
            <select name="account.favouriteCategoryId">
                <%--应该是在一开始就被放入缓存之中的--%>
                <c:forEach items="${sessionScope.category}" var="category">
                    <option value="${category}" label="${category}"></option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <td>Enable MyList</td>
        <td><input type="checkbox" name="account.listOption"/></td>
    </tr>
    <tr>
        <td>Enable MyBanner</td>
        <td><input type="checkbox" name="account.bannerOption"/></td>
    </tr>
</table>
