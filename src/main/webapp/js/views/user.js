$(function () {

    //1抽取变量
    //2将所有方法统一管理
    $("#user_datagrid").datagrid({
        fit: true,
        url: '/user_list',
        fitColumns: true,
        rownumbers: true,
        pagination: true,
        toolbar: '#user_datagrid_tb',
        pageList: [1, 10, 20, 30, 40, 50],//分页信息
        singleSelect: true, //选中一条数据
        columns: [
            [

                {field: 'username', align: 'center', title: '用户名', width: 1},
                {field: 'realname', align: 'center', title: '真实名字', width: 1},
                {field: 'tel', align: 'center', title: '电话号码', width: 1},
                {field: 'imgurl', align: 'center', title: '头像', width: 1},
            ]
        ],

    });
    //弹出框
    $("#user_dialog").dialog({
        width: 250,
        height: 300,
        buttons: "#user_dialog_bt",//按钮
        closed: true   //关闭状态
    });


});

//方法要放在$(function(){}外面 不然无法识别add方法

function add() {
    $("#user_dialog").dialog("open");
    $("#user_dialog").dialog("setTitle", "新增");
    $("#user_form").form("clear");

}

//添加
function save() {
    //获得页面的id判断是保存还是编辑
    var idVal = $("#user_form [name='userid']").val();
    var url;
    if (idVal) {

        url = "/user_update";
    } else {
        url = "/user_save";
    }

    //发送异步请求
    $("#user_form").form("submit", {
        url: url,
        success: function (data) {
            data = $.parseJSON(data);
            if (data.success) {
                $.messager.alert("温馨提示", data.msg, "info", function () {
                    //关闭对话框
                    $("#user_dialog").dialog("close");
                    //刷新页面
                    $("#user_datagrid").datagrid("load");
                });
            } else {
                $.messager.alert("温馨提示", data.msg, "info");
            }

        }

    })
}

//修改数据
function edit() {

    var rowData = $("#user_datagrid").datagrid("getSelected");
    if (rowData) {
        $("#user_dialog").dialog("open");
        $("#user_dialog").dialog("setTitle", "编辑");
        $("#user_form").form("clear");
        $("#user_form").form("load", rowData);

    } else {
        $.messager.alert("温馨提示", "请选中一条数据", "info");
    }


}

//删除数据
function del() {
    //选中数据
    var rowData = $("#user_datagrid").datagrid("getSelected");
    if (rowData) {
        $.messager.confirm("温馨提示", "您确定删除这条数据吗", function (yes) {
            if (yes) {
                $.get("/user_delete?id=" + rowData.userid, function (data) {
                    if (data.success) {
                        //刷新列表数据
                        $("#user_datagrid").datagrid("load");
                        $.messager.alert("温馨提示", data.msg);
                    } else {
                        $.messager.alert("温馨提示", data.msg, "info");
                    }
                })
            }

        })
    } else {
        $.messager.alert("温馨提示", "请选择需要删除的用户", "info");
    }

}

//刷新
function reload() {
    $("#user_datagrid").datagrid("load");

}

//关闭弹出框
function cancel() {
    $("#user_dialog").dialog("close");
}

function searchBtn() {
    var value = $("[name='keyword']").val();
    $("#user_datagrid").datagrid("load", {
        keyword: value
    });

}
function submit2(){
    var type = "file";          //后台接收时需要的参数名称，自定义即可
    var id = "cert";            //即input的id，用来寻找值
    var formData = new FormData();
    console.log(formData)
    formData.append(type, $("#"+id)[0].files[0]);    //生成一对表单属性
    $.ajax({
        type: "POST",           //因为是传输文件，所以必须是post
        url: '/uploadImg',         //对应的后台处理类的地址
        data: formData,
        processData: false,
        contentType: false,
        success: function (data) {
            console.log(data.url)
            $("#imgurl").val(data.url)
        }
    });
}
