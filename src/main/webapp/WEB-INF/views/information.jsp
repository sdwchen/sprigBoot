<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>

    <%@include file="common.jsp" %>
    <script type="text/javascript" src="/js/views/information.js"></script>
</head>
<body>

<div id="information_dialog">
    <form id="information_form" method="post">
        <table align="center" style="margin-top:15px">
            <input type="hidden" name="id">
          
            <tr>
                <td>资讯标题</td>
                <td><input type="text" name="informationtitle"></td>
            </tr>
            <tr>
                <td>资讯内容</td>
                <td><input type="text" name="information"></td>
            </tr>

        </table>
    </form>
</div>
<table id="information_datagrid"></table>
<div id="information_datagrid_tb">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">新增</a>
        <a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="edit()">编辑</a>
        <a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del()">删除</a>
        <a class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload()">刷新</a>
    </div>
    <div>
        关键字查询:<input name="keyword"><a class="easyui-linkbutton" iconCls="icon-search" onclick="searchBtn()">搜索</a>

    </div>
</div>

<div id="information_dialog_bt">
    <a class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="save()">保存</a>
    <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="cancel()">取消</a>
</div>

</body>
</html>