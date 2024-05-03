package entities;


import enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Order {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
    private Date moment;
    private OrderStatus status;
    private Client client;

    public Order() {

    }

    private List<OrderItem> orderItems = new ArrayList<>();

    public Order(Client client, Date moment, OrderStatus status) {
        this.client = client;
        this.moment = moment;
        this.status = status;
    }

    public Order(OrderStatus status, Date moment, Client client) {
        this.status = status;
        this.client = client;
        this.moment = moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public Date getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(OrderItem orderItem){
        orderItems.add(orderItem);
    }
    public void removeItem(OrderItem orderItem){
        orderItems.remove(orderItem);
    }



    public String toString() {
        double total = 0.0;
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ");
        sb.append(sdf.format(moment)).append("\n");
        sb.append("Order status: ");
        sb.append(status).append("\n");
        sb.append("Client: ").append(client.getName());
        sb.append(" ").append(sdf2.format(client.getBirthDay())).append(" - ");
        sb.append(client.getEmail()).append("\n");
        sb.append("Order items: " + "\n");
        for (OrderItem item: orderItems){
                sb.append(item.product.getName()).append(", ");
                sb.append(item.product.getPrice()).append(", ");
                sb.append("Quantity: ").append(item.getQuantity());
                sb.append(", subtotal: ");
                sb.append(item.subToltal(item.getQuantity(), item.product.getPrice())).append("\n");
                total += item.subToltal(item.getQuantity(), item.product.getPrice());
        }
        sb.append("subtotal price: ");
        sb.append(total);

        return sb.toString();
    }
}
