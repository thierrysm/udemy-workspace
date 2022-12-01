package model.services;

import model.entities.CarRental;

import java.time.Duration;

public class Rental {

    private Double pricePerDay;
    private Double pricePerHour;

    public Rental(Double pricePerDay, Double pricePerHour) {
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
    }

    public Double serviceInvoice(CarRental cr) {
        double minutes = Duration.between(cr.getStart(), cr.getFinish()).toMinutes();
        double hours = minutes/60;

        if (Math.ceil(hours) <= 12) {
            return pricePerHour * cr.getInvoice().getTax();
        }
        else {
            return pricePerDay * cr.getInvoice().getTax();
        }
    }
}
