package Modelos;

public class Periferico extends Producto {
    private String tipoConexion;
    private boolean inalambrico;

    public Periferico(String id, String nombre, double precioBase, String marca, int stock, String tipoConexion, boolean inalambrico) {
        super(id, nombre, precioBase, marca, stock);
        this.tipoConexion = tipoConexion;
        this.inalambrico = inalambrico;
    }

    @Override
    public double calcularPrecioFinal() {
    
        return getPrecioBase() * 0.19; 
    }

    public String getTipoConexion() {
        return tipoConexion;
    }

    public void setTipoConexion(String tipoConexion) {
        this.tipoConexion = tipoConexion;
    }

    public boolean isInalambrico() {
        return inalambrico;
    }

    public void setInalambrico(boolean inalambrico) {
        this.inalambrico = inalambrico;
    }
}