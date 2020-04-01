$(function () {

    //1抽取变量
    //2将所有方法统一管理
    $("#dingdan_datagrid").datagrid({
        fit: true,
        url: '/dingdan_list',
        fitColumns: true,
        rownumbers: true,
        pagination: true,
        toolbar: '#dingdan_datagrid_tb',
        pageList: [1, 10, 20, 30, 40, 50],//分页信息
        singleSelect: true, //选中一条数据
        columns: [
            [
                {field: 'user', align: 'center', title: '用户名', width: 1, formatter: userFormatter},
                {field: 'bookname', align: 'center', title: '书名', width: 1, formatter: booknameFormatter},
                {field: 'booktype', align: 'center', title: '书的类别', width: 1, formatter: booktypeFormatter},
                {field: 'clothesname', align: 'center', title: '衣服', width: 1, formatter: clothesnameFormatter},
                {field: 'clothestype', align: 'center', title: '衣服类型', width: 1, formatter: clothestypeFormatter},
                {field: 'othersname', align: 'center', title: '其它', width: 1, formatter: othersnameFormatter},
                {field: 'otherstype', align: 'center', title: '其它类型', width: 1, formatter: otherstypeFormatter},
                {field: 'state', align: 'center', title: '状态', width: 1},
                {field: 'time', align: 'center', title: '提交时间', width: 1},

            ]
        ],

    });
    //弹出框
    $("#dingdan_dialog").dialog({
        width: 300,
        height: 350,
        buttons: "#dingdan_dialog_bt",//按钮
        closed: true   //关闭状态
    });


});
//方法要放在$(function(){}外面 不然无法识别add方法

//因为user传过来的是一个对象无法在页面上显示所以用formatter
//显示用户名
function userFormatter(value, record, index) {

    if (value) {
        return value.username;

    } else {
        return null;
    }

}

//显示书本的名称
function booknameFormatter(value, row, index) {

    if (row.book) {
        return row.book.bookname;

    } else {
        return null;
    }

}

//显示书本的类型
function booktypeFormatter(value, row, index) {

    if (row.book) {
        console.log(value);
        return row.book.booktype;

    } else {
        return null;
    }

}

//显示衣服的名称
function clothesnameFormatter(value, row, index) {

    if (row.clothes) {
        return row.clothes.clothesname;

    } else {
        return null;
    }

}

//显示衣服的类型
function clothestypeFormatter(value, row, index) {

    if (row.clothes) {

        return row.clothes.clothestype;

    } else {
        return null;
    }

}

//显示其它的名称
function othersnameFormatter(value, row, index) {

    if (row.others) {
        return row.others.othersname;

    } else {
        return null;
    }

}

//显示其它的类型
function otherstypeFormatter(value, row, index) {

    if (row.others) {
        console.log(value);
        return row.others.otherstype;

    } else {
        return null;
    }

}

function add() {
    $("#dingdan_dialog").dialog("open");
    $("#dingdan_dialog").dialog("setTitle", "新增");
    $("#dingdan_form").form("clear");

}

//添加
function save() {
    //获得页面的id判断是保存还是编辑
    var idVal = $("#dingdan_form [name='id']").val();
    var url;
    if (idVal) {

        url = "/dingdan_update";
    } else {
        url = "dingdan_save";
    }

    //发送异步请求
    $("#dingdan_form").form("submit", {
        url: url,
        success: function (data) {
            data = $.parseJSON(data);
            if (data.success) {
                $.messager.alert("温馨提示", data.msg, "info", function () {
                    //关闭对话框
                    $("#dingdan_dialog").dialog("close");
                    //刷新页面
                    $("#dingdan_datagrid").datagrid("load");
                });
            } else {
                $.messager.alert("温馨提示", data.msg, "info");
            }

        }

    })
}

//修改数据
function edit() {

    var rowData = $("#dingdan_datagrid").datagrid("getSelected");
    if (rowData) {
        $("#dingdan_dialog").dialog("open");
        $("#dingdan_dialog").dialog("setTitle", "编辑");
        $("#dingdan_form").form("clear");
        //特殊属性,,,对于一对多关系在这里会显出一也就是用户的姓名显示在编辑的框中
        if (rowData.user) {

            rowData["user.userid"] = rowData.user.userid;
        }
        $("#dingdan_form").form("load", rowData);

    } else {
        $.messager.alert("温馨提示", "请选中一条数据", "info");
    }


}

//删除数据
function del() {
    //选中数据
    var rowData = $("#dingdan_datagrid").datagrid("getSelected");
    if (rowData) {
        $.messager.confirm("温馨提示", "您确定删除这条数据吗", function (yes) {
            if (yes) {
                $.get("/dingdan_delete?id=" + rowData.id, function (data) {
                    if (data.success) {
                        //刷新列表数据
                        $("#dingdan_datagrid").datagrid("load");
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
    $("#dingdan_datagrid").datagrid("load");

}

//关闭弹出框
function cancel() {
    $("#dingdan_dialog").dialog("close");
}

function searchBtn() {
    var value = $("[name='keyword']").val();
    $("#dingdan_datagrid").datagrid("load", {
        keyword: value
    });

}

