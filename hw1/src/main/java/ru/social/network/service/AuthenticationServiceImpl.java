package ru.social.network.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.social.network.dto.LoginRequest;
import ru.social.network.dto.LoginResponse;
import ru.social.network.dto.RegisterRequest;
import ru.social.network.dto.RegisterResponse;
import ru.social.network.mapper.RequestMapper;
import ru.social.network.mapper.ResponseMapper;
import ru.social.network.repository.UserRepository;

/**
 * Сервис обработки процедуры регистрации и логина.
 *
 * @author Irina Ilina
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RequestMapper requestMapper;
    private final ResponseMapper responseMapper;
    private final UserRepository userRepository;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        log.info("Login user: {}", loginRequest.getLogin());
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        var user = userRepository.findByLogin(loginRequest.getLogin())
                .orElseThrow();
        var token = jwtService.generateToken(user);

        return new LoginResponse(token, user);
    }

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        log.info("Register new user, with params: {}", registerRequest);
        var userEntity = requestMapper.toUserEntity(registerRequest);
        userRepository.save(userEntity);
        var user = userRepository.findByLogin(userEntity.getLogin());
        return responseMapper.toRegisterResponse(user.get());
    }
}
