<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:plantilla_admin title="Gestionar actividades - Lista de actividades">
<jsp:body>
	<h1 class="page-header">Lista de actividades
	<a href="activity/add.html" class="glyphicon glyphicon-plus" id="add">Añadir actividad</a>
    </h1>
          <div class="clear"></div>
          
	<div class="table-responsive">
	    <table class="table table-striped">
	    	<thead>
		        <tr>
		            <th>Nombre</th>
		            <th>Descripcion</th>
		            <th colspan=2>Acci&oacute;n</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${activities}" var="activity">
		            <tr>
		                <td>${activity.name}</td>
		                <td>${activity.description}</td>
		                <td><a href="activity/update/${activity.id}.html" class="glyphicon glyphicon-edit"></a></td></td>
                  		<td><a href="activity/delete/${activity.id}.html" class="glyphicon glyphicon-trash"></a></td>
		            </tr>
		        </c:forEach>
		    </tbody>
	    </table>
	</div>
</jsp:body>
</t:plantilla_admin>
