package entities;

import java.time.LocalDate;
import java.util.Date;

public class HourContract {

    private LocalDate date;
    private Double valuePorHour;
    private Integer hours;

    public HourContract(Double valuePorHour, Integer hours, LocalDate date) {
        this.valuePorHour = valuePorHour;
        this.hours = hours;
        this.date = date;
    }

    public LocalDate getLocalDate() {
        return date;
    }

    public void setLocalDate(LocalDate date) {
        this.date = date;
    }

    public Double getValuePorHour() {
        return valuePorHour;
    }

    public void setValuePorHour(Double valuePorHour) {
        this.valuePorHour = valuePorHour;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public double totalValue () {
        return valuePorHour * hours;
    }
}
