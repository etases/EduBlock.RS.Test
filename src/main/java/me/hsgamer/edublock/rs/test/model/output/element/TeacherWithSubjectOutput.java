package me.hsgamer.edublock.rs.test.model.output.element;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeacherWithSubjectOutput {
    AccountWithProfileOutput account = new AccountWithProfileOutput();
    SubjectOutput subject = new SubjectOutput();
}
