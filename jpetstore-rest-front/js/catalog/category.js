$(function () {
    //先从地址栏获取CategoryId
    const categoryId = getQueryString("categoryId");

    //第一次ajax请求
    $.ajax({
        url: "http://localhost:8080/catalog/category/" + categoryId,
        type: "get",
        //data用于接收服务器给予数据
        success: function (res) {
            //输出查看是否正确
            console.log(res);
            $("#categoryName").html(res.data.name);
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
        success: function (res) {
            console.log(res);
            const data = res.data;
            for (let i = 0; i < data.length; i++) {
                dataHtml = "<tr><td><a href='Product.html?productId="
                + data[i].productId + "&categoryId=" + categoryId + "'>" + data[i].productId +
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