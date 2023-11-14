package com.codegym.repository;


import com.codegym.model.supply.Supply;
import com.codegym.serializer.ReadSupplySerializer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SupplyRepository {
    private List<Supply> supplys;

    ReadSupplySerializer readSupplySerializer = ReadSupplySerializer.getReadSupplySerializer();

    private static SupplyRepository supplyRepository;

    private static AnimalRepository animalRepository = AnimalRepository.getAnimalRepository();

    private SupplyRepository() {
        this.supplys = readSupplySerializer.readFromCSV();

        supplys.stream().forEach(System.out::println);

    }

    public static SupplyRepository getSupplyRepository() {
        if (supplyRepository == null) {
            supplyRepository = new SupplyRepository();
        }
        return supplyRepository;
    }

    public void addSupply(Supply supply) {
        supplys.add(supply);
        updateFileCSV();
    }

    public void removeSupply(int supplyId) {
        supplys.removeIf(supply -> supply.getSupplyId() == supplyId);
        updateFileCSV();

    }

    public Supply findById(int supplyId) {
        Supply supply = null;
        Optional<Supply> optionalSupply = supplys.stream().filter(x -> supplyId ==x.getSupplyId()).findFirst();
        if (optionalSupply.isPresent()) {
            supply = optionalSupply.get();
        }
        return supply;

    }

    public List<Supply> getAllSupplies() {
        return supplys;
    }

    public void updateSupply(Supply updatedSupply) {
        for (int i = 0; i < supplys.size(); i++) {
            supplys.set(i, updatedSupply);
            updateFileCSV();
            return;

        }
    }
    public void remove(int id) {
       supplys.removeIf(x-> x.getSupplyId() == id);
    }

    public void updateFileCSV() {
        readSupplySerializer.writeToCSV(supplys);
    }

}
