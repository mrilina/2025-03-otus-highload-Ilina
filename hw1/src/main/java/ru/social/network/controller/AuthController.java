package ru.social.network.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.social.network.dto.LoginRequest;
import ru.social.network.dto.RegisterRequest;
import ru.social.network.dto.LoginResponse;
import ru.social.network.dto.RegisterResponse;
import ru.social.network.service.AuthenticationService;

/**
 * Контроллер создания и получения сведений о пользователях.
 *
 * @author Irina Ilina
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return authenticationService.login(loginRequest);
    }

    @PostMapping("/user/register")
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest) {
        return authenticationService.register(registerRequest);
    }
}
