package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.entities.WorkerLevel;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        DateTimeFormatter dtfm1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter department's name: ");
        String departmentName = sc.next();
        System.out.println("Enter worker data :");
        System.out.print("Name ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.print("Level ");
        String level = sc.next();
        System.out.print("Base salary ");
        Double baseSalary = sc.nextDouble();

        Worker worker = new Worker (name, WorkerLevel.valueOf(level), baseSalary, new Department(departmentName));

        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();

        for (int i=0; i<n; i++) {
            System.out.println("Enter contract #" + (i+1) + " data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            String date = sc.next();
            System.out.print("Value per hour: ");
            Double valuePorHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            Integer hours = sc.nextInt();

            HourContract hourContract = new HourContract(valuePorHour, hours, LocalDate.parse(date, dtfm1));
            worker.addContract(hourContract);
        }

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String date = sc.next();

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        int month = Integer.parseInt(date.substring(0,2));
        int year = Integer.parseInt(date.substring(3));
        System.out.println("Income for: " + date + ": " + worker.income(month, year));

        sc.close();
    }
}
