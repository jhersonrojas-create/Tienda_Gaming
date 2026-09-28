package Modelos;
import Excepciones.PrecioInvalidoException;
public class Componente extends Producto {
    private int mesesGarantia;
    private String socketCompatibilidad;

    public Componente(String id, String nombre, double precioBase, String marca, int stock, int mesesGarantia, String socketCompatibilidad) throws PrecioInvalidoException {
        super(id, nombre, precioBase, marca, stock);
        this.mesesGarantia = mesesGarantia;
        this.socketCompatibilidad = socketCompatibilidad;
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecioBase() + (getPrecioBase() * mesesGarantia * 0.005); 
    }

    public int getMesesGarantia() {
        return mesesGarantia;
    }

    public void setMesesGarantia(int mesesGarantia) {
        this.mesesGarantia = mesesGarantia;
    }

    public String getSocketCompatibilidad() {
        return socketCompatibilidad;
    }

    public void setSocketCompatibilidad(String socketCompatibilidad) {
        this.socketCompatibilidad = socketCompatibilidad;
    }
}