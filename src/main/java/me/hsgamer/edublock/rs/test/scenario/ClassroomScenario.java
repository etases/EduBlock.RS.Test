package me.hsgamer.edublock.rs.test.scenario;

import me.hsgamer.edublock.rs.test.JsonUtil;
import me.hsgamer.edublock.rs.test.Main;
import me.hsgamer.edublock.rs.test.SimpleAssert;
import me.hsgamer.edublock.rs.test.UrlSupplier;
import me.hsgamer.edublock.rs.test.annotation.Test;
import me.hsgamer.edublock.rs.test.model.input.*;
import me.hsgamer.edublock.rs.test.model.output.AccountWithStudentProfileListResponse;
import me.hsgamer.edublock.rs.test.model.output.ClassroomListResponse;
import me.hsgamer.edublock.rs.test.model.output.ClassroomResponse;
import me.hsgamer.edublock.rs.test.model.output.TeacherWithSubjectListResponse;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ClassroomScenario extends AnnotatedScenario {
    String adminToken;
    String staffToken;
    String studentToken;
    String teacherToken;

    public ClassroomScenario(UrlSupplier urlSupplier, HttpClient httpClient) {
        super(urlSupplier, httpClient);
    }

    @Override
    public void before() {
        var accountScenario = Main.getScenario(AccountScenario.class);
        adminToken = accountScenario.adminToken;
        staffToken = accountScenario.staffToken;
        studentToken = accountScenario.studentToken;
        teacherToken = accountScenario.teacherToken;
    }

    @Test
    private void createClassroom() throws IOException, InterruptedException {
        ClassCreate classCreate = new ClassCreate(
                "10A2",
                10,
                2020,
                3
        );
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/classroom"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + staffToken)
                .POST(HttpRequest.BodyPublishers.ofString(JsonUtil.toJson(classCreate)))
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        ClassroomResponse classroomResponse = JsonUtil.fromJson(response.body(), ClassroomResponse.class);
        SimpleAssert.assertNotNull(classroomResponse.getData());
        SimpleAssert.assertEquals(1L, classroomResponse.getData().getId());
        SimpleAssert.assertEquals(classCreate.getName(), classroomResponse.getData().getName());
        SimpleAssert.assertEquals(classCreate.getGrade(), classroomResponse.getData().getGrade());
        SimpleAssert.assertEquals(classCreate.getYear(), classroomResponse.getData().getYear());
        SimpleAssert.assertEquals(classCreate.getHomeroomTeacherId(), classroomResponse.getData().getHomeroomTeacher().getAccount().getId());
    }

    @Test(order = 1)
    private void addStudentToClassroom() throws IOException, InterruptedException {
        AccountListInput accountListInput = new AccountListInput(List.of(4L));
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/classroom/1/student"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + staffToken)
                .POST(HttpRequest.BodyPublishers.ofString(JsonUtil.toJson(accountListInput)))
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());
    }

    @Test(order = 1)
    private void addTeacherToClassroom() throws IOException, InterruptedException {
        TeacherWithSubjectListInput teacherWithSubjectListInput = new TeacherWithSubjectListInput(List.of(new TeacherWithSubjectInput(3L, 1L)));
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/classroom/1/teacher"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + staffToken)
                .POST(HttpRequest.BodyPublishers.ofString(JsonUtil.toJson(teacherWithSubjectListInput)))
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());
    }

    @Test(order = 2)
    private void getStudentFromClassroom() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/classroom/1/student"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + staffToken)
                .GET()
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        AccountWithStudentProfileListResponse accountWithStudentProfileListResponse = JsonUtil.fromJson(response.body(), AccountWithStudentProfileListResponse.class);
        SimpleAssert.assertNotNull(accountWithStudentProfileListResponse.getData());
        SimpleAssert.assertEquals(1, accountWithStudentProfileListResponse.getData().size());
        SimpleAssert.assertAnyMatch(accountWithStudentProfileListResponse.getData(), accountWithStudentProfile -> accountWithStudentProfile.getAccount().getId() == 4L);
    }

    @Test(order = 2)
    private void getTeacherFromClassroom() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/classroom/1/teacher"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + staffToken)
                .GET()
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        TeacherWithSubjectListResponse teacherWithSubjectListResponse = JsonUtil.fromJson(response.body(), TeacherWithSubjectListResponse.class);
        SimpleAssert.assertNotNull(teacherWithSubjectListResponse.getData());
        SimpleAssert.assertEquals(1, teacherWithSubjectListResponse.getData().size());
        SimpleAssert.assertAnyMatch(teacherWithSubjectListResponse.getData(), teacherWithSubject -> teacherWithSubject.getSubject().getId() == 1L && teacherWithSubject.getAccount().getAccount().getId() == 3L);
    }

    @Test(order = 3)
    private void removeStudentFromClassroom() throws IOException, InterruptedException {
        AccountListInput accountListInput = new AccountListInput(List.of(4L));
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/classroom/1/student"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + staffToken)
                .method("DELETE", HttpRequest.BodyPublishers.ofString(JsonUtil.toJson(accountListInput)))
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        addStudentToClassroom();
    }

    @Test(order = 3)
    private void removeTeacherFromClassroom() throws IOException, InterruptedException {
        TeacherWithSubjectListInput teacherWithSubjectListInput = new TeacherWithSubjectListInput(List.of(new TeacherWithSubjectInput(3L, 1L)));
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/classroom/1/teacher"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + staffToken)
                .method("DELETE", HttpRequest.BodyPublishers.ofString(JsonUtil.toJson(teacherWithSubjectListInput)))
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        addTeacherToClassroom();
    }

    @Test(order = 4)
    private void getClassroomList() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/classroom"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + staffToken)
                .GET()
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        ClassroomListResponse classroomListResponse = JsonUtil.fromJson(response.body(), ClassroomListResponse.class);
        SimpleAssert.assertNotNull(classroomListResponse.getData());
        SimpleAssert.assertEquals(1, classroomListResponse.getData().size());
        SimpleAssert.assertAnyMatch(classroomListResponse.getData(), classroom -> classroom.getId() == 1L);
    }

    @Test(order = 4)
    private void getClassroomListAsTeacher() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/classroom/teacher"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + teacherToken)
                .GET()
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        ClassroomListResponse classroomListResponse = JsonUtil.fromJson(response.body(), ClassroomListResponse.class);
        SimpleAssert.assertNotNull(classroomListResponse.getData());
        SimpleAssert.assertEquals(1, classroomListResponse.getData().size());
        SimpleAssert.assertAnyMatch(classroomListResponse.getData(), classroom -> classroom.getId() == 1L);
    }

    @Test(order = 4)
    private void getClassroomListAsStudent() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/classroom/student"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + studentToken)
                .GET()
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        ClassroomListResponse classroomListResponse = JsonUtil.fromJson(response.body(), ClassroomListResponse.class);
        SimpleAssert.assertNotNull(classroomListResponse.getData());
        SimpleAssert.assertEquals(1, classroomListResponse.getData().size());
        SimpleAssert.assertAnyMatch(classroomListResponse.getData(), classroom -> classroom.getId() == 1L);
    }

    @Test(order = 4)
    private void getClassroomListAsHomeroom() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/classroom/homeroom"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + teacherToken)
                .GET()
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        ClassroomListResponse classroomListResponse = JsonUtil.fromJson(response.body(), ClassroomListResponse.class);
        SimpleAssert.assertNotNull(classroomListResponse.getData());
        SimpleAssert.assertEquals(1, classroomListResponse.getData().size());
        SimpleAssert.assertAnyMatch(classroomListResponse.getData(), classroom -> classroom.getId() == 1L);
    }

    @Test(order = 4)
    private void getClassroomById() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/classroom/1"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + staffToken)
                .GET()
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        ClassroomResponse classroomResponse = JsonUtil.fromJson(response.body(), ClassroomResponse.class);
        SimpleAssert.assertNotNull(classroomResponse.getData());
        SimpleAssert.assertEquals(1L, classroomResponse.getData().getId());
    }

    @Test(order = 5)
    private void updateClassroom() throws IOException, InterruptedException {
        ClassUpdate classroomUpdate = new ClassUpdate(
                "10A1",
                10,
                2021,
                3
        );
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/classroom/1"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + staffToken)
                .PUT(HttpRequest.BodyPublishers.ofString(JsonUtil.toJson(classroomUpdate)))
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());


        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/classroom/1"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + staffToken)
                .GET()
                .build();

        var getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, getResponse.statusCode());

        ClassroomResponse classroomResponse = JsonUtil.fromJson(getResponse.body(), ClassroomResponse.class);
        SimpleAssert.assertNotNull(classroomResponse.getData());
        SimpleAssert.assertEquals(1L, classroomResponse.getData().getId());
        SimpleAssert.assertEquals(classroomUpdate.getName(), classroomResponse.getData().getName());
        SimpleAssert.assertEquals(classroomUpdate.getGrade(), classroomResponse.getData().getGrade());
        SimpleAssert.assertEquals(classroomUpdate.getYear(), classroomResponse.getData().getYear());
        SimpleAssert.assertEquals(classroomUpdate.getHomeroomTeacherId(), classroomResponse.getData().getHomeroomTeacher().getAccount().getId());
    }
}
