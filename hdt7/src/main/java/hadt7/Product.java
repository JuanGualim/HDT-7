package hadt7;

public class Product {
    long sku;
    double price_retail, price_current;
    String name, catagory;

    public Product(long sku, String catagory, double price_retail, double price_current,
            String name) {
        this.sku = sku;
        this.catagory = catagory;
        this.price_retail = price_retail;
        this.price_current = price_current;
        this.name = name;
    }
    
    public long getSku() {
        return sku;
    }

    public void setSku(long sku) {
        this.sku = sku;
    }

    public double getPrice_retail() {
        return price_retail;
    }

    public void setPrice_retail(double price_retail) {
        this.price_retail = price_retail;
    }

    public double getPrice_current() {
        return price_current;
    }

    public void setPrice_current(double price_current) {
        this.price_current = price_current;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    @Override
    public String toString() {
        return "--Product--\n-Sku: " + sku + "\nPrice_retail: " + price_retail + "\nPrice_current: " + price_current + "\nName_Product: "
                + name + "\n-Catagory:" + catagory + "\n";
    }

    
}
