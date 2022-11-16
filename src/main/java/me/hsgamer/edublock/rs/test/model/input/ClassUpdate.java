package me.hsgamer.edublock.rs.test.model.input;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClassUpdate {
    String name;
    int grade;
    int year;
    long homeroomTeacherId;

    public boolean validate() {
        return name != null && !name.isBlank()
                && grade > 0 && grade < 13
                && year > 0
                && homeroomTeacherId > 0;
    }
}
