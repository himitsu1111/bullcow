<%--
  Created by IntelliJ IDEA.
  User: book
  Date: 01.02.2018
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Choose your ads</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="panel panel-primary">
  <div class="panel-heading">
    <%--<br>Search:<br>--%>
    <div class="row">
      <div class="col-xs-3">
        <%--<input type="text" class="form-control">--%>


      </div>
    </div>
  </div>
</div>


<ul class="nav nav-pills col-md-6 col-md-offset-3" role="tablist" style="margin-bottom: 50px ;">
  <li class="active"><a href="#home" role="tab" data-toggle="tab">Registration</a></li>
  <li><a href="#profile" role="tab" data-toggle="tab">Log in</a></li>
</ul>


<div class="tab-content">
  <div class="tab-pane fade in active" id="home">

    <form action="/register" class="form-horizontal col-md-6 col-md-offset-3" method="post">
      <div class="form-group">
        <label for="inputLogin">Email address</label>
        <input type="text" name="login" class="form-control" id="inputLogin" placeholder="Login">
      </div>
      <div class="form-group">
        <label for="inputPassword">Password</label>
        <input type="password" name="password" class="form-control" id="inputPassword" placeholder="Password">
      </div>
      <button type="submit" class="btn btn-default">Register</button>
    </form>

  </div>
  <div class="tab-pane fade" id="profile">

    <form action="/login" class="form-horizontal col-md-6 col-md-offset-3" method="post">
      <div class="form-group">
        <label for="exampleInputLogin2">Email address</label>
        <input type="login" name="loginL" class="form-control" id="exampleInputLogin2" placeholder="Login">
      </div>
      <div class="form-group">
        <label for="exampleInputPassword2">Password</label>
        <input type="password" name="passwordL" class="form-control" id="exampleInputPassword2" placeholder="Password">
      </div>
      <button type="submit" class="btn btn-default">Log in</button>
    </form>

  </div>
</div>

<%--<script>--%>
<%--$('#myTabs a').click(function (e) {--%>
<%--e.preventDefault()--%>
<%--$(this).tab('${show}')--%>

<%--})--%>
<%--</script>--%>

</body>
</html>
