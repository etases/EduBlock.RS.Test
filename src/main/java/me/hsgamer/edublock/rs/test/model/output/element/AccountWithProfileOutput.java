package me.hsgamer.edublock.rs.test.model.output.element;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class AccountWithProfileOutput {
    AccountOutput account = new AccountOutput();
    ProfileOutput profile = new ProfileOutput();
}
