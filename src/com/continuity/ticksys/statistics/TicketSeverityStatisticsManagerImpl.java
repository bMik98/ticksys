package com.continuity.ticksys.statistics;

import com.continuity.ticksys.ticket.TicketSeverity;

public class TicketSeverityStatisticsManagerImpl implements TicketSeverityStatisticsManager {

    private final StatisticsCounterMap<TicketSeverity.Severity> severityCounters;
    private final StatisticsCounterMap<String> cveCounters;

    public TicketSeverityStatisticsManagerImpl() {
        severityCounters = new StatisticsCounterMap<>();
        cveCounters = new StatisticsCounterMap<>();
    }

    @Override
    public void addTicketForAnalyzing(TicketSeverity ticket) {
        severityCounters.increment(ticket.getSeverity());
        cveCounters.increment(ticket.getCve());
    }

    @Override
    public void removeTicketFromAnalyzing(TicketSeverity ticket) {
        severityCounters.decrement(ticket.getSeverity());
        cveCounters.decrement(ticket.getCve());
    }

    @Override
    public String calcStatistics() {
        return String.join(System.lineSeparator(), severityCounters.getStatistics());
    }

    @Override
    public String calcCveStatistics() {
        return String.join(System.lineSeparator(), cveCounters.getStatistics());
    }
}
