<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:plantilla_admin title="Gestionar reservas - Lista de reservas">
<jsp:body>
	<h1 class="page-header">Lista de reservas </h1>
          
	<div class="table-responsive">
	    <table class="table table-striped">
	    <thead>
        <tr>
            <th>Actividad</th>
            <th>Nombre cliente</th>
            <th>Fecha de realizaci&oacute;n</th>
            <th>Acci&oacute;n</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${bookings}" var="booking">
            <tr>
                <td>${booking.activityName}</td>
                <td>${booking.clientName}</td>
                <td><fmt:formatDate value="${booking.activityDate}" type="both" 
      pattern="dd-MM-yyyy" /></td>
                <!-- <td><a href="update/${booking.bookingId}.html">Edita</a>
                -->
                <td><a href="booking/delete/${booking.bookingId}.html" class="glyphicon glyphicon-trash"></a>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</jsp:body>
</t:plantilla_admin>