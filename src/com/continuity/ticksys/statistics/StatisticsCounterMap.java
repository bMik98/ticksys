package com.continuity.ticksys.statistics;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;

public class StatisticsCounterMap<K> {

    private final ConcurrentMap<K, LongAdder> counterMap = new ConcurrentHashMap<>();

    public void increment(K key) {
        if (key != null) {
            counterMap.compute(key, (dummy, adder) -> {
                LongAdder result = (adder == null) ? new LongAdder() : adder;
                result.increment();
                return result;
            });
        }
    }

    public void decrement(K key) {
        if (key != null) {
            counterMap.compute(key, (dummy, adder) -> {
                if (adder == null) {
                    return null;
                }
                adder.decrement();
                return adder;
            });
        }
    }

    public Collection<String> getStatistics() {
        return counterMap.entrySet().stream()
                .map(e -> e.getKey() + " : " + e.getValue() + " entries")
                .collect(Collectors.toList());
    }
}
