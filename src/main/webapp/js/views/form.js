$(function () {

    //1抽取变量
    //2将所有方法统一管理
    $("#form_datagrid").datagrid({
        fit: true,
        url: '/form_list',
        fitColumns: true,
        rownumbers: true,
        pagination: true,
        toolbar: '#form_datagrid_tb',
        pageList: [1, 10, 20, 30, 40, 50],//分页信息
        singleSelect: true, //选中一条数据
        columns: [
            [
                {field: 'user', align: 'center', title: '用户名', width: 1, formatter: userFormatter},
                {field: 'bookname', align: 'center', title: '书名', width: 1},
                {field: 'booktype', align: 'center', title: '书本类型', width: 1},
                {field: 'clothesname', align: 'center', title: '衣服名', width: 1},
                {field: 'clothestype', align: 'center', title: '衣服类型', width: 1},
                {field: 'othersname', align: 'center', title: '其它', width: 1},
                {field: 'otherstype', align: 'center', title: '其它类型', width: 1},
                {field: 'state', align: 'center', title: '状态', width: 1},
                {field: 'starttime', align: 'center', title: '订单发起时间', width: 1},
                {field: 'endtime', align: 'center', title: '订单结束时间', width: 1},
            ]
        ],

    });
    //弹出框
    $("#form_dialog").dialog({
        width: 350,
        height: 400,
        buttons: "#form_dialog_bt",//按钮
        closed: true   //关闭状态
    });


});
//方法要放在$(function(){}外面 不然无法识别add方法

//因为user传过来的是一个对象无法在页面上显示所以用formatter
function userFormatter(value, record, index) {

    if (value) {
        return value.username;

    } else {
        return null;
    }

}

function add() {
    $("#form_dialog").dialog("open");
    $("#form_dialog").dialog("setTitle", "新增");
    $("#form_form").form("clear");

}

//添加
function save() {
    //获得页面的id判断是保存还是编辑
    var idVal = $("#form_form [name='id']").val();
    var url;
    if (idVal) {

        url = "/form_update";
    } else {
        url = "form_save";
    }

    //发送异步请求
    $("#form_form").form("submit", {
        url: url,
        success: function (data) {
            data = $.parseJSON(data);
            if (data.success) {
                $.messager.alert("温馨提示", data.msg, "info", function () {
                    //关闭对话框
                    $("#form_dialog").dialog("close");
                    //刷新页面
                    $("#form_datagrid").datagrid("load");
                });
            } else {
                $.messager.alert("温馨提示", data.msg, "info");
            }

        }

    })
}

//修改数据
function edit() {

    var rowData = $("#form_datagrid").datagrid("getSelected");
    if (rowData) {
        $("#form_dialog").dialog("open");
        $("#form_dialog").dialog("setTitle", "编辑");
        $("#form_form").form("clear");
        //特殊属性,,,对于一对多关系在这里会显出一也就是用户的姓名显示在编辑的框中
        if (rowData.user) {

            rowData["user.userid"] = rowData.user.userid;
        }
        $("#form_form").form("load", rowData);

    } else {
        $.messager.alert("温馨提示", "请选中一条数据", "info");
    }


}

//删除数据
function del() {
    //选中数据
    var rowData = $("#form_datagrid").datagrid("getSelected");
    if (rowData) {
        $.messager.confirm("温馨提示", "您确定删除这条数据吗", function (yes) {
            if (yes) {
                $.get("/form_delete?id=" + rowData.id, function (data) {
                    if (data.success) {
                        //刷新列表数据
                        $("#form_datagrid").datagrid("load");
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
    $("#form_datagrid").datagrid("load");

}

//关闭弹出框
function cancel() {
    $("#form_dialog").dialog("close");
}

function searchBtn() {
    var value = $("[name='keyword']").val();
    $("#form_datagrid").datagrid("load", {
        keyword: value
    });

}

