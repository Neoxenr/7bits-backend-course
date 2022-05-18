package it.sevenbits.eightworkshop.core.repository.commentaries;

import it.sevenbits.eightworkshop.core.model.Commentary;
import org.springframework.jdbc.core.JdbcOperations;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * PostgresCommentaryRepository
 */
public class PostgresCommentaryRepository implements ICommentaryRepository {
    private final JdbcOperations jdbcOperations;

    /**
     * Constructor
     * @param jdbcOperations - jdbc operations
     */
    public PostgresCommentaryRepository(final JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public Commentary getById(final String id) {
        return jdbcOperations.queryForObject(
                "SELECT * FROM commentary WHERE id = ?",
                (resultSet, i) -> {
                    final String rowId = resultSet.getString("id");
                    final String rowText = resultSet.getString("text");
                    final String rowAuthorId = resultSet.getString("authorId");
                    final String rowCreatedAt = resultSet.getString("createdAt");
                    return new Commentary(rowId, rowText, rowAuthorId, rowCreatedAt);
                },
                id);
    }

    @Override
    public Commentary create(final Commentary commentary) {
        jdbcOperations.update(
                "INSERT INTO commentary (id, text, authorId, createdAt) VALUES (?, ?, ?, ?)",
                commentary.getId(), commentary.getText(), commentary.getAuthorId(), commentary.getCreatedAt()
        );
        return commentary;
    }

    @Override
    public List<Commentary> getAll() {
        return jdbcOperations.query(
                "SELECT * FROM commentary",
                (resultSet, i) -> {
                    final String rowId = resultSet.getString("id");
                    final String rowText = resultSet.getString("text");
                    final String rowAuthorId = resultSet.getString("authorId");
                    final String rowCreatedAt = resultSet.getString("createdAt");
                    return new Commentary(rowId, rowText, rowAuthorId, rowCreatedAt);
                }
        );
    }

    @Override
    public List<Commentary> getAll(final String order, final int page, final int size) {
        Stream<Commentary> commentaries = getAll().stream();

        if ("desc".equalsIgnoreCase(order)) {
            commentaries = commentaries.sorted(Comparator.comparing(Commentary::getCreatedAt).reversed());
        } else {
            commentaries = commentaries.sorted(Comparator.comparing(Commentary::getCreatedAt));
        }

        int pagesToSkip = Math.max(0, page - 1);

        commentaries = commentaries.skip((long) pagesToSkip * size).limit(size);

        return commentaries.collect(Collectors.toList());
    }

    @Override
    public List<Commentary> getAll(final String order, final int page, final int size, final String authorId) {
        Stream<Commentary> commentaries = getAll().stream();

        if ("desc".equalsIgnoreCase(order)) {
            commentaries = commentaries.sorted(Comparator.comparing(Commentary::getCreatedAt).reversed());
        } else {
            commentaries = commentaries.sorted(Comparator.comparing(Commentary::getCreatedAt));
        }

        if (authorId != null) {
            commentaries = commentaries.filter(commentary -> commentary.getAuthorId().equalsIgnoreCase(authorId));
        }

        int pagesToSkip = Math.max(0, page - 1);

        commentaries = commentaries.skip((long) pagesToSkip * size).limit(size);

        return commentaries.collect(Collectors.toList());
    }

    @Override
    public Commentary update(final Commentary commentary) {
        jdbcOperations.update(
                "UPDATE commentary SET text = ? WHERE id = ?",
                commentary.getText(), commentary.getId()
        );
        return commentary;
    }

    @Override
    public Commentary delete(final String id) {
        final Commentary commentary = getById(id);
        jdbcOperations.update(
                "DELETE FROM commentary WHERE id = ?",
                id
        );
        return commentary;
    }

    @Override
    public long count(final String authorId) {
        return jdbcOperations.queryForObject(
                "SELECT COUNT(authorId) from commentary WHERE authorId = ?",
                new Object[]{authorId},
                Long.class
        );
    }
}
