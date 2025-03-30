package ru.social.network.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.social.network.model.ERole;
import ru.social.network.model.Gender;
import ru.social.network.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Репозиторий обработки сведений об авторах.
 *
 * @author Irina Ilina
 */
@Repository
public class UserRepositoryJdbc implements UserRepository {

    /**
     * Шаблонный класс с базовым набором операций JDBC.
     */
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * Конструктор.
     *
     * @param namedParameterJdbcTemplate шаблонный класс с базовым набором операций JDBC
     */
    public UserRepositoryJdbc(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        return namedParameterJdbcTemplate.query("select id, login from users", new UserRowMapper());
    }

    @Override
    public Optional<User> findById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        try {
            return Optional.ofNullable(namedParameterJdbcTemplate.queryForObject(
                    "select id, FIRSTNAME, LASTNAME, LOGIN, BIRTHDATE, EMAIL, PASSWORD, GENDER, HOBBY, CITY, ROLE " +
                          "from users where id = :id", params, new UserRowMapper())
            );
        } catch (IncorrectResultSizeDataAccessException ex) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findByLogin(String login) {
        Map<String, Object> params = Collections.singletonMap("login", login);
        try {
            return Optional.ofNullable(namedParameterJdbcTemplate.queryForObject(
                    "select id, FIRSTNAME, LASTNAME, LOGIN, BIRTHDATE, EMAIL, PASSWORD, GENDER, HOBBY, CITY, ROLE " +
                            "from users where login = :login", params, new UserRowMapper())
            );
        } catch (IncorrectResultSizeDataAccessException ex) {
            return Optional.empty();
        }
    }

    @Override
    public void save(User user) {
        Map<String, Object> params = new HashMap<>();
        params.put("firstName", user.getFirstName());
        params.put("lastName", user.getLastName());
        params.put("login", user.getLogin());
        params.put("birthDate", user.getBirthDate());
        params.put("email", user.getEmail());
        params.put("password", user.getPassword());
        params.put("gender", user.getGender() != null ? user.getGender().name() : null);
        params.put("hobby", user.getHobby());
        params.put("city", user.getCity());
        params.put("role", user.getRole() != null ? user.getRole().name() : null);

        var sql = "insert into users(FIRSTNAME, LASTNAME, LOGIN, BIRTHDATE, EMAIL, PASSWORD, GENDER, HOBBY, CITY, ROLE) " +
                "VALUES (:firstName, :lastName, :login, :birthDate, :email, :password, :gender, :hobby, :city, :role)";

        namedParameterJdbcTemplate.execute(sql, params, new PreparedStatementCallback() {
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }

    @Override
    public Boolean existsByLogin(String login) {
        Map<String, Object> params = Collections.singletonMap("login", login);
        var sql = "select count(*) from users where login = :login";
        boolean exists;
        var count = namedParameterJdbcTemplate.queryForObject(sql, params, Integer.class);
        exists = count > 0;
        return exists;
    }

    @Override
    public Boolean existsByEmail(String email) {
        Map<String, Object> params = Collections.singletonMap("email", email);
        var sql = "select count(*) from users where email = :email";
        boolean exists;
        var count = namedParameterJdbcTemplate.queryForObject(sql, params, Integer.class);
        exists = count > 0;
        return exists;
    }

    private static class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {

            return new User(rs.getLong(1), rs.getString(2),
                    rs.getString(3), rs.getString(4),
                    rs.getDate(5), rs.getString(6),
                    rs.getString(7), Gender.valueOf(rs.getString(8)),
                    rs.getString(9), rs.getString(10),
                    ERole.valueOf(rs.getString(11))
            );
        }
    }
}
