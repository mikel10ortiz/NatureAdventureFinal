<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Gestionar actividades - Lista de actividades</title>
</head>
<body>
    <h1>Lista de actividades</h1>
    <table>
        <tr>
            <th>Nombre</th>
            <th>Descripcion</th>
        </tr>
        <c:forEach items="${activities}" var="activity">
            <tr>
                <td>${activity.name}</td>
                <td>${activity.description}</td>
                <td><a href="update/${activity.id}.html">Edita</a>
                <td><a href="delete/${activity.id}.html">Esborra</a>
            </tr>
        </c:forEach>
    </table>
    <a href="add.html">Add activity</a>
</body>
</html>