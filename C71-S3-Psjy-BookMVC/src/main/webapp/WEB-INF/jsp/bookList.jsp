<%@page import="com.sjy.dao.DBHelper"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>图书列表</title>
<style type="text/css">
*{
font-size:20px
}
</style>
</head>
<script>

function del(bookid){
	if(confirm("确认删除该图书？")){
		location.href='toDelete?bookid='+bookid;
	}
}

</script>
<body>
<h1>图书列表</h1>
	<form method="post" action="findByCondition.do">
	书名：<input name="bookname" value="${param.qbookname}"> 
	出版社：<input  name="bookpress" value="${param.qbookpress}"> 
	作者：<input name="bookauthor" value="${param.qsbookauthor}"> 
	<input type="submit" value="查询"> 
	<input type="submit" value="添加" formaction="toBookEdit" formmethod="get" >
	</form>


	<table border="1px"  width="1100px">
		<tr style="background:gray">
			<td>ID</td>
			<td>书名</td>
			<td>出版社</td>
			<td>出版时间</td>
			<td>作者</td>
			<td>数量</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${books}"  var="b">
			<tr>
				<td>${b.bookid}</td>
				<td><a href="toBookShow?bookid=${b.bookid}">${b.bookname}</a></td>
				<td>${b.bookpress}</td>
				<td>${b.pressdate}</td>
				<td>${b.bookauthor}</td>
				<td><img height="80px" width="70px" src="${b.bookimage}"></td>
				<td>${b.bookcount}</td>
				<td><input type="submit"  value="修改" onclick="location.href='toBookEdit?bookid=${b.bookid}'"> 
				<input type="submit" value="删除" onclick="del(${b.bookid})"></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>