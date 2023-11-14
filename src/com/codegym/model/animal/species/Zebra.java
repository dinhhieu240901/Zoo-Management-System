package com.codegym.model.animal.species;

import com.codegym.model.animal.Animal;
import com.codegym.model.animal.enumerations.HealAnimals;
import com.codegym.model.animal.enumerations.GenderAnimals;
import com.codegym.model.animal.interfaces.AnimalActions;
import com.codegym.model.animal.interfaces.Mammal;
import com.codegym.model.animal.interfaces.TerrestrialAnimal;
import com.codegym.model.foodplan.FoodPlan;

public class Zebra extends Animal implements  Mammal, TerrestrialAnimal {
    public Zebra(int id, String name, String species, double weight, double size, int age, HealAnimals heal, GenderAnimals gender, FoodPlan foodPlan,String cageId) {
        super(id, name, species, weight, size, age, heal, gender,"Zebra",foodPlan,cageId);
    }

    @Override
    public String feed() {
        return "Nhân viên cho ngựa vằn ăn cỏ và rơm.";
    }

    @Override
    public String clean() {
        return "Nhân viên làm sạch chuồng ngựa vằn.";
    }

    @Override
    public String play() {
        return "Ngựa vằn chạy và nhảy nhót trong chuồng của chúng.";
    }

    @Override
    public String makeSound() {
        return "Ngựa vằn phát ra âm thanh đặc biệt.";
    }

    @Override
    public String move() {
        return "Ngựa vằn đi bộ và đôi khi chạy quanh trong chuồng.";
    }

    @Override
    public String eat() {
        return "Ngựa vằn ăn cỏ và thảo mộc từ mặt đất.";
    }

    @Override
    public String feedMilk() {
        return "Ngựa vằn mẹ cho con bú sữa.";
    }

    @Override
    public String walk() {
        return "Ngựa vằn có thể đi bằng bốn chân.";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
