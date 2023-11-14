package com.codegym.service;


import com.codegym.model.history.HistoryTransaction;
import com.codegym.repository.TransactionHistoryRepository;

import java.util.List;

public class HistoryTransactionService {

    private static HistoryTransactionService historyTransactionService;

    private HistoryTransactionService() {

    }

    public static HistoryTransactionService getHistoryTransactionService(){
        if (historyTransactionService == null){
            historyTransactionService = new HistoryTransactionService();
        }
        return historyTransactionService;
    }
    private TransactionHistoryRepository historyTransactionRepository =  TransactionHistoryRepository.getHistoryTransactionRepository();


    public List<HistoryTransaction> getHistoryTransactions(){
        return historyTransactionRepository.getAllHistoryTransaction();
    }

    public  HistoryTransaction  findById(String id){
        return historyTransactionRepository.findById(id);
    }
    public void addHistoryTransaction(HistoryTransaction historyTransaction) {
        historyTransaction.calculateTotalPrice();
        historyTransactionRepository.addHistoryTransaction(historyTransaction);
    }
    public void updateHistoryTransaction(HistoryTransaction historyTransaction) {
        historyTransactionRepository.updateHistoryTransaction(historyTransaction);
    }


    
}
