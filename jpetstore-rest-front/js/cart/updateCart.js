$(document).ready(function () {

    var oldQuantity = $("#itemQuantity").val();

    $("#itemQuantity").focus(function () {

    }).change(function (e) {

        var quantity = $(this).val();
        console.log(quantity - oldQuantity);
        var name = $(this)[0].name;
        if (!isNaN(quantity)) {
            var data = {};
            data[name] = quantity;

            var that = this;
            $.ajax({
                url: "ajax_updateCart",
                method: "post",
                data: data,
                success: function (msg) {
                    console.log(msg);
                    if (msg !== "ok") {
                        alert("Sorry, over stock!");
                        return;
                    }
                    var price = parseFloat($(that).parent().next().text().replace(/^\s*|\s*$/g, "").substring(1));
                    var oldTotalPrice = parseFloat($(that).parent().next().next().text().replace(/^\s*|\s*$/g, "").substring(1));
                    var addMoney = price * (quantity - oldQuantity);
                    var oldMoney = parseFloat($("#totalMoney").text().replace(/^\s*|\s*$/g, "").substring(1));
                    console.log(oldMoney);
                    console.log(addMoney);
                    $("#totalMoney").text("$" + (oldMoney + addMoney).toString());
                    $(that).parent().next().next().text("$" + (oldTotalPrice + addMoney).toString())
                }
            })
        }
    });
});

