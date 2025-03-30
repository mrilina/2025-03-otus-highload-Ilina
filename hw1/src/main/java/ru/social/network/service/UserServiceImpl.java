package ru.social.network.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.social.network.dto.UserResponse;
import ru.social.network.mapper.ResponseMapper;
import ru.social.network.repository.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ResponseMapper responseMapper;

    @Override
    public UserResponse findById(Long id) {
        log.info("Get user by id: {}", id);
        var user = userRepository.findById(id).orElseThrow();
        return responseMapper.toUserResponse(user);
   }
}
