<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SpringMVC - All Employee</title>
</head>

<body>
    <div >
        <div >
              <!-- Default panel contents -->
            <div ><span>List of Employees </span></div>
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Surname</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${employees}" var="employee">
                    <tr>
                        <td>${employee.id}</td>
                        <td>${employee.name}</td>
                        <td>${employee.surname}</td>
                        <td><a href="<c:url value='/employee-web/edit-employee-${employee.id}' />" class="btn btn-success 
 
custom-width">edit</a></td>
                        <td><a href="<c:url value='/employee-web/delete-employee/${employee.id}' />" class="btn btn-danger 
 
custom-width">delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div>
            <a href="<c:url value='/employee-web/addEmployee' />">Add New Employee</a>
        </div>
    </div>
</body>
</html>