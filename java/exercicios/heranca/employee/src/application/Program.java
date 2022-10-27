package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();

        for (int i=0; i<n; i++) {

            System.out.println("Employee #" + (i+1) + " data:");
            System.out.print("Outsourced (y/n)? ");
            char aux = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            if (aux == 'y') {
                System.out.print("Additional charge: ");
                double addtionalCharge = sc.nextDouble();

                Employee outsourcedEmployee = new OutsourcedEmployee(name, hours, valuePerHour, addtionalCharge);
                employees.add(outsourcedEmployee);
            } else {
                Employee employee = new Employee(name, hours, valuePerHour);
                employees.add(employee);
            }
        }

        System.out.println("PAYMEMTS:");
        for (Employee c : employees) {
            System.out.println(c.getName() + " - $ " + c.payment());
        }

        sc.close();
    }
}
