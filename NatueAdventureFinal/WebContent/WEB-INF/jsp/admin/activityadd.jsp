<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:plantilla_admin title="Gestionar actividades - Nueva actividad">
<jsp:body>
	<h1 class="page-header">Nueva Actividad</h1>
	<form:form method="post" modelAttribute="activity">
		<table class="formulario">
			<tr>
				<td><form:label path="id">Id</form:label></td>
				<td><form:input path="id" class="form-control" /></td>
				<td><form:errors path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="name">Nombre</form:label></td>
				<td><form:input path="name" class="form-control" /></td>
				<td><form:errors path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="description">Descripción</form:label></td>
				<td><form:input path="description" class="form-control" /></td>
				<td><form:errors path="description" /></td>
			</tr>
			<tr>
				<td><form:label path="duration">Duración (minutos)</form:label></td>
				<td><form:input path="duration" class="form-control" /></td>
			</tr>
			<tr>
				<td><form:label path="kind">Tipo de actividad</form:label></td>
				<td><form:input path="kind" class="form-control" /></td>
				<td><form:errors path="kind" /></td>
			</tr>
			<tr>
				<td><form:label path="difficulty">Dificultad</form:label></td>
				<td><form:select path="difficulty" class="form-control" >
						<form:options items="${difficulties}" />
					</form:select>
				</td>
				<td><form:errors path="difficulty" /></td>
			</tr>
			<tr>
				<td><form:label path="minPersons">Min. personas</form:label></td>
				<td><form:input path="minPersons" class="form-control" /></td>
			</tr>
			<tr>
				<td><form:label path="enabled">Activada</form:label></td>
				<td><form:checkbox path="enabled" class="form-control" /></td>
			</tr>
			<tr>
				<td><form:label path="price">Precio</form:label></td>
				<td><form:input path="price" class="form-control" /></td>
			</tr>
			<tr>
				<td><form:label path="maxPersons">Max. personas</form:label></td>
				<td><form:input path="maxPersons" class="form-control" /></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"> <input type="submit" value="Alta de actividad" class="btn btn-default" /></td>
			</tr>
		</table>
	</form:form>
</jsp:body>
</t:plantilla_admin>