package entities;

import entities.enums.WorkerLevel;
import java.util.List;
import java.util.ArrayList;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    private Departament department;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker(){
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Departament department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Departament getDepartment() {
        return department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }


    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", baseSalary=" + baseSalary +
                ", department=" + department +
                '}';
    }

    public void addContract(HourContract contract){
        contracts.add(contract);
    }

    public void removeContract(HourContract contract){
        contracts.remove(contract);
    }

    public double income(int year, int month){
        double sum = baseSalary;


        for (HourContract c : contracts) {
            int c_year = c.getDate().getYear();
            int c_month = c.getDate().getMonthValue();

            if (c_year == year && c_month == month) {
                sum += c.totalValue();
            }
        }
        return sum;
    }

}
