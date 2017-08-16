<%--
  Created by IntelliJ IDEA.
  User: IanJasper
  Date: 8/2/2017
  Time: 06:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="refresh" content="100">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/signup.css">

    <title>Employee Management System</title>
</head>
<body>

<div class="login-container">
    <h1 class="title">EMPLOYEE MANAGEMENT<br/>System</h1>

    <div class="login-bar" id="login-bar">

        <form action="${pageContext.request.contextPath}/login" method="post">

            <label class="login-label">Email</label>
            <input id="login-email" type="email" placeholder="Enter Email" name="email-login" required>

            <label class="login-label">Password</label>
            <input id="login-password" type="password" placeholder="Enter Password" name="password-login"
                   required>

            <div class="sign-up-button">
                <input id="button-login-register" type="button" value="Register">
                <input id="button-login" type="submit" value="Log in">
            </div>

        </form>

    </div>
</div>

<div class="sign-up" id="sign-up">
    <form action="${pageContext.request.contextPath}/signup" method="post" onsubmit="return validate()" name=signUp>


        <label class="sign-up-label">Email</label>
        <input class="sign-up-textBox" id="email_address" type="email" placeholder="Enter Email" name="email_address"
               required>

        <label class="sign-up-label">Password</label>
        <input class="sign-up-textBox" id="psw" type="password" placeholder="Enter Password" name="psw" required>

        <label class="sign-up-label">Repeat Password</label>
        <input class="sign-up-textBox" id="psw-repeat" type="password" placeholder="Repeat Password" name="psw-repeat"
               required>

        <div class="sign-up-button">
            <input id="button-close" type="button" value="Close" name="close">
            <input id="button-register" type="submit" value="Sign Up" name="register">
        </div>
    </form>


</div>

<script src="${pageContext.request.contextPath}/script/Modal.js"></script>
<% response.getWriter().flush(); %>
</body>
</html>
