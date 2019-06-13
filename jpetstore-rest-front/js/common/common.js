function getQueryString(name) {
    const reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
    const r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2]);
    }
    return null;
}

$(document).ready(function () {

    // 校验登陆状态
    const auth = getAuthorization();
    if (auth != undefined && auth != '') {
        $.ajax({
            url: "http://localhost:8080/token/" + getUserId(),
            type: 'put',
            success: function (res) {
                // 按照登录状态渲染页面
                if (res.code == 1) {
                    $('#headerSignIn').hide();
                    $('#headerSignOut').show();
                    $.ajax({
                        url: "http://localhost:8080/account/" + getUserId(),
                        type: 'get',
                        success: function (res1) {
                            console.log(res1);
                            if (res1.code == 1) {
                                const data = res1.data;
                                if (data.bannerOption) {
                                    $('#Banner').html(data.bannerName);
                                }
                            }
                        },
                        beforeSend: function (request) {
                            request.setRequestHeader('Authorization', auth);
                        }
                    })
                }
            },
            error: function () {
                // 按照未登录状态渲染页面
                $('#headerSignIn').show();
                $('#headerSignOut').hide();
                $('#Banner').empty();
            },
            beforeSend: function (request) {
                request.setRequestHeader('Authorization', auth);
            }
        })
    } else {
        // 按照未登录状态渲染页面
        $('#headerSignIn').show();
        $('#headerSignOut').hide();
        $('#Banner').empty();
    }

    $('#headerSignOut').click(function () {
        $.ajax({
            url: "http://localhost:8080/token/" + getAuthorization(),
            type: "delete",
            success: function (res) {
                if (res.code == 1) {
                    sessionStorage.setItem("jpet-authorizaion", "");
                    $('#headerSignOut').attr('href', '../catalog/Main.html');
                    document.getElementById('headerSignOut').click();
                }
            },
            error: function () {

            }
        })
    });


    $('#searchButton').click(function () {
        let action = $('#searchForm').attr("action");
        action = action + "?keywords=" + $('#searchInput').val();
        $('#searchForm').attr("action", action);
        $('#searchForm').submit();
    });

    $("#searchInput").on("input propertychange", function (e) {
        const keyword = $(this).val();
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
                        let resArr = res.split(", ");
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

function getAuthorization() {
    return sessionStorage.getItem("jpet-authorization");
}

function getCart() {
    return sessionStorage.getItem("jpet-cart");
}

function getUserId() {
    const auth = getAuthorization();
    if (auth != undefined && auth != '') {
        return auth.split('_')[0];
    }
    return '';
}