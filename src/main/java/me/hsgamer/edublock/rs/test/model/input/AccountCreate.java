package me.hsgamer.edublock.rs.test.model.input;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountCreate {
    String firstName;
    String lastName;
    String role;

    public boolean validate() {
        return firstName != null && !firstName.isBlank()
                && lastName != null && !lastName.isBlank()
                && role != null && !role.isBlank();
    }
}
