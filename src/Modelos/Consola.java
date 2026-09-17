package Modelos;

public class Consola extends Producto {
    private String tipoConsola;
    private boolean incluyeControl;

    public Consola(String id, String nombre, double precioBase, String marca, int stock, String tipoConsola, boolean incluyeControl) {
        super(id, nombre, precioBase, marca, stock);
        this.tipoConsola = tipoConsola;
        this.incluyeControl = incluyeControl;
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecioBase() - (getPrecioBase() * 0.10); 
    }

    public String getTipoConsola() {
        return tipoConsola;
    }

    public void setTipoConsola(String tipoConsola) {
        this.tipoConsola = tipoConsola;
    }

    public boolean isIncluyeControl() {
        return incluyeControl;
    }

    public void setIncluyeControl(boolean incluyeControl) {
        this.incluyeControl = incluyeControl;
    }
}