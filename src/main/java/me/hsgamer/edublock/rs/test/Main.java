package me.hsgamer.edublock.rs.test;

import me.hsgamer.edublock.rs.test.scenario.AbstractScenario;
import me.hsgamer.edublock.rs.test.scenario.AccountScenario;
import me.hsgamer.edublock.rs.test.scenario.ClassroomScenario;
import org.tinylog.Logger;

import java.net.http.HttpClient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Main {
    private static final Map<Class<?>, AbstractScenario> scenarioMap = new HashMap<>();
    private static final List<BiFunction<UrlSupplier, HttpClient, AbstractScenario>> scenarioFunctionList = List.of(
            AccountScenario::new,
            ClassroomScenario::new
    );

    public static void main(String[] args) {
        String baseUrl = args.length > 0 ? args[0] : "http://localhost:7070";
        UrlSupplier urlSupplier = path -> {
            String normalizedBaseUrl = baseUrl.endsWith("/") ? baseUrl.substring(0, baseUrl.length() - 1) : baseUrl;
            String normalizedPath = path.startsWith("/") ? path.substring(1) : path;
            return normalizedBaseUrl + "/" + normalizedPath;
        };
        HttpClient httpClient = HttpClient.newHttpClient();

        List<AbstractScenario> scenarioList = scenarioFunctionList.stream()
                .map(scenarioFunction -> scenarioFunction.apply(urlSupplier, httpClient))
                .toList();
        scenarioList.forEach(scenario -> scenarioMap.put(scenario.getClass(), scenario));
        scenarioList.forEach(Main::runScenario);
    }

    public static <T extends AbstractScenario> T getScenario(Class<T> clazz) {
        AbstractScenario scenario = scenarioMap.get(clazz);
        if (scenario == null) {
            throw new IllegalArgumentException("Scenario not found");
        }
        return clazz.cast(scenario);
    }

    public static void runScenario(AbstractScenario scenario) {
        try {
            Logger.info("[RUNNING] " + scenario.getClass().getSimpleName());
            scenario.before();
            scenario.run();
            scenario.after();
            Logger.info("[PASSED] " + scenario.getClass().getSimpleName());
        } catch (ScenarioException e) {
            Logger.error(e, "[FAILED] " + scenario.getClass().getSimpleName());
        } catch (Throwable throwable) {
            Logger.error(throwable, "[UNEXPECTED] " + scenario.getClass().getSimpleName());
        }
    }
}