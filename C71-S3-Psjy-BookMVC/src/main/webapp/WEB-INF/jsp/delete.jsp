<%@page import="com.sjy.dao.DBHelper"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% 
String bookid = request.getParameter("bookid");
String sql = "delete from books where bookid = ?";
DBHelper.executeUpdate(sql, bookid);
response.sendRedirect("bookList.jsp");
%>