package me.hsgamer.edublock.rs.test;

public class ScenarioException extends RuntimeException {
    public ScenarioException() {
    }

    public ScenarioException(String message) {
        super(message);
    }

    public ScenarioException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScenarioException(Throwable cause) {
        super(cause);
    }

    public ScenarioException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
