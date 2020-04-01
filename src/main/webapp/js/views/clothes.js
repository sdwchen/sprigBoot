$(function () {

    //1抽取变量
    //2将所有方法统一管理
    $("#clothes_datagrid").datagrid({
        fit: true,
        url: '/clothes_list',
        fitColumns: true,
        rownumbers: true,
        pagination: true,
        toolbar: '#clothes_datagrid_tb',
        pageList: [1, 10, 20, 30, 40, 50],//分页信息
        singleSelect: true, //选中一条数据
        columns: [
            [
                {field: 'id', align: 'center', title: '订单id', width: 1, formatter: dingdanFormatter},
                {field: 'clothesname', align: 'center', title: '书名', width: 1},
                {field: 'clothestype', align: 'center', title: '书的类别', width: 1},
            ]
        ],

    });
    //弹出框
    $("#clothes_dialog").dialog({
        width: 300,
        height: 350,
        buttons: "#clothes_dialog_bt",//按钮
        closed: true   //关闭状态
    });


});
//方法要放在$(function(){}外面 不然无法识别add方法

//因为user传过来的是一个对象无法在页面上显示所以用formatter
function dingdanFormatter(value, row, index) {

    if (row.dingdan) {
        return row.dingdan.id;

    } else {
        return null;
    }

}

function add() {
    $("#clothes_dialog").dialog("open");
    $("#clothes_dialog").dialog("setTitle", "新增");
    $("#clothes_form").form("clear");

}

//添加
function save() {
    //获得页面的id判断是保存还是编辑
    var idVal = $("#clothes_form [name='id']").val();
    var url;
    if (idVal) {

        url = "/clothes_update";
    } else {
        url = "clothes_save";
    }

    //发送异步请求
    $("#clothes_form").form("submit", {
        url: url,
        success: function (data) {
            data = $.parseJSON(data);
            if (data.success) {
                $.messager.alert("温馨提示", data.msg, "info", function () {
                    //关闭对话框
                    $("#clothes_dialog").dialog("close");
                    //刷新页面
                    $("#clothes_datagrid").datagrid("load");
                });
            } else {
                $.messager.alert("温馨提示", data.msg, "info");
            }

        }

    })
}

//修改数据
function edit() {

    var rowData = $("#clothes_datagrid").datagrid("getSelected");
    if (rowData) {
        $("#clothes_dialog").dialog("open");
        $("#clothes_dialog").dialog("setTitle", "编辑");
        $("#clothes_form").form("clear");
        //特殊属性,,,对于一对多关系在这里会显出一也就是用户的姓名显示在编辑的框中
        if (rowData.dingdan) {

            rowData["dingdan.clothesid"] = rowData.dingdan.clothesid;
        }
        $("#clothes_form").form("load", rowData);

    } else {
        $.messager.alert("温馨提示", "请选中一条数据", "info");
    }


}

//删除数据
function del() {
    //选中数据
    var rowData = $("#clothes_datagrid").datagrid("getSelected");
    if (rowData) {
        $.messager.confirm("温馨提示", "您确定删除这条数据吗", function (yes) {
            if (yes) {
                $.get("/clothes_delete?id=" + rowData.id, function (data) {
                    if (data.success) {
                        //刷新列表数据
                        $("#clothes_datagrid").datagrid("load");
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
    $("#clothes_datagrid").datagrid("load");

}

//关闭弹出框
function cancel() {
    $("#clothes_dialog").dialog("close");
}

function searchBtn() {
    var value = $("[name='keyword']").val();
    $("#clothes_datagrid").datagrid("load", {
        keyword: value
    });

}

