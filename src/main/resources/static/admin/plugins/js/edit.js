var articleEditor;

$(function () {
    articleEditor = editormd("article-editormd", {
        width: "100%",
        height: 640,
        syncScrolling: "single",
        path: "/admin/plugins/editormd/lib/",
        toolbarModes: 'full',
        /**图片上传配置*/
        imageUpload: true,
        imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"], //图片上传格式
        imageUploadURL: "/admin/arrticle/uploadfile",
        onload: function (obj) { //上传成功之后的回调
        }
    });
});

$("#saveArticle").on("click",function () {
    var articleId = $('#articleId').val();
    var articleTitle = $('#articleName').val();
    var articleContent = articleEditor.getMarkdown();
    var articleCategoryId = $('#articleCategoryId').val();
    var articleCommentable =$("input[name='articleCommentable']:checked").val();
    var articleStatus =$("input[name='articleStatus']:checked").val();
    var objTag =$("input[name='articleTag']:checked");
    var articleTag="";
    for(var i in objTag){
        if(objTag[i].checked){
            articleTag=articleTag+","+objTag[i].value;
        }
    }
    if(articleTag.indexOf(",")==0){
        articleTag=articleTag.substring(1);
    }
    if(isNull(articleTitle)){
        swal("请输入文章标题",{
            icon:"error",
        });
        return;
    }
    if(!validLength(articleTitle,200)){
        swal("标题过长",{
            icon:"error",
        });
        return;
    }
    if(isNull(articleContent)){
        swal("请输入文章内容",{
            icon:"error",
        });
        return;
    }
    if(!validLength(articleContent,100000)){
        swal("文章内容过长",{
            icon:"error",
        });
        return;
    }
    if(isNull(articleCategoryId)){
        swal("请选择文章分类",{
            icon:"error",
        });
        return;
    }
    if(isNull(articleTag+"")){
        swal("请选择文章标签",{
            icon:"error",
        });
        return;
    }
    var url = '/admin/article/save';
    var message = '保存成功';
    var data = {
        "articleTitle": articleTitle, "articleContent": articleContent, "articleCategoryId": articleCategoryId,
        "articleCommentable": articleCommentable, "articleStatus": articleStatus, "articleTag": articleTag
    };
    if(articleId > 0){
        message = '修改成功';
        url = '/admin/article/update';
        data={
            "articleId" : articleId,"articleTitle": articleTitle, "articleContent": articleContent, "articleCategoryId": articleCategoryId,
            "articleCommentable": articleCommentable, "articleStatus": articleStatus, "articleTag": articleTag
        };
    }
    console.log(data);
    $.ajax({
        type: 'POST',//方法类型
        url: url,
        data: data,
        success: function (result) {
            if(result.resultCode =='000000'){
                swal({
                    title: message,
                    icon: 'success',
                    buttons: {cancel:false,
                              confirm:"返回文章列表"}
                }).then(function () {
                    window.location.href = "/admin/article";
                })
            }else {
                swal(result.message, {
                    icon: "error",
                });
            }
        },
        error: function () {
            swal("操作失败",{
                icon:"error",
            });
        }
    });
});
$("#returnArticle").on("click",function () {
    window.location.href = "/admin/article";
});