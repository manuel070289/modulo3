<%-- 
    Document   : producto
    Created on : 19-may-2017, 21:08:28
    Author     : Dilberth
--%>

<%@page import="modelo.entidad.Producto"%>
<%@page import="modelo.dao.ProductoDAO"%>
<%@page import="modelo.dominio.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
    Conexion cn = (Conexion)application.getAttribute("conexion");
   // out.println("Conexion "+ cn);
    ProductoDAO cl= new ProductoDAO(cn);
    Producto buscar = cl.read("1");
    //out.println(buscar.getNombres());

%>
<form action="ctrlProducto" method="POST">
    <table border="1">
            <tr>
                <td><h5>Ingrese el codigo</h5></td>
                <td><input type="text" name="codigo"> </td>
                <td><input type="submit" name="envio" value= "enviar"> </td>
                
            </tr>
            <table border="1">
                <thead>
                    <tr>
                        <th>Codigo</th>
                        <th>Precio</th>
                        <th>Descripcion</th>
                        <th>Existencia</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><%=request.getParameter("codigo")%></td>
                        <td><%=request.getParameter("precio")%></td>
                        <td><%=request.getParameter("descripcion")%></td>
                        <td><%=request.getParameter("existencia")%></td>
                    </tr>
                </tbody>
            </table>

    </table>

</form>
    </body>
</html>