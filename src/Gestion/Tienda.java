package Gestion;
import Excepciones.ProductoNoEncontradoException;
import Excepciones.StockInsuficienteException;
import Modelos.Producto;
import java.util.ArrayList;
import java.util.List;

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

    public Producto buscarPorId(String id) throws ProductoNoEncontradoException {
    for (Producto p : productos) {
        if (p.getId().equalsIgnoreCase(id)) {
            return p;
        }
    }
    
    throw new ProductoNoEncontradoException("Producto no encontrado con ID: " + id);
}

    public void venderProducto(String id, int cantidad) throws ProductoNoEncontradoException, StockInsuficienteException {
    Producto p = buscarPorId(id);
    if (p.getStock() < cantidad) {
        throw new StockInsuficienteException("Stock insuficiente para el producto con ID: " + id);
    }
    p.setStock(p.getStock() - cantidad);
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


