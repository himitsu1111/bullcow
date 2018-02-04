<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: book
  Date: 02.02.2018
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
  <title>The Game</title>
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

      </div>
    </div>
  </div>
</div>
<h1>The great game!</h1>
<h2>Загадано число из 4х неповторяющихся цифр, вам нужно его угадать</h2>
<br>
<details outline:none>
  <summary><span>Показать ответ</span></summary>
  <span>Секретное число это  <%=session.getAttribute("secretNum")%></span>
</details>
<br>

<form class="form-inline" action="/game" method="post">
  <div class="col-md-8">
    <div class="row">
      <div class="col-md-1">
        <select class="form-control" name="sellOne" id="sell1">

          <option>1</option>
          <option>2</option>
          <option>3</option>
          <option>4</option>
          <option>5</option>
          <option>6</option>
          <option>7</option>
          <option>8</option>
          <option>9</option>
        </select>

      </div>
      <div class="col-md-1"><select class="form-control" name="sellTwo" id="sell2">

        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
        <option>6</option>
        <option>7</option>
        <option>8</option>
        <option>9</option>
      </select>
      </div>
      <div class="col-md-1"><select class="form-control" name="sellThree" id="sell3">

        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
        <option>6</option>
        <option>7</option>
        <option>8</option>
        <option>9</option>
      </select>
      </div>
      <div class="col-md-1"><select class="form-control" name="sellFour" id="sell4">
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
        <option>6</option>
        <option>7</option>
        <option>8</option>
        <option>9</option>
      </select>
      </div>
    </div>
  </div>
  <button type="sumbit" class="btn btn-default">Угадать</button>
</form>
<br>
<%
  Integer bulls = (Integer)request.getAttribute("bulls");
  if (bulls != null) {

  for(int i = 0; i < bulls; i++)
  {
%>
    <img src="https://image.ibb.co/b778Om/bull100.jpg" alt="..." class="img-thumbnail">
<%}
  }%>
<br>

<br>
<%
  Integer cows = (Integer)request.getAttribute("cows");
  if (cows != null) {

  for(int i = 0; i < cows; i++)
  {
%>
<img src="https://image.ibb.co/bE4oOm/cow100.jpg" alt="..." class="img-thumbnail">
<%}
}%>
<h1> Попытка № <%=session.getAttribute("tryCount")%></h1>

<form class="form-inline" action="/result" method="get">
  <div class="form-group">
    <%--<label for="exampleInputName2">Search</label>--%>
      <button type="sumbit" class="btn btn-default">Завершить игру</button>
  </div>
</form>
</body>
</html>
