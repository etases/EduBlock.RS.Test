package me.hsgamer.edublock.rs.test.model.output;

import lombok.*;
import lombok.experimental.FieldDefaults;
import me.hsgamer.edublock.rs.test.model.output.element.ClassroomOutput;
import me.hsgamer.edublock.rs.test.model.output.element.PaginationInfo;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClassroomListResponse {
    int status;
    String message;
    PaginationInfo pageInfo;
    @Nullable
    List<ClassroomOutput> data;
}
