package me.hsgamer.edublock.rs.test.scenario;

import me.hsgamer.edublock.rs.test.UrlSupplier;

import java.net.http.HttpClient;

public abstract class AbstractScenario {
    protected final UrlSupplier urlSupplier;
    protected final HttpClient httpClient;

    protected AbstractScenario(UrlSupplier urlSupplier, HttpClient httpClient) {
        this.urlSupplier = urlSupplier;
        this.httpClient = httpClient;
    }

    public void before() throws Exception {
        // Do nothing
    }

    public abstract void run() throws Exception;

    public void after() throws Exception {
        // Do nothing
    }
}
