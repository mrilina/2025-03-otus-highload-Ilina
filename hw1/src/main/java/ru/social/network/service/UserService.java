package ru.social.network.service;

import ru.social.network.dto.UserResponse;

public interface UserService {

    UserResponse findById(Long id);
}
