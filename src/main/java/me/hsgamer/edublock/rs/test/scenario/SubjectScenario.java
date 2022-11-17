package me.hsgamer.edublock.rs.test.scenario;

import me.hsgamer.edublock.rs.test.JsonUtil;
import me.hsgamer.edublock.rs.test.SimpleAssert;
import me.hsgamer.edublock.rs.test.UrlSupplier;
import me.hsgamer.edublock.rs.test.annotation.Test;
import me.hsgamer.edublock.rs.test.model.output.SubjectListResponse;
import me.hsgamer.edublock.rs.test.model.output.SubjectResponse;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SubjectScenario extends AnnotatedScenario {
    public SubjectScenario(UrlSupplier urlSupplier, HttpClient httpClient) {
        super(urlSupplier, httpClient);
    }

    @Test
    private void getSubjectList() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/subject/list"))
                .headers("Content-Type", "application/json")
                .GET()
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        SubjectListResponse subjectListResponse = JsonUtil.fromJson(response.body(), SubjectListResponse.class);
        SimpleAssert.assertNotNull(subjectListResponse.getData());
        SimpleAssert.assertFalse(subjectListResponse.getData().isEmpty());
    }

    @Test
    private void getSubjectById() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/subject/1"))
                .headers("Content-Type", "application/json")
                .GET()
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        SubjectResponse subjectResponse = JsonUtil.fromJson(response.body(), SubjectResponse.class);
        SimpleAssert.assertNotNull(subjectResponse.getData());
        SimpleAssert.assertEquals(1L, subjectResponse.getData().getId());


        HttpRequest notFoundRequest = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/subject/0"))
                .headers("Content-Type", "application/json")
                .GET()
                .build();

        var notFoundResponse = httpClient.send(notFoundRequest, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(404, notFoundResponse.statusCode());
    }
}
