<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <title>CRM</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/resources/CSS/bootstrap.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/CSS/main.css" type="text/css" rel="stylesheet"/>

</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2 sidebar">
            <ul class="nav">
                <li>
                    <a title="Компании" href="companies">
                        <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                        <span class="menu-text">Компании</span>
                    </a>
                </li>
                <li>
                    <a title="Контактные лица" href="persons">
                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        <span class="menu-text">Контактные лица</span>
                    </a>
                </li>
                <li>
                    <a title="Сделки" href="dealings">
                        <span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>
                        <span class="menu-text">Сделки</span>
                    </a>
                </li>
                <li>
                    <a title="Задачи" href="tasks">
                        <span class="glyphicon glyphicon-check" aria-hidden="true"></span>
                        <span class="menu-text">Задачи</span>
                    </a>
                </li>
                <li>
                    <a title="Sign Out" href="logout">
                        <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
                        <span class="menu-text">Выйти</span>
                    </a>
                </li>
            </ul>
        </div>
        <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">

            <br>
            <a class="btn btn-sm btn-primary btn-create" href="${pageContext.request.contextPath}/add-contact" role="button">New contact</a>
            <br>

            <table class="table">
                <thead>
                <tr>
                    <th>ФИО</th>
                    <th>Компания</th>
                    <th>Должность</th>
                    <th>Телефон</th>
                    <th>Электронная почта</th>
                    <th>Тип контакта</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="element" items="${persons}">
                    <tr>
                        <td>${element.conactName}</td>
                        <td>${element.companies.companyName}</td>
                        <td>${element.conactPosition}</td>
                        <td>${element.conactPhoneNumber}</td>
                        <td>${element.conactEmail}</td>
                        <td>${element.companies.contactType}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
