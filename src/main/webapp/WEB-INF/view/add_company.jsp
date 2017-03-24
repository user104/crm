<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <h2 class="text-center">New Company</h2>
    <div class="row">
        <div class="col-md-4 col-md-offset-4">

            <!-- Add inputs-->
            <form method="post" action="add_company.jsp">
                <label for="company-name" class="control-label">Company Name</label>
                <input id="company-name" type="text" name="name" class="form-control" required
                       placeholder="input company name">
                <br>
                <label for="address" class="control-label">Address</label>
                <br><input id="address" type="text" name="address" class="form-control" required
                           placeholder="input address">
                <br>
                <label for="phoneNumber" class="control-label">Phone Number</label>
                <br><input id="phoneNumber" type="text" name="phoneNumber" class="form-control" required
                           placeholder="input phone number">
                <br>
                <label for="email" class="control-label">Email</label>
                <br><input id="email" type="text" name="email" class="form-control" required placeholder="input email">
                <br>
                <br><input type="submit" class="btn btn-primary pull-right" value="Save">
            </form>

        </div>
    </div>
</div>
</body>
</html>
