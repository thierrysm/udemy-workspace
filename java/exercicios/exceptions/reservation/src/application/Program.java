package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);
        try {
                System.out.print("Room number: ");
                int roomNumber = sc.nextInt();
                System.out.print("Check-in date (dd/MM/yyyy): ");
                LocalDate checkIn = LocalDate.parse(sc.next(), dtf1);
                System.out.print("Check-out date (dd/MM/yyyy):");
                LocalDate checkOut = LocalDate.parse(sc.next(), dtf1);

                Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
                System.out.println(reservation);

                System.out.println();
                System.out.println("Enter data to update the reservation:");
                System.out.print("Check-in date (dd/MM/yyyy): ");
                checkIn = LocalDate.parse(sc.next(), dtf1);
                System.out.print("Check-out date (dd/MM/yyyy):");
                checkOut = LocalDate.parse(sc.next(), dtf1);

                reservation.updateDates(checkIn, checkOut);
                System.out.println(reservation);

        }
        catch (DomainException e ) {
            System.out.println(e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }
        finally {
            sc.close();
        }
    }
}
