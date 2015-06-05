<%@ tag description="Estructura de la pagina de staff"
    pageEncoding="UTF-8"%>
<%@ attribute name="title" required="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>${title}</title>
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="${pageContext.request.contextPath}/css/sticky-footer-navbar.css" rel="stylesheet">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="shortcut icon" href="./img/favicon.ico">
	<link rel="stylesheet" type="text/css" media="screen" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	<link href="${pageContext.request.contextPath}/css/prettify-1.0.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet">
	<link href="http://cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/d004434a5ff76e7b97c8b07c01f34ca69e635d97/build/css/bootstrap-datetimepicker.css" rel="stylesheet">
	<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment-with-locales.js"></script>
	<script src="http://cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/d004434a5ff76e7b97c8b07c01f34ca69e635d97/src/js/bootstrap-datetimepicker.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/calendar.min.js"></script>
	<link href='http://fonts.googleapis.com/css?family=Ubuntu:300,400,500,700' rel='stylesheet' type='text/css'>
	<link href="${pageContext.request.contextPath}/css/calendar.min.css" rel="stylesheet">
</head>
<body>
	<header> 
		<div id="loginfo">
			<t:loginfo/>
		</div>
	</header>
	<div id="contenedor_central">
		<jsp:doBody/>
	</div>
	<footer>
		By NatureAdventure
	</footer>
</body>
</html>