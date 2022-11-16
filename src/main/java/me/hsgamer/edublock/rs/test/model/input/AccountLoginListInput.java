package me.hsgamer.edublock.rs.test.model.input;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountLoginListInput {
    List<AccountLogin> accounts;

    public boolean validate() {
        return accounts != null && accounts.stream().allMatch(AccountLogin::validate);
    }
}
