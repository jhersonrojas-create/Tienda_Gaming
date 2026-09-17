package Modelos;

public abstract class Producto {
    private String id;
    private String nombre;
    private double precioBase;
    private String marca;
    private int stock;


    public abstract double calcularPrecioFinal();
    
    public Producto(String id, String nombre, double precioBase, String marca, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.marca = marca;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}