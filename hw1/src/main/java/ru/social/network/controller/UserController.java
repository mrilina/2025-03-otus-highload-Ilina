package ru.social.network.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.social.network.dto.UserResponse;
import ru.social.network.service.UserService;

/**
 * Контроллер создания и получения сведений о пользователях.
 *
 * @author Irina Ilina
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  /**
   * Возвращает сведения о пользователе по его идентификатору.
   *
   * @param id идентификатор пользователя
   * @return сведения о пользователе
   */
  @GetMapping(value = "/user/get/{id}")
  public UserResponse findUserById(@PathVariable(value = "id") long id) {
    return userService.findById(id);

  }
}
