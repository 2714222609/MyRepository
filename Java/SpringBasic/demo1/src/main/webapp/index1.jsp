<%--
  Created by IntelliJ IDEA.
  User: 27142
  Date: 2021/2/8
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <form action="/upload" method="post" enctype="multipart/form-data">
        姓名：<input type="text" name="uname">
        文件：<input type="file" name="myfile">
        <button>上传</button>
    </form>
</body>
</html>
