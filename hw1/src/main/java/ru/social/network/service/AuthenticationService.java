package ru.social.network.service;

import ru.social.network.dto.LoginRequest;
import ru.social.network.dto.LoginResponse;
import ru.social.network.dto.RegisterRequest;
import ru.social.network.dto.RegisterResponse;

/**
 * Сервис обработки процедуры регистрации и логина.
 *
 * @author Irina Ilina
 */
public interface AuthenticationService {
    LoginResponse login(LoginRequest loginRequest);
    RegisterResponse register(RegisterRequest registerRequest);
}
