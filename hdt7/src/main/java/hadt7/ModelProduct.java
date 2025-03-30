package hadt7;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ModelProduct {
    private ArrayList<Product> productos = new ArrayList<Product>();
    public ModelProduct(){

    }

    public void cargarProductos(String filename) throws FileNotFoundException{
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String headerLine = br.readLine();

            if (headerLine == null ) return;
            
            String [] headers = headerLine.split(",");

            Map<String, Integer> columIndex = new HashMap<String, Integer>();

            for(int i = 0; i < headers.length; i++){
                columIndex.put(headers[i].trim(), i);
            }

            String line;
            while ((line = br.readLine()) != null) {
                String [] values = line.split(",");
                try{
                    Product p = new Product();
                    p.setSku(Integer.parseInt(values[columIndex.get("SKU")]));
                    p.setPrice_retail(Double.parseDouble(values[columIndex.get("PRICE_RETAIL")]));
                    p.setPrice_current(Double.parseDouble(values[columIndex.get("PRICE_CURRENT")]));
                    p.setName(values[columIndex.get("PRODUCT_NAME")]);
                    p.setCatagory(values[columIndex.get("CATEGORY")]);
                    productos.add(p);
                } catch (Exception e){
                    System.out.println("Error parsing line: " + line + " - " + e.getMessage());
                }
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
