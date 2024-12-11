package entities;

import java.time.LocalDate;

public class HourContract {

    private LocalDate date;
    private Double valuePerHour;
    private Integer hour;

    public HourContract(){}
    public HourContract(LocalDate date, Double valuePerHour, Integer hour) {
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hour = hour;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public Integer getHours() {
        return hour;
    }

    public void setHours(Integer hours) {
        this.hour = hours;
    }

    @Override
    public String toString() {
        return "HourContract{" +
                "date=" + date +
                ", valuePerHour=" + valuePerHour +
                ", hours=" + hour +
                '}';
    }

    public double totalValue(){
        return hour * valuePerHour;
    }
}
