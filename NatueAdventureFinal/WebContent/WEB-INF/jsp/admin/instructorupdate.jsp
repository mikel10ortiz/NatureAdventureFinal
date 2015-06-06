<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:plantilla_admin title="Gestionar instructores - Modificar instructor">
<jsp:body>
	<h1 class="page-header"> Modificar instructor </h1>
	<c:choose>
    	<c:when test="${ok not null}">
    		<div class="alert alert-success">
    			<c:out value="${ok}" />
    		</div>
    	</c:when>    
    </c:choose>
	<div id="content">
		<ul id="tabs" class="nav nav-tabs" data-tabs="tabs">
					<li class="active">
						<a data-toggle="tab" href="#ip">Informacón personal</a>
					</li>
					<li>
						<a data-toggle="tab" href="#dda">Datos de acceso</a>
					</li>
					<li>
						<a data-toggle="tab" href="#es">Especialidades</a>
					</li>			
        </ul>
		
		<div id="my-tab-content" class="tab-content">
			<div class="tab-pane active" id="ip">
				<form:form method="post" modelAttribute="instructor">
					<table class="formulario">
						<tr>
							<td><form:label path="name">Nombre</form:label></td>
							<td><form:input path="name" class="form-control" /></td>
						</tr>
						<tr>
							<td><form:label path="lastName">Apellidos</form:label></td>
							<td><form:input path="lastName" class="form-control" /></td>
						</tr>
						<tr>
							<td><form:label path="address">Dirección</form:label></td>
							<td><form:input path="address" class="form-control" /></td>
						</tr>
						<tr>
							<td><form:label path="telephone">Telefono</form:label></td>
							<td><form:input path="telephone" class="form-control" /></td>
						</tr>
						<tr>
							<td><form:label path="email">Email</form:label></td>
							<td><form:input path="email" class="form-control" /></td>
						</tr>
						<tr>
							<td><form:label path="idCard">NIF</form:label></td>
							<td><form:input path="idCard" class="form-control" /></td>
						</tr>
						<tr>
							<td><form:label path="dateOfBirth">Fecha de nacimiento</form:label></td>
							<td><form:input path="dateOfBirth" class="form-control" /></td>
						</tr>
						<tr>
							<td><form:label path="inittialHour">Hora de inicio de jornada</form:label></td>
							<td><form:input path="inittialHour" class="form-control"/></td>
						</tr>
						<tr>
							<td><form:label path="finalHour">Hora de fin de jornada</form:label></td>
							<td><form:input path="finalHour" class="form-control"/></td>
						</tr>
						<tr>
							<td><form:label path="entryDate">Fecha de alta</form:label></td>
							<td><form:input path="entryDate" class="form-control"/></td>
						</tr>
						<tr>
							<td><form:label path="username">Nombre de usuario</form:label></td>
							<td><form:input path="username" class="form-control" /></td>
						</tr>
						<tr>
							<td><form:label path="password">Contraseña</form:label></td>
							<td><form:input path="password" class="form-control" /></td>
						</tr>
						
						<tr>
							<td colspan="2"> <input type="submit" value="Guardar instructor" value="Guardar actividad" class="btn btn-default" /></td>
						</tr>
					</table>
				</form:form>
			</div>
			<div class="tab-pane" id="dda">
                <form:form  modelAttribute="userApp" method="post" action="${pageContext.request.contextPath}/admin/instructor/updatepassword/${instructor.idCard}.html">
	                <table class="formulario">
	                	<tr>
	                		<td><form:label path="username">Username</form:label></td>
	                		<td><form:input path="username" value="${instructor.username}" class="form-control"/></td>
	                	</tr>
	                	<tr>
	                		<td><form:label path="password">Password</form:label></td>
	                		<td><form:password path="password" class="form-control" /></td>
	                	</tr>
	                	<tr>
							<td colspan="2"> <input type="submit" value="Actualizar" value="Guardar actividad" class="btn btn-default" /></td>
						</tr>
	                </table>
	            </form:form>
              </div>
			<div class="tab-pane" id="es">
              	<c:choose>
					<c:when test='${empty specializations}'>
						<p> El instructor no tiene actividades para supervisar </p>
					</c:when>
					<c:otherwise>
						<h3>Actividades supervisadas</h3>
						<table class="table table-striped">
	    			<thead>
		        		<tr>
		            		<th>Nombre</th>
		            		<th>Descripcion</th>
		        		</tr>
		    		</thead>
		    		<tbody>
		        		<c:forEach items="${specializations}" var="activitySpecialization">
		            		<tr>
		                		<td>${activitySpecialization.name}</td>
		                		<td>${activitySpecialization.description}</td>
		            		</tr>
		        		</c:forEach>
		    		</tbody>
		    	</table>
					</c:otherwise>
				</c:choose>
				<h3>A&nacute;adir actividades</h3>
                <table class="table table-striped">
	    			<thead>
		        		<tr>
		            		<th>Nombre</th>
		            		<th>Descripcion</th>
		            		<th colspan=2>Acci&oacute;n</th>
		        		</tr>
		    		</thead>
		    		<tbody>
		        		<c:forEach items="${activitiesForSpecialization}" var="activity">
		            		<tr>
		                		<td>${activity.name}</td>
		                		<td>${activity.description}</td>
		                		<td colspan="2"><a href="../addspecialization/${instructor.idCard}/${activity.id}.html">Anadir</a></td>
		            		</tr>
		        		</c:forEach>
		    		</tbody>
		    	</table>
          	</div>
			
			</div>
	</div>
</jsp:body>
</t:plantilla_admin>