package modelo.dominio;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class Conexion {
 
    private Connection cn;
    private boolean cnFree;
    public Conexion(){
    this.cnFree = true;
    try{
    InitialContext ic = new InitialContext();
    DataSource ds = (DataSource) ic.lookup("sqlRealmResource");
        try {
            this.cn=ds.getConnection();
         } catch (SQLException ex) {
                System.out.println("Error" + ex.getMessage());
            }
    }catch (NamingException ex){
        System.out.println("Error" + ex.getMessage());
    }
   }
    
    public synchronized Connection Conectar(){
        while (this.cnFree == false){
            try{
                wait();
            }catch(InterruptedException e){
                
            }
        }
        this.cnFree = false;
        notify();
        return this.cn;
    }
    
     public synchronized void Desconectar(){
        while (this.cnFree == true){
            try{
                wait();
            }catch(InterruptedException e){
                
            }
        }
        this.cnFree = true;
        notify();
    }
    public void Cerrar(){
        try {
            this.cn.close();
        }catch(SQLException ex){
            System.out.println("Error al cerrar la coneccion");
        }
    }
}

  