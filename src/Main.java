
import Gestion.Tienda;
import Modelos.Producto;
import Modelos.Periferico;
import Modelos.Componente;
import Modelos.Consola;
import Modelos.Accesorio;
import java.util.List;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Tienda miTienda = new Tienda();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        NumberFormat formatoCOP = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
        formatoCOP.setMaximumFractionDigits(0);
        // Productos precargados para que el menú no arranque vacío
        miTienda.agregarProducto(new Periferico("P001", "Teclado Mecánico RGB", 189900, "Redragon", 15, "USB", false));
        miTienda.agregarProducto(new Componente("C001", "Procesador Intel Core i7", 1200000, "Intel", 10, 36, "LGA1200"));
        miTienda.agregarProducto(new Consola("CO001", "PlayStation 5", 5000000, "Sony", 5, "PS5", true));
        miTienda.agregarProducto(new Consola("CO002", "XBOX Series S", 1900000, "Microsoft", 4, "XBOX", true));
        miTienda.agregarProducto(new Accesorio("A001", "Mouse Gamer", 300000, "Logitech", 20, "Mouse"));

        while (opcion != 5) {
            System.out.println("\n--- MENÚ TIENDA GAMING ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Buscar productos por categoría");
            System.out.println("3. Ver valor total del inventario");
            System.out.println("4. Ver todos los productos");
            System.out.println("5. Salir");
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
                    break;

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
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elige una opción válida.");
            }
        }

        sc.close();
    }
}