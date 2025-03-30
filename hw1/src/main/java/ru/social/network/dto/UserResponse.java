package ru.social.network.dto;

import ru.social.network.model.Gender;

import java.util.Date;

public record UserResponse(
        Long id,
        String firstName,
        String lastName,
        Date birthdate,
        String email,
        Gender gender,
        String hobby,
        String city
) {
}
