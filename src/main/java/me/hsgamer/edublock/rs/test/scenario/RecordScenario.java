package me.hsgamer.edublock.rs.test.scenario;

import me.hsgamer.edublock.rs.test.*;
import me.hsgamer.edublock.rs.test.annotation.Test;
import me.hsgamer.edublock.rs.test.model.input.PendingRecordEntryInput;
import me.hsgamer.edublock.rs.test.model.input.PendingRecordEntryListInput;
import me.hsgamer.edublock.rs.test.model.input.PendingRecordEntryVerify;
import me.hsgamer.edublock.rs.test.model.output.PendingRecordEntryListResponse;
import me.hsgamer.edublock.rs.test.model.output.RecordResponse;
import me.hsgamer.edublock.rs.test.model.output.RecordWithStudentListResponse;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class RecordScenario extends AnnotatedScenario {
    String adminToken;
    String staffToken;
    String studentToken;
    String teacherToken;

    public RecordScenario(UrlSupplier urlSupplier, HttpClient httpClient) {
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
    private void requestChange() throws IOException, InterruptedException {
        Report.addLabel("Request 1", 3);
        PendingRecordEntryInput pendingRecordEntryInput = new PendingRecordEntryInput(
                4,
                1,
                5,
                5,
                5,
                1
        );
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/record/request"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + teacherToken)
                .POST(HttpRequest.BodyPublishers.ofString(JsonUtil.toJson(pendingRecordEntryInput)))
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        Report.addLabel("Request 2", 3);
        PendingRecordEntryInput pendingRecordEntryInput2 = new PendingRecordEntryInput(
                4,
                1,
                10,
                10,
                10,
                1
        );
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/record/request"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + studentToken)
                .POST(HttpRequest.BodyPublishers.ofString(JsonUtil.toJson(pendingRecordEntryInput2)))
                .build();

        var response2 = httpClient.send(request2, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response2.statusCode());
    }

    @Test
    private void bulkRequest() throws IOException, InterruptedException {
        Report.addLabel("Valid Request", 3);
        PendingRecordEntryListInput pendingRecordEntryListInput = new PendingRecordEntryListInput(List.of(
                new PendingRecordEntryInput(
                        4,
                        1,
                        1,
                        2,
                        3,
                        1
                ),
                new PendingRecordEntryInput(
                        4,
                        1,
                        5,
                        6,
                        7,
                        1
                )
        ));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/record/request/list"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + teacherToken)
                .POST(HttpRequest.BodyPublishers.ofString(JsonUtil.toJson(pendingRecordEntryListInput)))
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        Report.addLabel("Invalid Request", 3);
        PendingRecordEntryListInput pendingRecordEntryListInput2 = new PendingRecordEntryListInput(List.of(
                new PendingRecordEntryInput(
                        1,
                        1,
                        1,
                        2,
                        3,
                        1
                ),
                new PendingRecordEntryInput(
                        4,
                        1,
                        5,
                        6,
                        7,
                        1
                )
        ));

        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/record/request/list"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + studentToken)
                .POST(HttpRequest.BodyPublishers.ofString(JsonUtil.toJson(pendingRecordEntryListInput2)))
                .build();

        var response2 = httpClient.send(request2, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(400, response2.statusCode());
    }

    @Test(order = 1)
    private void getPendingRecordEntries() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/record/pending/list"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + teacherToken)
                .GET()
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        PendingRecordEntryListResponse pendingRecordEntryListResponse = JsonUtil.fromJson(response.body(), PendingRecordEntryListResponse.class);
        SimpleAssert.assertNotNull(pendingRecordEntryListResponse.getData());
        SimpleAssert.assertEquals(4, pendingRecordEntryListResponse.getData().size());
        SimpleAssert.assertAnyMatch(pendingRecordEntryListResponse.getData(), pendingRecordEntry ->
                pendingRecordEntry.getStudent().getAccount().getId() == 4
                        && pendingRecordEntry.getClassroom().getId() == 1
                        && pendingRecordEntry.getSubject().getId() == 1
                        && pendingRecordEntry.getFirstHalfScore() == 5
                        && pendingRecordEntry.getSecondHalfScore() == 5
                        && pendingRecordEntry.getFinalScore() == 5
        );
        SimpleAssert.assertAnyMatch(pendingRecordEntryListResponse.getData(), pendingRecordEntry ->
                pendingRecordEntry.getStudent().getAccount().getId() == 4
                        && pendingRecordEntry.getClassroom().getId() == 1
                        && pendingRecordEntry.getSubject().getId() == 1
                        && pendingRecordEntry.getFirstHalfScore() == 10
                        && pendingRecordEntry.getSecondHalfScore() == 10
                        && pendingRecordEntry.getFinalScore() == 10
        );
        SimpleAssert.assertAnyMatch(pendingRecordEntryListResponse.getData(), pendingRecordEntry ->
                pendingRecordEntry.getStudent().getAccount().getId() == 4
                        && pendingRecordEntry.getClassroom().getId() == 1
                        && pendingRecordEntry.getSubject().getId() == 1
                        && pendingRecordEntry.getFirstHalfScore() == 1
                        && pendingRecordEntry.getSecondHalfScore() == 2
                        && pendingRecordEntry.getFinalScore() == 3
        );
        SimpleAssert.assertAnyMatch(pendingRecordEntryListResponse.getData(), pendingRecordEntry ->
                pendingRecordEntry.getStudent().getAccount().getId() == 4
                        && pendingRecordEntry.getClassroom().getId() == 1
                        && pendingRecordEntry.getSubject().getId() == 1
                        && pendingRecordEntry.getFirstHalfScore() == 5
                        && pendingRecordEntry.getSecondHalfScore() == 6
                        && pendingRecordEntry.getFinalScore() == 7
        );
    }

    @Test(order = 1)
    private void getPendingRecordEntriesByStudentId() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/record/pending/list/4"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + teacherToken)
                .GET()
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        PendingRecordEntryListResponse pendingRecordEntryListResponse = JsonUtil.fromJson(response.body(), PendingRecordEntryListResponse.class);
        SimpleAssert.assertNotNull(pendingRecordEntryListResponse.getData());
        SimpleAssert.assertEquals(4, pendingRecordEntryListResponse.getData().size());
        SimpleAssert.assertAnyMatch(pendingRecordEntryListResponse.getData(), pendingRecordEntry ->
                pendingRecordEntry.getStudent().getAccount().getId() == 4
                        && pendingRecordEntry.getClassroom().getId() == 1
                        && pendingRecordEntry.getSubject().getId() == 1
                        && pendingRecordEntry.getFirstHalfScore() == 5
                        && pendingRecordEntry.getSecondHalfScore() == 5
                        && pendingRecordEntry.getFinalScore() == 5
        );
        SimpleAssert.assertAnyMatch(pendingRecordEntryListResponse.getData(), pendingRecordEntry ->
                pendingRecordEntry.getStudent().getAccount().getId() == 4
                        && pendingRecordEntry.getClassroom().getId() == 1
                        && pendingRecordEntry.getSubject().getId() == 1
                        && pendingRecordEntry.getFirstHalfScore() == 10
                        && pendingRecordEntry.getSecondHalfScore() == 10
                        && pendingRecordEntry.getFinalScore() == 10
        );
        SimpleAssert.assertAnyMatch(pendingRecordEntryListResponse.getData(), pendingRecordEntry ->
                pendingRecordEntry.getStudent().getAccount().getId() == 4
                        && pendingRecordEntry.getClassroom().getId() == 1
                        && pendingRecordEntry.getSubject().getId() == 1
                        && pendingRecordEntry.getFirstHalfScore() == 1
                        && pendingRecordEntry.getSecondHalfScore() == 2
                        && pendingRecordEntry.getFinalScore() == 3
        );
        SimpleAssert.assertAnyMatch(pendingRecordEntryListResponse.getData(), pendingRecordEntry ->
                pendingRecordEntry.getStudent().getAccount().getId() == 4
                        && pendingRecordEntry.getClassroom().getId() == 1
                        && pendingRecordEntry.getSubject().getId() == 1
                        && pendingRecordEntry.getFirstHalfScore() == 5
                        && pendingRecordEntry.getSecondHalfScore() == 6
                        && pendingRecordEntry.getFinalScore() == 7
        );
    }

    @Test(order = 2)
    private void verifyRequest() throws IOException, InterruptedException {
        Report.addLabel("Deny request", 3);
        PendingRecordEntryVerify verify = new PendingRecordEntryVerify(
                1,
                false
        );
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/record/pending/verify"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + teacherToken)
                .POST(HttpRequest.BodyPublishers.ofString(JsonUtil.toJson(verify)))
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        Report.addLabel("Accept request", 3);
        PendingRecordEntryVerify verify2 = new PendingRecordEntryVerify(
                2,
                true
        );
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/record/pending/verify"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + teacherToken)
                .POST(HttpRequest.BodyPublishers.ofString(JsonUtil.toJson(verify2)))
                .build();

        var response2 = httpClient.send(request2, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response2.statusCode());
    }

    @Test(order = 3)
    private void getOwnRecordEntries() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/record/1"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + studentToken)
                .GET()
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        RecordResponse recordResponse = JsonUtil.fromJson(response.body(), RecordResponse.class);
        SimpleAssert.assertNotNull(recordResponse.getData());
        SimpleAssert.assertEquals(1, recordResponse.getData().getEntries().size());
        SimpleAssert.assertAnyMatch(recordResponse.getData().getEntries(), recordEntry ->
                recordEntry.getSubject().getId() == 1
                        && recordEntry.getFirstHalfScore() == 10
                        && recordEntry.getSecondHalfScore() == 10
                        && recordEntry.getFinalScore() == 10
        );
    }

    @Test(order = 3)
    private void getRecordById() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/record/1/4"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + teacherToken)
                .GET()
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        RecordResponse recordResponse = JsonUtil.fromJson(response.body(), RecordResponse.class);
        SimpleAssert.assertNotNull(recordResponse.getData());
        SimpleAssert.assertEquals(1, recordResponse.getData().getEntries().size());
        SimpleAssert.assertAnyMatch(recordResponse.getData().getEntries(), recordEntry ->
                recordEntry.getSubject().getId() == 1
                        && recordEntry.getFirstHalfScore() == 10
                        && recordEntry.getSecondHalfScore() == 10
                        && recordEntry.getFinalScore() == 10
        );
    }

    @Test(order = 3)
    private void getRecordListByClassroomId() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/record/list/classroom/1"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + staffToken)
                .GET()
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        RecordWithStudentListResponse recordListResponse = JsonUtil.fromJson(response.body(), RecordWithStudentListResponse.class);
        SimpleAssert.assertNotNull(recordListResponse.getData());
        SimpleAssert.assertEquals(1, recordListResponse.getData().size());
        SimpleAssert.assertAnyMatch(recordListResponse.getData(), record ->
                record.getStudent().getAccount().getId() == 4 && record.getEntries().size() == 1
        );
    }

    @Test(order = 3)
    private void getRecordListByGradeAndYear() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlSupplier.getUri("/record/list/grade/10/2021"))
                .headers("Content-Type", "application/json")
                .headers("Authorization", "Bearer " + staffToken)
                .GET()
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        SimpleAssert.assertEquals(200, response.statusCode());

        RecordWithStudentListResponse recordListResponse = JsonUtil.fromJson(response.body(), RecordWithStudentListResponse.class);
        SimpleAssert.assertNotNull(recordListResponse.getData());
        SimpleAssert.assertEquals(1, recordListResponse.getData().size());
        SimpleAssert.assertAnyMatch(recordListResponse.getData(), record ->
                record.getStudent().getAccount().getId() == 4 && record.getEntries().size() == 1
        );
    }
}
