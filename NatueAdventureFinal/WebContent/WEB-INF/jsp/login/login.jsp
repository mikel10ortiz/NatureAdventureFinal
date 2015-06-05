<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>NatureAdventure - login</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">

    <!-- Just for de  bugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="${pageContext.request.contextPath}/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <div class="container">

      <form class="form-signin" name="f" method="post" action="<%=request.getContextPath() %>/j_spring_security_check">
        <h2 class="form-signin-heading">Gesti&oacute;n <br> NatureAdventure</h2>
        <label for="inputUser" class="sr-only">User</label>
        <input type="user" id="j_username"  name="j_username" class="form-control" placeholder="Usuario" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="j_password" name="j_password" class="form-control" placeholder="Contrase&nacute;a" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me">Recu&eacute;rdame</label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" id = "boton" type="submit">Iniciar sesi&oacute;n</button>
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
