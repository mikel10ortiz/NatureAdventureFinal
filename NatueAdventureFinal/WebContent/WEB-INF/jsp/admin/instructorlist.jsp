<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:plantilla_admin title="Gestionar instructores - Lista de instructores">
<jsp:body>
	<h1 class="page-header">Listado de instructores 
	<a href="instructor/add.html" class="glyphicon glyphicon-plus" id="add">Añadir instructor</a>
	</h1>
          
	<div class="table-responsive">
	    <table class="table table-striped">
	    <thead>
        <tr>
            <th>Nombre</th>
            <th>Apellidos</th>
            <th>Tel&eacute;fono</th>
            <th>Email</th>
            <th colspan=2>Acci&oacute;n</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${instructors}" var="instructor">
            <tr>
                <td>${instructor.name}</td>
                <td>${instructor.lastName}</td>
                <td>${instructor.telephone}</td>
                <td>${instructor.email}</td>
                <td><a href="instructor/update/${instructor.idCard}.html"  class="glyphicon glyphicon-edit"></a>
                <td><a href="instructor/delete/${instructor.idCard}.html" class="glyphicon glyphicon-trash"></a>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
</jsp:body>
</t:plantilla_admin>