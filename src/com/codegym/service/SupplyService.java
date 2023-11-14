package com.codegym.service;



import com.codegym.model.person.enumerations.AgeCategory;
import com.codegym.model.supply.Supply;
import com.codegym.repository.SupplyRepository;

import java.util.List;

public class SupplyService {

    private static SupplyService supplyService;

    private SupplyService() {

    }

    public static SupplyService getSupplyService(){
        if (supplyService == null){
            supplyService = new SupplyService();
        }
        return supplyService;
    }
    private SupplyRepository supplyRepository =  SupplyRepository.getSupplyRepository();


    public List<Supply> getSupplies(){
        return supplyRepository.getAllSupplies();
    }

    public  Supply  findById(int id){
        return supplyRepository.findById(id);
    }
    public void addSupply(Supply supply) {
        supplyRepository.addSupply(supply);
    }
    public void updateSupply(Supply supply) {
        supplyRepository.updateSupply(supply);
    }

    public void removeSupply(int supplyId) {
        supplyRepository.removeSupply(supplyId);
    }


    
}
