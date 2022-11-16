package me.hsgamer.edublock.rs.test;

import lombok.experimental.UtilityClass;

import java.util.Objects;
import java.util.function.Predicate;

@UtilityClass
public class SimpleAssert {
    public static void assertTrue(boolean condition, String failMessage) {
        if (!condition) {
            throw new ScenarioException(failMessage);
        }
    }

    public static void assertFalse(boolean condition, String failMessage) {
        assertTrue(!condition, failMessage);
    }

    public static void assertEquals(Object expected, Object actual, String failMessage) {
        if (!Objects.equals(expected, actual)) {
            throw new ScenarioException(failMessage);
        }
    }

    public static void assertNotEquals(Object expected, Object actual, String failMessage) {
        if (Objects.equals(expected, actual)) {
            throw new ScenarioException(failMessage);
        }
    }

    public static void assertNull(Object object, String failMessage) {
        if (object != null) {
            throw new ScenarioException(failMessage);
        }
    }

    public static void assertNotNull(Object object, String failMessage) {
        if (object == null) {
            throw new ScenarioException(failMessage);
        }
    }

    public static void assertSame(Object expected, Object actual, String failMessage) {
        if (expected != actual) {
            throw new ScenarioException(failMessage);
        }
    }

    public static void assertNotSame(Object expected, Object actual, String failMessage) {
        if (expected == actual) {
            throw new ScenarioException(failMessage);
        }
    }

    public static void assertArrayEquals(Object[] expected, Object[] actual, String failMessage) {
        if (expected.length != actual.length) {
            throw new ScenarioException(failMessage);
        }
        for (int i = 0; i < expected.length; i++) {
            if (!Objects.equals(expected[i], actual[i])) {
                throw new ScenarioException(failMessage);
            }
        }
    }

    public static void assertArrayNotEquals(Object[] expected, Object[] actual, String failMessage) {
        if (expected.length != actual.length) {
            return;
        }
        for (int i = 0; i < expected.length; i++) {
            if (!Objects.equals(expected[i], actual[i])) {
                return;
            }
        }
        throw new ScenarioException(failMessage);
    }

    public static void assertArraySame(Object[] expected, Object[] actual, String failMessage) {
        if (expected.length != actual.length) {
            throw new AssertionError(failMessage);
        }
        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual[i]) {
                throw new ScenarioException(failMessage);
            }
        }
    }

    public static void assertArrayNotSame(Object[] expected, Object[] actual, String failMessage) {
        if (expected.length != actual.length) {
            return;
        }
        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual[i]) {
                return;
            }
        }
        throw new ScenarioException(failMessage);
    }

    public static <T> void assertAnyMatch(Iterable<T> iterable, Predicate<T> predicate, String failMessage) {
        for (T t : iterable) {
            if (predicate.test(t)) {
                return;
            }
        }
        throw new ScenarioException(failMessage);
    }

    public static <T> void assertAllMatch(Iterable<T> iterable, Predicate<T> predicate, String failMessage) {
        for (T t : iterable) {
            if (!predicate.test(t)) {
                throw new ScenarioException(failMessage);
            }
        }
    }

    public static <T> void assertNoneMatch(Iterable<T> iterable, Predicate<T> predicate, String failMessage) {
        for (T t : iterable) {
            if (predicate.test(t)) {
                throw new ScenarioException(failMessage);
            }
        }
    }
}
