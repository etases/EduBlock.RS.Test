package me.hsgamer.edublock.rs.test.scenario;

import me.hsgamer.edublock.rs.test.JsonUtil;
import me.hsgamer.edublock.rs.test.Report;
import me.hsgamer.edublock.rs.test.SimpleAssert;
import me.hsgamer.edublock.rs.test.UrlSupplier;
import me.hsgamer.edublock.rs.test.annotation.Test;
import me.hsgamer.edublock.rs.test.model.output.ClassificationListResponse;
import me.hsgamer.edublock.rs.test.model.output.ClassificationResponse;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClassificationScenario extends AnnotatedScenario {
    public ClassificationScenario(UrlSupplier urlSupplier, HttpClient httpClient) {
        super(urlSupplier, httpClient);
    }

    @Test
    private void getClassificationList() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/classification/list"))
                .headers("Content-Type", "application/json")
                .GET()
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        ClassificationListResponse classificationListResponse = JsonUtil.fromJson(response.body(), ClassificationListResponse.class);
        SimpleAssert.assertNotNull(classificationListResponse.getData());
        SimpleAssert.assertFalse(classificationListResponse.getData().isEmpty());
    }

    @Test
    private void getClassificationById() throws IOException, InterruptedException {
        Report.addLabel("Found", 3);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/classification/good"))
                .headers("Content-Type", "application/json")
                .GET()
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        ClassificationResponse classificationResponse = JsonUtil.fromJson(response.body(), ClassificationResponse.class);
        SimpleAssert.assertNotNull(classificationResponse.getData());
        SimpleAssert.assertEquals("GOOD", classificationResponse.getData().getIdentifier());

        Report.addLabel("Not Found", 3);
        HttpRequest notFoundRequest = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/classification/null"))
                .headers("Content-Type", "application/json")
                .GET()
                .build();

        var notFoundResponse = httpClient.send(notFoundRequest, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(404, notFoundResponse.statusCode());
    }
}
