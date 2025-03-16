package ru.social.network.service;

import ru.social.network.model.User;
import java.util.Map;

public interface JwtService {
    String generateToken(Map<String, Object> extraClaims, User user);
    String generateToken(User user);
    boolean validateJwtToken(String authToken);
    String getUserNameFromJwtToken(String token);
}
