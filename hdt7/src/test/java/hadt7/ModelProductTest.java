package hadt7;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class ModelProductTest {
    private ModelProduct model;

    @Before
    public void setUp() {
        model = new ModelProduct();
    }

    @Test
    public void testCargarProductos() throws FileNotFoundException {
        model.cargarProductos("home_appliance_skus_lowes.csv");
        assertFalse("La lista de productos no debe estar vacía después de cargar el archivo.", model.productcsIsEmpty());
    }

    @Test
    public void testDatosEnArbolBinario() {
        Product p1 = new Product("1001", "Categoría1", 100.0, 90.0, "Producto1");
        Product p2 = new Product("1002", "Categoría2", 200.0, 180.0, "Producto2");

        model.agregarProducto(p1);
        model.agregarProducto(p2);

        model.datosEnArbolBinario();

        assertNotNull("El árbol binario no debe ser nulo.", model.getArbol());
        assertEquals("El árbol debe contener el producto con SKU 1001.", p1, model.getArbol().search("1001"));
        assertEquals("El árbol debe contener el producto con SKU 1002.", p2, model.getArbol().search("1002"));
    }

    @Test
    public void testMostrarArbolAscendente() {
        Product p1 = new Product("1001", "Categoría1", 100.0, 90.0, "Producto1");
        Product p2 = new Product("1002", "Categoría2", 200.0, 180.0, "Producto2");
        Product p3 = new Product("1003", "Categoría3", 150.0, 120.0, "Producto3");

        model.agregarProducto(p1);
        model.agregarProducto(p2);
        model.agregarProducto(p3);

        model.datosEnArbolBinario();

        // Verificar el orden ascendente
        ListarElementos<String, Product> listar = new ListarElementos<>();
        model.getArbol().InOrder(listar);

        assertEquals("El primer producto debe ser Producto1.", p1, listar.getElementos().get(0));
        assertEquals("El último producto debe ser Producto3.", p3, listar.getElementos().get(2));
    }

    @Test
    public void testBusqueda() {
        Product p1 = new Product("1001", "Categoría1", 100.0, 90.0, "Producto1");
        Product p2 = new Product("1002", "Categoría2", 200.0, 180.0, "Producto2");

        model.agregarProducto(p1);
        model.agregarProducto(p2);

        model.datosEnArbolBinario();

        Product resultado = model.getArbol().search("1001");
        assertNotNull("El producto con SKU 1001 debe encontrarse.", resultado);
        assertEquals("El producto encontrado debe ser Producto1.", p1, resultado);

        resultado = model.getArbol().search("9999");
        assertNull("El producto con SKU 9999 no debe encontrarse.", resultado);
    }
    
    @Test
    public void testMostrarArbolDescendente() {
        Product p1 = new Product("1001", "Categoría1", 100.0, 90.0, "Producto1");
        Product p2 = new Product("1002", "Categoría2", 200.0, 180.0, "Producto2");
        Product p3 = new Product("1003", "Categoría3", 150.0, 120.0, "Producto3");

        model.agregarProducto(p1);
        model.agregarProducto(p2);
        model.agregarProducto(p3);

        model.datosEnArbolBinario();

        // Verificar el orden descendente
        ListarElementos<String, Product> listar = new ListarElementos<>();
        model.getArbol().ReverseInOrder(listar);

        assertEquals("El primer producto debe ser Producto3.", p3, listar.getElementos().get(0));
        assertEquals("El último producto debe ser Producto1.", p1, listar.getElementos().get(2));
    }
}