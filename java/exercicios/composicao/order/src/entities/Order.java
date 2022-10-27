package entities;

import entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {

    static DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");

    private LocalDateTime moment;
    private OrderStatus status;
    private Client client;

    private List<OrderItem> items = new ArrayList<>();

    public Order(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem (OrderItem item) {
        items.add(item);
    }

    public void removeItem (OrderItem item) {
        items.remove(item);
    }

    public double total () {
        int sum = 0;
        for (OrderItem c : items) {
            sum += c.subTotal();
        }
        return sum;
    }

    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: " + dtf2.format(getMoment()));
        sb.append("\nOrder status: " + getStatus());
        sb.append("\nCLient: " + getClient().getName());
        sb.append(" (" + dtf1.format(getClient().getBirthDate()) + ") ");
        sb.append(" - " + getClient().getEmail());
        sb.append("\nOrder items");
        double sum = 0;
        for (OrderItem c : items) {
            sb.append("\n" + c);
            sum += c.subTotal();
        }
        //sb.append("Total price: $");
        //sb.append(String.format("%.2f", total()));
        sb.append("Total price: ");
        sb.append(String.format("%.2f", sum));
        return  sb.toString();
    }

}
