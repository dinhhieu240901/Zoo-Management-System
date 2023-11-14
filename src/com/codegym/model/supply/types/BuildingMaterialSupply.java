package com.codegym.model.supply.types;

import com.codegym.model.supply.Supply;
import com.codegym.model.supply.enumerations.BuildingMaterialType;

public class BuildingMaterialSupply extends Supply {
    private BuildingMaterialType buildingMaterialType;

    public BuildingMaterialSupply(int supplyId, String name, double pricePerUnit, int quantityAvailable, BuildingMaterialType buildingMaterialType) {
        super(supplyId, name, pricePerUnit, quantityAvailable,"BuildingMaterialSupply");
        this.buildingMaterialType = buildingMaterialType;
    }

    public BuildingMaterialType getBuildingMaterialType() {
        return buildingMaterialType;
    }

    public void setBuildingMaterialType(BuildingMaterialType buildingMaterialType) {
        this.buildingMaterialType = buildingMaterialType;
    }

    @Override
    public String toString() {
        return "BuildingMaterialSupply{" +
                "buildingMaterialType=" + buildingMaterialType +
                '}'+super.toString();
    }
}
