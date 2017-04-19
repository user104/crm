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
            <a href="${pageContext.request.contextPath}/companies"><- back</a>
            <br>
            <!-- Add inputs-->
            <form method="post" action="${pageContext.request.contextPath}/add">
                <label for="company-name" class="control-label">Company Name</label>
                <br>
                <input id="company-name" type="text" name="name" class="form-control" required
                       placeholder="input company name">
                <br>
                <label for="address" class="control-label">Address</label>
                <br>
                <input id="address" type="text" name="address" class="form-control" required
                       placeholder="input address">
                <br>
                <label for="website" class="control-label">Website</label>
                <br>
                <input id="website" type="text" name="website" class="form-control" required
                       placeholder="input website">
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

                <label for="contact-type" class="control-label">Contact Type</label>
                <br>
                <input id="contact-type" type="text" name="contactType" class="form-control" required
                       placeholder="input contact type">
                <br>
                <br>
                <input type="submit" class="btn btn-primary pull-right" value="Save">
            </form>

        </div>
    </div>
</div>
</body>
</html>
