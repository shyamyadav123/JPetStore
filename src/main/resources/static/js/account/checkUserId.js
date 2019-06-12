$(document).ready(function () {
    var id_success = false;
    var id_result_label = $("#id_result");
    $('#userId').blur(function () {
        // start ajax
        // $.ajaxSetup({contentType: 'application/json'});
        var userId = $('#userId').val();
        console.log(userId);
        $.ajax({
            url: "ajax_checkUserId",
            // dataType: 'json',
            method: 'post',
            data: {userId: userId},
            success: function (data) {
                if (data === "ok") {
                    // can
                    id_success = true;
                    id_result_label.show();
                    id_result_label.html("userId is available.");
                    id_result_label.css("color", "green");
                } else {
                    // 注意这里后端要排除它改了但是用的是原先那一个
                    id_success = false;
                    id_result_label.show();
                    id_result_label.html("userId is already occupied.");
                    id_result_label.css("color", "red");
                }
            },
            error: function (xhr) {
                // alert('error:' + JSON.stringify(xhr));
            }
        }).done(function (data) {
            console.log('success');
        }).fail(function () {
            console.log('error');
        }).always(function () {
            console.log('complete');
        });
    })
});
