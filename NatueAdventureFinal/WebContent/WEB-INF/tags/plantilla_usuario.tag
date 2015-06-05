<%@ tag description="Estructura de la pagina del manager"
    pageEncoding="UTF-8"%>
<%@ attribute name="title" required="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${title}</title>
<!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="${pageContext.request.contextPath}/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
	<link href="${pageContext.request.contextPath}/css/estilos.css" rel="stylesheet">
</head>
<body>
	<header>
		<div class="container">
    		<img id="logotipo" src="${pageContext.request.contextPath}/images/logotipo.png" alt="Logo natureAdventure" class="img-rounded">
  		</div>
	</header>
		<t:menu-usuario/>
	<article>
		<div class="container">
			<jsp:doBody/>
		</div>
 	</article>

<footer class="footer">
    <div class="container">
       <p class="text-muted">Nature Adventure, tu especialista en actividades.</p>
	</div>
</footer>
</body>
</html>
