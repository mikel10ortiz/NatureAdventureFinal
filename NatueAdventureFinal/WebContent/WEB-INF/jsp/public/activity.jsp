<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:plantilla_usuario title="NatueAdventure - ${kind}">
<jsp:body>
<div style="padding: 10px; float: left; width: 45%; text-align: justify;">
      <img style="margin: 0px; float: left;" src="${pageContext.request.contextPath}/images/senderismo.jpg" alt="Trucos"/>
    </div>
    <div style="padding: 10px; float: right; width: 45%; text-align: justify;">
          
          <h1>${activity.name }</h1>
          <p>Descripción: ${activity.description}</p>
          <p>Dificultad: ${activity.difficulty}</p>
          <p>Duración: ${activity.duration}</p>
          <p>Num. personas ${activity.minPersons} - ${activity.maxPersons}</p>
          <p>PVP por persona ${activity.price}</p>
          <p><a class="btn btn-default" href="${pageContext.request.contextPath}/public/booking/${activity.id}.html" role="button">Reserva ya &raquo;</a></p>

    </div>
</jsp:body>
</t:plantilla_usuario>