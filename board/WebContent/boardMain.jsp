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
	board.setName("���");
	board.setTitle("�ȳ��ϼ���");
	board.setContent("�ݰ�");

%>
<jsp:forward page="boardTest.jsp"/>
</body>
</html>