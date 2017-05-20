<%-- 
    Document   : logout
    Created on : 14-may-2017, 14:11:13
    Author     : ioalvarado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            session.invalidate();
        %>
        <a href="index.html">Regresar</a>
    </body>
</html>
