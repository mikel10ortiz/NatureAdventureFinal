<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestionar instructores - Modificar Instructor</title>
</head>
<body>
	<h2> Modificar instructor </h2>
	<form:form method="post" modelAttribute="instructor">
		<table>
			<tr>
				<td><form:label path="name">Nombre</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Apellidos</form:label></td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td><form:label path="address">Dirección</form:label></td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td><form:label path="telephone">Telefono</form:label></td>
				<td><form:input path="telephone" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="idCard">NIF</form:label></td>
				<td><form:input path="idCard" /></td>
			</tr>
			<tr>
				<td><form:label path="dateOfBirth">Fecha de nacimiento</form:label></td>
				<td><form:input path="dateOfBirth" /></td>
			</tr>
			<tr>
				<td><form:label path="inittialHour">Hora de inicio de jornada</form:label></td>
				<td><form:input path="inittialHour" /></td>
			</tr>
			<tr>
				<td><form:label path="finalHour">Hora de fin de jornada</form:label></td>
				<td><form:input path="finalHour" /></td>
			</tr>
			<tr>
				<td><form:label path="entryDate">Fecha de alta</form:label></td>
				<td><form:input path="entryDate" /></td>
			</tr>
			<tr>
				<td><form:label path="username">Nombre de usuario</form:label></td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Contraseña</form:label></td>
				<td><form:input path="password" /></td>
			</tr>
			
			<tr>
				<td colspan="2"> <input type="submit" value="Guardar instructor" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>