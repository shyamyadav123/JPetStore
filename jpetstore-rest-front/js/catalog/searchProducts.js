$(function () {
    //先从地址栏获取CategoryId
    const keywords = getQueryString("keywords");

    let dataHtml = "";
    $.ajax({
        url: "http://localhost:8080/catalog/product/" + keywords + "/products",
        type: "get",
        success: function (res) {
            console.log(res);
            const data = res.data;
            for (let i = 0; i < data.length; i++) {
                dataHtml = "<tr>" +
                    "<td><a href='Product.html?productId=" + data[i].productId + "&categoryId=" + categoryId + "'>"+ data[i].description  + "</a></td>" +
                    "<td><b><a href='Product.html?productId=" + data[i].productId + "&categoryId=" + categoryId + "'>" + data[i].productId + "</a></b></td>" +
                    "<td>" + data[i].name + "</td>" +
                    "</tr>";
                console.log(dataHtml);
                $("#productList").append(dataHtml);
            }
        },
        error: function () {
            alert("Error")
        }
    });
});