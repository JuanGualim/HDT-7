package hadt7;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Clase que gestiona los productos y su almacenamiento en un árbol binario.
 * Proporciona métodos para cargar productos desde un archivo, almacenarlos en un árbol binario,
 * realizar búsquedas y mostrar los productos en diferentes órdenes.
 */
public class ModelProduct {
    private ArrayList<Product> productos; // Lista de productos
    private BinarySearchTree<String, Product> arbol; // Árbol binario para almacenar productos por SKU

    /**
     * Constructor de la clase ModelProduct.
     * Inicializa la lista de productos.
     */
    public ModelProduct() {
        productos = new ArrayList<Product>();
    }

    /**
     * Carga los productos desde un archivo CSV y los almacena en la lista de productos.
     * 
     * @param filename el nombre del archivo CSV que contiene los productos
     * @throws FileNotFoundException si el archivo no se encuentra
     */
    public void cargarProductos(String filename) throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String headerLine = br.readLine(); // Leer encabezado
            if (headerLine == null) {
                System.out.println("El archivo está vacío.");
                return;
            }

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length < 7) { // Verificar que la línea tenga suficientes columnas
                    System.out.println("Línea con datos incompletos: " + line);
                    continue;
                }

                try {
                    // Procesar el resto de las columnas y agregar el producto
                    double priceRetail = esNumeroDouble(values[9].trim()) ? Double.parseDouble(values[9].trim()) : 0.0;
                    double priceCurrent = esNumeroDouble(values[10].trim()) ? Double.parseDouble(values[10].trim()) : 0.0;

                    Product product = new Product(
                        values[6].trim(), // SKU
                        values[0].trim(), // Categoría
                        priceRetail,
                        priceCurrent,
                        values[18].trim() // Nombre del producto
                    );
                    productos.add(product);
                } catch (Exception e) {
                    System.out.println("Error procesando la línea: " + line + " - " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Verifica si una cadena es un número válido de tipo double.
     * 
     * @param str la cadena a verificar
     * @return true si la cadena es un número válido, false en caso contrario
     */
    private boolean esNumeroDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Inserta los productos de la lista en un árbol binario, utilizando el SKU como clave.
     */
    public void datosEnArbolBinario() {
        arbol = new BinarySearchTree<String, Product>();
        for (Product p : productos) {
            arbol.insert(p.getSku(), p);
        }
    }

    /**
     * Muestra los productos almacenados en el árbol binario en orden ascendente por SKU.
     */
    public void mostrarArbolAscendente() {
        ListarElementos<String, Product> listar = new ListarElementos<>();
        arbol.InOrder(listar);

        ArrayList<Product> listaProductos = listar.getElementos();

        for (Product p : listaProductos) {
            System.out.println("\nSKU: " + p.getSku() + "\nNombre: " + p.getName() + "\nPrice_current: " + p.getPrice_current() + "\nPrice_Retail: " + p.getPrice_retail());
        }
    }

    /**
     * Muestra los productos almacenados en el árbol binario en orden descendente por SKU.
     */
    public void mostrarArbolDescendente() {
        ListarElementos<String, Product> listar = new ListarElementos<>();
        arbol.ReverseInOrder(listar);

        ArrayList<Product> listaProductos = listar.getElementos();

        for (Product p : listaProductos) {
            System.out.println("\nSKU: " + p.getSku() + "\nNombre: " + p.getName() + "\nPrice_current: " + p.getPrice_current() + "\nPrice_Retail: " + p.getPrice_retail());
        }
    }

    /**
     * Busca un producto en el árbol binario utilizando el SKU como clave.
     * 
     * @param sku el SKU del producto a buscar
     */
    public void busqueda(String sku) {
        Product p = arbol.search(sku);
        if (p != null) {
            System.out.println("Producto encontrado: " + p.toString());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    /**
     * Agrega un producto a la lista de productos.
     * 
     * @param p el producto a agregar
     */
    public void agregarProducto(Product p) {
        productos.add(p);
    }

    /**
     * Devuelve el árbol binario que contiene los productos.
     * 
     * @return el árbol binario de productos
     */
    public BinarySearchTree<String, Product> getArbol() {
        return arbol;
    }

    /**
     * Verifica si la lista de productos está vacía.
     * 
     * @return true si la lista de productos está vacía, false en caso contrario
     */
    public boolean productcsIsEmpty() {
        return productos.isEmpty();
    }
}