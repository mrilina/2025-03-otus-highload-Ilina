package ru.social.network.mapper;

import org.springframework.stereotype.Component;
import ru.social.network.dto.RegisterResponse;
import ru.social.network.dto.UserResponse;
import ru.social.network.model.User;

@Component
public class ResponseMapper {
    private static final String USER_REGISTERED = "User registered successfully!";

    public RegisterResponse toRegisterResponse(User user) {
        return new RegisterResponse(USER_REGISTERED, user.getLogin());
    }

    public UserResponse toUserResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthDate(),
                user.getEmail(),
                user.getGender(),
                user.getHobby(),
                user.getCity());
    }
}
