package com.codegym.model.person.employee;

import com.codegym.model.person.Person;
import com.codegym.model.person.enumerations.GenderPerson;

public class  Owner extends Employee {

    public Owner(String name, String streetAddress, String city, String country, GenderPerson gender, int age, String employeeId, String jobPosition, double salary,String username, String password) {
        super(name, streetAddress, city, country, gender, age, employeeId, jobPosition, salary,"Owner", username,password);

    }

}