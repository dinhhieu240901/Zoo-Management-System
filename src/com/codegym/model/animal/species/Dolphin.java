package com.codegym.model.animal.species;

import com.codegym.model.animal.Animal;
import com.codegym.model.animal.enumerations.HealAnimals;
import com.codegym.model.animal.enumerations.GenderAnimals;
import com.codegym.model.animal.interfaces.AnimalActions;
import com.codegym.model.animal.interfaces.AquaticAnimal;
import com.codegym.model.foodplan.FoodPlan;

import java.io.Serializable;

public class Dolphin extends Animal implements  AquaticAnimal, Serializable {
    public Dolphin(int id, String name, String species, double weight, double size, int age, HealAnimals heal, GenderAnimals gender, FoodPlan foodPlan,String cageId) {
        super(id, name, species, weight, size, age, heal, gender,"Dolphin",foodPlan,cageId);
    }


    @Override
    public String feed() {
        return "Nhân viên cho cá heo ăn cá.";
    }

    @Override
    public String clean() {
        return "Nhân viên làm sạch bể cá của cá heo.";
    }

    @Override
    public String play() {
        return "Cá heo nhảy và chơi quanh trong bể cá của nó.";
    }

    @Override
    public String makeSound() {
        return "Cá heo kêu tiếng hòa, hòa!";
    }

    @Override
    public String move() {
        return "Cá heo bơi quanh trong bể cá của nó.";
    }

    @Override
    public String eat() {
        return "Cá heo ăn cá từ trong nước.";
    }

    @Override
    public String swim() {
        return "Cá heo đang bơi vui vẻ!";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
