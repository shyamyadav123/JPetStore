$(function () {
    //先从地址栏获取CategoryId
    const productId = getQueryString("productId");

    //第一次ajax请求
    $.ajax({
        url: "http://localhost:8080/jpetstore/catalog/product/" + productId,
        dataType: 'json',
        type: "get",
        //data用于接收服务器给予数据
        success: function (data) {
            //输出查看是否正确
            console.log("Hello Product");
            console.log(data);
            $("#productName").text(data.name);
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
        url: "http://localhost:8080/jpetstore/catalog/product/" + productId + "/items",
        dataType: 'json',
        type: "get",
        success: function (data) {
            console.log("Hello Items");
            console.log(data);
            for (let i = 0; i < data.length; i++) {
                dataHtml = "<tr><td><a href=\"../../views/catalog/Item.html\">" + data[i].itemId + "</a>" +
                    "</td><td>" + data[i].name + "</td>" +
                    "<td>" + productId + "</td>" +
                    "<td>" + data[i].attribute1 + " " + data[i].attribute2 + " " + "</td>" +
                    "<td>" + data[i].listPrice + "</td>" +
                    "<td>" + "<a href=\"${ctx}/cart/addItemToCart?workingItemId=\""+ data[i].itemId +">Add to Cart</a>" + "</td>" +
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