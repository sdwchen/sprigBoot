$(function () {

    //1抽取变量
    //2将所有方法统一管理
    $("#msg_datagrid").datagrid({
        fit: true,
        url: '/msg_list',
        fitColumns: true,
        rownumbers: true,
        pagination: true,
        toolbar: '#msg_datagrid_tb',
        pageList: [1, 10, 20, 30, 40, 50],//分页信息
        singleSelect: true, //选中一条数据
        columns: [
            [
                {field: 'id', align: 'center', title: '评论id', width: 1},
                {field: 'username', align: 'center', title: '用户名', width: 1, formatter: userFormatter},
                {field: 'msg', align: 'center', title: '留言内容', width: 1},
            ]
        ],

    });
    //弹出框
    $("#msg_dialog").dialog({
        width: 300,
        height: 350,
        buttons: "#msg_dialog_bt",//按钮
        closed: true   //关闭状态
    });


});
//方法要放在$(function(){}外面 不然无法识别add方法

//因为user传过来的是一个对象无法在页面上显示所以用formatter
function userFormatter(value, row, index) {

    if (row.user) {
        return row.user.username;

    } else {
        return null;
    }

}

function add() {
    $("#msg_dialog").dialog("open");
    $("#msg_dialog").dialog("setTitle", "新增");
    $("#msg_form").form("clear");

}
//删除数据
function del() {
    //选中数据
    var rowData = $("#msg_datagrid").datagrid("getSelected");
    if (rowData) {
        $.messager.confirm("温馨提示", "您确定删除这条数据吗", function (yes) {
            if (yes) {
                $.get("/msg_delete?id=" + rowData.id, function (data) {
                    if (data.success) {
                        //刷新列表数据
                        $("#msg_datagrid").datagrid("load");
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
    $("#msg_datagrid").datagrid("load");

}

//关闭弹出框
function cancel() {
    $("#msg_dialog").dialog("close");
}

function searchBtn() {
    var value = $("[name='keyword']").val();
    $("#msg_datagrid").datagrid("load", {
        keyword: value
    });

}

