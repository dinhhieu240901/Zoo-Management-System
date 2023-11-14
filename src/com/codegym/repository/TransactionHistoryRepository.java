package com.codegym.repository;


import com.codegym.model.history.HistoryTransaction;
import com.codegym.serializer.ReadHistoryTransactionSerializer;

import java.util.List;
import java.util.Optional;

public class TransactionHistoryRepository {
    private List<HistoryTransaction> historyTransactions;

    ReadHistoryTransactionSerializer readHistoryTransactionSerializer = ReadHistoryTransactionSerializer.getInstanceReadHistoryTransactionSerializer();

    private static TransactionHistoryRepository historyTransactionRepository;

    private static AnimalRepository animalRepository = AnimalRepository.getAnimalRepository();

    private TransactionHistoryRepository() {
        this.historyTransactions = readHistoryTransactionSerializer.readFromCSV();
        
        historyTransactions.stream().forEach(System.out::println);

    }

    public static TransactionHistoryRepository getHistoryTransactionRepository() {
        if (historyTransactionRepository == null) {
            historyTransactionRepository = new TransactionHistoryRepository();
        }
        return historyTransactionRepository;
    }

    public void addHistoryTransaction(HistoryTransaction historyTransaction) {
        historyTransactions.add(historyTransaction);
        updateFileCSV();
    }

    public void removeHistoryTransaction(String historyTransactionId) {
        historyTransactions.removeIf(historyTransaction -> historyTransaction.getId() == historyTransactionId);
        updateFileCSV();

    }

    public HistoryTransaction findById(String historyTransactionId) {
        HistoryTransaction historyTransaction = null;
        Optional<HistoryTransaction> optionalHistoryTransaction = historyTransactions.stream().filter(x -> historyTransactionId.equals(x.getId())).findFirst();
        if (optionalHistoryTransaction.isPresent()) {
            historyTransaction = optionalHistoryTransaction.get();
        }
        return historyTransaction;

    }

    public List<HistoryTransaction> getAllHistoryTransaction() {
        return historyTransactions;
    }

    public void updateHistoryTransaction(HistoryTransaction updatedHistoryTransaction) {
        for (int i = 0; i < historyTransactions.size(); i++) {
            HistoryTransaction currentTransaction = historyTransactions.get(i);
            if (currentTransaction.getId().equals(updatedHistoryTransaction.getId())) {
                currentTransaction.setTotalMoney(updatedHistoryTransaction.getTotalMoney());
                updateFileCSV();
                return;
            }
        }
    }

    public void updateFileCSV() {
        readHistoryTransactionSerializer.writeToCSV(historyTransactions);
    }

}
