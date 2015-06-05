<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:plantilla_usuario title="NatueAdventure - ${kind}">
<jsp:body>
	<div style="padding: 10px; float: left; width: 45%; text-align: justify;">
     	<h1>${activity.name }</h1>
        <p>Descripción: ${activity.description}</p>
    </div>
   
    <div style="padding: 10px; float: right; width: 45%; text-align: justify;">
          
          <form:form method="post" modelAttribute="booking">
          	<table class="formulario">
          		
				<form:hidden path="bookingId" value="0"/>
				<form:hidden path="activityId" value="${activity.id}"/>
				<form:hidden path="bookingDate" value="00-00-0000"/>
				<form:hidden path="status" value="false"/>
				<form:hidden path="instructor" value=" "/>
				
				<tr>
					<td><form:label path="activityDate">Fecha de realización</form:label></td>
					<td><form:input path="activityDate" class="form-control" /></td>
					<td><form:errors path="activityDate" /></td>
				</tr>
				<tr>
					<td><form:label path="clientIdCard">DNI</form:label></td>
					<td><form:input path="clientIdCard" class="form-control" /></td>
					<td><form:errors path="clientIdCard" /></td>
				</tr>
				<tr>
					<td><form:label path="hour">Hora de realización</form:label></td>
					<td><form:input path="hour" class="form-control" /></td>
					<td><form:errors path="hour" /></td>
				</tr>
				<tr>
					<td><form:label path="clientName">Nombre completo</form:label></td>
					<td><form:input path="clientName" class="form-control" /></td>
					<td><form:errors path="clientName" /></td>
				</tr>
				<tr>
					<td><form:label path="clientPhone">Telefono</form:label></td>
					<td><form:input path="clientPhone" class="form-control" /></td>
					<td><form:errors path="clientPhone" /></td>
				</tr>
				<tr>
					<td><form:label path="clientEmail">Email</form:label></td>
					<td><form:input path="clientEmail" class="form-control" /></td>
					<td><form:errors path="clientEmail" /></td>
				</tr>
				<tr>
					<td><form:label path="peopleNumber">Número de personas</form:label></td>
					<td><form:input path="peopleNumber" class="form-control" /></td>
					<td><form:errors path="peopleNumber" /></td>
				</tr>
				
          		<tr>
					<td colspan="2" align="center"> <input type="submit" value="Reservar" class="btn btn-default" /></td>
				</tr>
          	</table>
          </form:form>

    </div>
</jsp:body>
</t:plantilla_usuario>