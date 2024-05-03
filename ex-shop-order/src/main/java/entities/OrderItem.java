package entities;



public class OrderItem {
    private  Integer quantity;
    private Double price;

    public Product product = new Product();

    public OrderItem(Integer quantity, Double price, String name) {
        this.quantity = quantity;
        this.price = price;
        product.setName(name);
        product.setPrice(price);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void addQuantity(Integer quatity) {
        this.quantity += quatity;
    }
    public void removeQuantity(Integer quatity) {
        this.quantity -= quatity;
    }


    public Double subToltal(int quantity, double price){
        return quantity * price;
    }
}
