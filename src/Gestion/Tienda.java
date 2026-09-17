package Gestion;
import Modelos.Producto;
import java.util.List;
import java.util.ArrayList;


public class Tienda {
    private List<Producto> productos = new ArrayList<>();

    public Tienda() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        this.productos.add(p);
    }

    public List<Producto> getProductos() {
        return productos;
    }



    public List<Producto> buscarPorCategoria(String categoria) {
        
        List<Producto> resultado = new ArrayList<>();

        for (Producto p : productos) {
        
    
        if (p instanceof Modelos.Periferico && categoria.equalsIgnoreCase("Periferico")) {
    resultado.add(p);
        }
    
        else if (p instanceof Modelos.Componente && categoria.equalsIgnoreCase("Componente")) {
    resultado.add(p);
        } 
        else if (p instanceof Modelos.Consola && categoria.equalsIgnoreCase("Consola")) {
    resultado.add(p);
        } 
        else if (p instanceof Modelos.Accesorio && categoria.equalsIgnoreCase("Accesorio")) {
    resultado.add(p);}
        }
    return resultado;
}


    public double calcularValorInventario(){

        double valorTotal = 0;
        for (Producto p : productos) {
            valorTotal += p.calcularPrecioFinal() * p.getStock();
        }
        return valorTotal;

    }
}
