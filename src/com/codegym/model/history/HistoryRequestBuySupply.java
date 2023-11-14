package com.codegym.model.history;

public class HistoryRequestBuySupply {

    private String id;

    private String userIdRequest;

    private int supplyId;

    private int amount;

    private double totalMoney;

    private String status;

    public HistoryRequestBuySupply(String id, String userIdRequest, int supplyId, int amount, double totalMoney, String status) {
        this.id = id;
        this.userIdRequest = userIdRequest;
        this.supplyId = supplyId;
        this.amount = amount;
        this.totalMoney = totalMoney;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserIdRequest() {
        return userIdRequest;
    }

    public void setUserIdRequest(String userIdRequest) {
        this.userIdRequest = userIdRequest;
    }

    public int getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(int supplyId) {
        this.supplyId = supplyId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HistoryRequestBuySupply{" +
                "id='" + id + '\'' +
                ", userIdRequest='" + userIdRequest + '\'' +
                ", supplyId=" + supplyId +
                ", amount=" + amount +
                ", totalMoney=" + totalMoney +
                ", status='" + status + '\'' +
                '}';
    }
}
