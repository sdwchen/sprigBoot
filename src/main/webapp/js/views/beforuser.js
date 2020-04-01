$(function () {

    //1抽取变量
    //2将所有方法统一管理
    $("#beforuser_datagrid").datagrid({
        fit: true,
        url: '/beforuser_list',
        fitColumns: true,
        rownumbers: true,
        pagination: true,
        toolbar: '#beforuser_datagrid_tb',
        pageList: [1, 10, 20, 30, 40, 50],//分页信息
        singleSelect: true, //选中一条数据
        columns: [
            [
                {field: 'id', align: 'center', title: 'id', width: 1},
                {field: 'name', align: 'center', title: '名字', width: 1},
                {field: 'password', align: 'center', title: '密码', width: 1},
            ]
        ],

    });
    //弹出框
    $("#beforuser_dialog").dialog({
        width: 300,
        height: 350,
        buttons: "#beforuser_dialog_bt",//按钮
        closed: true   //关闭状态
    });


});

//方法要放在$(function(){}外面 不然无法识别add方法


function add() {
    $("#beforuser_dialog").dialog("open");
    $("#beforuser_dialog").dialog("setTitle", "新增");
    $("#beforuser_form").form("clear");

}

//添加
function save() {
    //获得页面的id判断是保存还是编辑
    var idVal = $("#beforuser_form [name='id']").val();
    var url;
    if (idVal) {

        url = "/beforuser_update";
    } else {
        url = "beforuser_save";
    }

    //发送异步请求
    $("#beforuser_form").form("submit", {
        url: url,
        success: function (data) {
            data = $.parseJSON(data);
            if (data.success) {
                $.messager.alert("温馨提示", data.msg, "info", function () {
                    //关闭对话框
                    $("#beforuser_dialog").dialog("close");
                    //刷新页面
                    $("#beforuser_datagrid").datagrid("load");
                });
            } else {
                $.messager.alert("温馨提示", data.msg, "info");
            }

        }

    })
}

//修改数据
function edit() {

    var rowData = $("#beforuser_datagrid").datagrid("getSelected");
    if (rowData) {
        $("#beforuser_dialog").dialog("open");
        $("#beforuser_dialog").dialog("setTitle", "编辑");
        $("#beforuser_form").form("clear");
        $("#beforuser_form").form("load", rowData);

    } else {
        $.messager.alert("温馨提示", "请选中一条数据", "info");
    }


}

//删除数据
function del() {
    //选中数据
    var rowData = $("#beforuser_datagrid").datagrid("getSelected");
    if (rowData) {
        $.messager.confirm("温馨提示", "您确定删除这条数据吗", function (yes) {
            if (yes) {
                $.get("/beforuser_delete?id=" + rowData.id, function (data) {
                    if (data.success) {
                        //刷新列表数据
                        $("#beforuser_datagrid").datagrid("load");
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
    $("#beforuser_datagrid").datagrid("load");

}

//关闭弹出框
function cancel() {
    $("#beforuser_dialog").dialog("close");
}

function searchBtn() {
    var value = $("[name='keyword']").val();
    $("#beforuser_datagrid").datagrid("load", {
        keyword: value
    });

}

