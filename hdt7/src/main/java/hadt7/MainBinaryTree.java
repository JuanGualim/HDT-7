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
    int opcion = 0;
    try{
        while (opcion != 4){
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Buscar producto por SKU");
            System.out.println("2. Listar productos en orden");
            
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el SKU del producto a buscar: ");
                    int sku = scanner.nextInt();
                    model.busqueda(sku);
                    break;
                case 2:
                    model.mostrarArbol();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    
    } catch (NumberFormatException e){
        System.out.println("Error al ingresar la opción: " + e.getMessage());
    } catch (Exception e){
        System.out.println("Error inesperado: " + e.getMessage());
    }
    scanner.close();

    }
}
