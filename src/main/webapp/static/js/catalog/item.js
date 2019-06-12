$(function () {
    //先从地址栏获取CategoryId
    const itemId = getQueryString("itemId");
    const productId = getQueryString("productId");

    $('#backToProduct').href = "Product.html?productId=" + productId;

    let dataHtml = "";
    //第二次ajax请求
    $.ajax({
        url: "http://localhost:8080/jpetstore/catalog/item/" + itemId,
        dataType: 'json',
        type: "get",
        success: function (data) {
            console.log("Hello Item");
            console.log(data);
            let quantityHtml = "";
            if (data.item.quantity <= 0) {
                quantityHtml = "<tr><td>Back ordered.</td></tr>"
            } else {
                quantityHtml = "<tr><td>" + data.item.quantity + "in stock</td></tr>"
            }
            dataHtml = "<tbody>" +
                "<tr><td>" + data.product.description + "</td></tr>" +
                "<tr><td><b>" + itemId + "</b></td></tr>" +
                "<tr><td><b><font size=\"4\">" + data.item.attribute1 + "</font></b></td></tr>" +
                "<tr><td>" + data.product.name + "</td></tr>" +
                quantityHtml +
                "<tr><td>" + data.item.listPrice + "</td></tr>" +
                "<tr><td><a class='button' href='../../views/cart/Cart.html?workingItemId=" + itemId + "'>Add to Cart</a></td></tr>" +
                "</tbody>";
            $("#itemInfo").append(dataHtml);
        },
        error: function () {
            alert("Error")
        }
    });
});