package com.continuity.ticksys.manager;

import com.continuity.ticksys.sequence.IdSequence;
import com.continuity.ticksys.statistics.TicketSeverityStatisticsManager;
import com.continuity.ticksys.ticket.Ticket;

import java.util.Collection;
import java.util.Collections;

public class TicketManagerImpl implements TicketManager {

    private final TicketSeverityStatisticsManager statisticsManager;
    private final IdSequence sequence;

    public TicketManagerImpl(TicketSeverityStatisticsManager statisticsManager, IdSequence sequence) {
        this.statisticsManager = statisticsManager;
        this.sequence = sequence;
    }

    @Override
    public void addTicket(Ticket ticket) {
        ticket.setId(sequence.nextId());
        statisticsManager.addTicketForAnalyzing(ticket);
        //TODO implement adding to a ticket repository when the need arises
    }

    @Override
    public void removeTicket(Ticket ticket) {
        statisticsManager.removeTicketFromAnalyzing(ticket);
        //TODO implement removing from a ticket repository when the need arises
    }

    @Override
    public Ticket getTicket(int id) {
        //TODO implement when the need arises
        return null;
    }

    @Override
    public Collection<Ticket> getTickets() {
        //TODO implement when the need arises
        return Collections.emptyList();
    }
}
