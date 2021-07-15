package com.continuity.ticksys.ticket.impl;

public class SecurityTicket extends AbstractTicket {

    private String cve;

    @Override
    public String getCve() {
        return cve;
    }

    public void setCve(String cve) {
        this.cve = cve;
    }
}
