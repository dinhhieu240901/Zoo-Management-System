package com.codegym.model.animal.species;

import com.codegym.model.animal.Animal;
import com.codegym.model.animal.enumerations.HealAnimals;
import com.codegym.model.animal.enumerations.GenderAnimals;
import com.codegym.model.animal.interfaces.AnimalActions;
import com.codegym.model.animal.interfaces.TerrestrialAnimal;
import com.codegym.model.foodplan.FoodPlan;

public class Lion extends Animal implements  TerrestrialAnimal {

    public Lion(int id, String name, String species, double weight, double size, int age, HealAnimals heal, GenderAnimals gender, FoodPlan foodPlan,String cageId) {
        super(id, name, species, weight, size, age, heal, gender,"Lion",foodPlan,cageId);
    }

    @Override
    public String feed() {
        return "Nhân viên cho sư tử ăn thịt.";

    }
    @Override
    public String clean() {
        return "Nhân viên làm sạch mặt đất và nước cho sư tử.";
    }
    @Override
    public String play() {
        return "Khách tham quan chơi bằng cách chọc tức sư tử trong chuồng.";
    }

    @Override
    public String makeSound() {
        return "Sư tử gầm lên.";
    }

    @Override
    public String move() {
        return "Sư tử chạy quanh bên trong chuồng.";
    }
    @Override
    public String eat() {
        return "Sư tử ăn thịt và các loài động vật khác.";
    }
    @Override
    public String walk() {
        return "Sư tử đi dạo trong chuồng.";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
