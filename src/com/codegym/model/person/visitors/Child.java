package com.codegym.model.person.visitors;

import com.codegym.model.person.Person;
import com.codegym.model.person.enumerations.AgeCategory;
import com.codegym.model.person.enumerations.GenderPerson;
import com.codegym.model.ticket.ChildTicket;

public class Child extends Visitor {
    private ChildTicket childTicket;

    public Child(String name, String streetAddress, String city, String country, GenderPerson gender, int age, String visitorID, AgeCategory ageCategory, ChildTicket childTicket) {
        super(name, streetAddress, city, country, gender, age, visitorID, ageCategory);
        this.childTicket = childTicket;
    }

    public ChildTicket getChildTicket() {
        return childTicket;
    }

    public void setChildTicket(ChildTicket childTicket) {
        this.childTicket = childTicket;
    }

    @Override
    public String toString() {
        return super.toString() + childTicket;
    }
}
