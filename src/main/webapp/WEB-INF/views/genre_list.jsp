<%-- 
    Document   : genre_lister
    Created on : 10 oct. 2016, 11:01:45
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${titre}</h1>
         <div>
             <a href="<spring:url value="/ajouter_genre"/>"> Nouveau genre</a>
             <br><br>
        <c:forEach items="${mesgenres}" var="monGenre">
       
            ${monGenre.nom}
           <a href="supprimer_genre/${monGenre.id}"> Supprimer</a>
            <a href="modifier_genre/${monGenre.id}"> Editer</a>
            
            
            <br>
            
        </c:forEach>
        </div>
    </body>
</html>
