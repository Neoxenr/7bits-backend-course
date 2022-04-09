package it.sevenbits.eightworkshop.web.service.posts;

import it.sevenbits.eightworkshop.core.model.Post;
import it.sevenbits.eightworkshop.web.model.request.posts.AddPostRequest;
import it.sevenbits.eightworkshop.web.model.request.posts.UpdatePostRequest;

import java.sql.SQLException;
import java.util.List;

/**
 * Service which works with posts
 */
public interface IPostService {

    /**
     * Returns all posts
     *
     * @return returns posts
     */
    List<Post> getAll();


    /**
     * Returns posts with pagination
     *
     * @param page index page
     * @param size size of one page
     * @param order sort order
     * @return returns posts
     */
    List<Post> getAll(String order, int page, int size);

    /**
     * Returns all posts paginated
     *
     * @param page  offset post
     * @param size  limit post
     * @param order order of sorting result list
     * @param authorId author's id
     * @return returns number of posts up to size
     */
    List<Post> getAll(String order, int page, int size, String authorId);

    /**
     * Returns amount of posts authored by user
     *
     * @param authorId id of user
     * @return returns amount of posts
     */
    long count(String authorId);

    /**
     * Create new post
     *
     * @param addPostRequest model of request of post
     * @throws SQLException sql exception
     * @return new post
     */
    Post create(AddPostRequest addPostRequest) throws SQLException;

    /**
     * Returns post by ID
     *
     * @param postId ID post
     * @return returns post
     */
    Post getById(String postId);

    /**
     * Update post by ID
     *
     * @param id   id post
     * @param post updated post
     * @throws SQLException sql exception
     * @return returns  count updated rows
     */
    Post update(String id, UpdatePostRequest post) throws SQLException;

    /**
     * Remove post from repository
     *
     * @param postId post for removing
     * @return return count deleted rows
     */
    Post delete(String postId);
}
