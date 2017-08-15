$(function () {
    $("#login").click(function () {
        var username = $("#username").val();
        var pssword = $("#password").val();
        $.ajax({
            type:"post",
            data:{ 'userName': username, 'passWord': pssword },
            url: "/user/login",
            success:function (data) {
                $("#user").html(data.userName);
                $("#session").html(data.sessionId);
            }
        })
    })
})