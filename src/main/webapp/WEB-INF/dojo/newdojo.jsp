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
    <title>New Dojo</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
    
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
</head>
<body>
<section class="section">
<div class="container">
<h1 class="title"> New Dojo </h1>
<form:form action="/dojo/new/process" method="post" modelAttribute="dojo">
    <div class="field">
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input class="input is-success" path="name"/>
    </div>
    <input class="button is-primary"type="submit" value="Submit"/>
</form:form>
</div>
</section>
</body>
</html>