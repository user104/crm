<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration</title>
    <link href="${pageContext.request.contextPath}/resources/CSS/bootstrap.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/CSS/registration.css" type="text/css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please sign up
                        <small>It's free!</small>
                    </h3>
                </div>
                <div class="panel-body">
                    <p class="text-center">
                        <%--@elvariable id="registrationError" type="java.lang.String"--%>
                        <c:if test="${registrationError!=null}">
                            <c:out value="${registrationError}"/>
                        </c:if>
                    </p>

                    <form:form method="post" action="/save-account" modelAttribute="user" role="form">
                        <div class="form-group">
                            <form:input path="username" id="first_name" class="form-control input-sm"
                                   placeholder="Username"/>
                        </div>

                        <div class="form-group">
                            <form:input type="email" path="email" id="email" class="form-control input-sm"
                                   placeholder="Email Address"/>
                        </div>

                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <form:input path="password" type="password" id="password" class="form-control input-sm"
                                           placeholder="Password"/>
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="password" name="password_confirmation" id="password_confirmation"
                                           class="form-control input-sm" placeholder="Confirm Password">
                                </div>
                            </div>
                        </div>
                        <input type="submit" value="Register" class="btn btn-info btn-block">
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
