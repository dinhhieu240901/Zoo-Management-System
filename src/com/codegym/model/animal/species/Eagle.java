package com.codegym.model.animal.species;

import com.codegym.model.animal.Animal;
import com.codegym.model.animal.enumerations.HealAnimals;
import com.codegym.model.animal.enumerations.GenderAnimals;
import com.codegym.model.animal.interfaces.*;
import com.codegym.model.foodplan.FoodPlan;

public class Eagle extends Animal implements FlyingAnimal {
    public Eagle(int id, String name,String  species, double weight, double size, int age, HealAnimals heal, GenderAnimals gender, FoodPlan foodPlan,String cageId) {
        super(id, name, species, weight, size, age, heal, gender,"Eagle",foodPlan,cageId);
    }

    @Override
    public String feed() {
        return "Nhân viên cho đại bàng ăn thịt.";
    }

    @Override
    public String clean() {
        return "Nhân viên làm sạch chuồng cho đại bàng.";
    }

    @Override
    public String play() {
        return "Đại bàng bay quanh chuồng của chúng.";
    }

    @Override
    public String makeSound() {
        return "Đại bàng phát ra tiếng kêu ồn ào.";
    }

    @Override
    public String move() {
        return "Đại bàng bay trong chuồng của chúng.";
    }

    @Override
    public String eat() {
        return "Đại bàng ăn thịt.";
    }

    @Override
    public String fly() {
        return "Đại bàng bay cao và duyên dáng.";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
