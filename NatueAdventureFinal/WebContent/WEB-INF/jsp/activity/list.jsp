<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Gestionar actividades</title>
</head>
<body>
    <h1>Lista de actividades</h1>
    <table>
        <tr>
            <th>NumFederat</th>
            <th>Nom</th>
            <th>Edat</th>
            <th>Sexe</th>
        </tr>
        <c:forEach items="${activities}" var="activity">
            <tr>
                <td>${activity.name}</td>
                <td><a href="update/${activity.name}.html">Edita</a>
                <td><a href="delete/${activity.name}.html">Esborra</a>
            </tr>
        </c:forEach>
    </table>
    <a href="add.html">Add activity</a>
</body>
</html>