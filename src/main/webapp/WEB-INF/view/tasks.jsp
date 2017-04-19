<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <title>CRM</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/resources/CSS/bootstrap.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/CSS/main.css" type="text/css" rel="stylesheet">

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
            <table class="table">
                <thead>
                <tr>
                    <th>Название</th>
                    <th>Компания</th>
                    <th>Контактное лицо</th>
                    <th>Срок исполнения</th>
                    <th>Статус</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="element" items="${tasks}">
                    <tr>
                        <td>${element.taskName}</td>
                        <td>${element.dealings.contactPerson.companies.companyName}</td>
                        <td>${element.dealings.contactPerson.conactName}</td>
                        <td>${element.deadline}</td>
                        <td>${element.taskStatus}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
