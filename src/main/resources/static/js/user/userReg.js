$(function () {
    layui.use('layer', function () {
        var layer = layui.layer;
    });
    toLogin();
    $(".submitUserInfo").click(function () {
        var userInfoArr= $(".userRegForm").serializeArray();
        if(checkUserIngInfo(userInfoArr)){
            userReg();
        }
    });
});
//跳转到登录
function toLogin() {
    $(".loginBtn").click(function () {
        window.location.href="userLogin";
    });
}

function userReg() {
    $.ajax({
        url:'userReg',
        data:$(".userRegForm").serialize(),
        type:'post',
        dataType:'json',
        success:function (data) {
            if (data.code=="0"){
                layer.msg("注册成功!");
            }else {
                layer.msg(data.msg, function () {});
            }
        }
    });
}

/**
 * 检查添加表单是否为空
 * @param userInfoArr
 */
function checkUserIngInfo(userInfoArr) {
    if(userInfoArr[0].value==''||userInfoArr[0].value.length==0){
        layer.msg('手机号码不能为空！', function () {});
        return false;
    }
    if(userInfoArr[1].value==''||userInfoArr[1].value.length==0){
        layer.msg('密码不能为空！', function () {});
        return false;
    }
    if(userInfoArr[2].value==''||userInfoArr[2].value.length==0){
        layer.msg('确认密码不能为空！', function () {});
        return false;
    }
    if(userInfoArr[1].value!=userInfoArr[2].value){
        layer.msg('两次输入密码不一致！', function () {});
        return false;
    }
    return  true;
}
