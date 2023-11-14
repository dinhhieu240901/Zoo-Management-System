package com.codegym.model.supply.types;

import com.codegym.model.supply.Supply;
import com.codegym.model.supply.enumerations.FoodType;

public class FoodSupply extends Supply {
    private FoodType foodType ;

    public FoodSupply(int supplyId, String name, double pricePerUnit, int quantityAvailable, FoodType foodType) {
        super(supplyId, name, pricePerUnit, quantityAvailable,"FoodSupply");
        this.foodType = foodType;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    @Override
    public String toString() {
        return "FoodSupply{" +
                "foodType=" + foodType +
                '}';
    }
}
