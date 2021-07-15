package com.continuity;

import com.continuity.ticksys.ticket.TicketSeverity.Severity;
import com.continuity.ticksys.ticket.impl.BestPracticeTicket;
import com.continuity.ticksys.ticket.impl.ConfigurationTicket;
import com.continuity.ticksys.ticket.impl.SecurityTicket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class TicketFactory {

    private TicketFactory() {
    }

    public static Collection<SecurityTicket> generateSecurityTickets(int quantity, Severity severity, String cve) {
        List<SecurityTicket> result = new ArrayList<>(quantity);
        for (int i = 0; i < quantity; i++) {
            SecurityTicket ticket = new SecurityTicket();
            ticket.setCve(cve);
            ticket.setSeverity(severity);
            result.add(ticket);
        }
        return result;
    }

    public static Collection<SecurityTicket> generateSecurityTickets(int quantity, Severity severity) {
        List<SecurityTicket> result = new ArrayList<>(quantity);
        for (int i = 0; i < quantity; i++) {
            SecurityTicket ticket = new SecurityTicket();
            ticket.setSeverity(severity);
            result.add(ticket);
        }
        return result;
    }

    public static Collection<BestPracticeTicket> generateBestPracticeTickets(int quantity, Severity severity, String cve) {
        List<BestPracticeTicket> result = new ArrayList<>(quantity);
        for (int i = 0; i < quantity; i++) {
            BestPracticeTicket ticket = new BestPracticeTicket();
            ticket.setCve(cve);
            ticket.setSeverity(severity);
            result.add(ticket);
        }
        return result;
    }

    public static Collection<BestPracticeTicket> generateBestPracticeTickets(int quantity, Severity severity) {
        List<BestPracticeTicket> result = new ArrayList<>(quantity);
        for (int i = 0; i < quantity; i++) {
            BestPracticeTicket ticket = new BestPracticeTicket();
            ticket.setSeverity(severity);
            result.add(ticket);
        }
        return result;
    }

    public static Collection<ConfigurationTicket> generateConfigurationTickets(int quantity, Severity severity) {
        List<ConfigurationTicket> result = new ArrayList<>(quantity);
        for (int i = 0; i < quantity; i++) {
            ConfigurationTicket ticket = new ConfigurationTicket();
            ticket.setSeverity(severity);
            result.add(ticket);
        }
        return result;
    }
}
