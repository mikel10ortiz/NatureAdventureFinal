<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:plantilla_admin title="Gestionar instructores - Nuevo instructor">
<jsp:body>
	<h1 class="page-header">Nuevo Instructor</h1>
	<form:form method="post" modelAttribute="instructor">
		<table class="formulario">
			<tr>
				<td><form:label path="name">Nombre</form:label></td>
				<td><form:input path="name" class="form-control" /></td>
				<td><form:errors path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Apellidos</form:label></td>
				<td><form:input path="lastName" class="form-control" /></td>
				<td><form:errors path="lastName" /></td>
			</tr>
			<tr>
				<td><form:label path="address">Dirección</form:label></td>
				<td><form:input path="address" class="form-control" /></td>
			</tr>
			<tr>
				<td><form:label path="telephone">Telefono</form:label></td>
				<td><form:input path="telephone" class="form-control" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" class="form-control" /></td>
				<td><form:errors path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="idCard">NIF</form:label></td>
				<td><form:input path="idCard" class="form-control" /></td>
				<td><form:errors path="idCard" /></td>
			</tr>
			<tr>
				<td><form:label path="dateOfBirth">Fecha de nacimiento</form:label></td>
				<td><form:input path="dateOfBirth" class="form-control" /></td>
			</tr>
			<tr>
				<td><form:label path="inittialHour">Hora de inicio de jornada</form:label></td>
				<td><form:input path="inittialHour" class="form-control" /></td>
			</tr>
			<tr>
				<td><form:label path="finalHour">Hora de fin de jornada</form:label></td>
				<td><form:input path="finalHour" class="form-control" /></td>
			</tr>
			<tr>
				<td><form:label path="entryDate">Fecha de alta</form:label></td>
				<td><form:input path="entryDate" class="form-control" /></td>
			</tr>
			<tr>
				<td><form:label path="username">Nombre de usuario</form:label></td>
				<td><form:input path="username" class="form-control" /></td>
				<td><form:errors path="username" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Contraseña</form:label></td>
				<td><form:input path="password" class="form-control" /></td>
				<td><form:errors path="password" /></td>
			</tr>
			
			<tr>
				<td colspan="2"> <input type="submit" value="Alta de instructor" /></td>
			</tr>
		</table>
	</form:form>
</jsp:body>
</t:plantilla_admin>