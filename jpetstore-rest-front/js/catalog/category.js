$(function () {
    //先从地址栏获取CategoryId
    const categoryId = getQueryString("categoryId");

    //第一次ajax请求
    $.ajax({
        url: "http://localhost:8080/catalog/category/" + categoryId,
        type: "get",
        //data用于接收服务器给予数据
        success: function (data) {
            //输出查看是否正确
            console.log("Hello Category");
            console.log(data);
            $("#categoryName").text(data.name);
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
        url: "http://localhost:8080/catalog/category/" + categoryId + "/products",
        dataType: 'json',
        type: "get",
        success: function (data) {
            console.log("Hello Products");
            console.log(data);
            for (let i = 0; i < data.length; i++) {
                dataHtml = "<tr><td><a href='../../views/catalog/Product.html?productId=" 
                + data[i].productId + "&categoryId=" + categoryId + "'>" +
                    "</a></td><td>" + data[i].name + "</td></tr>";
                console.log(dataHtml);
                $("#productList").append(dataHtml);
            }
        },
        error: function () {
            alert("Error")
        }
    });
});