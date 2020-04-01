$(function () {

    //1抽取变量
    //2将所有方法统一管理
    $("#book_datagrid").datagrid({
        fit: true,
        url: '/book_list',
        fitColumns: true,
        rownumbers: true,
        pagination: true,
        toolbar: '#book_datagrid_tb',
        pageList: [1, 10, 20, 30, 40, 50],//分页信息
        singleSelect: true, //选中一条数据
        columns: [
            [
                {field: 'id', align: 'center', title: '订单id', width: 1, formatter: dingdanFormatter},
                {field: 'bookname', align: 'center', title: '书名', width: 1},
                {field: 'booktype', align: 'center', title: '书的类别', width: 1},
            ]
        ],

    });
    //弹出框
    $("#book_dialog").dialog({
        width: 300,
        height: 350,
        buttons: "#book_dialog_bt",//按钮
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
    $("#book_dialog").dialog("open");
    $("#book_dialog").dialog("setTitle", "新增");
    $("#book_form").form("clear");

}

//添加
function save() {
    //获得页面的id判断是保存还是编辑
    var idVal = $("#book_form [name='id']").val();
    var url;
    if (idVal) {

        url = "/book_update";
    } else {
        url = "book_save";
    }

    //发送异步请求
    $("#book_form").form("submit", {
        url: url,
        success: function (data) {
            data = $.parseJSON(data);
            if (data.success) {
                $.messager.alert("温馨提示", data.msg, "info", function () {
                    //关闭对话框
                    $("#book_dialog").dialog("close");
                    //刷新页面
                    $("#book_datagrid").datagrid("load");
                });
            } else {
                $.messager.alert("温馨提示", data.msg, "info");
            }

        }

    })
}

//修改数据
function edit() {

    var rowData = $("#book_datagrid").datagrid("getSelected");
    if (rowData) {
        $("#book_dialog").dialog("open");
        $("#book_dialog").dialog("setTitle", "编辑");
        $("#book_form").form("clear");
        //特殊属性,,,对于一对多关系在这里会显出一也就是用户的姓名显示在编辑的框中
        if (rowData.dingdan) {

            rowData["dingdan.bookid"] = rowData.dingdan.bookid;
        }
        $("#book_form").form("load", rowData);

    } else {
        $.messager.alert("温馨提示", "请选中一条数据", "info");
    }


}

//删除数据
function del() {
    //选中数据
    var rowData = $("#book_datagrid").datagrid("getSelected");
    if (rowData) {
        $.messager.confirm("温馨提示", "您确定删除这条数据吗", function (yes) {
            if (yes) {
                $.get("/book_delete?id=" + rowData.id, function (data) {
                    if (data.success) {
                        //刷新列表数据
                        $("#book_datagrid").datagrid("load");
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
    $("#book_datagrid").datagrid("load");

}

//关闭弹出框
function cancel() {
    $("#book_dialog").dialog("close");
}

function searchBtn() {
    var value = $("[name='keyword']").val();
    $("#book_datagrid").datagrid("load", {
        keyword: value
    });

}

