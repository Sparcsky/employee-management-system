<%--
  Created by IntelliJ IDEA.
  User: IanJasper
  Date: 8/13/2017
  Time: 08:54 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/navbar.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/personal-info.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/display-info.css">
</head>
<body>

<div class="main-container">

    <div class="nav-bar">
        <div class="nav-menu">
            <p id="top-title" class="nav-email">Employee Management System</p>

        </div>


        <div class="nav-email-container">
            <input class="nav-email" type="search" placeholder="ID number">
            <p class="nav-email">${email}</p>

        </div>
    </div>

    <form action="${pageContext.request.contextPath}/home" method="post">
        <div class="personal-info-container">


            <div>
                <p class="employee-info">EMPLOYEE INFORMATION</p>
            </div>
            <div class="personal-info">
                <input type="text" placeholder="first name" name="first-name">
                <input type="text" placeholder="last name" name="last-name">
                <input type="text" placeholder="M.I" name="M.I" maxlength="1">
            </div>
            <div class="personal-info">
                <input type="text" placeholder="address" name="address">
            </div>
            <div class="personal-info">
                <input type="tel" placeholder="phone number" name="phone-number">
                <input type="email" placeholder="email" name="email-address">
            </div>
            <div class="personal-info">
                <input placeholder="birth date" name="birth-date" class="date" type="text"
                       onfocus="(this.type='date')"
                       onblur="(this.type='text')">
                <input type="text" placeholder="birth place" name="birth-place">
            </div>
            <div class="personal-info">
                <label>
                    Gender
                    <select name="gender">
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                    </select>
                </label>
                <label>
                    Marital Status
                    <select name="marital-status">
                        <option value="single">Single</option>
                        <option value="married">Married</option>
                        <option value="divorced">Divorced</option>
                        <option value="widowed">Widowed</option>
                    </select>
                </label>
            </div>

            <div class="personal-info">
                <input type="submit" value="Submit" class="submit-employee">
            </div>

        </div>

        <div class="personal-info-display">

            <div class="wrapper">

                <div class="table">

                    <div class="row header green">
                        <div class="cell">ID</div>
                        <div class="cell">First name</div>
                        <div class="cell">Last name</div>
                        <div class="cell">M.I</div>
                        <div class="cell">Address</div>
                        <div class="cell">Phone number</div>
                        <div class="cell">Email</div>
                        <div class="cell">Birth date</div>
                        <div class="cell">Birth place</div>
                        <div class="cell">Gender</div>
                        <div class="cell">${phoneNumber}</div>
                    </div>
                    <c:forEach items="${employees}" var="employee">
                        <div class="row">
                            <div class="cell"> <c:out value="${employee.email}"/></div>
                            <div class="cell">${employee.password}</div>
                            <div class="cell">${email}</div>
                            <div class="cell">${birthDate}}</div>
                            <div class="cell">${birthPlace}</div>
                            <div class="cell">${gender}</div>
                            <div class="cell">${maritalStatus}</div>
                        </div>
                    </c:forEach>

                </div>

            </div>

            <%--

              <div class="table">

                                <div class="row header">
                                    <div class="cell">
                                        Name
                                    </div>
                                    <div class="cell">
                                        Age
                                    </div>
                                    <div class="cell">
                                        Occupation
                                    </div>
                                    <div class="cell">
                                        Location
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="cell">
                                        Luke Peters
                                    </div>
                                    <div class="cell">
                                        25
                                    </div>
                                    <div class="cell">
                                        Freelance Web Developer
                                    </div>
                                    <div class="cell">
                                        Brookline, MA
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="cell">
                                        Joseph Smith
                                    </div>
                                    <div class="cell">
                                        27
                                    </div>
                                    <div class="cell">
                                        Project Manager
                                    </div>
                                    <div class="cell">
                                        Somerville, MA
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="cell">
                                        Maxwell Johnson
                                    </div>
                                    <div class="cell">
                                        26
                                    </div>
                                    <div class="cell">
                                        UX Architect & Designer
                                    </div>
                                    <div class="cell">
                                        Arlington, MA
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="cell">
                                        Harry Harrison
                                    </div>
                                    <div class="cell">
                                        25
                                    </div>
                                    <div class="cell">
                                        Front-End Developer
                                    </div>
                                    <div class="cell">
                                        Boston, MA
                                    </div>
                                </div>

                            </div>
                            <div class="table">

                                <div class="row header blue">
                                    <div class="cell">
                                        Username
                                    </div>
                                    <div class="cell">
                                        Email
                                    </div>
                                    <div class="cell">
                                        Password
                                    </div>
                                    <div class="cell">
                                        Active
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="cell">
                                        ninjalug
                                    </div>
                                    <div class="cell">
                                        misterninja@hotmail.com
                                    </div>
                                    <div class="cell">
                                        ************
                                    </div>
                                    <div class="cell">
                                        Yes
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="cell">
                                        jsmith41
                                    </div>
                                    <div class="cell">
                                        joseph.smith@gmail.com
                                    </div>
                                    <div class="cell">
                                        ************
                                    </div>
                                    <div class="cell">
                                        No
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="cell">
                                        1337hax0r15
                                    </div>
                                    <div class="cell">
                                        hackerdude1000@aol.com
                                    </div>
                                    <div class="cell">
                                        ************
                                    </div>
                                    <div class="cell">
                                        Yes
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="cell">
                                        hairyharry19
                                    </div>
                                    <div class="cell">
                                        harryharry@gmail.com
                                    </div>
                                    <div class="cell">
                                        ************
                                    </div>
                                    <div class="cell">
                                        Yes
                                    </div>
                                </div>

                            </div>
            --%>

    </form>

</div>


<div class="crud">
    <input class="crud-image" type="image" src="image/add.png"/>
    <input class="crud-image" type="image" src="image/edit.png"/>
    <input class="crud-image" type="image" src="image/delete.png"/>
</div>

</body>
</html>
