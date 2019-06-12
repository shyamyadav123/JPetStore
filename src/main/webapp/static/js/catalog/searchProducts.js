$(function () {
    //先从地址栏获取CategoryId
    const keywords = getQueryString("keywords");

    let dataHtml = "";
    $.ajax({
        url: "http://localhost:8080/jpetstore/catalog/product/" + keywords + "/products",
        dataType: 'json',
        type: "get",
        success: function (data) {
            console.log("Hello Search Product");
            console.log(data);
            for (let i = 0; i < data.length; i++) {
                dataHtml = "<tr>" +
                    "<td><a href='../../views/catalog/Product.html?productId=" + data[i].productId + "&categoryId=" + categoryId + "'>"+ data[i].description  + "</a></td>" +
                    "<td><b><a href='../../views/catalog/Product.html?productId=" + data[i].productId + "&categoryId=" + categoryId + "'>" + data[i].productId + "</a></b></td>" +
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