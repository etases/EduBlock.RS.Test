package me.hsgamer.edublock.rs.test.scenario;

import me.hsgamer.edublock.rs.test.JsonUtil;
import me.hsgamer.edublock.rs.test.Main;
import me.hsgamer.edublock.rs.test.SimpleAssert;
import me.hsgamer.edublock.rs.test.UrlSupplier;
import me.hsgamer.edublock.rs.test.annotation.Test;
import me.hsgamer.edublock.rs.test.model.output.StringListResponse;
import me.hsgamer.edublock.rs.test.model.output.StringResponse;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class UpdaterScenario extends AnnotatedScenario {
    String studentToken;
    String key;

    public UpdaterScenario(UrlSupplier urlSupplier, HttpClient httpClient) {
        super(urlSupplier, httpClient);
    }

    @Override
    public void before() {
        studentToken = Main.getScenario(AccountScenario.class).studentToken;
    }

    @Test
    private void createKey() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/updater"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + studentToken)
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        StringResponse stringResponse = JsonUtil.fromJson(response.body(), StringResponse.class);
        SimpleAssert.assertNotNull(stringResponse);
        SimpleAssert.assertNotNull(stringResponse.getData());
        key = stringResponse.getData();
    }

    @Test(order = 1)
    private void getKeyList() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/updater/list"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + studentToken)
                .GET()
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        StringListResponse stringResponse = JsonUtil.fromJson(response.body(), StringListResponse.class);
        SimpleAssert.assertNotNull(stringResponse);
        SimpleAssert.assertNotNull(stringResponse.getData());
        SimpleAssert.assertTrue(stringResponse.getData().contains(key));
    }

    @Test(order = 2)
    private void deleteKey() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/updater/" + key))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + studentToken)
                .DELETE()
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        HttpRequest getKeyListRequest = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/updater/list"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + studentToken)
                .GET()
                .build();

        var keyListResponse = httpClient.send(getKeyListRequest, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, keyListResponse.statusCode());

        StringListResponse stringResponse = JsonUtil.fromJson(keyListResponse.body(), StringListResponse.class);
        SimpleAssert.assertNotNull(stringResponse);
        SimpleAssert.assertNotNull(stringResponse.getData());
        SimpleAssert.assertFalse(stringResponse.getData().contains(key));
    }
}
