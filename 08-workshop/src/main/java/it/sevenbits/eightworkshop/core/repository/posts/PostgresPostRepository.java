package it.sevenbits.eightworkshop.core.repository.posts;

import it.sevenbits.eightworkshop.core.model.Post;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Array;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Postgres post repository realization
 */
public class PostgresPostRepository implements IPostRepository {
    private final JdbcOperations jdbcOperations;

    /**
     * Constructor
     * @param jdbcOperations - jdbc operations
     */
    public PostgresPostRepository(final JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public List<Post> getAll() {
        return jdbcOperations.query(
                "SELECT * FROM post",
                (resultSet, i) -> {
                    final String rowId = resultSet.getString("id");
                    final String rowText = resultSet.getString("text");
                    final String rowAuthorId = resultSet.getString("authorId");
                    final String rowCreatedAt = resultSet.getString("createdAt");
                    final Array rowArray = resultSet.getArray("commentaryIdList");
                    return new Post(rowId, rowText, rowAuthorId, rowCreatedAt, Arrays.asList((String[]) rowArray.getArray()));
                }
        );
    }

    @Override
    public List<Post> getAll(final String order, final int page, final int size) {
        Stream<Post> posts = getAll().stream();

        if ("desc".equalsIgnoreCase(order)) {
            posts = posts.sorted(Comparator.comparing(Post::getCreatedAt).reversed());
        } else {
            posts = posts.sorted(Comparator.comparing(Post::getCreatedAt));
        }

        int pagesToSkip = Math.max(0, page - 1);

        posts = posts.skip((long) pagesToSkip * size).limit(size);

        return posts.collect(Collectors.toList());
    }

    @Override
    public List<Post> getAll(final String order, final int page, final int size, final String authorId) {
        Stream<Post> posts = getAll().stream();

        if ("desc".equalsIgnoreCase(order)) {
            posts = posts.sorted(Comparator.comparing(Post::getCreatedAt).reversed());
        } else {
            posts = posts.sorted(Comparator.comparing(Post::getCreatedAt));
        }

        if (authorId != null) {
            posts = posts.filter(post -> post.getAuthorId().equalsIgnoreCase(authorId));
        }

        int pagesToSkip = Math.max(0, page - 1);

        posts = posts.skip((long) pagesToSkip * size).limit(size);

        return posts.collect(Collectors.toList());
    }

    @Override
    public Post getById(final String id) {
        return jdbcOperations.queryForObject(
                "SELECT * FROM post WHERE id = ?",
                (resultSet, i) -> {
                    final String rowId = resultSet.getString("id");
                    final String rowText = resultSet.getString("text");
                    final String rowAuthorId = resultSet.getString("authorId");
                    final String rowCreatedAt = resultSet.getString("createdAt");
                    final Array rowArray = resultSet.getArray("commentaryIdList");
                    return new Post(rowId, rowText, rowAuthorId, rowCreatedAt, Arrays.asList((String[]) rowArray.getArray()));
                },
                id);
    }

    @Override
    public Post create(final Post post) throws SQLException {
        jdbcOperations.update(
                "INSERT INTO post (id, text, authorId, createdAt, commentaryIdList) VALUES (?, ?, ?, ?, ?)",
                post.getId(), post.getText(), post.getAuthorId(), post.getCreatedAt(),
                ((JdbcTemplate) jdbcOperations).getDataSource().getConnection().createArrayOf("text",
                        post.getCommentaryIdList().toArray())
        );
        return post;
    }

    @Override
    public Post update(final Post post) throws SQLException {
        jdbcOperations.update(
                "UPDATE post SET text = ?, commentaryIdList = ? WHERE id = ?",
                post.getText(), ((JdbcTemplate) jdbcOperations).getDataSource().getConnection().createArrayOf("text",
                        post.getCommentaryIdList().toArray()), post.getId()
        );
        return post;
    }

    @Override
    public Post delete(final String id) {
        Post post = getById(id);
        jdbcOperations.update(
                "DELETE FROM post WHERE id = ?",
                id
        );
        return post;
    }

    @Override
    public long count(final String authorId) {
        return jdbcOperations.queryForObject(
                "SELECT COUNT(authorId) from post WHERE authorId = ?",
                new Object[]{authorId},
                Long.class
        );
    }
}
