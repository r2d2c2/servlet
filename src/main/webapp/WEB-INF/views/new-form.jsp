<%--
  Created by IntelliJ IDEA.
  User: cjftn
  Date: 2024-01-23
  Time: 오후 2:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 상대 경로를 사용하여 주소 가 짧다
new-form 에서 save로 변경--%>
<form action="save" method="post">
    username: <input type="text" name="username"/>
    age:      <input type="text" name="age"/>
    <button type="submit">전송</button>
</form>
</body>
</html>
