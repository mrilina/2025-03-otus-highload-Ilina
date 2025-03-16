package ru.social.network.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.social.network.model.ERole;
import ru.social.network.model.Gender;
import ru.social.network.model.User;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
        private String token;
        private String type = "Bearer";
        private Long id;
        private String firstName;
        private String lastName;
        private String login;
        private Date birthDate;
        private String email;
        private Gender gender;
        private String hobby;
        private String city;
        private ERole role;

        public LoginResponse(String accessToken, User user) {
                this.token = accessToken;
                this.id = user.getId();
                this.firstName = user.getFirstName();
                this.lastName = user.getLastName();
                this.login = user.getLogin();
                this.birthDate = user.getBirthDate();
                this.email = user.getEmail();
                this.role = user.getRole();
        }
}
