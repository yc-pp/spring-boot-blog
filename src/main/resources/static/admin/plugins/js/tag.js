 $(function () {

        var t = $("#table_tagList").bootstrapTable({
            toolbar: '#toolbar',
            url: '/admin/tag/list',
            method: 'get',
            dataType: "json",
            striped: true,//设置为 true 会有隔行变色效果
            undefinedText: "空",//当数据为 undefined 时显示的字符
            pagination: true, //分页
            // paginationLoop:true,//设置为 true 启用分页条无限循环的功能。
            showToggle: false,//是否显示 切换试图（table/card）按钮
            showColumns: false,//是否显示 内容列下拉框
            pageNumber: 1,//如果设置了分页，首页页码
            // showPaginationSwitch:true,//是否显示 数据条数选择框
            pageSize: 5,//如果设置了分页，页面数据条数
            pageList: [5, 10, 20, 40],	//如果设置了分页，设置可供选择的页面数据条数。设置为All 则显示所有记录。
            paginationPreText: '<<',//指定分页条中上一页按钮的图标或文字,这里是<
            paginationNextText: '›>',//指定分页条中下一页按钮的图标或文字,这里是>
            // singleSelect: false,//设置True 将禁止多选
            search: false, //显示搜索框
            data_local: "zh-US",//表格汉化
            sidePagination: "server", //服务端处理分页
            queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的
                var param= {//这里的params是table提供的
                    page: params.offset,//从数据库第几条记录开始
                    limit: params.limit//找多少条
                };
                console.log(param);
                return param;
            },
            idField: "oId",//指定主键列
            columns: [
                {
                    //部门名字
                    title: '标签名称',
                    field: 'tagtitle',//可以直接取到属性里面的属性，赞
                    align: 'center'
                },
                {
                    title: '添加时间',
                    field: 'createdate',
                    align: 'center'
                },
                {
                    title: '操作',
                    field: 'oid',
                    align: 'center',
                    formatter: function (value, row, index) {//自定义显示可以写标签哦~
                        return '<button type="buttton" class="btn btn-danger" onclick="del(\'' + row.oid + '\')">删除</button> ';
                    }
                }

            ]
        });


        t.on('load-success.bs.table', function (data) {//table加载成功后的监听函数
            console.log("load success");
            console.log(data);
           // $(".pull-right").css("display", "block");
        });

    });

function del(oid) {
    swal({
        title: "确认弹框",
        text: "确认要删除数据吗?",
        icon: "warning",
        buttons: ["取消", "确认"],
        dangerMode: true,
    }).then((inputValue) => {
        if(inputValue) {
            $.ajax({
                type: 'POST',//方法类型
                url: '/admin/tag/del',
                data: {"oid": oid},
                success: function (result) {
                    if(result.resultCode =='000000'){
                        swal("删除成功",{
                            icon:"success",
                        });
                        $('#table_tagList').bootstrapTable('refresh');
                    }else {
                        swal(result.message, {
                            icon: "error",
                        });
                    }
                },
                error: function () {
                    swal("删除失败",{
                        icon:"error",
                    });
                    $('#table_tagList').bootstrapTable('refresh');
                }
            });
        }
    })

}

 //绑定modal上的保存按钮
 $('#saveButton').click(function () {
     var tagTitle = $("#tagTitle").val();
     if (!validCN_ENString2_18(tagTitle)) {
         $('#edit-error-msg').css("display", "block");
         $('#edit-error-msg').html("请输入符合规范的名称！");
         return;
     }
     $.ajax({
         type: 'POST',//方法类型
         url: '/admin/tag/save',
         data: {"tagTitle": tagTitle},
         success: function (result) {
             $('#myModal').modal('hide');
             document.getElementById("tagForm").reset();
             if(result.resultCode =='000000'){
                 swal("保存成功",{
                     icon:"success",
                 });
                 $('#table_tagList').bootstrapTable('refresh');
             }else {
                 swal(result.message, {
                     icon: "error",
                 });
             }
         },
         error: function () {
             $('#myModal').modal('hide');
             swal("保存失败",{
                 icon:"error",
             });
             document.getElementById("tagForm").reset();
             $('#table_tagList').bootstrapTable('refresh');
         }
     });

 });

function tagAdd() {
    $('#edit-error-msg').css("display", "none");
    document.getElementById("tagForm").reset();
    $('#myModal').modal('show');
}