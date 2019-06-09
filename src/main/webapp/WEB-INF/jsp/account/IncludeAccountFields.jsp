<h3>Account Information</h3>

<table>
    <%--<tr>--%>
    <%--<td>First name:</td>--%>
    <%--<td>--%>
    <%--<input type="text" name="account.firstName"/>--%>
    <%--</td>--%>
    <%--</tr>--%>
    <s:textfield name="account.firstName" label="First name"/>
    <%--<tr>--%>
    <%--<td>Last name:</td>--%>
    <%--<td>--%>
    <%--<input type="text" name="account.lastName"/>--%>
    <%--</td>--%>
    <%--</tr>--%>
    <s:textfield name="account.lastName" label="Last name"/>
    <%--<tr>--%>
    <%--<td>Email:</td>--%>
    <%--<td>--%>
    <%--<input type="text" name="account.email"/>--%>
    <%--</td>--%>
    <%--</tr>--%>
    <s:textfield name="account.email" label="Email"/>
    <%--<tr>--%>
    <%--<td>Phone:</td>--%>
    <%--<td>--%>
    <%--<input type="text" name="account.phone"/>--%>
    <%--</td>--%>
    <%--</tr>--%>
    <s:textfield name="account.phone" label="Phone"/>

    <%--<tr>--%>
    <%--<td>Address 1:</td>--%>
    <%--<td>--%>
    <%--<input type="text" name="account.address1"/>--%>
    <%--</td>--%>
    <%--</tr>--%>
    <s:textfield name="account.address1" label="Address 1"/>
    <%--<tr>--%>
    <%--<td>Address 2:</td>--%>
    <%--<td>--%>
    <%--<input type="text" name="account.address2"/>--%>
    <%--</td>--%>
    <%--</tr>--%>
    <s:textfield name="account.address2" label="Address 2"/>

    <%--<tr>--%>
    <%--<td>City:</td>--%>
    <%--<td>--%>
    <%--<input type="text" name="account.city"/>--%>
    <%--</td>--%>
    <%--</tr>--%>
    <s:textfield name="account.city" label="City"/>
    <%--<tr>--%>
    <%--<td>State:</td>--%>
    <%--<td>--%>
    <%--<input type="text" name="account.state"/>--%>
    <%--</td>--%>
    <%--</tr>--%>
    <s:textfield name="account.state" label="State"/>
    <%--<tr>--%>
    <%--<td>Zip:</td>--%>
    <%--<td>--%>
    <%--<input type="text" name="account.zip"/>--%>
    <%--</td>--%>
    <%--</tr>--%>
    <s:textfield name="account.zip" label="Zip"/>
    <%--<tr>--%>
    <%--<td>Country:</td>--%>
    <%--<td>--%>
    <%--<input type="text" name="account.country"/>--%>
    <%--</td>--%>
    <%--</tr>--%>
    <s:textfield name="account.country" label="Country"/>
</table>

<h3>Profile Information</h3>

<table>
    <%--<tr>--%>
    <%--<td>Language Preference:</td>--%>
    <%--&lt;%&ndash;<td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<select name="account.languagePreference">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<option>English</option>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<option>Chinese</option>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</select>&ndash;%&gt;--%>
    <%--&lt;%&ndash;structs的select的list必须是一个map&ndash;%&gt;--%>
    <%--</td>--%>
    <%--</tr>--%>
    <s:select list="#{'English':'English','Chinese':'Chinese'}"
              label="Language Preference"
              name="account.languagePreference">
    </s:select>
    <tr>
        <td>Favourite Category:</td>
        <td>
            <select name="account.favouriteCategoryId">
                <option value="FISH">FISH</option>
                <option selected="selected" value="DOGS">DOGS</option>
                <option value="REPTILES">REPTILES</option>
                <option value="CATS">CATS</option>
                <option value="BIRDS">BIRDS</option>
            </select>
            <%--<s:select list="#request.CATEGORY_LIST" name="account.favouriteCategoryId">--%>

            <%--</s:select>--%>
        </td>
    </tr>
    <%--<tr>--%>
    <%--<td>Enable MyBanner</td>--%>
    <%--<td>--%>
    <%--&lt;%&ndash;<input type="checkbox" name="bannerOption"/>&ndash;%&gt;--%>
    <%--</td>--%>
    <%--</tr>--%>
    <s:checkbox name="bannerOption" label="Enable MyBanner"/>

</table>
