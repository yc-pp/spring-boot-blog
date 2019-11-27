$(".submit").on('click',function () {
    if($(".username").val() == '') {
        $(".err-username").html('请输入用户名！？？？');
        //$(".tips").html('请输入用户名！？？？');
        //$("#logo").attr("src",'../../img/login/null-username.jpg')
    } else if($(".password").val() == '') {
        $(".err-password").html('请输入密码！？？？');
        //$(".tips").html('请输入密码！？？？');
       // $("#logo").attr("src",'../../img/login/null-password.jpg')
    } else {
        imgVer({
            el:'$("#imgVer")',
            width:'260',
            height:'116',
            img : [ "/admin/plugins/img/login/1.jpg",
                    "/admin/plugins/img/login/2.jpg",
                    "/admin/plugins/img/login/3.jpg",
                    "/admin/plugins/img/login/4.jpg",
                    "/admin/plugins/img/login/5.jpg",
                    "/admin/plugins/img/login/6.jpg",
                    "/admin/plugins/img/login/7.jpg"],
            //img : (JSON.parse($("#imglist").val())),
            success:function () {
                login();
            },
            error:function () {
                //alert('错误什么都不执行')
            }
        });
        $(".login").css({
            "left":"-404px",
            "opacity":"0"
        });
        $(".verBox").css({
            "left":"0",
            "opacity":"1"
        })
    }
});
function login() {
    var userName = $(".username").val();
    var passWord = $(".password").val();
    $.ajax({
        type: 'POST',//方法类型
        url: '/admin/login',
        data: {"userName": userName,"passWord" : passWord},
        success: function (result) {
            if(result.resultCode =='000000'){
                window.location.href = "/admin/index";
            }else {
                swal(result.message, {
                    icon: "error",
                });
                $(".login").css({
                    "left":"0",
                    "opacity":"1"
                });
                $(".verBox").css({
                    "left":"404px",
                    "opacity":"0"
                });
            }
        },
        error: function () {
            swal("登陆失败",{
                icon:"error",
            });
            $(".login").css({
                "left":"0",
                "opacity":"1"
            });
            $(".verBox").css({
                "left":"404px",
                "opacity":"0"
            });
        }
    });
}