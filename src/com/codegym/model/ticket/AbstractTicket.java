package com.codegym.model.ticket;

public abstract class AbstractTicket implements Ticket {
    protected double price;
    protected int quantity;

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException("Số lượng không hợp lệ");
        }
    }

}
