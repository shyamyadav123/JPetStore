$(document).ready(function () {
    $("#searchInput").on("input propertychange", function (e) {
        var keyword = $(this).val();
        if (keyword) {
            $.ajax({
                url: "catalog/ajax_search",
                type: "get",
                data: {
                    keyword: keyword
                },
                success: function (res) {
                    if (res !== "[]") {
                        res = res.substring(1, res.length - 1);
                        var resArr = res.split(", ");
                        setItems(resArr)
                    } else {
                        $("#searchItem").hide();
                    }
                }
            })
        } else {
            $("#searchItem").hide();
        }

    }).blur(function () {
        //防止失去焦点隐藏 和 点击事件 冲突
        setTimeout(function () {
            $("#searchItem").hide();
        }, 100)
    });
});

function setItems(a) {
    $("#itemList").html("");
    for (var i in a) {
        $("#itemList").append("<li class=\"list-group-item\" onmouseover=\"selectItem(this)\" >" + a[i] + "</li>");
        $("#searchItem").show();
    }
}

function selectItem(target) {
    $("#searchInput").val(target.innerText);

}