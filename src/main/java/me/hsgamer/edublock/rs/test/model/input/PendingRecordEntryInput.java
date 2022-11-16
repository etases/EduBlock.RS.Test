package me.hsgamer.edublock.rs.test.model.input;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PendingRecordEntryInput {
    long studentId;
    long classroomId;
    float firstHalfScore;
    float secondHalfScore;
    float finalScore;
    long subjectId;

    public boolean validate() {
        boolean isStudentIdValid = studentId >= 0;
        boolean isClassroomIdValid = classroomId >= 0;
        boolean isFirstHalfScoreValid = 10 >= firstHalfScore && firstHalfScore >= 0;
        boolean isSecondHalfScore = 10 >= secondHalfScore && secondHalfScore >= 0;
        boolean isFinalScoreValid = 10 >= finalScore && finalScore >= 0;
        boolean isSubjectIdValid = subjectId >= 0;

        return isStudentIdValid && isClassroomIdValid && isFirstHalfScoreValid && isSecondHalfScore && isFinalScoreValid && isSubjectIdValid;
    }
}
