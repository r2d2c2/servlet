<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberRepository memberRepository=MemberRepository.getInstance();
    //request, response 바로 사용가능
    String username = request.getParameter("username");
    int age =Integer.parseInt(request.getParameter("age"));
    //html로 받은 값을
    Member member=new Member(username,age);
    memberRepository.save(member);
    //저장하고
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
