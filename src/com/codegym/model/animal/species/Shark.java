package com.codegym.model.animal.species;

import com.codegym.model.animal.Animal;
import com.codegym.model.animal.enumerations.HealAnimals;
import com.codegym.model.animal.enumerations.GenderAnimals;
import com.codegym.model.animal.interfaces.AnimalActions;
import com.codegym.model.animal.interfaces.AquaticAnimal;
import com.codegym.model.foodplan.FoodPlan;

public class Shark extends Animal implements  AquaticAnimal {

    public Shark(int id, String name, String species, double weight, double size, int age, HealAnimals heal, GenderAnimals gender, FoodPlan foodPlan,String cageId) {
        super(id, name, species, weight, size, age, heal, gender,"Shark",foodPlan,cageId);
    }

    @Override
    public String feed() {
        return "Nhân viên cho cá mập ăn cá và thịt.";
    }

    @Override
    public String clean() {
        return "Nhân viên làm sạch bể cá cho cá mập.";
    }

    @Override
    public String play() {
        return "Cá mập bơi quanh trong bể cá của chúng.";
    }

    @Override
    public String makeSound() {
        return "Cá mập không tạo ra âm thanh nghe thấy được đối với con người.";
    }

    @Override
    public String move() {
        return "Cá mập bơi trong nước.";
    }

    @Override
    public String eat() {
        return "Cá mập ăn cá và thịt.";
    }

    @Override
    public String swim() {
        return "Cá mập bơi nhanh và mạnh mẽ.";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
