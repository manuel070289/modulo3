
package modelo.dominio;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class OyenteServidor implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        try{
        Conexion cnx = new Conexion();
        sc.setAttribute("conexion", cnx);
        }catch(Exception ex){
            System.out.println("No se pudo crear el objeto conexion");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
     ServletContext sc = sce.getServletContext();
        try{
           sc.removeAttribute("conexion");
        }catch(Exception ex){
            System.out.println("No se pudo elimina el objeto conexion");
        }
    }
    
}
