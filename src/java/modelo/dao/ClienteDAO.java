
package modelo.dao;

import interfaces.Operaciones;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.dominio.Conexion;
import modelo.entidad.Cliente;


public class ClienteDAO implements Operaciones<Cliente>{

    private static final String SQL_INSERT ="INSERT INTO cliente (codigo,nombres,apellidos,direccion,telefono) values (?,?,?)";
    private static final String SQL_DELETE ="DELETE FROM cliente WHERE codigo = ?";
    private static final String SQL_UPDATE ="UPDATE cliente SET nombres =?, apellidos=?, direccion=?, telefono=? WHERE codigo = ?";
    private static final String SQL_READ ="SELECT * FROM cliente WHERE codigo = ?";
    private static final String SQL_READALL ="SELECT * FROM cliente";
    private Conexion cn;
    
     public ClienteDAO(Conexion cnx) {
        this.cn = cnx;
    }
     
    @Override
    public boolean create(Cliente c) {
       boolean r=false;
       PreparedStatement pstm;
        try{
            
            pstm = this.cn.Conectar().prepareStatement(SQL_INSERT);
            pstm.setString(1, c.getCodigo());
            pstm.setString(2, c.getNombres());
            pstm.setString(3, c.getApellidos());
            pstm.setString(4, c.getDireccion());
            pstm.setString(5, c.getTelefono());
            int n = pstm.executeUpdate();
            if (n > 0 )
                r=true;
            this.cn.Desconectar();
        }
        catch (SQLException e){
            System.out.println("Error, en la ejecucion de la sentencia SQL " + e.getMessage());
        }            
        return r;
    }

    @Override
    public boolean delete(Object key) {
         boolean r=false;
         PreparedStatement pstm;
        try{
           
            pstm = this.cn.Conectar().prepareStatement(SQL_DELETE);
            pstm.setString(1, key.toString());
            int n = pstm.executeUpdate();
            if (n > 0 )
                r=true;
            this.cn.Desconectar();
        }
        catch (SQLException e){
            System.out.println("Error, en la ejecucion de la sentencia SQL " + e.getMessage());
        }            
        return r;
    }

    @Override
    public boolean update(Cliente c) {
        boolean r=false;
       PreparedStatement pstm;
        try{
            
            pstm = this.cn.Conectar().prepareStatement(SQL_UPDATE);
            pstm.setString(1, c.getNombres());
            pstm.setString(2, c.getApellidos());
            pstm.setString(3, c.getDireccion());
            pstm.setString(4, c.getTelefono());
            pstm.setString(5, c.getCodigo());
            int n = pstm.executeUpdate();
            if (n > 0 )
                r=true;
            this.cn.Desconectar();
        }
        catch (SQLException e){
            System.out.println("Error, en la ejecucion de la sentencia SQL " + e.getMessage());
        }            
        return r;
    }

    @Override
    public Cliente read(Object Key) {
            PreparedStatement pstm;
            ResultSet rs = null;
            Cliente cl = null;
        try {
            pstm = this.cn.Conectar().prepareStatement(SQL_READ);
            pstm.setString(1, Key.toString());
          
            rs= pstm.executeQuery();
            while(rs.next()){
                cl= new Cliente(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            }
            this.cn.Desconectar(); 
            return cl; 
             
        }  
        catch (SQLException e){
            System.out.println("Error, en la ejecucion de la sentencia SQL " + e.getMessage());
        }
        return cl;   
    }

    @Override
    public List<Cliente> readAll() {
        PreparedStatement pstm;
        ArrayList<Cliente> cliente =new ArrayList();    
        ResultSet rs = null;
        
        try {
            pstm = this.cn.Conectar().prepareStatement(SQL_READALL);
            rs= pstm.executeQuery();
            while(rs.next()){
                cliente.add(new Cliente(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
            this.cn.Desconectar(); 
             
        }  
        catch (SQLException e){
            System.out.println("Error, en la ejecucion de la sentencia SQL " + e.getMessage());
        }
        return cliente;   
    }

}