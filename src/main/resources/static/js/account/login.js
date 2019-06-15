$(document).ready(function () {
    $("#submitForm").click(function () {
        var userId = $('#userId').val();
        var password = $('#password').val();
        var code = $('#verifyCode').val();
        console.log(userId);
        console.log(code);
        var on_submit = true;
        if (code === "" || code === null) {
            $('#SignInInfo').text("Please enter verify code");
            on_submit = false;
        }
        if (on_submit===true) {
            if (userId === "" || userId === null) {
                $('#SignInInfo').text("Please enter username!");
                on_submit = false;
            }
            if (password === "" || password === null) {
                $('#SignInInfo').text("Please enter password!");
                on_submit = false;
            }
        }

        if (on_submit===true) {
            $.ajax({
                url: 'ajax_login',
                method: "post",
                data: {
                    userId: userId,
                    password: password,
                    verifyCode: code
                },
                success: function (res) {
                    console.log(res);
                    res = JSON.parse(res);
                    if (res.status === false) {
                        $('#SignInInfo').text(res.message);
                    } else {
                        window.location = "/jpetstore/main";
                    }
                }
            })
        }

    });
});
