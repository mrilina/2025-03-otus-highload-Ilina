package ru.social.network.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Сведения для аутентификации пользователей.
 *
 * @author Irina Ilina
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    private String login;

    private String password;
}
