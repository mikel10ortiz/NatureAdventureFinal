<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:plantilla_staff title="Calendario de reservas">
<jsp:body>
	<div class="container">
		<div class="calendar" data-color="normal">
		<c:forEach items="${bookings}" var="booking">
			<div data-role="day" data-day="<fmt:formatDate value="${booking.activityDate}" type="both" 
      		pattern="yyyyMd" />">
      		<div data-role="event" data-name="${booking.activityId}" data-start="${booking.hour}">
      		</div>
      		</div>
		</c:forEach>
		
		<div data-role="day" data-day="2015530">
		<div data-role="event" data-name="Soy un evento que siempre saldr&eacute; ma&ntilde;ana" data-start="9.00" data-end="9.50" data-location="martiniglesias.eu">
		</div></div>
		<div data-role="day" data-day="2015529">
		<div data-role="event" data-name="Soy un evento que siempre saldr&eacute; ma&ntilde;ana" data-start="9.00" data-end="9.50" data-location="martiniglesias.eu">
		</div></div></div>
		  <script>
		  var yy;
		  var calendarArray =[];
		  var monthOffset = [6,7,8,9,10,11,0,1,2,3,4,5];
		  var monthArray = [["ENE","Enero"],["FEB","Febrero"],["MAR","Marzo"],["ABR","Abril"],["MAY","Mayo"],["JUN","Junio"],["JUL","Julio"],["AGO","Agosto"],["SEP","Septiembre"],["OCT","Octubre"],["NOV","Noviembre"],["DIC","Diciembre"]];
		  var letrasArray = ["L","M","X","J","V","S","D"];
		  var dayArray = ["7","1","2","3","4","5","6"];
		  $(document).ready(function() {
		    $(document).on('click','.calendar-day.have-events',activateDay);
		    $(document).on('click','.specific-day',activatecalendar);
		    $(document).on('click','.calendar-month-view-arrow',offsetcalendar);
		    $(window).resize(calendarScale);
		    $(".calendar").calendar({
		      "2015910": {
		        "Mulberry Festival": {
		          start: "9.00",
		          end: "9.40",
		          location: "España"
		        }
		      }
		    });
		    calendarSet();
		    calendarScale();
		    });
		  </script>
	</div>
</jsp:body>
</t:plantilla_staff>