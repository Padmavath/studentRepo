<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>update Student id</title>
    </head>
    <body>
        <c:if test="${SuccessMessage}">
            <div>Successfully Student is updated: </div>
        </c:if>
    
        <c:url var="update_student_url" value="updatestudent"/>
        <form:form action="/updatestudent" method="POST" modelAttribute="studentBean">
            <form:label path="id">ID: </form:label> <form:input type="text" path="id" value="${id}"/>
            <form:label path="name">Student Name: </form:label> <form:input type="text" path="name" value="${name}"/>
            <form:label path="email">Student Email: </form:label> <form:input path="email" value="${email}"/>
            <form:label path="password">Student Password: </form:label> <form:input path="password" value="${password}"/>
            <input type="submit" value="submit"/>
        </form:form>
        <br>
        <br>
        <a href="getallstudent">view All Student</a>
        <br>
        <br>
        <a href="createstudent">Add Student</a>
    </body>
</html>