<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Зарегаться</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>

</head>
<body>
<form action="register" method="post">
    <label for="firstName">Фамилия:</label>
    <input type="text" id="firstName" name="firstName"><br><br>

    <label for="lastName">Имя:</label>
    <input type="text" id="lastName" name="lastName"><br><br>

    <label for="password">Пароль:</label>
    <input type="password" id="password" name="password"><br><br>

    <input type="submit" value="register">
</form>
</body>
</html>
