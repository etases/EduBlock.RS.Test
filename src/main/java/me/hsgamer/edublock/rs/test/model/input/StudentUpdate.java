package me.hsgamer.edublock.rs.test.model.input;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentUpdate {
    String ethnic;
    String fatherName;
    String fatherJob;
    String motherName;
    String motherJob;
    String guardianName;
    String guardianJob;
    String homeTown;

    public boolean validate() {
        return ethnic != null && !ethnic.isBlank()
                && fatherName != null
                && fatherJob != null
                && motherName != null
                && motherJob != null
                && guardianName != null
                && guardianJob != null
                && homeTown != null && !homeTown.isBlank();
    }
}
