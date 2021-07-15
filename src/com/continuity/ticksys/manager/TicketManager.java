package com.continuity.ticksys.manager;

import com.continuity.ticksys.ticket.Ticket;

import java.util.Collection;

public interface TicketManager {

    void addTicket(Ticket ticket);

    void removeTicket(Ticket ticket);

    Ticket getTicket(int id);

    Collection<Ticket> getTickets();
}
