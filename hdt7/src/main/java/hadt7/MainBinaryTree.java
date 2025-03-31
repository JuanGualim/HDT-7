package hadt7;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainBinaryTree {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ModelProduct model = new ModelProduct();
    String filename = "home_appliance_skus_lowes.csv";
    
    System.out.println("Bienvenido al programa");
    try {
        model.cargarProductos(filename);
    } catch (FileNotFoundException e) {
        System.out.println("Error al cargar el archivo: " + e.getMessage());
        scanner.close();
        return;
    }
    
    model.datosEnArbolBinario();
    model.datosEnArbolPorPrecio();
    int opcion = 0;
    while (opcion != 4){
    try{
        
            System.out.println("\n--Menu de opciones--");
            System.out.println("1. Buscar producto por SKU");
            System.out.println("2. Listar productos por precio ascendente");
            System.out.println("3. Listar productos por precio descendente");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el SKU del producto a buscar: ");
                    long sku = scanner.nextLong();
                    model.busqueda(sku);
                    break;
                case 2:
                    model.mostrarArbolPorPrecioAscendente();
                    break;
                case 3:
                    model.mostrarArbolPorPrecioDescendente();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        
    
    } catch (NumberFormatException e){
        System.out.println("Error al ingresar la opción: " + e.getMessage());
        scanner.nextLine(); // Limpiar el buffer
    } catch (Exception e){
        System.out.println("Error inesperado: " + e.getMessage());
        scanner.nextLine(); // Limpiar el buffer
    }
    }
    scanner.close();

    }
}
