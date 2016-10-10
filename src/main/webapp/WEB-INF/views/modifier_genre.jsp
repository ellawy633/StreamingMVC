<%-- 
    Document   : modifier_genre
    Created on : 10 oct. 2016, 14:43:40
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>edition du genre</h1>
        <div>
            <c:set var="racine">
                <spring:url value="/"/>
            </c:set>
            <form:form action="${racine}modifier" modelAttribute="genreAct">
                <form:hidden path="id"/>
                <label>nom de genre</label>
                <form:input path="nom"/>
                <br>
                <input type="submit" value="modifier"/>
            </form:form>   
        </div>
    </body>
</html>
