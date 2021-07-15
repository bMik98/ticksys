package com.continuity.ticksys.ticket;

public interface TicketSeverity extends TicketCve {

    Severity getSeverity();

    enum Severity {
        ERROR, WARNING, INFORMATION
    }
}
