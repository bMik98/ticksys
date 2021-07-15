package com.continuity;

import com.continuity.ticksys.manager.TicketManager;
import com.continuity.ticksys.manager.TicketManagerImpl;
import com.continuity.ticksys.sequence.IdSequence;
import com.continuity.ticksys.sequence.TicketIdSequence;
import com.continuity.ticksys.statistics.TicketSeverityStatisticsManager;
import com.continuity.ticksys.statistics.TicketSeverityStatisticsManagerImpl;
import com.continuity.ticksys.ticket.Ticket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.continuity.ticksys.ticket.TicketSeverity.Severity.*;

public class Main {

    public static void main(String[] args) {
        new Main().start();
    }

    private void start() {
        IdSequence sequence = new TicketIdSequence();
        TicketSeverityStatisticsManager statisticsManager = new TicketSeverityStatisticsManagerImpl();
        TicketManager manager = new TicketManagerImpl(statisticsManager, sequence);
        createTestData().forEach(manager::addTicket);
        System.out.println("Severity Statistics");
        System.out.println("-------------------");
        System.out.println(statisticsManager.calcStatistics());
        System.out.println("\nCVE Statistics");
        System.out.println("-------------------");
        System.out.println(statisticsManager.calcCveStatistics());
    }

    private Collection<Ticket> createTestData() {
        List<Ticket> result = new ArrayList<>();

        result.addAll(TicketFactory.generateBestPracticeTickets(10, INFORMATION));
        result.addAll(TicketFactory.generateBestPracticeTickets(20, INFORMATION, "CVE-2021-1001"));
        result.addAll(TicketFactory.generateBestPracticeTickets(30, WARNING));
        result.addAll(TicketFactory.generateBestPracticeTickets(40, WARNING, "CVE-2021-1002"));
        result.addAll(TicketFactory.generateBestPracticeTickets(50, ERROR));
        result.addAll(TicketFactory.generateBestPracticeTickets(60, ERROR, "CVE-2021-1003"));

        result.addAll(TicketFactory.generateSecurityTickets(70, INFORMATION));
        result.addAll(TicketFactory.generateSecurityTickets(80, INFORMATION, "CVE-2021-1001"));
        result.addAll(TicketFactory.generateSecurityTickets(100, WARNING));
        result.addAll(TicketFactory.generateSecurityTickets(90, WARNING, "CVE-2021-2002"));
        result.addAll(TicketFactory.generateSecurityTickets(110, ERROR));
        result.addAll(TicketFactory.generateSecurityTickets(120, ERROR, "CVE-2021-2003"));

        result.addAll(TicketFactory.generateConfigurationTickets(20, INFORMATION));
        result.addAll(TicketFactory.generateConfigurationTickets(40, WARNING));
        result.addAll(TicketFactory.generateConfigurationTickets(160, ERROR));

        return result;
    }
}
