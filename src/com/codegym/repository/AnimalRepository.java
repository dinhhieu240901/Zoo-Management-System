package com.codegym.repository;

import com.codegym.model.animal.Animal;
import com.codegym.serializer.ReadAnimalSerializer;
import com.codegym.service.CageService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalRepository {
    ReadAnimalSerializer readAnimalSerializer=    ReadAnimalSerializer.getInstanceReadAnimalSerializer();

    private static AnimalRepository animalRepository = null;

    private List<Animal> animals;

    private AnimalRepository() {
        List<Animal> animalList = readAnimalSerializer.readFromCSV();
        animalList.stream().forEach(System.out::println);
        animals = readAnimalSerializer.readFromCSV();

    }

    public static AnimalRepository getAnimalRepository(){

        if (animalRepository == null){
            System.out.println("test");
            animalRepository = new AnimalRepository();
        }
        return animalRepository;
    }



    public void addAnimal(Animal animal) {
        animals.add(animal);
        updateFileCSV();
    }

    public void removeAnimal(int animalId) {
        animals.removeIf(animal -> animal.getId() == animalId);
        updateFileCSV();
    }

    public Animal findById(int animalId) {
        for (Animal animal : animals) {
            if (animal.getId() == animalId) {
                return animal;
            }
        }
        return null;
    }

    public List<Animal> findByName(String name) {
        List<Animal> foundAnimals = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                foundAnimals.add(animal);
            }
        }
        return foundAnimals;
    }

    public List<Animal> findByCageId(String cageId) {
        List<Animal> foundAnimals = animals.stream().filter(x -> cageId.equals(x.getCageId())).collect(Collectors.toList());

        return foundAnimals;
    }

    public List<Animal> getAllAnimals() {
        return animals;
    }

    public void updateAnimal(Animal updatedAnimal) {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getId() == updatedAnimal.getId()) {
                animals.set(i, updatedAnimal);
                updateFileCSV();
                return;
            }
        }
    }
    public void updateFileCSV(){

        readAnimalSerializer.writeToCSV(animals);
    }
}
