package entities;

import entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private LocalDateTime moment;
    private OrderStatus status;
    private List<OrderItem> items = new ArrayList<>();
    private Client client;

    public Order(){}

    public Order(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Order summary:\n");
        sb.append("Moment: " + getMoment().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n");
        sb.append("Status: " + getStatus() + "\n");
        sb.append("Client: " + getClient().toString() + "\n");
        sb.append("Itens: \n");
        for (OrderItem i: getItems()) {
            sb.append(i + "\n");
        }
        sb.append("Total price: $" + String.format("%.2f", total()));
        return sb.toString();
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Client getClient() {
        return client;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }

    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public double total(){
        double sum = 0;

        for (OrderItem i: items) {
            sum += i.subTotal();
        }
        return sum;
    }
}
