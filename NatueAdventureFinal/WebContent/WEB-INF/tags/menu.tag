<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<ul class="nav nav-sidebar">
	<c:choose>
		<c:when test="${category == 'summary' }">
			<li class="active"><a href="${pageContext.request.contextPath}/admin/index.html">Resumen<span class="sr-only">(current)</span></a></li>
		</c:when>
		<c:otherwise>
			<li><a href="${pageContext.request.contextPath}/admin/index.html">Resumen</a></li>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${category == 'activity' }">
			<li class="active"><a href="${pageContext.request.contextPath}/admin/activity.html">Actividades<span class="sr-only">(current)</span></a></li>
		</c:when>
		<c:otherwise>
			<li><a href="${pageContext.request.contextPath}/admin/activity.html">Actividades</a></li>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${category == 'instructor' }">
			<li class="active"><a href="${pageContext.request.contextPath}/admin/instructor.html">Monitores<span class="sr-only">(current)</span></a></li>
		</c:when>
		<c:otherwise>
			<li><a href="${pageContext.request.contextPath}/admin/instructor.html">Monitores</a></li>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${category == 'booking' }">
			<li class="active"><a href="${pageContext.request.contextPath}/admin/booking.html">Reservas<span class="sr-only">(current)</span></a></li>
		</c:when>
		<c:otherwise>
			<li><a href="${pageContext.request.contextPath}/admin/booking.html">Reservas</a></li>
		</c:otherwise>
	</c:choose>
    <!-- <li class="active"><a href="${pageContext.request.contextPath}/admin/index.html">Resumen<span class="sr-only">(current)</span></a></li>
    <li><a href="${pageContext.request.contextPath}/admin/activity.html">Actividades</a></li>
    <li><a href="${pageContext.request.contextPath}/admin/instructor.html">Monitores</a></li>
	<li><a href="${pageContext.request.contextPath}/admin/booking.html">Reservas</a></li> -->
</ul>