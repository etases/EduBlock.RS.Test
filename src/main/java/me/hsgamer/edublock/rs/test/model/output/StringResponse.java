package me.hsgamer.edublock.rs.test.model.output;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.Nullable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StringResponse {
    int status;
    String message;
    @Nullable
    String data;
}
