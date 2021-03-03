<%--
  Created by IntelliJ IDEA.
  User: 27142
  Date: 2021/1/28
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .red {
            width: 100px;
            height: 100px;
            /* 背景颜色 */
            background-color: red;
        }
        .green {
            width: 100px;
            height: 100px;
            background-color: green;
        }
        .blue {
            width: 100px;
            height: 100px;
            background-color: blue;
        }
    </style>
</head>
<body>
<h1>${message}</h1>
<div class="red">红色</div>
<div class="blue">绿色</div>
<div class="green">蓝色</div>
</body>
</html>
