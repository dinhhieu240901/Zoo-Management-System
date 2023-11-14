package com.codegym.model.history;


import com.codegym.model.ticket.Ticket;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class HistoryTransaction {
    private String id;
    private String objectId;

    private HistoryType historyType;

    private double totalMoney;
    private List<Ticket> tickets;
    private Date date;

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
        calculateTotalPrice();
    }

    public HistoryTransaction(String id, String objectId, HistoryType historyType, double totalMoney, Date date) {
        this.id = id;
        this.objectId = objectId;
        this.historyType = historyType;
        this.totalMoney = totalMoney;
        this.tickets = new ArrayList<>();
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public HistoryType getHistoryType() {
        return historyType;
    }

    public void setHistoryType(HistoryType historyType) {
        this.historyType = historyType;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Ticket ticket : tickets) {
            totalPrice += ticket.getPrice();
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return "HistoryTransaction{" +
                "id='" + id + '\'' +
                ", objectId='" + objectId + '\'' +
                ", historyType=" + historyType +
                ", totalMoney=" + totalMoney +
                ", date=" + date +
                ", Total Price=" + calculateTotalPrice() +
                '}';
    }
}
