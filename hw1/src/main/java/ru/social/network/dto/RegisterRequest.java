package ru.social.network.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.social.network.model.ERole;
import ru.social.network.model.Gender;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
        private String firstName;
        private String lastName;
        private String login;
        private Date birthDate;
        private String email;
        private Gender gender;
        private String hobby;
        private String city;
        private ERole role;
        @ToString.Exclude
        private String password;
}
