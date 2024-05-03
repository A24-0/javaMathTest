<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.concurrent.ThreadLocalRandom" %>
<%@ page import="mathtest.Question" %>
<%@ page import="mathtest.DatabaseConnection" %>

<html>
<title>Математика</title>
<style><%@include file="/WEB-INF/css/style.css"%></style>
<body>
<%
    Question q = new Question();
    DatabaseConnection store = new DatabaseConnection();
    store.save(q);
%>
<h2>Решить:</h2>
<form action='Check' method='post'>
<input type='hidden' name='questionId' value='<%=q.getId()%>'>
    <label for="answer"> <%=q.getContent()%> ? </label>
    <input type="number" name="answer" id="answer"><br><br>
    <input type='submit' value='check'>
</form>
</body>
</html>
