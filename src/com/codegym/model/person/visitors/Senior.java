package com.codegym.model.person.visitors;

import com.codegym.model.person.Person;
import com.codegym.model.person.enumerations.AgeCategory;
import com.codegym.model.person.enumerations.GenderPerson;
import com.codegym.model.ticket.SeniorTicket;

public class Senior extends Visitor {
    private SeniorTicket seniorTicket;

    public Senior(String name, String streetAddress, String city, String country, GenderPerson gender, int age, String visitorID, AgeCategory ageCategory, SeniorTicket seniorTicket) {
        super(name, streetAddress, city, country, gender, age, visitorID, ageCategory);
        this.seniorTicket = seniorTicket;
    }

    public SeniorTicket getSeniorTicket() {
        return seniorTicket;
    }

    public void setSeniorTicket(SeniorTicket seniorTicket) {
        this.seniorTicket = seniorTicket;
    }

    @Override
    public String toString() {
        return super.toString() + seniorTicket;
    }
}
