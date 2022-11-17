package me.hsgamer.edublock.rs.test;

import lombok.experimental.UtilityClass;

import java.util.concurrent.atomic.AtomicInteger;

@UtilityClass
public class Counter {
    private static final AtomicInteger testCounter = new AtomicInteger(0);
    private static final AtomicInteger assertCounter = new AtomicInteger(0);
    private static final AtomicInteger scenarioCounter = new AtomicInteger(0);

    public static int getTestCounter() {
        return testCounter.get();
    }

    public static int getAssertCounter() {
        return assertCounter.get();
    }

    public static int getScenarioCounter() {
        return scenarioCounter.get();
    }

    public static void incrementTestCounter() {
        testCounter.incrementAndGet();
    }

    public static void incrementAssertCounter() {
        assertCounter.incrementAndGet();
    }

    public static void incrementScenarioCounter() {
        scenarioCounter.incrementAndGet();
    }
}
