$(function () {
    const cartId = getCart();
    // 如果具有cartId则获取购物车
    if (cartId != undefined && cartId != '') {
       $.ajax({
           url: "http://localhost:8080/cart/" + cartId,
           type: 'get',
           success: function (res) {
               if(res.code == 1) {

               }
           },
           error:function (res) {

           }
       })
    }
});

function renderPage(data) {
    if(data == null || data.length == 0) {
        $('#cartEmpty').show();
    } else {
        let dataHtml = "";
        for (let i = 0; i < data.length; i++) {
            const item = data[i];
            dataHtml = "<tr>" +
                "<td></td>" +
                "</tr>"
        }
    }
}