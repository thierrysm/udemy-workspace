package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);

        List<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i=0; i<n; i++) {
            System.out.println("Product #" + (i+1) + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char productType = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            double price = sc.nextDouble();

            if (productType == 'i') {
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();

                Product importedProduct = new ImportedProduct(name, price, customsFee);
                products.add(importedProduct);
            } else if (productType == 'u') {
                System.out.print("Manufacture date: ");
                LocalDate date = LocalDate.parse(sc.next(), dtf1);

                Product usedProduct = new UsedProduct(name, price, date);
                products.add(usedProduct);
            } else {
                Product product = new Product(name, price);

                products.add(product);
            }
        }

        System.out.println("PRICE TAGS:");
        for (Product c : products) {
            System.out.println(c.priceTag());
        }
        sc.close();
    }
}
