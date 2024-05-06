package entities;

public class ImportProduct extends Product {
    private Double customsFee;

    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }

    public ImportProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    @Override
    public  String priceTag(){
        return (name + " $ " + (price + customsFee) + " (Custom fee: $ " + customsFee + ")");
    }
    public Double totalPrice(){
        return  price += customsFee;
    }
}
