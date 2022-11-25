package me.hsgamer.edublock.rs.test.scenario;

import me.hsgamer.edublock.rs.test.JsonUtil;
import me.hsgamer.edublock.rs.test.Report;
import me.hsgamer.edublock.rs.test.SimpleAssert;
import me.hsgamer.edublock.rs.test.UrlSupplier;
import me.hsgamer.edublock.rs.test.annotation.Test;
import me.hsgamer.edublock.rs.test.model.input.*;
import me.hsgamer.edublock.rs.test.model.output.*;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
                new AccountCreate( // ID: 1
                        "Tien",
                        "Huynh",
                        "Admin"
                ),
                new AccountCreate( // ID: 2
                        "Tu",
                        "Le",
                        "Staff"
                ),
                new AccountCreate( // ID: 3
                        "Da",
                        "Quach",
                        "Teacher"
                ),
                new AccountCreate( // ID: 4
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

        Report.addLabel("Admin", 3);
        HttpResponse<String> adminResponse = httpClient.send(adminRequest, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, adminResponse.statusCode());
        SimpleAssert.assertEquals("Hello Admin", adminResponse.body());

        Report.addLabel("Staff", 3);
        HttpResponse<String> staffResponse = httpClient.send(staffRequest, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(401, staffResponse.statusCode());
        SimpleAssert.assertEquals(-1990, JsonUtil.fromJson(staffResponse.body(), Response.class).getStatus());

        Report.addLabel("Teacher", 3);
        HttpResponse<String> teacherResponse = httpClient.send(teacherRequest, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(401, teacherResponse.statusCode());
        SimpleAssert.assertEquals(-1990, JsonUtil.fromJson(teacherResponse.body(), Response.class).getStatus());

        Report.addLabel("Student", 3);
        HttpResponse<String> studentResponse = httpClient.send(studentRequest, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(401, studentResponse.statusCode());
        SimpleAssert.assertEquals(-1990, JsonUtil.fromJson(studentResponse.body(), Response.class).getStatus());
    }

    @Test(order = 3)
    private void getOwnAccount() throws IOException, InterruptedException {
        Report.addLabel("Admin", 3);
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

        Report.addLabel("Staff", 3);
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
        Report.addLabel("Admin", 3);
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

        Report.addLabel("Staff", 3);
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

        Report.addLabel("Teacher", 3);
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
        SimpleAssert.assertAnyMatch(accountWithProfileListResponse.getData(), accountWithProfile -> accountWithProfile.getAccount().getUsername().equals("TienH"));
        SimpleAssert.assertAnyMatch(accountWithProfileListResponse.getData(), accountWithProfile -> accountWithProfile.getAccount().getUsername().equals("TuL"));
        SimpleAssert.assertAnyMatch(accountWithProfileListResponse.getData(), accountWithProfile -> accountWithProfile.getAccount().getUsername().equals("DaQ"));
        SimpleAssert.assertAnyMatch(accountWithProfileListResponse.getData(), accountWithProfile -> accountWithProfile.getAccount().getUsername().equals("UyCHA"));
    }

    @Test(order = 5)
    private void getPagedAllAccount() throws IOException, InterruptedException {
        Report.addLabel("Page 1", 3);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/account/list", Map.of("pageNumber", "1", "pageSize", "2")))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + adminToken)
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        SimpleAssert.assertTrue(response.statusCode() == 200);

        AccountWithProfileListResponse accountWithProfileListResponse = JsonUtil.fromJson(response.body(), AccountWithProfileListResponse.class);
        SimpleAssert.assertNotNull(accountWithProfileListResponse.getData());
        SimpleAssert.assertEquals(2, accountWithProfileListResponse.getData().size());
        SimpleAssert.assertAnyMatch(accountWithProfileListResponse.getData(), accountWithProfile -> accountWithProfile.getAccount().getUsername().equals("TienH"));
        SimpleAssert.assertAnyMatch(accountWithProfileListResponse.getData(), accountWithProfile -> accountWithProfile.getAccount().getUsername().equals("TuL"));

        Report.addLabel("Page 2", 3);
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/account/list", Map.of("pageNumber", "2", "pageSize", "2")))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + adminToken)
                .GET()
                .build();

        HttpResponse<String> response2 = httpClient.send(request2, HttpResponse.BodyHandlers.ofString());

        SimpleAssert.assertTrue(response2.statusCode() == 200);

        AccountWithProfileListResponse accountWithProfileListResponse2 = JsonUtil.fromJson(response2.body(), AccountWithProfileListResponse.class);
        SimpleAssert.assertNotNull(accountWithProfileListResponse2.getData());
        SimpleAssert.assertEquals(2, accountWithProfileListResponse2.getData().size());
        SimpleAssert.assertAnyMatch(accountWithProfileListResponse2.getData(), accountWithProfile -> accountWithProfile.getAccount().getUsername().equals("DaQ"));
        SimpleAssert.assertAnyMatch(accountWithProfileListResponse2.getData(), accountWithProfile -> accountWithProfile.getAccount().getUsername().equals("UyCHA"));
    }

    @Test(order = 6)
    private void getAccountByRole() throws IOException, InterruptedException {
        HttpRequest adminRequest = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/account/role/admin/list"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + adminToken)
                .GET()
                .build();
        HttpRequest teacherRequest = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/account/role/teacher/list"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + adminToken)
                .GET()
                .build();
        HttpRequest studentRequest = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/account/role/student/list"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + adminToken)
                .GET()
                .build();
        HttpRequest staffRequest = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/account/role/staff/list"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + adminToken)
                .GET()
                .build();

        Report.addLabel("Admin", 3);
        HttpResponse<String> adminResponse = httpClient.send(adminRequest, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertTrue(adminResponse.statusCode() == 200);
        AccountWithProfileListResponse adminResponseData = JsonUtil.fromJson(adminResponse.body(), AccountWithProfileListResponse.class);
        SimpleAssert.assertNotNull(adminResponseData.getData());
        SimpleAssert.assertEquals(1, adminResponseData.getData().size());
        SimpleAssert.assertAnyMatch(adminResponseData.getData(), accountWithProfile -> accountWithProfile.getAccount().getUsername().equals("TienH"));

        Report.addLabel("Teacher", 3);
        HttpResponse<String> teacherResponse = httpClient.send(teacherRequest, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertTrue(teacherResponse.statusCode() == 200);
        AccountWithProfileListResponse teacherResponseData = JsonUtil.fromJson(teacherResponse.body(), AccountWithProfileListResponse.class);
        SimpleAssert.assertNotNull(teacherResponseData.getData());
        SimpleAssert.assertEquals(1, teacherResponseData.getData().size());
        SimpleAssert.assertAnyMatch(teacherResponseData.getData(), accountWithProfile -> accountWithProfile.getAccount().getUsername().equals("DaQ"));

        Report.addLabel("Student", 3);
        HttpResponse<String> studentResponse = httpClient.send(studentRequest, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertTrue(studentResponse.statusCode() == 200);
        AccountWithStudentProfileListResponse studentResponseData = JsonUtil.fromJson(studentResponse.body(), AccountWithStudentProfileListResponse.class);
        SimpleAssert.assertNotNull(studentResponseData.getData());
        SimpleAssert.assertEquals(1, studentResponseData.getData().size());
        SimpleAssert.assertAnyMatch(studentResponseData.getData(), accountWithProfile -> accountWithProfile.getAccount().getUsername().equals("UyCHA"));

        Report.addLabel("Staff", 3);
        HttpResponse<String> staffResponse = httpClient.send(staffRequest, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertTrue(staffResponse.statusCode() == 200);
        AccountWithProfileListResponse staffResponseData = JsonUtil.fromJson(staffResponse.body(), AccountWithProfileListResponse.class);
        SimpleAssert.assertNotNull(staffResponseData.getData());
        SimpleAssert.assertEquals(1, staffResponseData.getData().size());
        SimpleAssert.assertAnyMatch(staffResponseData.getData(), accountWithProfile -> accountWithProfile.getAccount().getUsername().equals("TuL"));
    }

    @Test(order = 7)
    private void changePassword() throws IOException, InterruptedException {
        AccountLogin accountLogin = new AccountLogin("TienH", "123456");
        AccountLoginListInput accountLoginListInput = new AccountLoginListInput(List.of(accountLogin));
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/account/list/password"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + adminToken)
                .PUT(HttpRequest.BodyPublishers.ofString(JsonUtil.toJson(accountLoginListInput)))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        SimpleAssert.assertEquals(200, response.statusCode());

        HttpRequest loginRequest = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/login"))
                .headers("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(JsonUtil.toJson(accountLogin)))
                .build();

        HttpResponse<String> loginResponse = httpClient.send(loginRequest, HttpResponse.BodyHandlers.ofString());

        SimpleAssert.assertEquals(200, loginResponse.statusCode());
        StringResponse stringResponse = JsonUtil.fromJson(loginResponse.body(), StringResponse.class);
        SimpleAssert.assertNotNull(stringResponse.getData());
        adminToken = stringResponse.getData();
    }

    @Test(order = 8)
    private void changeSelfProfile() throws IOException, InterruptedException {
        ProfileUpdate profileUpdate = new ProfileUpdate(
                "Tien",
                "Huynh",
                true,
                "",
                Date.from(Instant.EPOCH),
                "Ha Noi",
                "0123456789",
                "test@test.com"
        );
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/account/self/profile"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + adminToken)
                .PUT(HttpRequest.BodyPublishers.ofString(JsonUtil.toJson(profileUpdate)))
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        HttpRequest getProfileRequest = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/account"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + adminToken)
                .GET()
                .build();

        var getProfileResponse = httpClient.send(getProfileRequest, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, getProfileResponse.statusCode());
        AccountWithProfileResponse accountWithProfileResponse = JsonUtil.fromJson(getProfileResponse.body(), AccountWithProfileResponse.class);
        SimpleAssert.assertNotNull(accountWithProfileResponse.getData());
        SimpleAssert.assertEquals("Tien", accountWithProfileResponse.getData().getProfile().getFirstName());
        SimpleAssert.assertEquals("Huynh", accountWithProfileResponse.getData().getProfile().getLastName());
        SimpleAssert.assertEquals(true, accountWithProfileResponse.getData().getProfile().isMale());
        SimpleAssert.assertEquals("", accountWithProfileResponse.getData().getProfile().getAvatar());
        SimpleAssert.assertEquals(Date.from(Instant.EPOCH), accountWithProfileResponse.getData().getProfile().getBirthDate());
        SimpleAssert.assertEquals("Ha Noi", accountWithProfileResponse.getData().getProfile().getAddress());
        SimpleAssert.assertEquals("0123456789", accountWithProfileResponse.getData().getProfile().getPhone());
        SimpleAssert.assertEquals("test@test.com", accountWithProfileResponse.getData().getProfile().getEmail());
    }

    @Test(order = 9)
    private void changeProfile() throws IOException, InterruptedException {
        ProfileUpdate profileUpdate = new ProfileUpdate(
                "Da",
                "Quach",
                true,
                "",
                Date.from(Instant.EPOCH),
                "Ha Noi",
                "0123456789",
                "daql@test.com"
        );
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/account/3/profile"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + staffToken)
                .PUT(HttpRequest.BodyPublishers.ofString(JsonUtil.toJson(profileUpdate)))
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        HttpRequest getProfileRequest = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/account/3"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + staffToken)
                .GET()
                .build();

        var getProfileResponse = httpClient.send(getProfileRequest, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, getProfileResponse.statusCode());

        AccountWithProfileResponse accountWithProfileResponse = JsonUtil.fromJson(getProfileResponse.body(), AccountWithProfileResponse.class);
        SimpleAssert.assertNotNull(accountWithProfileResponse.getData());
        SimpleAssert.assertEquals("Da", accountWithProfileResponse.getData().getProfile().getFirstName());
        SimpleAssert.assertEquals("Quach", accountWithProfileResponse.getData().getProfile().getLastName());
        SimpleAssert.assertEquals(true, accountWithProfileResponse.getData().getProfile().isMale());
        SimpleAssert.assertEquals("", accountWithProfileResponse.getData().getProfile().getAvatar());
        SimpleAssert.assertEquals(Date.from(Instant.EPOCH), accountWithProfileResponse.getData().getProfile().getBirthDate());
        SimpleAssert.assertEquals("Ha Noi", accountWithProfileResponse.getData().getProfile().getAddress());
        SimpleAssert.assertEquals("0123456789", accountWithProfileResponse.getData().getProfile().getPhone());
        SimpleAssert.assertEquals("daql@test.com", accountWithProfileResponse.getData().getProfile().getEmail());
    }

    @Test(order = 10)
    private void updateStudentProfile() throws IOException, InterruptedException {
        Report.addLabel("Valid", 3);
        StudentUpdate studentUpdate = new StudentUpdate(
                "Kinh",
                "Nguyen Van A",
                "Giang vien",
                "Tran Thi B",
                "Mua ban",
                "Trang Thi C",
                "Ki su",
                "Can Tho"
        );
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/account/4/student"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + staffToken)
                .PUT(HttpRequest.BodyPublishers.ofString(JsonUtil.toJson(studentUpdate)))
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        HttpRequest getProfileRequest = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/account/4"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + staffToken)
                .GET()
                .build();

        var getProfileResponse = httpClient.send(getProfileRequest, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, getProfileResponse.statusCode());

        AccountWithStudentProfileResponse accountWithStudentProfileResponse = JsonUtil.fromJson(getProfileResponse.body(), AccountWithStudentProfileResponse.class);
        SimpleAssert.assertNotNull(accountWithStudentProfileResponse.getData());
        SimpleAssert.assertNotNull(accountWithStudentProfileResponse.getData().getStudent());
        SimpleAssert.assertEquals("Kinh", accountWithStudentProfileResponse.getData().getStudent().getEthnic());
        SimpleAssert.assertEquals("Nguyen Van A", accountWithStudentProfileResponse.getData().getStudent().getFatherName());
        SimpleAssert.assertEquals("Giang vien", accountWithStudentProfileResponse.getData().getStudent().getFatherJob());
        SimpleAssert.assertEquals("Tran Thi B", accountWithStudentProfileResponse.getData().getStudent().getMotherName());
        SimpleAssert.assertEquals("Mua ban", accountWithStudentProfileResponse.getData().getStudent().getMotherJob());
        SimpleAssert.assertEquals("Trang Thi C", accountWithStudentProfileResponse.getData().getStudent().getGuardianName());
        SimpleAssert.assertEquals("Ki su", accountWithStudentProfileResponse.getData().getStudent().getGuardianJob());
        SimpleAssert.assertEquals("Can Tho", accountWithStudentProfileResponse.getData().getStudent().getHomeTown());

        Report.addLabel("Invalid", 3);
        HttpRequest invalidRequest = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/account/3/student"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + staffToken)
                .PUT(HttpRequest.BodyPublishers.ofString(JsonUtil.toJson(studentUpdate)))
                .build();

        var invalidResponse = httpClient.send(invalidRequest, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(404, invalidResponse.statusCode());
    }
}
