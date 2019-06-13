$(function () {
    let message = getQueryString('message');
    if (message == undefined) {
        message = '';
    }
    $('#editAccountMessage').text(message);
    const auth = getAuthorization();
    // 未登录 重定向至登陆界面
    if (auth == undefined || auth == '') {
        $('#redirect').attr('href', 'SignonForm.html');
        document.getElementById('redirect').click();
    } else {
        // 请求用户信息
        getUserInfo();
    }
});

$(document).ready(function () {
    $('#editAccount').click(function () {
        const pwd = $('#password').val();
        const rePwd = $('#repeatedPassword').val();
        if (pwd != rePwd) {
            $('#editAccountMessage').text("password and repeatedPassword is not equal");
            return;
        }
        // $('#editAccountForm').attr('action', 'http://localhost:8080/account/' + $('#username').text());
        // $('#editAccountForm').attr('method', 'put');
        // $('#editAccountForm').submit();
        // getUserInfo();
        $.ajax({
            url: "http://localhost:8080/account/" + $('#username').text(),
            type: "put",
            dataType: 'json',
            data: $('#editAccountForm').serialize(),
            success: function (res) {
                if (res.code == 1) {
                    renderPage(res.data)
                } else {
                    $('#editAccountMessage').text(res.msg);
                }
            },
            error: function (res) {
                $('#editAccountMessage').text(res.msg);
            },
            beforeSend: function (request) {
                request.setRequestHeader('Authorization', getAuthorization());
            }
        })
    })
});

function getUserInfo() {
    $.ajax({
        url: "http://localhost:8080/account/" + getUserId(),
        type: "get",
        success: function (res) {
            if (res.code == 1) {
                const data = res.data;
                // 渲染界面
                renderPage(data);
            } else {
                $('#redirect').attr('href', 'SignonForm.html');
                document.getElementById('redirect').click();
            }
        },
        error: function () {
            $('#redirect').attr('href', 'SignonForm.html');
            document.getElementById('redirect').click();
        },
        beforeSend: function (request) {
            request.setRequestHeader("Authorization", getAuthorization());
        }

    })
}

function renderPage(data) {
    $('#username').text(data.username);
    $('#firstName').val(data.firstName);
    $('#lastName').val(data.lastName);
    $('#phone').val(data.phone);
    $('#address1').val(data.address1);
    $('#address2').val(data.address2);
    $('#city').val(data.city);
    $('#zip').val(data.zip);
    $('#country').val(data.country);
    $('#languagePreference').val(data.languagePreference);
    $('#favouriteCategoryId').val(data.favouriteCategoryId);
    $('#listOption').attr('checked', data.listOption);
    $('#bannerOption').attr('checked', data.bannerOption);
}