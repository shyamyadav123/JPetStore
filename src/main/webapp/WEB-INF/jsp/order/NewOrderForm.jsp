<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
	<form action="confirmOrder" method="post">
	<table>
		<tr>
			<th colspan=2>Payment Details</th>
		</tr>
		<tr>
			<td>Card Type:</td>
			<td>
				<select>
					<option  selected="selected" value="Visa">
					     Visa
					</option>
					<option value="MasterCard">
						MasterCard
					</option>
					<option value="American Express">
						American Express
					</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Card Number:</td>
			<td>
				<input name="order.creditCard" type="text"/>
			</td>
		</tr>
		<tr>
			<td>Expiry Date (MM/YYYY):</td>
			<td>
				<input type="text" name="order.expiryDate" />
			</td>
		</tr>
		<tr>
			<th colspan=2>Billing Address</th>
		</tr>

		<tr>
			<td>First name:</td>
			<td>
				<input type="text" name="order.billToFirstName"/>
			</td>
		</tr>
		<tr>
			<td>Last name:</td>
			<td>
				<input type="text" name="order.billToLastName">
			</td>
		</tr>
		<tr>
			<td>Address 1:</td>
			<td>
				<input type="text" name="order.billAddress1">
			</td>
		</tr>
		<tr>
			<td>Address 2:</td>
			<td>
				<input type="text" name="order.billAddress2">
			</td>
		</tr>
		<tr>
			<td>City:</td>
			<td>
				<input type="text" name="order.billCity">
			</td>
		</tr>
		<tr>
			<td>State:</td>
			<td>
				<input type="text" name="order.billState">
			</td>
		</tr>
		<tr>
			<td>Zip:</td>
			<td>
				<input type="text" name="order.billZip">
			</td>
		</tr>
		<tr>
			<td>Country:</td>
			<td>
				<input type="text" name="order.billCountry">
			</td>
		</tr>

		<tr>
			<td colspan=2>
				<input name=" shippingAddressRequired" type="checkbox"/>
			     Ship to different address...
			</td>
		</tr>

	</table>

     <input name="newOrder" value="Continue" type="submit"/>
	</form>
</div>

<%@ include file="../common/IncludeButtom.jsp"%>