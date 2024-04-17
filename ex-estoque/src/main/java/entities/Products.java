package entities;

public class Products {
    public String name;
    public double price;
    public int quantity ;



    public double totalValueInStock (){
        return price * quantity;
    }

    public void addProducts( int addQuantity ){
        quantity += addQuantity;
    }

    public void removeProducts( int removeQuantity ){
        quantity -= removeQuantity;
    }
    public String toString(){
        return  name
                + ", $ "
                + price + ", "
                + quantity
                + " units, Total: $ " + totalValueInStock();
    }
}
