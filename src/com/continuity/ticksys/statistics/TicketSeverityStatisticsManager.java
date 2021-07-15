package com.continuity.ticksys.statistics;

import com.continuity.ticksys.ticket.TicketSeverity;

public interface TicketSeverityStatisticsManager {

    void addTicketForAnalyzing(TicketSeverity ticket);

    void removeTicketFromAnalyzing(TicketSeverity ticket);

    String calcStatistics();

    String calcCveStatistics();
}
