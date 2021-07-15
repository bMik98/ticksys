package com.continuity.ticksys.ticket;

public interface Ticket extends TicketSeverity {

    int getId();

    String getDescription();

    String getResolution();

    void setId(int id);
}
