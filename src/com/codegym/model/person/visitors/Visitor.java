package com.codegym.model.person.visitors;

import com.codegym.model.person.Person;
import com.codegym.model.person.enumerations.AgeCategory;
import com.codegym.model.person.enumerations.GenderPerson;
import com.codegym.model.ticket.Ticket;

import java.util.ArrayList;
import java.util.List;

public class Visitor extends Person {
    private String visitorID;
    private AgeCategory ageCategory;
    private List<Ticket> tickets;
    private double totalPrices;

    public Visitor(String name, String streetAddress, String city, String country, GenderPerson gender, int age, String visitorID, AgeCategory ageCategory) {
        super(name, streetAddress, city, country, gender, age);
        this.visitorID = visitorID;
        this.ageCategory = ageCategory;
        this.tickets = new ArrayList<>();
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(AgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }

    public double getTotalPrices() {
        return totalPrices;
    }

    public void setTotalPrices(double totalPrices) {
        this.totalPrices = totalPrices;
    }

    public String getVisitorID() {
        return visitorID;
    }

    public void setVisitorID(String visitorID) {
        this.visitorID = visitorID;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Ticket ticket : tickets) {
            totalPrice += ticket.getPrice();
        }
        setTotalPrices(totalPrice);
        return totalPrice;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }
    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + getName() + '\'' +
                ", streetAddress='" + getStreetAddress() + '\'' +
                ", city='" + getCity() + '\'' +
                ", country='" + getCountry() + '\'' +
                ", gender=" + getGender() +
                ", age=" + getAge() +
                ", visitorID=" + visitorID +
                ", ageCategory=" + ageCategory +
                '}';
    }
}
