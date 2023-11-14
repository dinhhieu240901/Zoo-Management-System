package com.codegym.service;

import com.codegym.model.animal.Animal;
import com.codegym.model.foodplan.FoodPlan;
import com.codegym.repository.AnimalRepository;

import java.util.List;

public class AnimalService {

    private static AnimalService animalService;

    private AnimalService() {

    }

    public static AnimalService getAnimalService(){
        if (animalService == null){
            animalService = new AnimalService();
        }
        return animalService;
    }





    private AnimalRepository animalRepository = AnimalRepository.getAnimalRepository();
    public  List<Animal> getAnimals(){
        return animalRepository.getAllAnimals();
    }

    public Animal findById(int animalId){
        return animalRepository.findById(animalId);
    }
    public  List<Animal> findByName(String animalName){
        return animalRepository.findByName(animalName);
    }

    public void addAnimal(Animal animal) {
        animalRepository.addAnimal(animal);
    }
    public void updateAnimal(Animal animal) {
        animalRepository.updateAnimal(animal);
    }

    public void removeAnimal(int animalId) {
        animalRepository.removeAnimal(animalId);
    }

    public void addFoodPlan(int animalId, FoodPlan foodPlan) {
        Animal animal = animalRepository.findById(animalId);
        if (animal != null) {
            animal.setFoodPlan(foodPlan);
            animalRepository.updateFileCSV();
            System.out.println("Chế độ ăn mới đã được thêm cho " + animal.getName());
        } else {
            System.out.println("Không tìm thấy con vật. Vui lòng kiểm tra lại ID.");
        }
    }




}
