<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <h2 class="text-center">New Task</h2>
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <br>
            <a href="${pageContext.request.contextPath}/tasks"><- back</a>
            <br>
            <!-- Add inputs-->
            <form method="post" action="${pageContext.request.contextPath}/save-task">
                <label for="task-name" class="control-label">Task Name</label>
                <br>
                <input id="task-name" type="text" name="taskName" class="form-control" required
                       placeholder="input task name">
                <br>
                <label for="deadline" class="control-label">Deadline</label>
                <br>
                <input id="deadline" type="text" name="deadline" class="form-control" required
                       placeholder="input deadline">
                <br>
                <label for="task-status" class="control-label">Task Status</label>
                <br>
                <input id="task-status" type="text" name="taskStatus" class="form-control" required
                       placeholder="input status">
                <br>
                <br>

                <label for="dealing" class="control-label">Contact Type</label>
                <br>
                <select id="dealing" name="DealId">
                    <c:forEach var="element" items="${dealings}">
                        <option value="${element.id}">${element.contactPerson.companies.companyName} - ${element.contactPerson.conactName} - ${element.dealName}</option>
                    </c:forEach>
                </select>
                <br>
                <input type="submit" class="btn btn-primary pull-right" value="Save">
            </form>

        </div>
    </div>
</div>
</body>
</html>
