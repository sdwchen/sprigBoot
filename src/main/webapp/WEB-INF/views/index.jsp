<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="common.jsp" %>
    <script type="text/javascript" src="/js/views/index.js"></script>
</head>
<body>
<div id="cc" class="easyui-layout" fit="true" style="width:600px;height:400px;">
    <div data-options="region:'north'"
         style="height:80px;background: url('/image/bottom.jpg') no-repeat;background-size:cover;">
        <div id="top">
            <h2>公交查询后台管理系统</h2>
            <div style="float: right;width: 200px;">
                <font style="font-size: 12px;color: #FAFAFA;margin-right: 1px">当前用户:${username}</font>
                <a href="/login.jsp" class="btn-logout">安全退出</a>
            </div>
        </div>
    </div>
    <div data-options="region:'west'" style="width:180px;">
        <!-- 手风琴+菜单 -->
        <div class="easyui-accordion" fit="true">
            <div title="菜单">
                <!-- 使用树组件来定义菜单 -->
                <ul id="menuTree"></ul>
            </div>
            <div title="帮助"></div>
            <div title="简介"></div>
        </div>
    </div>
    <div data-options="region:'center'" style="padding:5px;background:#eee;">
        <!-- 正文内容 -->
        <div id="myTabs" class="easyui-tabs" fit="true">
            <div title="欢迎页" closable="true">
                <h1>欢迎登陆系统</h1>
            </div>
        </div>
    </div>
    <div data-options="region:'south'"
         style="height:20px;  background: url('/image/bottom.jpg') no-repeat; background-size: cover">

    </div>
</div>
</body>
</html>
