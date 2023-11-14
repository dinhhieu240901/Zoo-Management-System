package com.codegym.model.ticket;

public class SeniorTicket extends AbstractTicket{
    public SeniorTicket() {
        this.price = 50000;
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
