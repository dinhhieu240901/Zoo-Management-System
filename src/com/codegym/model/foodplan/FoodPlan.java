package com.codegym.model.foodplan;

public class FoodPlan {
    private String foodItem;
    private int quantity;

    public FoodPlan(String foodItem, int quantity) {
        this.foodItem = foodItem;
        this.quantity = quantity;
    }

    public String getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "FoodPlan{" +
                "foodItem='" + foodItem + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}