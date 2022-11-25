package me.hsgamer.edublock.rs.test.scenario;

import me.hsgamer.edublock.rs.test.Counter;
import me.hsgamer.edublock.rs.test.Report;
import me.hsgamer.edublock.rs.test.ScenarioException;
import me.hsgamer.edublock.rs.test.UrlSupplier;
import me.hsgamer.edublock.rs.test.annotation.Test;
import org.tinylog.Logger;

import java.lang.reflect.Method;
import java.net.http.HttpClient;
import java.util.List;
import java.util.stream.Stream;

public class AnnotatedScenario extends AbstractScenario {
    public AnnotatedScenario(UrlSupplier urlSupplier, HttpClient httpClient) {
        super(urlSupplier, httpClient);
    }

    @Override
    public void run() throws Exception {
        Method[] methods = getClass().getDeclaredMethods();
        List<Method> testMethods = Stream.of(methods)
                .filter(method -> method.isAnnotationPresent(Test.class))
                .sorted((method1, method2) -> {
                    Test test1 = method1.getAnnotation(Test.class);
                    Test test2 = method2.getAnnotation(Test.class);
                    return Integer.compare(test1.order(), test2.order());
                })
                .toList();
        for (Method method : testMethods) {
            Test test = method.getAnnotation(Test.class);
            if (test.name().isEmpty()) {
                Report.addLabel(method.getName(), 2);
                Logger.info("[TEST] {} # {}", getClass().getSimpleName(), method.getName());
            } else {
                Report.addLabel(test.name(), 2);
                Logger.info("[TEST] {} # {}", getClass().getSimpleName(), test.name());
            }
            Counter.incrementTestCounter();
            if (method.trySetAccessible()) {
                try {
                    method.invoke(this);
                } catch (Exception e) {
                    if (e.getCause() instanceof ScenarioException scenarioException) {
                        throw scenarioException;
                    }
                    throw e;
                }
            } else {
                throw new ScenarioException("Cannot access method " + method.getName());
            }
        }
    }
}
