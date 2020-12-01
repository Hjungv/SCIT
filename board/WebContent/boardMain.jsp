<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="board" class="board.board" scope="request"/>
<%
	board.setName("운영자");
	board.setTitle("안녕하세요");
	board.setContent("반갑");

%>
<jsp:forward page="boardTest.jsp"/>
</body>
</html>