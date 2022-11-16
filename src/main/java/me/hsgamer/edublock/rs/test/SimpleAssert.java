package me.hsgamer.edublock.rs.test;

import lombok.experimental.UtilityClass;

import java.util.Objects;
import java.util.function.Predicate;

@UtilityClass
public class SimpleAssert {
    public static void assertTrue(boolean condition, String failMessage, Object... args) {
        if (!condition) {
            throw new ScenarioException(String.format(failMessage, args));
        }
    }

    public static void assertFalse(boolean condition, String failMessage, Object... args) {
        assertTrue(!condition, failMessage, args);
    }

    public static void assertTrue(boolean condition) {
        assertTrue(condition, "Expected true, but got false");
    }

    public static void assertFalse(boolean condition) {
        assertFalse(condition, "Expected false, but got true");
    }

    public static void assertEquals(Object expected, Object actual) {
        assertTrue(Objects.equals(expected, actual), "Expected %s but got %s", Objects.toString(expected), Objects.toString(actual));
    }

    public static void assertNotEquals(Object expected, Object actual) {
        assertFalse(Objects.equals(expected, actual), "Expected not %s but got %s", Objects.toString(expected), Objects.toString(actual));
    }

    public static void assertNull(Object object) {
        assertTrue(object == null, "Expected null but got %s", Objects.toString(object));
    }

    public static void assertNotNull(Object object) {
        assertFalse(object == null, "Expected not null but got null");
    }

    public static void assertSame(Object expected, Object actual) {
        assertTrue(expected == actual, "Expected %s but got %s", Objects.toString(expected), Objects.toString(actual));
    }

    public static void assertNotSame(Object expected, Object actual) {
        assertFalse(expected == actual, "Expected not %s but got %s", Objects.toString(expected), Objects.toString(actual));
    }

    public static void assertArrayEquals(Object[] expected, Object[] actual) {
        assertTrue(Objects.deepEquals(expected, actual), "Expected %s but got %s", Objects.toString(expected), Objects.toString(actual));
    }

    public static void assertArrayNotEquals(Object[] expected, Object[] actual) {
        assertFalse(Objects.deepEquals(expected, actual), "Expected not %s but got %s", Objects.toString(expected), Objects.toString(actual));
    }

    public static <T> void assertAnyMatch(Iterable<T> iterable, Predicate<T> predicate) {
        for (T t : iterable) {
            if (predicate.test(t)) {
                return;
            }
        }
        throw new ScenarioException("No element matches the predicate");
    }

    public static <T> void assertAllMatch(Iterable<T> iterable, Predicate<T> predicate) {
        for (T t : iterable) {
            if (!predicate.test(t)) {
                throw new ScenarioException("An element does not match the predicate");
            }
        }
    }

    public static <T> void assertNoneMatch(Iterable<T> iterable, Predicate<T> predicate) {
        for (T t : iterable) {
            if (predicate.test(t)) {
                throw new ScenarioException("An element matches the predicate");
            }
        }
    }
}
