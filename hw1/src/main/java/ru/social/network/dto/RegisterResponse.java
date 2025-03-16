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
public class RegisterResponse {
        private String message;
        private String param;
}
