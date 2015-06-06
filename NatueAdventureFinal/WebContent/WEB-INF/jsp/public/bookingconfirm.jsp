<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:plantilla_usuario title="NatueAdventure - ${kind}">
<jsp:body>
	<h1>Reserva realizada con éxito</h1>
	<p>
		La reserva se ha realizado con éxito. En unos instantes el sistema validará la información
		recibida y se le enviará un email con la confirmación de la misma.
	</p>
	<h2>
		Datos de la reserva
	</h2>
	<p>
		Actividad: ${activity.name} <br/>
		Fecha: <fmt:formatDate value="${booking.activityDate}" type="both" 
      pattern="dd-MM-yyyy" /> <br/>
		Num. Personas: ${booking.peopleNumber} <br/>
	</p>
	<p>
		Muchas gracias por su confianza. Esperamos verle pronto por aquí.
	</p>
</jsp:body>
</t:plantilla_usuario>