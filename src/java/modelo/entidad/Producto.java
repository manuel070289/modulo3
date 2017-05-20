package modelo.entidad;


public class Producto {
   private int codigo;
   private float precio;
   private String descripcion;
   private int existencia;

    public Producto() {
    }

    public Producto(int codigo, float precio, String descripcion, int existencia) {
        this.codigo = codigo;
        this.precio = precio;
        this.descripcion = descripcion;
        this.existencia = existencia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
   
   
   
}
