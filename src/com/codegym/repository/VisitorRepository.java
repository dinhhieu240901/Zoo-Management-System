package com.codegym.repository;

import com.codegym.model.person.enumerations.AgeCategory;
import com.codegym.model.person.visitors.Visitor;
import com.codegym.serializer.ReadCustomerSerializer;

import java.util.ArrayList;
import java.util.List;

public class VisitorRepository {

    private List<Visitor> visitors;
    private ReadCustomerSerializer readCustomerSerializer;

    private static VisitorRepository visitorRepository;

    private VisitorRepository() {
        this.visitors = new ArrayList<>();
        this.readCustomerSerializer = ReadCustomerSerializer.getInstanceReadCustomerSerializer();
        loadVisitorsFromCSV();  // Thêm phương thức để load dữ liệu từ file CSV khi khởi tạo
    }

    public static VisitorRepository getVisitorRepository() {
        if (visitorRepository == null) {
            visitorRepository = new VisitorRepository();
        }
        return visitorRepository;
    }

    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
        updateFileCSV();
    }

    public List<Visitor> findVisitorsByAgeCategory(AgeCategory ageCategory) {
        List<Visitor> matchingVisitors = new ArrayList<>();
        for (Visitor visitor : visitors) {
            if (visitor.getAgeCategory() == ageCategory) {
                matchingVisitors.add(visitor);
            }
        }
        return matchingVisitors;
    }

    public List<Visitor> getAllVisitors() {
        return visitors;
    }

    public void updateVisitor(Visitor updatedVisitor) {
        for (int i = 0; i < visitors.size(); i++) {
            if (visitors.get(i).getVisitorID().equals(updatedVisitor.getVisitorID())) {
                visitors.set(i, updatedVisitor);
                updateFileCSV();
                return;
            }
        }
    }

    private void updateFileCSV() {
        readCustomerSerializer.writeToCSV(visitors);
    }

    private void loadVisitorsFromCSV() {
        visitors = readCustomerSerializer.readFromCSV();
    }
}
