package me.hsgamer.edublock.rs.test.scenario;

import me.hsgamer.edublock.rs.test.JsonUtil;
import me.hsgamer.edublock.rs.test.SimpleAssert;
import me.hsgamer.edublock.rs.test.UrlSupplier;
import me.hsgamer.edublock.rs.test.annotation.Test;
import me.hsgamer.edublock.rs.test.model.input.AccountCreate;
import me.hsgamer.edublock.rs.test.model.input.AccountCreateListInput;
import me.hsgamer.edublock.rs.test.model.input.AccountLogin;
import me.hsgamer.edublock.rs.test.model.output.AccountWithProfileListResponse;
import me.hsgamer.edublock.rs.test.model.output.AccountWithProfileResponse;
import me.hsgamer.edublock.rs.test.model.output.Response;
import me.hsgamer.edublock.rs.test.model.output.StringResponse;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class AccountScenario extends AnnotatedScenario {
    String adminToken;
    String staffToken;
    String studentToken;
    String teacherToken;

    public AccountScenario(UrlSupplier urlSupplier, HttpClient httpClient) {
        super(urlSupplier, httpClient);
    }

    @Test
    private void createAccount() throws IOException, InterruptedException {
        AccountCreateListInput accountCreateListInput = new AccountCreateListInput(List.of(
                new AccountCreate(
                        "Tien",
                        "Huynh",
                        "Admin"
                ),
                new AccountCreate(
                        "Tu",
                        "Le",
                        "Staff"
                ),
                new AccountCreate(
                        "Da",
                        "Quach",
                        "Teacher"
                ),
                new AccountCreate(
                        "Uy",
                        "Cao Hoang Anh",
                        "Student"
                )
        ));
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/account/list"))
                .headers("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(JsonUtil.toJson(accountCreateListInput)))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        SimpleAssert.assertTrue(response.statusCode() == 200);

        AccountWithProfileListResponse accountWithProfileListResponse = JsonUtil.fromJson(response.body(), AccountWithProfileListResponse.class);
        SimpleAssert.assertNotNull(accountWithProfileListResponse.getData());
        SimpleAssert.assertEquals(4, accountWithProfileListResponse.getData().size());
        SimpleAssert.assertAnyMatch(accountWithProfileListResponse.getData(), accountWithProfile -> accountWithProfile.getAccount().getUsername().equals("TienH"));
        SimpleAssert.assertAnyMatch(accountWithProfileListResponse.getData(), accountWithProfile -> accountWithProfile.getAccount().getUsername().equals("TuL"));
        SimpleAssert.assertAnyMatch(accountWithProfileListResponse.getData(), accountWithProfile -> accountWithProfile.getAccount().getUsername().equals("DaQ"));
        SimpleAssert.assertAnyMatch(accountWithProfileListResponse.getData(), accountWithProfile -> accountWithProfile.getAccount().getUsername().equals("UyCHA"));
    }

    @Test(order = 1)
    private void loginAdmin() throws IOException, InterruptedException {
        AccountLogin accountLogin = new AccountLogin("TienH", "password");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/login"))
                .headers("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(JsonUtil.toJson(accountLogin)))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        SimpleAssert.assertTrue(response.statusCode() == 200);

        StringResponse stringResponse = JsonUtil.fromJson(response.body(), StringResponse.class);
        SimpleAssert.assertNotNull(stringResponse.getData());
        adminToken = stringResponse.getData();
    }

    @Test(order = 1)
    private void loginStaff() throws IOException, InterruptedException {
        AccountLogin accountLogin = new AccountLogin("TuL", "password");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/login"))
                .headers("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(JsonUtil.toJson(accountLogin)))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        SimpleAssert.assertTrue(response.statusCode() == 200);

        StringResponse stringResponse = JsonUtil.fromJson(response.body(), StringResponse.class);
        SimpleAssert.assertNotNull(stringResponse.getData());
        staffToken = stringResponse.getData();
    }

    @Test(order = 1)
    private void loginTeacher() throws IOException, InterruptedException {
        AccountLogin accountLogin = new AccountLogin("DaQ", "password");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/login"))
                .headers("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(JsonUtil.toJson(accountLogin)))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        SimpleAssert.assertTrue(response.statusCode() == 200);

        StringResponse stringResponse = JsonUtil.fromJson(response.body(), StringResponse.class);
        SimpleAssert.assertNotNull(stringResponse.getData());
        teacherToken = stringResponse.getData();
    }

    @Test(order = 1)
    private void loginStudent() throws IOException, InterruptedException {
        AccountLogin accountLogin = new AccountLogin("UyCHA", "password");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/login"))
                .headers("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(JsonUtil.toJson(accountLogin)))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        SimpleAssert.assertTrue(response.statusCode() == 200);

        StringResponse stringResponse = JsonUtil.fromJson(response.body(), StringResponse.class);
        SimpleAssert.assertNotNull(stringResponse.getData());
        studentToken = stringResponse.getData();
    }

    @Test(order = 1)
    private void loginInvalid() throws IOException, InterruptedException {
        AccountLogin accountLogin = new AccountLogin("Null", "password");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/login"))
                .headers("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(JsonUtil.toJson(accountLogin)))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        SimpleAssert.assertTrue(response.statusCode() == 401);
    }

    @Test(order = 2)
    private void authorizeCheck() throws IOException, InterruptedException {
        HttpRequest adminRequest = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/helloadmin"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + adminToken)
                .GET()
                .build();

        HttpRequest staffRequest = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/helloadmin"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + staffToken)
                .GET()
                .build();

        HttpRequest teacherRequest = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/helloadmin"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + teacherToken)
                .GET()
                .build();

        HttpRequest studentRequest = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/helloadmin"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + studentToken)
                .GET()
                .build();

        HttpResponse<String> adminResponse = httpClient.send(adminRequest, HttpResponse.BodyHandlers.ofString());
        HttpResponse<String> staffResponse = httpClient.send(staffRequest, HttpResponse.BodyHandlers.ofString());
        HttpResponse<String> teacherResponse = httpClient.send(teacherRequest, HttpResponse.BodyHandlers.ofString());
        HttpResponse<String> studentResponse = httpClient.send(studentRequest, HttpResponse.BodyHandlers.ofString());

        SimpleAssert.assertEquals(200, adminResponse.statusCode());
        SimpleAssert.assertEquals(401, staffResponse.statusCode());
        SimpleAssert.assertEquals(401, teacherResponse.statusCode());
        SimpleAssert.assertEquals(401, studentResponse.statusCode());

        SimpleAssert.assertEquals("Hello Admin", adminResponse.body());
        SimpleAssert.assertEquals(-1990, JsonUtil.fromJson(staffResponse.body(), Response.class).getStatus());
        SimpleAssert.assertEquals(-1990, JsonUtil.fromJson(teacherResponse.body(), Response.class).getStatus());
        SimpleAssert.assertEquals(-1990, JsonUtil.fromJson(studentResponse.body(), Response.class).getStatus());
    }

    @Test(order = 3)
    private void getOwnAccount() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/account"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + adminToken)
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        SimpleAssert.assertTrue(response.statusCode() == 200);

        AccountWithProfileResponse accountWithProfileResponse = JsonUtil.fromJson(response.body(), AccountWithProfileResponse.class);
        SimpleAssert.assertNotNull(accountWithProfileResponse.getData());
        SimpleAssert.assertEquals("TienH", accountWithProfileResponse.getData().getAccount().getUsername());

        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/account"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + staffToken)
                .GET()
                .build();

        HttpResponse<String> response2 = httpClient.send(request2, HttpResponse.BodyHandlers.ofString());

        SimpleAssert.assertTrue(response2.statusCode() == 200);

        AccountWithProfileResponse accountWithProfileResponse2 = JsonUtil.fromJson(response2.body(), AccountWithProfileResponse.class);
        SimpleAssert.assertNotNull(accountWithProfileResponse2.getData());
        SimpleAssert.assertEquals("TuL", accountWithProfileResponse2.getData().getAccount().getUsername());
    }

    @Test(order = 4)
    private void getAccount() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/account/1"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + adminToken)
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        SimpleAssert.assertTrue(response.statusCode() == 200);

        AccountWithProfileResponse accountWithProfileResponse = JsonUtil.fromJson(response.body(), AccountWithProfileResponse.class);
        SimpleAssert.assertNotNull(accountWithProfileResponse.getData());
        SimpleAssert.assertEquals("TienH", accountWithProfileResponse.getData().getAccount().getUsername());

        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/account/2"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + staffToken)
                .GET()
                .build();

        HttpResponse<String> response2 = httpClient.send(request2, HttpResponse.BodyHandlers.ofString());

        SimpleAssert.assertTrue(response2.statusCode() == 200);

        AccountWithProfileResponse accountWithProfileResponse2 = JsonUtil.fromJson(response2.body(), AccountWithProfileResponse.class);
        SimpleAssert.assertNotNull(accountWithProfileResponse2.getData());
        SimpleAssert.assertEquals("TuL", accountWithProfileResponse2.getData().getAccount().getUsername());

        HttpRequest request3 = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/account/100"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + teacherToken)
                .GET()
                .build();

        HttpResponse<String> response3 = httpClient.send(request3, HttpResponse.BodyHandlers.ofString());

        SimpleAssert.assertTrue(response3.statusCode() == 404);

        AccountWithProfileResponse accountWithProfileResponse3 = JsonUtil.fromJson(response3.body(), AccountWithProfileResponse.class);
        SimpleAssert.assertEquals(1, accountWithProfileResponse3.getStatus());
        SimpleAssert.assertNull(accountWithProfileResponse3.getData());
    }

    @Test(order = 5)
    private void getAllAccount() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/account/list"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + adminToken)
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        SimpleAssert.assertTrue(response.statusCode() == 200);

        AccountWithProfileListResponse accountWithProfileListResponse = JsonUtil.fromJson(response.body(), AccountWithProfileListResponse.class);
        SimpleAssert.assertNotNull(accountWithProfileListResponse.getData());
        SimpleAssert.assertEquals(4, accountWithProfileListResponse.getData().size());

    }
}
