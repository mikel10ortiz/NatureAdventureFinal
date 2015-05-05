<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestión de instructores - Listado de instructores</title>
</head>
<body>
	<h2>Listado de instructores</h2>
	<table>
        <tr>
            <th>Nombre</th>
            <th>Descripcion</th>
        </tr>
        <c:forEach items="${instructors}" var="instructor">
            <tr>
                <td>${instructor.name}</td>
                <td>${instructor.lastName}</td>
                <td><a href="update/${instructor.idCard}.html">Edita</a>
                <td><a href="delete/${instructor.idCard}.html">Esborra</a>
            </tr>
        </c:forEach>
    </table>
    <a href="add.html">Add instructor</a>
</body>
</html>