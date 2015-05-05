<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestionar actividades - Modificar actividad</title>
</head>
<body>
	<h2> Modificar actividad </h2>
	<form:form method="post" modelAttribute="activity">
		<table>
			<tr>
				<td><form:label path="id">Id</form:label></td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="name">Nombre</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="description">Descripción</form:label></td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
				<td><form:label path="duration">Duración</form:label></td>
				<td><form:input path="duration" /></td>
			</tr>
			<tr>
				<td><form:label path="kind">Tipo de actividad</form:label></td>
				<td><form:input path="kind" /></td>
			</tr>
			<tr>
				<td><form:label path="difficulty">Dificultad</form:label></td>
				<td><form:input path="difficulty" /></td>
			</tr>
			<tr>
				<td><form:label path="minPersons">Min. personas</form:label></td>
				<td><form:input path="minPersons" /></td>
			</tr>
			<tr>
				<td><form:label path="enabled">Activada</form:label></td>
				<td><form:input path="enabled" /></td>
			</tr>
			<tr>
				<td><form:label path="price">Precio</form:label></td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
				<td><form:label path="maxPersons">Max. personas</form:label></td>
				<td><form:input path="maxPersons" /></td>
			</tr>
			
			<tr>
				<td colspan="2"> <input type="submit" value="Guardar actividad" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>