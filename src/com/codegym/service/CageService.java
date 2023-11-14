package com.codegym.service;

import com.codegym.model.Cage.Cage;
import com.codegym.model.Cage.Habitat;
import com.codegym.model.animal.Animal;
import com.codegym.model.animal.interfaces.AnimalActions;
import com.codegym.repository.AnimalRepository;
import com.codegym.repository.CageRepository;

import java.util.List;

public class CageService extends BaseService{


    private static CageService cageService;

    private CageService() {

    }

    public static CageService getCageService() {
        if (cageService == null) {
            cageService = new CageService();
        }
        return cageService;
    }


    private CageRepository cageRepository = CageRepository.getCageRepository();

    private AnimalRepository animalRepository = AnimalRepository.getAnimalRepository();


    public List<Cage> getCages() {
        return cageRepository.getAllCages();
    }

    public List<Cage> getCagesForUser() {
        return cageRepository.getAllCagesForUserId(getEmployeeId());
    }


    public void feedAnimals(String cageId){
        Cage cage = cageRepository.findById(cageId);
        if (cage == null){
            System.out.println("Thông tin chuồng thú không hợp lệ.");
        }else if (cage.isEmpty()){
            System.out.println("Chuồng phải chứa động vật.");
        }else {
            System.out.println("Nhân viên đang cho thú ăn.");
            cage.getAnimals().stream().forEach(x -> x.eat());
        }
    }

    public void cleanEnclosure(String cageId){
        Cage cage = cageRepository.findById(cageId);
        if (cage == null){
            System.out.println("Thông tin chuồng thú không hợp lệ.");
        }else if (cage.isEmpty()){
            System.out.println("Chuồng phải chứa động vật.");
        }else {
            System.out.println("Chuồng đã được vệ sinh");
            cage.getAnimals().parallelStream().forEach(x -> {
                x.move();
                x.makeSound();
                x.play();
            });
        }
    }

    public void addAnimalForCage(String cageId, int animalId) {
        Cage cage = cageRepository.findById(cageId);
        Animal animal = animalRepository.findById(animalId);
        if (cage == null || animal == null) {
            System.out.println("Thông tin chuồng hoặc thú không hợp lệ.");
        } else if (cage.isFull()) {
            System.out.println("Chuồng thú đã đầy.");
        } else if (!cage.isCompatible(animal)) {
            System.out.println("Chuồng không đúng loại thú.");
        } else {
            if (!animal.getCageId().isBlank()) {
                Cage oldCage = cageRepository.findById(animal.getCageId());
                oldCage.getAnimals().removeIf(x -> x.getId()== animalId);
            }
            animal.setCageId(cageId);
            cage.getAnimals().add(animal);
            animalRepository.updateFileCSV();

            System.out.println("Thành Công.");
        }
    }


    public void removeAnimalForCage(String cageId, int animalId) {
        Cage cage = cageRepository.findById(cageId);
        Animal animal = animalRepository.findById(animalId);
        if (cage == null || animal == null) {
            System.out.println("Thông tin chuồng hoặc thú không hợp lệ.");

        } else {
            cage.getAnimals().remove(animal);
            animal.setCageId(null);
            animalRepository.updateFileCSV();
            System.out.println("Thành Công.");
        }

    }

    public Cage findById(String cageId) {
        return cageRepository.findById(cageId);
    }

    public void addCage(Cage cage) {
        cageRepository.addCage(cage);
    }

    public void updateCage(Cage cage) {
        cageRepository.updateCage(cage);
    }

    public void removeCage(String cageId) {
        cageRepository.removeCage(cageId);
    }
}
