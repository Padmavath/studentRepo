<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>view all student</title>
<link href="@Url.Content("~/Content/getallstudent.css")" rel="stylesheet">
<link href="~/Content/css/getallstudent.css" rel="stylesheet" type="text/css" />  
</head>
<body>
<h1>All Student data......!!!!!!.&&&&&&&&&&&</h1>
<table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                     <th>Password</th>
                      <th>Edit</th>
                      <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${studentList}" var="student">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.email}</td>
                        <td>${student.password}</td>
                        <td><a href="updatestudent/${student.id}">Edit</a></td>
                         <td><a href="deletestudent/${student.id}">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
</body>
</html>
