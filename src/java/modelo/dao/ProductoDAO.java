package modelo.dao;

import interfaces.Operaciones;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.dominio.Conexion;
import modelo.entidad.Producto;


public class ProductoDAO implements Operaciones<Producto>{
    private static final String SQL_INSERT ="INSERT INTO producto (codigo,precio,descripcion,existencia) values (?,?,?,?)";
    private static final String SQL_DELETE ="DELETE FROM producto WHERE codigo = ?";
    private static final String SQL_UPDATE ="UPDATE producto SET precio =?, descripcion=?, existencia=? WHERE codigo = ?";
    private static final String SQL_READ ="SELECT * FROM producto WHERE codigo = ?";
    private static final String SQL_READALL ="SELECT * FROM producto";
    private Conexion cn;
    
     public ProductoDAO(Conexion cnx) {
        this.cn = cnx;
    }
     
    @Override
    public boolean create(Producto c) {
       boolean r=false;
       PreparedStatement pstm;
        try{
            
            pstm = this.cn.Conectar().prepareStatement(SQL_INSERT);
            pstm.setInt(1, c.getCodigo());
            pstm.setFloat(2, c.getPrecio());
            pstm.setString(3, c.getDescripcion());
            pstm.setInt(4, c.getExistencia());
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
    public boolean update(Producto c) {
        boolean r=false;
       PreparedStatement pstm;
        try{
            
            pstm = this.cn.Conectar().prepareStatement(SQL_UPDATE);
            pstm.setFloat(1, c.getPrecio());
            pstm.setString(2, c.getDescripcion());
            pstm.setInt(3, c.getExistencia());
            pstm.setInt(4, c.getCodigo());
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
    public Producto read(Object Key) {
            PreparedStatement pstm;
            ResultSet rs = null;
            Producto cl = null;
        try {
            pstm = this.cn.Conectar().prepareStatement(SQL_READ);
            pstm.setString(1, Key.toString());
          
            rs= pstm.executeQuery();
            while(rs.next()){
                cl= new Producto(rs.getInt(1),rs.getFloat(2),rs.getString(3),rs.getInt(4));
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
    public List<Producto> readAll() {
        PreparedStatement pstm;
        ArrayList<Producto> producto =new ArrayList();    
        ResultSet rs = null;
        
        try {
            pstm = this.cn.Conectar().prepareStatement(SQL_READALL);
            rs= pstm.executeQuery();
            while(rs.next()){
                producto.add(new Producto(rs.getInt(1),rs.getFloat(2),rs.getString(3),rs.getInt(4)));
            }
            this.cn.Desconectar(); 
             
        }  
        catch (SQLException e){
            System.out.println("Error, en la ejecucion de la sentencia SQL " + e.getMessage());
        }
        return producto;   
    }

}