package me.hsgamer.edublock.rs.test.model.output;

import lombok.*;
import lombok.experimental.FieldDefaults;
import me.hsgamer.edublock.rs.test.model.input.TeacherWithSubjectInput;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class TeacherWithSubjectErrorListResponse {
    int status;
    String message;
    @Nullable
    List<ErrorData> data;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class ErrorData {
        int status;
        String message;
        TeacherWithSubjectInput data;
    }
}
