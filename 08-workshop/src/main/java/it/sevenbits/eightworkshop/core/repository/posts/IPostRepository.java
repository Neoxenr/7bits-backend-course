package it.sevenbits.eightworkshop.core.repository.posts;

import it.sevenbits.eightworkshop.core.model.Post;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface for repository of posts
 */
public interface IPostRepository {

    /**
     * Returns post by id
     *
     * @param id id post
     * @return returns post
     */
    Post getById(String id);

    /**
     * Create new post
     *
     * @param post new post
     * @return created post
     * @throws SQLException sql exception
     */
    Post create(Post post) throws SQLException;

    /**
     * Returns all posts in repository (not safe!)
     *
     * @return returns all posts
     */
    List<Post> getAll();

    /**
     * Returns all posts paginated
     *
     * @param page  offset post
     * @param size  limit post
     * @param order sort order
     * @return returns number of posts up to size
     */
    List<Post> getAll(String order, int page, int size);

    /**
     * Returns all posts with pagination and filter
     *
     * @param page     offset post
     * @param size     limit post
     * @param authorId authorId to filter result
     * @param order    sort order
     * @return returns number of posts up to size
     */
    List<Post> getAll(String order, int page, int size, String authorId);


    /**
     * Update post by id
     *
     * @param post post with id
     * @throws SQLException sql exception
     * @return returns count updated rows
     */
    Post update(Post post) throws SQLException;

    /**
     * Remove post by id
     *
     * @param id id post
     * @return returns count deleted rows
     */
    Post delete(String id);

    /**
     * Returns amount of all posts by authorId
     *
     * @param authorId id of author User for filter
     * @return returns amount posts
     */
    long count(String authorId);
}

