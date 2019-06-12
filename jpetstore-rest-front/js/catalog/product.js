$(function () {
    //先从地址栏获取CategoryId
    const productId = getQueryString("productId");
    const categoryId = getQueryString("categoryId");

    $('#backToCategory').href = "Category.html?categoryId=" + categoryId;

    //第一次ajax请求
    $.ajax({
        url: "http://localhost:8080/catalog/product/" + productId,
        type: "get",
        //data用于接收服务器给予数据
        success: function (res) {
            //输出查看是否正确
            console.log(res);
            $("#productName").text(res.data.name);
        },
        error: function () {
            alert("Error")
            //类似java异常处理
        }
    });
    // alert(categoryId);

    let dataHtml = "";
    //第二次ajax请求
    $.ajax({
        url: "http://localhost:8080/catalog/product/" + productId + "/items",
        type: "get",
        success: function (res) {
            console.log(res);
            const data = res.data;
            for (let i = 0; i < data.length; i++) {
                dataHtml = "<tr><td><a href='Item.html?itemId=" + data[i].itemId + "&productId=" + productId + "'>"+data[i].itemId +"</a></td>" +
                    "<td>" + data[i].product.name + "</td>" +
                    "<td>" + productId + data[i].attribute1 + "</td>" +
                    "<td>" + data[i].listPrice + "</td>" +
                    "<td>" + "<a class='button' href='../cart/Cart.html?workingItemId='" + data[i].itemId + "'>Add to Cart</a>" + "</td>" +
                    "</tr>";
                console.log(dataHtml);
                $("#itemList").append(dataHtml);
            }
        },
        error: function () {
            alert("Error")
        }
    });
});