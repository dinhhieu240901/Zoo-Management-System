package com.codegym.model.supply;

public enum SupplyCategory {
    FOOD("Thức ăn"), BUILDING_MATERIAL("Vật liệu xây dựng"), MEDICINE("Thuốc");

    private final String displayName;

    SupplyCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }}
