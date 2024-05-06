package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {
    private Date manufactureDate ;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public UsedProduct(String name, Double price, Date manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag(){
        return (name + " (Used) $ " + price + " (Manufacture date : " + sdf.format(manufactureDate) + ")") ;
    }
}
