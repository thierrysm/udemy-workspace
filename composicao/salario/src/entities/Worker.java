package entities;

import entities.entities.WorkerLevel;

import java.util.ArrayList;
import java.util.List;

public class Worker {

    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    private Department department;

    private List<HourContract> contracts = new ArrayList<>();

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
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

    public List<HourContract> getContracts() {
        return contracts;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void addContract (HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract (HourContract contract) {
        contracts.remove(contract);
    }

    public double income (Integer month, Integer year) {
        int soma = 0;
        for (HourContract c : contracts) {
            if (c.getLocalDate().getYear()== year && c.getLocalDate().getMonthValue() == month) {
                soma += c.totalValue();
            }
        }
        return soma + baseSalary;
    }
}
