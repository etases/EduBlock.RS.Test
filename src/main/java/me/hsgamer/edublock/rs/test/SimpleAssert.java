package me.hsgamer.edublock.rs.test;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

@UtilityClass
public class SimpleAssert {
    private static void addAssertDetail(String name, String expected, String actual) {
        Report.addDetail("**" + name + "** expected: `" + expected + "`, actual: `" + actual + "`");
    }

    public static void assertTrue(boolean condition, String failMessage, Object... args) {
        Counter.incrementAssertCounter();
        if (!condition) {
            throw new ScenarioException(String.format(failMessage, args));
        }
    }

    public static void assertFalse(boolean condition, String failMessage, Object... args) {
        addAssertDetail("assertFalse", "false", String.valueOf(condition));
        assertTrue(!condition, failMessage, args);
    }

    public static void assertTrue(boolean condition) {
        addAssertDetail("assertTrue", "true", String.valueOf(condition));
        assertTrue(condition, "Expected true, but got false");
    }

    public static void assertFalse(boolean condition) {
        addAssertDetail("assertFalse", "false", String.valueOf(condition));
        assertFalse(condition, "Expected false, but got true");
    }

    public static void assertEquals(Object expected, Object actual) {
        addAssertDetail("assertEquals", String.valueOf(expected), String.valueOf(actual));
        assertTrue(Objects.equals(expected, actual), "Expected %s but got %s", Objects.toString(expected), Objects.toString(actual));
    }

    public static void assertNotEquals(Object expected, Object actual) {
        addAssertDetail("assertNotEquals", String.valueOf(expected), String.valueOf(actual));
        assertFalse(Objects.equals(expected, actual), "Expected not %s but got %s", Objects.toString(expected), Objects.toString(actual));
    }

    public static void assertNull(Object object) {
        addAssertDetail("assertNull", "null", String.valueOf(object));
        assertTrue(object == null, "Expected null but got %s", Objects.toString(object));
    }

    public static void assertNotNull(Object object) {
        addAssertDetail("assertNotNull", "not null", String.valueOf(object));
        assertFalse(object == null, "Expected not null but got null");
    }

    public static void assertSame(Object expected, Object actual) {
        addAssertDetail("assertSame", String.valueOf(expected), String.valueOf(actual));
        assertTrue(expected == actual, "Expected %s but got %s", Objects.toString(expected), Objects.toString(actual));
    }

    public static void assertNotSame(Object expected, Object actual) {
        addAssertDetail("assertNotSame", String.valueOf(expected), String.valueOf(actual));
        assertFalse(expected == actual, "Expected not %s but got %s", Objects.toString(expected), Objects.toString(actual));
    }

    public static void assertArrayEquals(Object[] expected, Object[] actual) {
        addAssertDetail("assertArrayEquals", Arrays.toString(expected), Arrays.toString(actual));
        assertTrue(Objects.deepEquals(expected, actual), "Expected %s but got %s", Objects.toString(expected), Objects.toString(actual));
    }

    public static void assertArrayNotEquals(Object[] expected, Object[] actual) {
        addAssertDetail("assertArrayNotEquals", Arrays.toString(expected), Arrays.toString(actual));
        assertFalse(Objects.deepEquals(expected, actual), "Expected not %s but got %s", Objects.toString(expected), Objects.toString(actual));
    }

    public static <T> void assertAnyMatch(Iterable<T> iterable, Predicate<T> predicate) {
        boolean found = false;
        for (T t : iterable) {
            if (predicate.test(t)) {
                found = true;
                break;
            }
        }
        addAssertDetail("assertAnyMatch", "true", String.valueOf(found));
        assertTrue(found, "Expected any match but got none");
    }

    public static <T> void assertAllMatch(Iterable<T> iterable, Predicate<T> predicate) {
        boolean found = true;
        for (T t : iterable) {
            if (!predicate.test(t)) {
                found = false;
                break;
            }
        }
        addAssertDetail("assertAllMatch", "true", String.valueOf(found));
        assertTrue(found, "Expected all match but got none");
    }

    public static <T> void assertNoneMatch(Iterable<T> iterable, Predicate<T> predicate) {
        boolean found = false;
        for (T t : iterable) {
            if (predicate.test(t)) {
                found = true;
                break;
            }
        }
        addAssertDetail("assertNoneMatch", "true", String.valueOf(found));
        assertFalse(found, "Expected none match but got some");
    }
}
