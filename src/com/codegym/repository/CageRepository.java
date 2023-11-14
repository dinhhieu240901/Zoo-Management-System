package com.codegym.repository;

import com.codegym.model.Cage.Cage;
import com.codegym.serializer.ReadAnimalSerializer;
import com.codegym.serializer.ReadCageSerializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CageRepository {
    private List<Cage> cages;

    ReadCageSerializer readCageSerializer = ReadCageSerializer.getInstanceReadCageSerializer();

    private static CageRepository cageRepository;

    private static AnimalRepository animalRepository = AnimalRepository.getAnimalRepository();

    private CageRepository() {
        this.cages = readCageSerializer.readFromCSV();

        cages.stream().forEach(x ->{
            x.setAnimals( animalRepository.findByCageId(x.getCageId()));
        });
        cages.stream().forEach(System.out::println);

    }

    public static CageRepository getCageRepository() {
        if (cageRepository == null) {
            cageRepository = new CageRepository();
        }
        return cageRepository;
    }

    public void addCage(Cage cage) {
        cages.add(cage);
        updateFileCSV();
    }

    public void removeCage(String cageId) {
        cages.removeIf(cage -> cage.getCageId().equals(cageId));
        updateFileCSV();

    }

    public Cage findById(String cageId) {
        Cage cage = null;
        Optional<Cage> optionalCage = cages.stream().filter(x -> cageId.equals(x.getCageId())).findFirst();
        if (optionalCage.isPresent()) {
            cage = optionalCage.get();
        }
        return cage;

    }

    public List<Cage> getAllCages() {
        return cages;
    }
    public List<Cage> getAllCagesForUserId(String employeeId) {
        return cages.stream().filter(x -> employeeId.equals(x.getEmployeeId())).collect(Collectors.toList());
    }

    public void updateCage(Cage updatedCage) {
        for (int i = 0; i < cages.size(); i++) {
            cages.set(i, updatedCage);
            updateFileCSV();
            return;

        }
    }

    public void updateFileCSV() {
        readCageSerializer.writeToCSV(cages);
    }

}
