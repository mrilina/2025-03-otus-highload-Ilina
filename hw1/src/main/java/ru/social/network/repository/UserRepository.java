package ru.social.network.repository;

import ru.social.network.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс репозитория обработки сведений о пользователях.
 *
 * @author Irina Ilina
 */
public interface UserRepository {

    /**
     * Возвращает сведений обо всех пользователях.
     *
     * @return список авторов
     */
    List<User> findAll();

    /**
     * Возвращает сведений о пользователе по идентификатору.
     *
     * @param id идентификатор
     * @return сведения о пользователе
     */
    Optional<User> findById(long id);

    /**
     * Возвращает сведений о пользователе по логину.
     *
     * @param login логин
     * @return сведения о пользователе
     */
    Optional<User> findByLogin(String login);

    /**
     * Сохраняет сведения о пользователе.
     *
     * @param user сведения о пользователе
     */
    void save(User user);

    /**
     * Возвращает найденную запись по логину.
     *
     * @param login логин
     * @return результат поиска
     */
    Boolean existsByLogin(String login);

    /**
     * Возвращает найденную запись по электронной почте.
     *
     * @param email электронная почта
     * @return результат поиска
     */

    Boolean existsByEmail(String email);

}
