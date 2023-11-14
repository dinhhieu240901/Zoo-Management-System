package com.codegym.repository;

import com.codegym.model.Cage.Cage;
import com.codegym.model.animal.Animal;
import com.codegym.model.foodplan.FoodPlan;
import com.codegym.model.person.employee.Employee;

public class AnimalManagement {
    private AnimalRepository animalRepository;
    private Employee employee;

    public AnimalManagement(AnimalRepository animalRepository, Employee employee) {
        this.animalRepository = animalRepository;
        this.employee = employee;
    }

    public void addFoodPlan(int animalId, FoodPlan foodPlan) {
        Animal animal = animalRepository.findById(animalId);
        if (animal != null) {
            animal.setFoodPlan(foodPlan);
            System.out.println("Chế độ ăn mới đã được thêm cho " + animal.getName());
        } else {
            System.out.println("Không tìm thấy con vật. Vui lòng kiểm tra lại ID.");
        }
    }

    public void feedAnimalsInEnclosure(Cage cage) {
        employee.feedAnimalsEnclosure(cage);
    }

    public void cleanEnclosure(Cage cage) {
        System.out.println(employee.cleanEnclosure(cage));
    }
}
