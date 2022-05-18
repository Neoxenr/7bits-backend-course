package it.sevenbits.eightworkshop.core.repository.users;

import it.sevenbits.eightworkshop.core.model.User;
import org.springframework.jdbc.core.JdbcOperations;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * PostgresUserRepository
 */
public class PostgresUserRepository implements IUserRepository {
    private final JdbcOperations jdbcOperations;

    /**
     * Constuctor
     *
     * @param jdbcOperations - jdbc operations
     */
    public PostgresUserRepository(final JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public List<User> getAll() {
        return jdbcOperations.query(
                "SELECT id, name FROM \"user\"",
                (resultSet, i) -> {
                    final String id = resultSet.getString("id");
                    final String name = resultSet.getString("name");
                    return new User(id, name);
                }
        );
    }

    @Override
    public List<User> getAll(final int page, final int size) {
        return getAll().stream().sorted(Comparator.comparing(User::getName))
                .skip((long) page * size)
                .limit(size)
                .collect(Collectors.toList());
    }

    @Override
    public User getById(final String id) {
        return jdbcOperations.queryForObject(
                "SELECT * FROM \"user\" WHERE id = ?",
                (resultSet, i) -> {
                    final String rowId = resultSet.getString("id");
                    final String rowName = resultSet.getString("name");
                    return new User(rowId, rowName);
                },
                id);
    }

    @Override
    public User create(final User user) {
        jdbcOperations.update(
                "INSERT INTO \"user\" (id, name) VALUES(?, ?)",
                user.getId(), user.getName()
        );
        return user;
    }

    @Override
    public User update(final User user) {
        jdbcOperations.update(
                "UPDATE \"user\" SET name = ? WHERE id = ?",
                user.getName(), user.getId()
        );
        return user;
    }

    @Override
    public User delete(final String id) {
        User user = getById(id);
        jdbcOperations.update(
                "DELETE FROM \"user\" WHERE id = ?",
                id
        );
        return user;
    }
}
