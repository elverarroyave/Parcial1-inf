package co.edu.udea.inf.parcial.model;

public class Producto {
    private int codigo;
    private String descripcion;
    private String marca;
    private int contenido;
    private String unidadDeMedida;
    private String categoria;
    private int precio;

    public Producto(int codigo, String descripcion, String marca, int contenido, String unidadDeMedida, String categoria, int precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.marca = marca;
        this.contenido = contenido;
        this.unidadDeMedida = unidadDeMedida;
        this.categoria = categoria;
        this.precio = precio;
    }

    public Producto(){}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getContenido() {
        return contenido;
    }

    public void setContenido(int contenido) {
        this.contenido = contenido;
    }

    public String getUnidadDeMedida() {
        return unidadDeMedida;
    }

    public void setUnidadDeMedida(String unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
