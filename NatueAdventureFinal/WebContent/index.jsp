<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:plantilla_usuario title="NatueAdventure - Tu empresa especializada en deportes de aventure">
<jsp:body>
<div class="row">
        <div class="col-md-4">
         <img id="foto" src="${pageContext.request.contextPath}/images/senderismo.jpg" alt="...">
          <p><a href="Actividad.html">Senderismo</a> </p>
          <p><a class="btn btn-default" href="#" role="button">M&aacutes informaci&oacuten &raquo;</a></p>
        </div>
        <p> ${prueba} </p>
</div>
</jsp:body>
</t:plantilla_usuario>