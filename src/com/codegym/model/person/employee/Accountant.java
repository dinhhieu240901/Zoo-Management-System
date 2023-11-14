package com.codegym.model.person.employee;

import com.codegym.model.person.enumerations.GenderPerson;
import com.codegym.model.ticket.Ticket;
import java.util.List;

public class Accountant extends Employee {
    private double totalRevenue;

    public Accountant(String name, String streetAddress, String city, String country, GenderPerson gender, int age, String employeeId, String jobPosition, double salary,String username, String password) {
        super(name, streetAddress, city, country, gender, age, employeeId, jobPosition, salary,"Accountant",username,password);
        this.totalRevenue = 0.0;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public void recordRevenue(List<Ticket> soldTickets) {
        double revenue = 0.0;
        for (Ticket ticket : soldTickets) {
            revenue += ticket.getPrice();
        }
        totalRevenue += revenue;
    }

    public void displayTotalRevenue() {
        System.out.println("Tổng doanh thu hiện tại: " + totalRevenue);
    }
}
