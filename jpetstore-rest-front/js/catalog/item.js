$(function () {
    //先从地址栏获取CategoryId
    const itemId = getQueryString("itemId");
    const productId = getQueryString("productId");

    $('#backToProduct').href = "Product.html?productId=" + productId;

    let dataHtml = "";
    //第二次ajax请求
    $.ajax({
        url: "http://localhost:8080/catalog/item/" + itemId,
        type: "get",
        success: function (res) {
            console.log(res);
            const data = res.data;
            let quantityHtml = "";
            if (data.quantity <= 0) {
                quantityHtml = "<tr><td>Back ordered.</td></tr>"
            } else {
                quantityHtml = "<tr><td>" + data.quantity + "in stock</td></tr>"
            }
            dataHtml = "<tbody>" +
                "<tr><td>" + data.product.description + "</td></tr>" +
                "<tr><td><b>" + itemId + "</b></td></tr>" +
                "<tr><td><b><font size=\"4\">" + data.attribute1 + "</font></b></td></tr>" +
                "<tr><td>" + data.product.name + "</td></tr>" +
                quantityHtml +
                "<tr><td>" + data.listPrice + "</td></tr>" +
                "<tr><td><a class='button' href='../../views/cart/Cart.html?workingItemId=" + itemId + "'>Add to Cart</a></td></tr>" +
                "</tbody>";
            console.log(dataHtml);
            $("#itemInfo").append(dataHtml);
        },
        error: function () {
            alert("Error")
        }
    });
});