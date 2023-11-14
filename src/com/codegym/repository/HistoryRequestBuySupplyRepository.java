package com.codegym.repository;


import com.codegym.model.history.HistoryRequestBuySupply;
import com.codegym.serializer.ReadHistoryRequestBuySupplySerializer;

import java.util.List;
import java.util.Optional;

public class HistoryRequestBuySupplyRepository {
    private List<HistoryRequestBuySupply> historyRequestBuySupplys;

    ReadHistoryRequestBuySupplySerializer readHistoryRequestBuySupplySerializer = ReadHistoryRequestBuySupplySerializer.getInstanceReadHistoryRequestBySupplySerializer();

    private static HistoryRequestBuySupplyRepository historyRequestBuySupplyRepository;

    private static AnimalRepository animalRepository = AnimalRepository.getAnimalRepository();

    private HistoryRequestBuySupplyRepository() {
        this.historyRequestBuySupplys = readHistoryRequestBuySupplySerializer.readFromCSV();
        
        historyRequestBuySupplys.stream().forEach(System.out::println);

    }

    public static HistoryRequestBuySupplyRepository getHistoryRequestBuySupplyRepository() {
        if (historyRequestBuySupplyRepository == null) {
            historyRequestBuySupplyRepository = new HistoryRequestBuySupplyRepository();
        }
        return historyRequestBuySupplyRepository;
    }

    public void addHistoryRequestBuySupply(HistoryRequestBuySupply historyRequestBuySupply) {
        historyRequestBuySupplys.add(historyRequestBuySupply);
        updateFileCSV();
    }

    public void removeHistoryRequestBuySupply(String historyRequestBuySupplyId) {
        historyRequestBuySupplys.removeIf(historyRequestBuySupply -> historyRequestBuySupply.getId() == historyRequestBuySupplyId);
        updateFileCSV();

    }

    public HistoryRequestBuySupply findById(String historyRequestBuySupplyId) {
        HistoryRequestBuySupply historyRequestBuySupply = null;
        Optional<HistoryRequestBuySupply> optionalHistoryRequestBuySupply = historyRequestBuySupplys.stream().filter(x -> historyRequestBuySupplyId.equals(x.getId())).findFirst();
        if (optionalHistoryRequestBuySupply.isPresent()) {
            historyRequestBuySupply = optionalHistoryRequestBuySupply.get();
        }
        return historyRequestBuySupply;

    }

    public List<HistoryRequestBuySupply> getAllHistoryRequestBuySupplies() {
        return historyRequestBuySupplys;
    }

    public void updateHistoryRequestBuySupply(HistoryRequestBuySupply updatedHistoryRequestBuySupply) {
        for (int i = 0; i < historyRequestBuySupplys.size(); i++) {
            historyRequestBuySupplys.set(i, updatedHistoryRequestBuySupply);
            updateFileCSV();
            return;

        }
    }

    public void updateFileCSV() {
        readHistoryRequestBuySupplySerializer.writeToCSV(historyRequestBuySupplys);
    }

}
