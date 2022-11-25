package me.hsgamer.edublock.rs.test.model.input;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PendingRecordEntryListInput {
    List<PendingRecordEntryInput> requests;

    public boolean validate() {
        return requests != null && requests.stream().allMatch(PendingRecordEntryInput::validate);
    }
}
