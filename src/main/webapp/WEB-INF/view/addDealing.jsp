<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <h2 class="text-center">New Deal</h2>
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <br>
            <a href="${pageContext.request.contextPath}/dealings"><- back</a>
            <br>
            <!-- Add inputs-->
            <form method="post" action="${pageContext.request.contextPath}/save-deal">
                <label for="deal-name" class="control-label">Deal Name</label>
                <br>
                <input id="deal-name" type="text" name="dealName" class="form-control" required
                       placeholder="input deal name">
                <br>
                <label for="deal-budget" class="control-label">Deal Budget</label>
                <br>
                <input id="deal-budget" type="text" name="dealBudget" class="form-control" required
                       placeholder="input budget">
                <br>
                <label for="deal-status" class="control-label">Deal Status</label>
                <br>
                <input id="deal-status" type="text" name="dealStatus" class="form-control" required
                       placeholder="input status">
                <br>
                <label for="deal-stage" class="control-label">Deal Stage</label>
                <br>
                <input id="deal-stage" type="text" name="dealStage" class="form-control" required
                       placeholder="input stage">
                <br>
                <label for="contact-person" class="control-label">Contact</label>
                <br>
                <select id="contact-person" name="contactPersonId">
                    <c:forEach var="element" items="${contactPersons}">
                        <option value="${element.id}">${element.companies.companyName} - ${element.conactName}</option>
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
