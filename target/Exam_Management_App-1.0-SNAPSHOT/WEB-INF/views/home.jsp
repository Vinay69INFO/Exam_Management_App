<%-- 
    Document   : home
    Created on : 24 Nov, 2019, 10:59:56 AM
    Author     : vinay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="../commonLib/cdnLink.jsp" /> 

    </head>
    <body>
        <form:errors path="stu.*" />
        <jsp:include page="./components/header.jsp" />
        <br>
        <h1>${message}</h1>

    </body>
</html>
