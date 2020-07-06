$(function () {
    layui.use('layer', function () {
        var layer = layui.layer;
    });
    setTimeout(function () {
        queryTopicInfo(1);
        pageClick();
    },100);
});
function queryTopicInfo(pageNum){
    $.ajax({
        url:"queryTopicInfo",
        data:{pageNum:pageNum},
        type:"get",
        dataType:"json",
        beforeSend:function(){
            layer.load(2,{
                offset:'30%'
            });
        },
        success:function (data) {
            loadingTopicInfo(data);
            paging(data);
        }
    });
}

/**
 * 加载数据
 */
function loadingTopicInfo(pageInfo) {
    var topicInfo=pageInfo.list;
    var topicList=$(".topicList");
    topicList.empty();
    for (i=0;i<topicInfo.length;i++){
        topicList.append(
            '<div  class="topicItem" style=" margin-top: 20px; cursor:pointer;" id="'+topicInfo[i].topicInfoId+'">'+
                '<div style="margin-right: 10px; display: inline-block;">'+
                    '<img width="150px" src="'+topicInfo[i].topicImg+'" />'+
                '</div>'+
                '<div style="display: inline-block; position: relative;top:10px">'+
                    '<h2 style="display: inline-block;">'+topicInfo[i].topicTitle+'</h2>'+
                    '<p style=" word-wrap: break-word;width: 200px; color: #B8D5E4; font-size:17px ; position: relative;top:-25px">'+topicInfo[i].topicBrief+'</p>'+
                '</div>'+
            '</div>'
        );
    }
}

/**
 * 分页
 */
function paging(pageInfo){
    $(".pageTopic").empty();
    $(".pageTopic").append('<span data-num="1" class="firstPage" style=" cursor:pointer;">[首页]</span>');
    $(".pageTopic").append('<span data-num="'+pageInfo.prePage+'" class="prevPage"">[上一页]</span>');
    for(i=0;i<pageInfo.navigatepageNums.length;i++){
        $(".pageTopic").append('<span data-num="'+pageInfo.navigatepageNums[i]+'" class="navPageNums">['+pageInfo.navigatepageNums[i]+']<span/>');
    }
    $(".pageTopic").append('<span style=" cursor:pointer;">[<input class="currentPage" type="text" value="'+pageInfo.pageNum+'" style="height:15px;width: 50px;" />/'+pageInfo.pages+'页]</span>');
    $(".pageTopic").append('<span data-num="'+pageInfo.nextPage+'" class="nextPage">[下一页]</span>');
    $(".pageTopic").append('<span data-num="'+pageInfo.pages+'" class="lastPage">[尾页]</span>');
    $(".pageTopic").append('<span class="total">共'+pageInfo.total+"条话题"+'<span/>');

    layer.closeAll();
}

/**
 * 分页查询按钮
 */
function pageClick() {
    var pagesBtn=$(".pageTopic");
    pagesBtn.on("click",".firstPage",function () {
        var pageNum=$(this).data("num");
        queryTopicInfo(pageNum);
    });
    pagesBtn.on("click",".prevPage",function () {
        var pageNum=$(this).data("num");
        queryTopicInfo(pageNum);
    });
    pagesBtn.on("click",".navPageNums",function () {
        var pageNum=$(this).data("num");
        queryTopicInfo(pageNum);
    });
    pagesBtn.on("click",".nextPage",function () {
        var pageNum=$(this).data("num");
        queryTopicInfo(pageNum);
    });
    pagesBtn.on("click",".lastPage",function () {
        var pageNum=$(this).data("num");
        queryTopicInfo(pageNum);
    });
    pagesBtn.on("blur",".currentPage",function () {
        var pageNum=$(this).val();
        if((/^(\+|-)?\d+$/.test( pageNum ))|| pageNum<0){
            queryTopicInfo(pageNum);
            return true;
        }else{
            queryTopicInfo(1);
            return false;
        }

    });
}