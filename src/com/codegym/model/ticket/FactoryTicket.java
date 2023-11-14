package com.codegym.model.ticket;

import com.codegym.model.person.enumerations.AgeCategory;

public class FactoryTicket {
    public static Ticket getTicket(AgeCategory type, int quantity) {
        Ticket ticket = switch (type) {
            case CHILD -> new ChildTicket();
            case ADULT -> new AdultTicket();
            case SENIOR -> new SeniorTicket();
            default -> throw new IllegalArgumentException("Loại vé không hợp lệ");
        };
        ticket.setQuantity(quantity);
        return ticket;
    }
}
