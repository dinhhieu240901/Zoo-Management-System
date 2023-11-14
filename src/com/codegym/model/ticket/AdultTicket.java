package com.codegym.model.ticket;


public class AdultTicket extends AbstractTicket{
    public AdultTicket() {
        this.price = 60000;
    }

    @Override
    public double getPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return ", AdultTicket=" + getPrice() + ", Quantity=" + quantity;
    }
}
