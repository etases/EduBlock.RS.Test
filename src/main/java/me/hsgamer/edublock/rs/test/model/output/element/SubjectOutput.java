package me.hsgamer.edublock.rs.test.model.output.element;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubjectOutput {
    long id = -1;
    String identifier = "";
    String name = "";
    List<String> otherNames = Collections.emptyList();
}
