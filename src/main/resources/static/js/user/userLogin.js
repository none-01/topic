$(function () {
    layui.use('layer', function () {
        var layer = layui.layer;
    });
    torReg();
    $(".loginBtn").click(function () {
        var loginUserInfo= $(".userloginForm").serializeArray();
        if(checkLoginUserIngInfo(loginUserInfo)){
            userLogin();
        }
    });
});
//跳转到注册
function torReg() {
    $(".regBtn").click(function () {
        window.location.href="userRegister";
    });
}

function userLogin() {
    $.ajax({
        url:'userLogin',
        data:$(".userloginForm").serialize(),
        type:'post',
        dataType:'json',
        success:function (data) {
            if (data.code=="0"){
                window.location.href="topicList"
            }else {
                layer.msg(data.msg, function () {});
            }
        }
    });
}

/**
 * 检查登录表单是否为空
 * @param loginUserInfo
 */
function checkLoginUserIngInfo(loginUserInfo) {
    if(loginUserInfo[0].value==''||loginUserInfo[0].value.length==0){
        layer.msg('手机号码不能为空！', function () {});
        return false;
    }
    if(loginUserInfo[1].value==''||loginUserInfo[1].value.length==0){
        layer.msg('密码不能为空！', function () {});
        return false;
    }
    return  true;
}
