<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="board" class="board.board" scope="request" />
	<%
		out.print("�ۼ��� : " + board.getName() + "<br>");
	out.print("���� : " + board.getTitle() + "<br>");
	out.print("���� : " + board.getContent() + "<br>");
	%>
</body>
</html>