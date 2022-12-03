package me.hsgamer.edublock.rs.test.model.output;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StringListResponse {
    int status;
    String message;
    @Nullable
    List<String> data;
}
