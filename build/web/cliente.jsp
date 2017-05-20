<%@page import="modelo.entidad.Cliente"%>
<%@page import="modelo.dao.ClienteDAO"%>
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
    ClienteDAO cl= new ClienteDAO(cn);
    Cliente buscar = cl.read("1");
    //out.println(buscar.getNombres());

%>
<form action="ctrlCliente" method="POST">
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
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Direccion</th>
                        <th>Telefono</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><%=request.getParameter("codigo")%></td>
                        <td><%=request.getParameter("nombre")%></td>
                        <td><%=request.getParameter("apellido")%></td>
                        <td><%=request.getParameter("direccion")%></td>
                        <td><%=request.getParameter("telefono")%></td>
                    </tr>
                </tbody>
            </table>

    </table>

</form>
    </body>
</html>
