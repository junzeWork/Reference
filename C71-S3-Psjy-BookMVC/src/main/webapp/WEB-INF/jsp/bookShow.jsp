<%@page import="java.util.*"%>
<%@page import="com.sjy.dao.DBHelper"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>图书信息</title>
<style type="text/css">
* {
	font-size: 28px
}
</style>
</head>
<body>
	<h1>图书信息</h1>
	<ul>
		<li><span>ID: </span>&nbsp;&nbsp;${book.bookid}</li>
		<li><span>书名: </span>&nbsp;&nbsp;${book.bookname}</li>
		<li><span>出版社: </span>&nbsp;&nbsp;${book.bookpress}</li>
		<li><span>出版时间: </span>&nbsp;&nbsp;${book.pressdate}</li>
		<li><span>作者: </span>&nbsp;&nbsp;${book.bookauthor}</li>
		<li><span>数量: </span>&nbsp;&nbsp;${book.bookcount}</li>
	</ul><br/>
	<button onclick="history.back()">返回</button>
</body>
</html>