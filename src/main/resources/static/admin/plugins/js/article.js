$(function () {

    var t = $("#table_tagList").bootstrapTable({
        toolbar: '#toolbar',
        url: '/admin/article/list',
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
                title: '文章标题',
                field: 'articletitle',//可以直接取到属性里面的属性，赞
                align: 'center',
                width:  '15%'
            },
            {
                title: '文章分类',
                field: 'articlecategoryname',//可以直接取到属性里面的属性，赞
                align: 'center',
                width:  '13%'
            },
            {
                //部门名字
                title: '文章图片',
                field: 'articleimguri',//可以直接取到属性里面的属性，赞
                align: 'center',
                width:  '25%'
            },
            {
                title: '文章状态',
                field: 'articlestatus',//可以直接取到属性里面的属性，赞
                align: 'center',
                width:  '5%',
                formatter: function (value, row, index) {//自定义显示可以写标签哦~
                    if(row.articlestatus==0){
                        return '<button type="buttton"  class="btn btn-info" disabled="disabled">草稿</button>';
                    }else {
                        return '<button type="buttton" class="btn btn-success" disabled="disabled">发布</button>';

                    }
                }
            },
            {
                title: '浏览量',
                field: 'articleviewcount',//可以直接取到属性里面的属性，赞
                align: 'center',
                width:  '5%'
            },
            {
                title: '添加时间',
                field: 'articlecreated',
                align: 'center',
                width:  '20%'
            },
            {
                title: '操作',
                field: 'oid',
                align: 'center',
                width:  '17%',
                formatter: function (value, row, index) {//自定义显示可以写标签哦~
                    return '<button type="buttton" class="btn btn-info" onclick="edit(\'' + row.oid + '\')">修改</button>&nbsp;&nbsp;&nbsp;&nbsp;<button type="buttton" class="btn btn-danger" onclick="del(\'' + row.oid + '\')">删除</button> ';
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
function edit(oid) {
    window.location.href = "/admin/article/edit/"+oid;
}
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
                url: '/admin/article/del',
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


function articleAdd() {
    window.location.href = "/admin/article/edit";
}