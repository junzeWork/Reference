<%@page import="com.sjy.dao.DBHelper"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");

	String bookid = request.getParameter("bookid");
	String bookname = request.getParameter("bookname");
	String bookpress= request.getParameter("bookpress");
	String pressdate = request.getParameter("pressdate");
	String bookauthor = request.getParameter("bookauthor");
	String bookcount = request.getParameter("bookcount");

	if(bookid==null || bookid.trim().isEmpty()){
		String sql = "insert into books values(null,?,?,?,?,?) ";
		DBHelper.executeUpdate(sql,bookname,bookpress,pressdate,bookauthor,bookcount);
	}else{
		String sql ="update books set bookname=?,bookpress=?,pressdate=?,bookauthor=?,bookcount=? where bookid=?";
		DBHelper.executeUpdate(sql, bookname,bookpress,pressdate,bookauthor,bookcount,bookid);
	}

	response.sendRedirect("bookList.jsp");
%>