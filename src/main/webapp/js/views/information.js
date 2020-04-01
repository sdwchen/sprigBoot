$(function () {

    //1抽取变量
    //2将所有方法统一管理
    $("#information_datagrid").datagrid({
        fit: true,
        url: '/information_list',
        fitColumns: true,
        rownumbers: true,
        pagination: true,
        toolbar: '#information_datagrid_tb',
        pageList: [1, 10, 20, 30, 40, 50],//分页信息
        singleSelect: true, //选中一条数据
        columns: [
            [
                {field: 'id', align: 'center', title: 'id', width: 1},
                {field: 'informationtitle', align: 'center', title: '资讯标题', width: 1},
                {field: 'information', align: 'center', title: '资讯内容', width: 1},
            ]
        ],

    });
    //弹出框
    $("#information_dialog").dialog({
        width: 300,
        height: 350,
        buttons: "#information_dialog_bt",//按钮
        closed: true   //关闭状态
    });


});
//方法要放在$(function(){}外面 不然无法识别add方法

//因为user传过来的是一个对象无法在页面上显示所以用formatter

function add() {
    $("#information_dialog").dialog("open");
    $("#information_dialog").dialog("setTitle", "新增");
    $("#information_form").form("clear");

}

//添加
function save() {
    //获得页面的id判断是保存还是编辑
    var idVal = $("#information_form [name='id']").val();
    var url;
    if (idVal) {

        url = "/information_update";
    } else {
        url = "/information_save";
    }

    //发送异步请求
    $("#information_form").form("submit", {
        url: url,
        success: function (data) {
            data = $.parseJSON(data);
            if (data.success) {
                $.messager.alert("温馨提示", data.msg, "info", function () {
                    //关闭对话框
                    $("#information_dialog").dialog("close");
                    //刷新页面
                    $("#information_datagrid").datagrid("load");
                });
            } else {
                $.messager.alert("温馨提示", data.msg, "info");
            }

        }

    })
}

//修改数据
function edit() {

    var rowData = $("#information_datagrid").datagrid("getSelected");
    if (rowData) {
        $("#information_dialog").dialog("open");
        $("#information_dialog").dialog("setTitle", "编辑");
        $("#information_form").form("clear");

        $("#information_form").form("load", rowData);

    } else {
        $.messager.alert("温馨提示", "请选中一条数据", "info");
    }


}

//删除数据
function del() {
    //选中数据
    var rowData = $("#information_datagrid").datagrid("getSelected");
    if (rowData) {
        $.messager.confirm("温馨提示", "您确定删除这条数据吗", function (yes) {
            if (yes) {
                $.get("/information_delete?id=" + rowData.id, function (data) {
                    if (data.success) {
                        //刷新列表数据
                        $("#information_datagrid").datagrid("load");
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
    $("#information_datagrid").datagrid("load");

}

//关闭弹出框
function cancel() {
    $("#information_dialog").dialog("close");
}

function searchBtn() {
    var value = $("[name='keyword']").val();
    $("#information_datagrid").datagrid("load", {
        keyword: value
    });

}

