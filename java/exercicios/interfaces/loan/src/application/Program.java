package application;

import servicies.BrazilInterestService;
import servicies.InterestService;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Amount: ");
        double amount = sc.nextDouble();
        System.out.print("Months: ");
        int months = sc.nextInt();

        InterestService is = new BrazilInterestService();
        double payment = is.payment(amount, months);

        System.out.println("Payment after 3 months:");
        System.out.println(String.format("%.2f", payment));

        sc.close();
    }
}
