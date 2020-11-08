<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SpringMVC - Add Employee</title>
</head>
<body>
	<h2>
		<spring:message code="lbl.page" text="Add New Employee" />
	</h2>
	<br />
	
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	
	<form:form method="post" modelAttribute="employee" action="${contextPath}/employee-web/submitAddEmployee">
		<table>
			<tr>
				<td><spring:message code="lbl.name"/></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="lbl.surname" /></td>
				<td><form:input path="surname" /></td>
				<td><form:errors path="surname" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add Employee" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>