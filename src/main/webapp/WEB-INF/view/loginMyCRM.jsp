<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
${(sessionScope.loggedIn)?pageContext.response.sendRedirect("companies"):null}
<html>
<head>
    <title>CRM</title>
    <link href="${pageContext.request.contextPath}/resources/CSS/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/CSS/login.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row">
        <p class="text-center">
            <%--@elvariable id="registration" type="java.lang.String"--%>
            <c:if test="${registration!=null}">
                <c:out value="${registration}"/>
            </c:if>
        </p>
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="account-wall">
                <div id="my-tab-content" class="tab-content">
                    <div class="tab-pane active" id="login">
                        <img class="profile-img" src="${pageContext.request.contextPath}/resources/images/avatar_2x.png"
                             alt="Hello">
                        <c:if test="${param.containsKey('error')}">
                            <p class="text-center">Неверный логин или пассворд</p>
                        </c:if>
                        <form class="form-signin" action="/login" method="post">
                            <input type="text" class="form-control" name="username" placeholder="Username" required
                                   autofocus>
                            <input type="password" class="form-control" name="password" placeholder="Password" required>
                            <label>
                                <input type="checkbox" name="rememberJava" checked>
                                Keep me signed in.
                            </label>
                            <input type="submit" class="btn btn-lg btn-default btn-block" value="Sign In"/>
                        </form>
                        <div id="tabs" data-tabs="tabs">
                            <p class="text-center"><a href="registration" data-toggle="tab">Need an Account?</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
