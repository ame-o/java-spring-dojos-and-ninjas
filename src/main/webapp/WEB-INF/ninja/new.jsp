<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c"%>

<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>New Ninja</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
    
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
</head>
<body>
<section class="section">
<div class="container">
<h1 class="title"> New Ninja</h1>
<form:form action="/ninja/new/process" method="post" modelAttribute="ninja">
    <div class="select is-primary">
    <form:select path="dojo">
    <c:forEach items="${allDojos}" var="d">
        <form:option class="input is-success" path="dojo" value="${d.id}"> 
        ${d.name}
    	</form:option>
    </c:forEach>
    </form:select>
    </div>
    <div class="field">
        <form:label class="label" path="firstName">First Name</form:label>
        <form:errors path="firstName"/>
    <div class="control has-icons-left has-icons-right">
        <form:input class="input is-success" path="firstName"/>
    </div>
    </div>
    
    <div class="field">
        <form:label class="label" path="lastName">Last Name</form:label>
        <form:errors path="lastName"/>
        <div class="control has-icons-left has-icons-right">
        <form:input class="input is-success" path="lastName"/>
    </div>
    </div>
    
    <div class="field">
        <form:label class="label" path="age">Age</form:label>
        <form:errors path="age"/>
        <div class="control has-icons-left has-icons-right">     
        <form:input class="input is-success" type="number" path="age"/>
    </div>    
    </div>
    <input class="button is-primary"type="submit" value="Submit"/>
</form:form>    

</div>
</section>
</body>
</html>