package com.continuity.ticksys.sequence;

import java.util.concurrent.atomic.AtomicInteger;

public class TicketIdSequence implements IdSequence {

    private static final AtomicInteger counter = new AtomicInteger(0);

    @Override
    public int nextId() {
        return counter.incrementAndGet();
    }
}
