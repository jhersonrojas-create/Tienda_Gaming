
import Excepciones.PrecioInvalidoException;
import Excepciones.ProductoNoEncontradoException;
import Excepciones.StockInsuficienteException;
import Gestion.Tienda;
import Modelos.Accesorio;
import Modelos.Componente;
import Modelos.Consola;
import Modelos.Periferico;
import Modelos.Producto;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tienda miTienda = new Tienda();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        NumberFormat formatoCOP = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
        formatoCOP.setMaximumFractionDigits(0);
      try{  // Productos precargados para que el menú no arranque vacío
        miTienda.agregarProducto(new Periferico("P001", "Teclado Mecánico RGB", 189900, "Redragon", 11, "USB", false));
        miTienda.agregarProducto(new Periferico("P002", "Microfono (HyperX SoloCast 2)", 260000, "Hyperx", 4, "USB-C", false));
        miTienda.agregarProducto(new Periferico("P003", "Cámara (Razer Kiyo V2 X)", 440000, "Razer", 8, "USB-A", false));
        miTienda.agregarProducto(new Componente("C001", "Procesador Intel Core i7", 1200000, "Intel", 10, 36, "LGA1200"));
        miTienda.agregarProducto(new Componente("C002", "Procesador Ryzen 5 5600X", 1800000, "AMD", 10, 36, "AM4"));
        miTienda.agregarProducto(new Componente("C003", "Tarjeta Gráfica NVIDIA RTX 3080", 2500000, "NVIDIA", 5, 24, "PCIe"));
        miTienda.agregarProducto(new Componente("C004", "Memoria RAM DDR4 16GB", 800000, "Corsair", 15, 16, "DIMM"));
        miTienda.agregarProducto(new Componente("C005", "Disco Duro SSD 1TB", 900000, "Kingston", 10, 12, "SATA"));
        miTienda.agregarProducto(new Consola("CO001", "PlayStation 5", 5000000, "Sony", 5, "PS5", true));
        miTienda.agregarProducto(new Consola("CO002", "PlayStation 4", 1000000, "Sony", 10, "PS4", true));
        miTienda.agregarProducto(new Consola("CO003", "XBOX Series S", 1900000, "Microsoft", 4, "XBOX", true));
        miTienda.agregarProducto(new Consola("CO004", "XBOX Series X", 4000000, "Microsoft", 3, "XBOX", true));
        miTienda.agregarProducto(new Accesorio("A001", "Mouse (Logitech G502 Hero)", 300000, "Logitech", 20, "Mouse Gamer"));
        miTienda.agregarProducto(new Accesorio("A002", "Audifonos (HyperX Cloud III)", 400000, "Hyperx", 9, "Audifonos Gamer"));
    }catch (PrecioInvalidoException e) {
        System.out.println("Error al cargar productos iniciales: " + e.getMessage());
    }

        while (opcion != 6) {
            System.out.println("\n--- MENÚ TIENDA GAMING ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Buscar productos por categoría");
            System.out.println("3. Ver valor total del inventario");
            System.out.println("4. Ver todos los productos");
            System.out.println("5. Vender producto");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 
            switch (opcion) {
                case 1:
                    System.out.println("¿Qué tipo de producto quieres agregar?");
                    System.out.println("1. Periférico  2. Componente  3. Consola  4. Accesorio");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Precio base: ");
                    double precioBase = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Stock: ");
                    int stock = sc.nextInt();
                    sc.nextLine();
                try {
                    if (tipo == 1) {
                        System.out.print("Tipo de conexión: ");
                        String tipoConexion = sc.nextLine();
                        System.out.print("¿Es inalámbrico? (true/false): ");
                        boolean inalambrico = sc.nextBoolean();
                        sc.nextLine();
                        miTienda.agregarProducto(new Periferico(id, nombre, precioBase, marca, stock, tipoConexion, inalambrico));
                    } else if (tipo == 2) {
                        System.out.print("Meses de garantía: ");
                        int mesesGarantia = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Socket/compatibilidad: ");
                        String socket = sc.nextLine();
                        miTienda.agregarProducto(new Componente(id, nombre, precioBase, marca, stock, mesesGarantia, socket));
                    } else if (tipo == 3) {
                        System.out.print("Tipo/generación de consola: ");
                        String tipoConsola = sc.nextLine();
                        System.out.print("¿Incluye control? (true/false): ");
                        boolean incluyeControl = sc.nextBoolean();
                        sc.nextLine();
                        miTienda.agregarProducto(new Consola(id, nombre, precioBase, marca, stock, tipoConsola, incluyeControl));
                    } else if (tipo == 4) {
                        System.out.print("Categoría del accesorio: ");
                        String categoria = sc.nextLine();
                        miTienda.agregarProducto(new Accesorio(id, nombre, precioBase, marca, stock, categoria));
                    } else {
                        System.out.println("Tipo no válido.");
                    }
                    System.out.println("Producto agregado con éxito.");
                    
                } catch (PrecioInvalidoException e) {
                    System.out.println("Error al agregar el producto: " + e.getMessage());
                } break;

                case 2:
                    System.out.print("¿Qué categoría buscas? (Periferico, Componente, Consola, Accesorio): ");
                    String categoriaBuscar = sc.nextLine();
                    List<Producto> encontrados = miTienda.buscarPorCategoria(categoriaBuscar);
                    if (encontrados.isEmpty()) {
                        System.out.println("No se encontraron productos de esa categoría.");
                    } else {
                        System.out.println("--- Productos encontrados ---");
                        for (Producto p : encontrados) {
                            System.out.println(p.getNombre() + " - " + formatoCOP.format(p.calcularPrecioFinal()));
                        }
                    }
                    break;

                case 3:
                    double total = miTienda.calcularValorInventario();
                    System.out.println("Valor total del inventario: " + formatoCOP.format(total));
                    break;

                case 4:
                    List<Producto> todos = miTienda.getProductos();
                    for (Producto p : todos) {
                        System.out.println(p.getNombre() + " - " + p.getMarca() + " - " + formatoCOP.format(p.calcularPrecioFinal()));
                    }
                    break;

                case 5:
                    System.out.print("Ingresa el ID del producto a vender: ");
                    String idVender = sc.nextLine();
                    System.out.print("Ingresa la cantidad a vender: ");
                    int cantidadVender = Integer.parseInt(sc.nextLine());
                    try {
                        miTienda.venderProducto(idVender, cantidadVender);
                        System.out.println("Producto vendido con éxito.");
                    } catch (ProductoNoEncontradoException | StockInsuficienteException e) {
                        System.out.println("Error al vender el producto: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elige una opción válida.");
            }
        }

        sc.close();
    }
}