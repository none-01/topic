$(function () {
    selectImgs();
    $("body").on("click",".subminTopic",function () {
        addTopicInfo();
    });
});

/**
 * 添加对话框
 */
function addTopicUI() {
    layer.open({
        type: 1 //Page层类型
        , area: ['510px', '550px']
        , title: '添加话题'
        , shade: 0.6 //遮罩透明度
        , maxmin: false //允许全屏最小化
        , anim: 0 //0-6的动画形式，-1不开启
        , content:
            '<form style="margin-left: 30px;" class="addTopicForm" enctype="multipart/form-data">' +
                '<div style="margin-top:20px;margin-left: 30px;">'+
                    '<img class="topimg-btn" style="margin-left: -20px;" width="100" height="100" src="img/add.jpg"/>'+
                    '<input name="file"  class="img-file-btn" type="file" style="display: none" accept = "image/*">'+
                '</div>'+
                '<div  style="margin-left:10px; margin-top:20px;">'+
                    '<input style="width: 400px; height: 40px;" name="topicTitle" type="text" placeholder="话题标题">'+
                '</div>'+
                '<div  style="margin-left:10px; margin-top:20px;">'+
                    '<input style="width: 400px; height: 40px;" name="topicBrief" type="text" placeholder="话题简介">'+
                '</div>'+
                '<div  style="margin-left:10px; margin-top:20px;">'+
                    '<textarea style="width: 400px; height: 100px;" name="topicContent" type="text" placeholder="话题内容"></textarea>'+
                '</div>'+
                '<div  style="margin-left:10px; margin-top:20px;">'+
                    '<button class="subminTopic" style="width: 405px; height: 40px;" type="button">提交</button>'+
                '</div>'+
            '</form>'
    });
}

/**
 * 选择头像
 */
function selectImgs() {
    var body=$("body");
    body.on('click','.topimg-btn',function () {
        $(".img-file-btn").trigger('click');
        $(".img-file-btn").on("change",function(){
            var objUrl = getObjectURL(this.files[0]) ; //获取图片的路径，该路径不是图片在本地的路径
            if (objUrl) {
                $(".topimg-btn").attr("src", objUrl); //将图片路径存入src中，显示出图片
            }
        });
    });
}
//建立一個可存取到該file的url
function getObjectURL(file) {
    var url = null ;
    if (window.createObjectURL!=undefined) { // basic
        url = window.createObjectURL(file) ;
    } else if (window.URL!=undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(file) ;
    } else if (window.webkitURL!=undefined) { // webkit or chrome
        url = window.webkitURL.createObjectURL(file) ;
    }
    return url ;
}

/**
 * 添加话题
 */
function addTopicInfo() {
    var dataform=new FormData($(".addTopicForm")[0]);
    layer.load(0, {
        shade: [0.1,'#000'] //0.1透明度的白色背景
    }); //0代表加载的风格，支持0-2
    $.ajax({
        url:'addTopicInfo',
        data:dataform,
        type:'post',
        processData: false,
        contentType: false,
        dataType:'json',
        success:function (data) {
            if (data.code=="0"){
                layer.closeAll();
                layer.msg("添加成功!");
                setTimeout(function () {
                    queryTopicInfo(1);
                },150)
            }else {
                layer.msg(data.msg);
            }
        }
    });
}