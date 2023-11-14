package com.codegym.model.animal.species;

import com.codegym.model.animal.Animal;
import com.codegym.model.animal.enumerations.HealAnimals;
import com.codegym.model.animal.enumerations.GenderAnimals;
import com.codegym.model.animal.interfaces.*;
import com.codegym.model.foodplan.FoodPlan;

public class Panda extends Animal implements Mammal, TerrestrialAnimal {
    public Panda(int id, String name, String species, double weight, double size, int age, HealAnimals heal, GenderAnimals gender, FoodPlan foodPlan,String cageId) {
        super(id, name, species, weight, size, age, heal, gender,"Panda",foodPlan,cageId);
    }

    @Override
    public String feed() {
        return "Nhân viên cho gấu trúc ăn tre.";
    }

    @Override
    public String clean() {
        return "Nhân viên làm sạch chuồng của gấu trúc.";
    }

    @Override
    public String play() {
        return "Gấu trúc leo trèo và chơi đùa trong chuồng của chúng.";
    }

    @Override
    public String makeSound() {
        return "Gấu trúc tạo ra những âm thanh đặc biệt";
    }

    @Override
    public String move() {
        return "Gấu trúc đi dạo trong chuồng của chúng.";
    }

    @Override
    public String eat() {
        return "Gấu trúc ăn tre từ mặt đất";
    }

    @Override
    public String feedMilk() {
        return "Mẹ gấu trúc cho con bú sữa.";
    }

    @Override
    public String walk() {
        return "Gấu trúc có thể đi bằng bốn chân.";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
