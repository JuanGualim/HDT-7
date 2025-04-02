package hadt7;

/**
 * Clase que representa un producto con información como SKU, categoría, precios y nombre.
 */
public class Product {
    double price_retail, price_current; // Precio de venta al por menor y precio actual
    String name, catagory, sku; // Nombre del producto, categoría y SKU

    /**
     * Constructor de la clase Product.
     * 
     * @param sku           el identificador único del producto
     * @param catagory      la categoría del producto
     * @param price_retail  el precio de venta al por menor del producto
     * @param price_current el precio actual del producto
     * @param name          el nombre del producto
     */
    public Product(String sku, String catagory, double price_retail, double price_current, String name) {
        this.sku = sku;
        this.catagory = catagory;
        this.price_retail = price_retail;
        this.price_current = price_current;
        this.name = name;
    }

    /**
     * Devuelve el SKU del producto.
     * 
     * @return el SKU del producto
     */
    public String getSku() {
        return sku;
    }

    /**
     * Establece el SKU del producto.
     * 
     * @param sku el SKU a establecer
     */
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * Devuelve el precio de venta al por menor del producto.
     * 
     * @return el precio de venta al por menor
     */
    public double getPrice_retail() {
        return price_retail;
    }

    /**
     * Establece el precio de venta al por menor del producto.
     * 
     * @param price_retail el precio de venta al por menor a establecer
     */
    public void setPrice_retail(double price_retail) {
        this.price_retail = price_retail;
    }

    /**
     * Devuelve el precio actual del producto.
     * 
     * @return el precio actual del producto
     */
    public double getPrice_current() {
        return price_current;
    }

    /**
     * Establece el precio actual del producto.
     * 
     * @param price_current el precio actual a establecer
     */
    public void setPrice_current(double price_current) {
        this.price_current = price_current;
    }

    /**
     * Devuelve el nombre del producto.
     * 
     * @return el nombre del producto
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del producto.
     * 
     * @param name el nombre a establecer
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Devuelve la categoría del producto.
     * 
     * @return la categoría del producto
     */
    public String getCatagory() {
        return catagory;
    }

    /**
     * Establece la categoría del producto.
     * 
     * @param catagory la categoría a establecer
     */
    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    /**
     * Devuelve una representación en forma de cadena del producto.
     * 
     * @return una cadena que representa el producto
     */
    @Override
    public String toString() {
        return "--Product--\n-Sku: " + sku + "\nPrice_retail: " + price_retail + "\nPrice_current: " + price_current
                + "\nName_Product: " + name + "\n-Catagory:" + catagory + "\n";
    }
}