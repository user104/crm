<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <h2 class="text-center">New Company</h2>
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <br>
            <a href="${pageContext.request.contextPath}/persons"><- back</a>
            <br>
            <!-- Add inputs-->
            <form method="post" action="${pageContext.request.contextPath}/save-contact">
                <label for="contact-name" class="control-label">Contact name</label>
                <br>
                <input id="contact-name" type="text" name="contactName" class="form-control" required
                       placeholder="input contact name">
                <br>
                <label for="position" class="control-label">Contact position</label>
                <br>
                <input id="position" type="text" name="position" class="form-control" required
                       placeholder="input position">
                <br>
                <label for="phoneNumber" class="control-label">Phone Number</label>
                <br>
                <input id="phoneNumber" type="text" name="phoneNumber" class="form-control" required
                       placeholder="input phone number">
                <br>
                <label for="email" class="control-label">Email</label>
                <br>
                <input id="email" type="text" name="email" class="form-control" required placeholder="input email">
                <br>
                <label for="company" class="control-label">Company</label>
                <br>
                <select id="company" name="company">
                    <c:forEach var="element" items="${companies}">
                        <option value="${element.id}">${element.companyName}</option>
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
