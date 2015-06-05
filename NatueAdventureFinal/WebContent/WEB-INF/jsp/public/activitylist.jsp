<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:plantilla_usuario title="NatueAdventure - ${kind}">
<jsp:body>
<div class="row">
	<c:forEach items="${activities}" var="activity">
        <div class="col-md-4">
          <a href="${pageContext.request.contextPath}/public/activity/${activity.id}.html"><img id="foto" src="${pageContext.request.contextPath}/images/senderismo.jpg" alt="nombre actividad"></a>
          <p><a href="/public/${activity.id}.html">${activity.name}</a> </p>
          <p><a class="btn btn-default" href="${pageContext.request.contextPath}/public/activity/${activity.id}.html" role="button">M&aacutes informaci&oacuten &raquo;</a></p>
        </div>
    </c:forEach>
</div>
</jsp:body>
</t:plantilla_usuario>