package hadt7;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ModelProduct {
    private ArrayList<Product> productos;;
    private BinarySearchTree<Long, Product> arbol;
    private BinarySearchTree<Double, List<Product>> arbolPorPrecio;

    public ModelProduct(){
        productos = new ArrayList<Product>();
    }

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

                String skuStr = values[6].trim(); // Columna SKU
                if (!esNumeroLong(skuStr)) {
                    continue; // Omitir esta fila
                }

                try {
                    long sku = Long.parseLong(skuStr); // Convertir SKU a long
                    // Procesar el resto de las columnas y agregar el producto
                    double priceRetail = esNumeroDouble(values[9].trim()) ? Double.parseDouble(values[9].trim()) : 0.0;
                    double priceCurrent = esNumeroDouble(values[10].trim()) ? Double.parseDouble(values[10].trim()) : 0.0;

                    Product product = new Product(
                        sku,
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

    private boolean esNumeroLong(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }    
    private boolean esNumeroDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void datosEnArbolBinario (){
        arbol = new BinarySearchTree<Long, Product>();
        for (Product p : productos) {
            arbol.insert(p.getSku(), p);
        }
    }

    public void datosEnArbolPorPrecio(){
        arbolPorPrecio = new BinarySearchTree<Double, List<Product>>();
        for (Product p : productos) {
            List<Product> listaProductos = arbolPorPrecio.search(p.getPrice_current());
            if (listaProductos == null) {
                listaProductos = new ArrayList<Product>();
                arbolPorPrecio.insert(p.getPrice_current(), listaProductos);
            }
            listaProductos.add(p);
        }
    }

    public void mostrarArbolPorPrecioAscendente(){
        ListarElementos<Double, List<Product>> listar = new ListarElementos<>();
        arbolPorPrecio.InOrder(listar);

        ArrayList<List<Product>> listaProductos = listar.getElementos();

        for (List<Product> lista : listaProductos) {
            System.out.println("Precio: " + lista.get(0).getPrice_current() + "\nProductos: ");
            for (Product p : lista) {
                System.out.println("Name: " + p.name + " - SKU: " + p.sku );
            }
        }
    }

    public void mostrarArbolPorPrecioDescendente(){
        ListarElementos<Double, List<Product>> listar = new ListarElementos<>();
        arbolPorPrecio.ReverseInOrder(listar);

        ArrayList<List<Product>> listaProductos = listar.getElementos();

        for (List<Product> lista : listaProductos) {
            System.out.println("Precio: " + lista.get(0).getPrice_current() + "\nProductos: ");
            for (Product p : lista) {
                System.out.println("Name: " + p.name + " - SKU: " + p.sku );
            }
        }

    }
    
    public void busqueda(long sku) {
        Product p = arbol.search(sku);
        if (p != null) {
            System.out.println("Producto encontrado: " + p.toString());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}
