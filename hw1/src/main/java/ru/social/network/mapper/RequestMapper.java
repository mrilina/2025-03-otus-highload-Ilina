package ru.social.network.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.social.network.dto.RegisterRequest;
import ru.social.network.model.User;

/**
 * Маппер сведений о пользователе.
 *
 * @author Irina Ilina
 */
@Component
@RequiredArgsConstructor
public class RequestMapper {

    @Autowired
    private PasswordEncoder encoder;

    public User toUserEntity(RegisterRequest registerRequest) {

        return new User(null, registerRequest.getFirstName(), registerRequest.getLastName(),
                registerRequest.getLogin(), registerRequest.getBirthDate(),
                registerRequest.getEmail(), encoder.encode(registerRequest.getPassword()), registerRequest.getGender(),
                registerRequest.getHobby(), registerRequest.getCity(), registerRequest.getRole()
        );

    }
}
