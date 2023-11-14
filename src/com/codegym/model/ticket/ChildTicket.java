package com.codegym.model.ticket;


public class ChildTicket extends AbstractTicket{
    public ChildTicket() {
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
