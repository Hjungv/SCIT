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
		out.print("작성자 : " + board.getName() + "<br>");
	out.print("제목 : " + board.getTitle() + "<br>");
	out.print("내용 : " + board.getContent() + "<br>");
	%>
</body>
</html>