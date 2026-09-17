package Modelos;

public class Accesorio extends Producto {
    private String categoria;

    public Accesorio(String id, String nombre, double precioBase, String marca, int stock, String categoria) {
        super(id, nombre, precioBase, marca, stock);
        this.categoria = categoria;
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecioBase() + (getPrecioBase() * 0.25); 
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}