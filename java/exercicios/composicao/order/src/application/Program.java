package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        //sc.nextLine();
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        LocalDate birthDate = LocalDate.parse(sc.next(), dtf1);
        Client client = new Client(name, email, birthDate);

        System.out.print("Enter order data: ");
        System.out.print("Status: ");
        String orderData = sc.next();
        Order order = new Order(LocalDateTime.now(), OrderStatus.valueOf(orderData), client);

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        for (int i=0; i<n; i++) {
            System.out.println("Enter #" + (i+1) + " item data:");
            System.out.print("Product name: ");
            String nameProduct = sc.next();
            System.out.print("Product price: ");
            double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            Product product = new Product(nameProduct, price);
            OrderItem orderItem = new OrderItem(quantity, price, product);

            order.addItem(orderItem);
        }

        System.out.println("ORDER SUMMARY");
        System.out.println(order);
    }
}
