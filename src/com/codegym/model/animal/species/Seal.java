package com.codegym.model.animal.species;

import com.codegym.model.animal.Animal;
import com.codegym.model.animal.enumerations.HealAnimals;
import com.codegym.model.animal.enumerations.GenderAnimals;
import com.codegym.model.animal.interfaces.AnimalActions;
import com.codegym.model.animal.interfaces.AquaticAnimal;
import com.codegym.model.animal.interfaces.Mammal;
import com.codegym.model.foodplan.FoodPlan;

public class Seal extends Animal implements  AquaticAnimal, Mammal {
    public Seal(int id, String name, String species, double weight, double size, int age, HealAnimals heal, GenderAnimals gender, FoodPlan foodPlan,String cageId) {
        super(id, name, species, weight, size, age, heal, gender,"Seal",foodPlan,cageId);
    }

    @Override
    public String feed() {
        return "Nhân viên cho hải cẩu ăn cá.";
    }

    @Override
    public String clean() {
        return "Nhân viên làm sạch bể cá của hải cẩu.";
    }

    @Override
    public String play() {
        return "Hải cẩu nhảy và chơi đùa trong bể cá của chúng.";
    }

    @Override
    public String makeSound() {
        return "Hải cẩu tạo ra tiếng sủa, sủa!";
    }

    @Override
    public String move() {
        return "Hải cẩu bơi quanh trong bể cá của chúng.";
    }

    @Override
    public String eat() {
        return "Hải cẩu ăn cá từ trong nước";
    }

    @Override
    public String swim() {
        return "Hải cẩu đang bơi vui vẻ!";
    }

    @Override
    public String feedMilk() {
        return "Hải cẩu đang cho con bú sữa";
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String getSpecies() {
        return "Hải cẩu";
    }
}
