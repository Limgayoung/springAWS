<%--
  Created by IntelliJ IDEA.
  User: lim
  Date: 2022-03-10
  Time: 오후 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <title>To Do List</title>
  </head>
  <body class="">
  <nav class="navbar navbar-expand-lg ">
    <div class="container navbar-header">

      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.jsp">To Do List</a>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="nav navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="login.jsp"><b>Login</b></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="join.jsp"><b>Join</b></a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <div class="container">
    <table class="table table-hover text-center">
      <thead>
      <tr>
        <td class = "task">task</td>
        <td>check</td>
        <td>edit</td>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>밥먹기</td>
        <td><input type="checkbox" name="check" value="false"></td>
        <td><button type="button">edit</button></td>
      </tr>
      </tbody>
    </table>
  </div>

  <div>
    <button class="new_task" type = "button">new task</button>
  </div>

  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
  <script>
    // location.href = 'login.jsp';

  </script>
  </body>
</html>
