package com.codegym.model.supply.types;

import com.codegym.model.supply.Supply;
import com.codegym.model.supply.enumerations.MedicineType;

public class MedicineSupply extends Supply {
    private MedicineType medicineType;

    public MedicineSupply(int supplyId, String name, double pricePerUnit, int quantityAvailable, MedicineType medicineType) {
        super(supplyId, name, pricePerUnit, quantityAvailable,"MedicineSupply");
        this.medicineType = medicineType;
    }

    public MedicineType getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(MedicineType medicineType) {
        this.medicineType = medicineType;
    }

    @Override
    public String toString() {
        return "MedicineSupply{" +
                "medicineType=" + medicineType +
                '}' + super.toString();
    }
}
