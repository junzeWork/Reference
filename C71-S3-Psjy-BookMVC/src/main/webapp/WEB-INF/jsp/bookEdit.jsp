<%@page import="com.sjy.dao.DBHelper"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>图书信息编辑</title>
<style type="text/css">
table {
	font-size: 20px;
}

</style>
</head>
<body>
	

	<h1>图书信息编辑</h1>
	
	<form method="post" action="doSave" enctype="multipart/form-data">
	<input type="hidden" name="bookid" value="${book.bookid }">
	<table>
		<tr>
			<td>书名：</td>
			<td><input name="bookname" value="${book.bookname }"></td>
		</tr>
		<tr>
			<td>出版社：</td>
			<td><input name="bookpress" value="${book.bookpress }"></td>
		</tr>
		<tr>
			<td>出版时间：</td>
			<td><input name="pressdate" value="${book.pressdate }" type="date"></td>
		</tr>
		<tr>
			<td>作者：</td>
			<td><input name="bookauthor" value="${book.bookauthor }"></td>
		</tr>
		<tr>
			<td>图片：</td>
			<td><img height="80px" width="70px" src="${book.bookimage}"></td>
			<td><input type="file" name="image" value="${book.bookimage }"></td>
		</tr>
		<tr>
			<td>数量：</td>
			<td><input name="bookcount" value="${book.bookcount }" type="number"></td>
		</tr>
		</table>
		<input class="btn_input" type="button" value="取消" onclick="history.back()">
		<input class="btn_input" type="submit" value="保存" >
	</form>


</body>
</html>