$(document).ready(function () {
    $('#newAccount').click(function () {
        const pwd = $('#password').val();
        const rePwd = $('#repeatedPassword').val();
        if (pwd != rePwd) {
            $('#newAccountMessage').text("password and repeatedPassword is not equal");
            return;
        }
        $.ajax({
            url: "http://localhost:8080/account/",
            type: "POST",
            dataType: 'json',
            data: {
                username: $('#username').val(),
                password: $('#password').val()
            },
            success: function (res) {
                if (res.code == 1) {
                    $('#redirect').attr('href', '../catalog/Main.html');
                    document.getElementById('redirect').click();
                } else {
                    $('#newAccountMessage').text(res.msg);
                }
            },
            error: function (res) {
                $('#newAccountMessage').text(res.msg);
            }
        })
    })
});