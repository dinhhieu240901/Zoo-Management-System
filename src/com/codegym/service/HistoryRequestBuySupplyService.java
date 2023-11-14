package com.codegym.service;



import com.codegym.model.history.HistoryRequestBuySupply;
import com.codegym.model.history.HistoryTransaction;
import com.codegym.model.history.HistoryType;
import com.codegym.model.supply.Supply;
import com.codegym.repository.HistoryRequestBuySupplyRepository;

import java.sql.Date;
import java.util.List;

public class HistoryRequestBuySupplyService  extends BaseService{

    private static HistoryRequestBuySupplyService historyRequestBuySupplyService;

    private HistoryRequestBuySupplyService() {

    }

    public static HistoryRequestBuySupplyService getHistoryRequestBuySupplyService(){
        if (historyRequestBuySupplyService == null){
            historyRequestBuySupplyService = new HistoryRequestBuySupplyService();
        }
        return historyRequestBuySupplyService;
    }
    private HistoryRequestBuySupplyRepository historyRequestBuySupplyRepository =  HistoryRequestBuySupplyRepository.getHistoryRequestBuySupplyRepository();
    private SupplyService supplyService =  SupplyService.getSupplyService();

    private HistoryTransactionService historyTransactionService =  HistoryTransactionService.getHistoryTransactionService();


    public List<HistoryRequestBuySupply> getSupplies(){
        return historyRequestBuySupplyRepository.getAllHistoryRequestBuySupplies();
    }

    public  HistoryRequestBuySupply  findById(String id){
        return historyRequestBuySupplyRepository.findById(id);
    }
    public void addHistoryRequestBuySupply(int idSupply, int quantity ) {

        Supply supply = supplyService.findById(idSupply);
        if (supply != null && supply.getQuantityAvailable() >= quantity){
            HistoryRequestBuySupply requestBuySupply = new HistoryRequestBuySupply(genId(), getEmployeeId(), idSupply, quantity, supply.getPricePerUnit()*quantity,"WAITING");
            historyRequestBuySupplyRepository.addHistoryRequestBuySupply(requestBuySupply);
            System.out.println("Thành Công");
        }else {
            System.out.println("Không tìm thấy nguyên liệu hoặc không đủ");

        }
    }
    public void updateFailHistoryRequestBuySupply(String id ) {
        HistoryRequestBuySupply requestBuySupply = findById(id);
        if (requestBuySupply != null){
            requestBuySupply.setStatus("FAIL");
            historyRequestBuySupplyRepository.updateHistoryRequestBuySupply(requestBuySupply);
            System.out.println("Thành công.");
        } else {
            System.out.println("Không tìm thấy yêu cầu mua nguyên liêu.");
        }
    }
    public void updateSuccessHistoryRequestBuySupply(String id ) {
        HistoryRequestBuySupply requestBuySupply = findById(id);
        if (requestBuySupply != null){
            requestBuySupply.setStatus("SUCCESS");
            historyRequestBuySupplyRepository.updateHistoryRequestBuySupply(requestBuySupply);
            historyTransactionService.addHistoryTransaction(new HistoryTransaction(genId(), requestBuySupply.getUserIdRequest(), HistoryType.BUY_SUPPLY,requestBuySupply.getTotalMoney(),new Date(System.currentTimeMillis())));
            System.out.println("Thành công.");
        } else {
            System.out.println("Không tìm thấy yêu cầu mua nguyên liêu.");
        }
    }


    
}
