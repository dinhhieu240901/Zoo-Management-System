package com.codegym.model.animal.species;

import com.codegym.model.animal.Animal;
import com.codegym.model.animal.enumerations.HealAnimals;
import com.codegym.model.animal.enumerations.GenderAnimals;
import com.codegym.model.animal.interfaces.AnimalActions;
import com.codegym.model.animal.interfaces.Mammal;
import com.codegym.model.animal.interfaces.TerrestrialAnimal;
import com.codegym.model.foodplan.FoodPlan;

public class Elephant extends Animal implements  TerrestrialAnimal, Mammal {
    public Elephant(int id, String name, String species, double weight, double size, int age, HealAnimals heal, GenderAnimals gender, FoodPlan foodPlan,String cageId) {
        super(id, name, species, weight, size, age, heal, gender,"Elephant",foodPlan,cageId);
    }

    @Override
    public String feed() {
        return "Nhân viên cho voi ăn cỏ và rau.";
    }

    @Override
    public String clean() {
        return "Nhân viên làm sạch chuồng cho voi.";
    }

    @Override
    public String play() {
        return "Voi chơi với nước và bùn trong chuồng của chúng.";
    }

    @Override
    public String makeSound() {
        return "Voi phát ra tiếng kêu ồn ào.";
    }

    @Override
    public String move() {
        return "Voi đi bộ và đôi khi chạy quanh trong chuồng của chúng.";
    }

    @Override
    public String eat() {
        return "Voi ăn nhiều loại cây và rau cải.";
    }

    @Override
    public String walk() {
        return "Voi đi dạo trong chuồng của chúng.";
    }

    @Override
    public String feedMilk() {
        return "Mẹ voi cho con bú sữa.";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
