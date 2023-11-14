package com.codegym.main;

import com.codegym.model.animal.Animal;
import com.codegym.model.person.enumerations.AgeCategory;
import com.codegym.model.person.enumerations.GenderPerson;
import com.codegym.model.person.visitors.Adult;
import com.codegym.model.person.visitors.Child;
import com.codegym.model.person.visitors.Senior;
import com.codegym.model.person.visitors.Visitor;
import com.codegym.model.ticket.*;
import com.codegym.service.AnimalService;
import com.codegym.service.CageService;
import com.codegym.service.EmployeeService;
import com.codegym.service.VisitorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VisitorFunction implements MainFunction {

    AnimalService animalService = AnimalService.getAnimalService();

    EmployeeService employeeService = EmployeeService.getEmployeeService();

    CageService cageService = CageService.getCageService();

    VisitorService visitorService = VisitorService.getVisitorService();

    @Override
    public void show() {
        System.out.println("=== MENU KHÁCH THAM QUAN ===");
        System.out.println("1. Đặt vé theo độ tuổi");
        System.out.println("2. Đặt tour hướng dẫn");
        System.out.println("3. Thoát về Menu chính");
        Scanner scanner = new Scanner(System.in);
        int inputMenuManagerCustomerSelected = scanner.nextInt();
        switch (inputMenuManagerCustomerSelected) {
            case 1:
                visitorService.addVisitor(getNewVisitor());
                showDetail();
                break;
            case 2:
                System.out.println("2. Đặt tour hướng dẫn");
                break;
            case 3:
                System.out.println("3. Thoát về Menu chính");
                return;
        }

    }



    public void showDetail() {
        while (true) {
            System.out.println("=== MENU KHÁCH THAM QUAN ===");
            System.out.println("1. Xem danh sách thú");
            System.out.println("2. Xem chi tiết thú");
            System.out.println("3. Thăm chuồng thú");
            System.out.println("4. Quay lại menu");
            Scanner scanner = new Scanner(System.in);
            int inputMenuManagerCustomerSelected = scanner.nextInt();
            switch (inputMenuManagerCustomerSelected) {
                case 1:
                    for (Animal animal : animalService.getAnimals()) {
                        System.out.println(animal);
                    }
                    break;
                case 2:
                    System.out.println("AnimalId ID: ");
                    int animalId = scanner.nextInt();
                    Animal animal = animalService.findById(animalId);
                    animal.play();
                    animal.move();
                    animal.makeSound();
                    animal.eat();
                    break;
                case 3:
                    cageService.getCages().stream().forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("4. Quay lại menu");
                    return;

            }
        }

    }


    public Visitor getNewVisitor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Thông tin khách thăm quan ===");

        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Street Address: ");
        String streetAddress = scanner.nextLine();
        System.out.println("City: ");
        String city = scanner.nextLine();
        System.out.println("Country: ");
        String country = scanner.nextLine();
        System.out.println("Gender Person in MALE, FEMALE, OTHER: ");
        GenderPerson gender = GenderPerson.valueOf(scanner.nextLine().toUpperCase());
        System.out.println("Age: ");
        int age;

        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Tuổi không hợp lệ. Hãy nhập lại.");
            return null;
        }

        System.out.println("Visitor ID: ");
        String visitorID = scanner.nextLine();
        System.out.println();

        AgeCategory ageCategory;

        if (age <= 12) {
            ageCategory = AgeCategory.CHILD;
        } else if (age <= 64) {
            ageCategory = AgeCategory.ADULT;
        } else {
            ageCategory = AgeCategory.SENIOR;
        }

        List<Ticket> tickets = new ArrayList<>();
        int choice=0;

        do {
            System.out.println("Chọn loại vé:");
            System.out.println("1. Vé trẻ em");
            System.out.println("2. Vé người lớn");
            System.out.println("3. Vé người già");
            System.out.println("Nhập lựa chọn (0 để kết thúc):");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                continue;
            }

            if (choice > 0 && choice <= 3) {
                System.out.println("Nhập số lượng vé:");

                try {
                    int quantity = Integer.parseInt(scanner.nextLine());
                    if (quantity < 0) {
                        System.out.println("Số lượng vé không hợp lệ. Vui lòng nhập lại.");
                        continue;
                    }

                    switch (choice) {
                        case 1:
                            tickets.add(FactoryTicket.getTicket(AgeCategory.CHILD, quantity));
                            break;
                        case 2:
                            tickets.add(FactoryTicket.getTicket(AgeCategory.ADULT, quantity));
                            break;
                        case 3:
                            tickets.add(FactoryTicket.getTicket(AgeCategory.SENIOR, quantity));
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Số lượng vé không hợp lệ. Vui lòng nhập lại.");
                    continue;
                }
            } else if (choice != 0) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 0);

        Visitor visitor = new Visitor(name, streetAddress, city, country, gender, age, visitorID, ageCategory);
        visitor.setTickets(tickets);

        return visitor;
    }


}
