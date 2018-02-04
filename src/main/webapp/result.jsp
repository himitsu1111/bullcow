<%@ page import="java.util.List" %>
<%@ page import="my.bull.jdbc.POJO.Scores" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="my.bull.jdbc.POJO.BestScores" %>
<%--
  Created by IntelliJ IDEA.
  User: book
  Date: 02.02.2018
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>

<head>
  <title>Your results and statistics</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Just result</h1>

<h4 align="right"><a href="/game" class="widget-cat" charset="UTF-8">Play again</a></h4>
<br>
<br>
<br>
<div class="row">
  <div class="col-md-4">

    <h1>User    <span style="display:inline-block; width: 100pt;"></span> Score</h1>
    <%
      ArrayList<Scores> eList = (ArrayList<Scores>)session.getAttribute("allScores");
      if (eList != null) {
        for(Scores scores : eList)
        {
    %>
    <h1><%=scores.getUserid()%><span style="display:inline-block; width: 100pt;"></span> <%=scores.getTriesnumber()%></h1>
    <%}
    }%>


  </div>
  <div class="col-md-4">

    <h1>User    <span style="display:inline-block; width: 100pt;"></span>       Best Score</h1>
    <%
      ArrayList<BestScores> bestList = (ArrayList<BestScores>)session.getAttribute("bestScores");
      if (bestList != null) {
        for(BestScores scores : bestList)
        {
    %>
    <h1><%=scores.getUser()%>     <span style="display:inline-block; width: 100pt;"></span>      <%=scores.getScore()%></h1>
    <%}
    }%>

  </div>

</div>
</body>
</html>
