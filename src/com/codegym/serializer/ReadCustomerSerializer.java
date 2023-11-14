package com.codegym.serializer;

import com.codegym.model.person.enumerations.GenderPerson;

import com.codegym.model.person.visitors.Visitor;
import com.codegym.model.ticket.AdultTicket;
import com.codegym.model.ticket.ChildTicket;
import com.codegym.model.ticket.SeniorTicket;
import com.codegym.model.ticket.Ticket;
import com.codegym.model.person.enumerations.AgeCategory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadCustomerSerializer {

    private static ReadCustomerSerializer readCustomerSerializer;

    public static ReadCustomerSerializer getInstanceReadCustomerSerializer() {
        if (readCustomerSerializer == null) {
            readCustomerSerializer = new ReadCustomerSerializer();
        }
        return readCustomerSerializer;
    }

    private ReadCustomerSerializer() {
    }
    public void writeToCSV(List<Visitor> objects) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Zoo-system/visitor.csv"))) {
            writer.println("Name,Street,City,Country,Gender,Age,Visitor ID,Age Category");
            for (Visitor obj : objects) {

                writer.println(String.join(",",
                        obj.getName(),
                        obj.getStreetAddress(),
                        obj.getCity(),
                        obj.getCountry(),
                        obj.getGender().toString(),
                        String.valueOf(obj.getAge()),
                        obj.getVisitorID(),
                        obj.getAgeCategory().toString())
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Visitor> readFromCSV() {
        List<Visitor> loadedObjects = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Zoo-system/visitor.csv"))) {
            String line;
            boolean skipHeader = false;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length > 0 && skipHeader) {
                    String name = data[0];
                    String streetAddress = data[1];
                    String city = data[2];
                    String country = data[3];
                    GenderPerson gender = GenderPerson.valueOf(data[4]);
                    int age = Integer.parseInt(data[5]);
                    String visitorId = data[6];
                    AgeCategory ageCategory = AgeCategory.valueOf(data[7]);
                    double totalPrices = Double.parseDouble(data[8]);

                    Ticket ticket;
                    if (ageCategory == AgeCategory.CHILD) {
                        ticket = new ChildTicket();
                    } else if (ageCategory == AgeCategory.ADULT) {
                        ticket = new AdultTicket();
                    } else {
                        ticket = new SeniorTicket();
                    }

                    Visitor visitor = new Visitor(name, streetAddress, city, country, gender, age, visitorId, ageCategory);
                    visitor.addTicket(ticket);
                    visitor.setTotalPrices(totalPrices); // Set giá trị totalPrices cho Visitor

                    loadedObjects.add(visitor);
                }
                skipHeader = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loadedObjects;
    }
}
