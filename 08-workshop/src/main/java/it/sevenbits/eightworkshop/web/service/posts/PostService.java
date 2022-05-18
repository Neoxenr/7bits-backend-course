package it.sevenbits.eightworkshop.web.service.posts;

import it.sevenbits.eightworkshop.core.model.Post;
import it.sevenbits.eightworkshop.core.repository.posts.IPostRepository;
import it.sevenbits.eightworkshop.web.model.request.posts.AddPostRequest;
import it.sevenbits.eightworkshop.web.model.request.posts.UpdatePostRequest;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Service for post resource
 */
public class PostService implements IPostService {

    private final IPostRepository postRepository;

    /**
     * Create service
     *
     * @param postRepository repository of posts
     */
    public PostService(final IPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**
     * Returns all posts
     *
     * @return returns posts
     */
    @Override
    public List<Post> getAll() {
        return postRepository.getAll();
    }

    /**
     * Returns posts with pagination
     *
     * @param page index page
     * @param size size of one page
     * @return returns posts
     */

    @Override
    public List<Post> getAll(final String order, final int page, final int size) {
        return postRepository.getAll(order, page, size);
    }

    /**
     * Returns all posts with pagination and filter
     *
     * @param page     offset post
     * @param size     limit post
     * @param authorId authorId to filter result
     * @return returns number of posts up to size
     */
    @Override
    public List<Post> getAll(final String order, final int page, final int size, final String authorId) {
        return postRepository.getAll(order, page, size, authorId);
    }

    /**
     * Returns post by ID
     *
     * @param postId ID post
     * @return returns post
     */
    @Override
    public Post getById(final String postId) {
        return postRepository.getById(postId);
    }

    /**
     * Create new post
     *
     * @param addPostRequest model of request of post
     * @return new post
     */
    @Override
    public Post create(final AddPostRequest addPostRequest) throws SQLException {
        String id = UUID.randomUUID().toString();
        String currentDate = getCurrentDate();
        List<String> commentaryIdList = new ArrayList<>();
        Post post = new Post(id, addPostRequest.getText(), addPostRequest.getAuthorId(),
                currentDate, commentaryIdList);

        return postRepository.create(post);
    }

    /**
     * Update post by ID
     *
     * @param updatePostRequest updated post
     * @return returns count updated post
     */
    @Override
    public Post update(final String id, final UpdatePostRequest updatePostRequest) throws SQLException {
        Post post = postRepository.getById(id);

        if (post == null) {
            return null;
        }

        if (updatePostRequest.getCommentaryIdList() != null) {
            post.setCommentaryIdList(updatePostRequest.getCommentaryIdList());
        }
        if (updatePostRequest.getText() != null) {
            post.setText(updatePostRequest.getText());
        }

        return postRepository.update(post);
    }

    /**
     * Remove post from repository
     *
     * @param postId postId for removing
     */
    @Override
    public Post delete(final String postId) {
        return postRepository.delete(postId);
    }

    /**
     * Returns current date
     *
     * @return return string of current day
     */
    private String getCurrentDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime time = LocalDateTime.now(ZoneOffset.UTC);
        return time.format(dateTimeFormatter);
    }

    /**
     * Returns amount of posts authored by user
     *
     * @param authorId id of user
     * @return returns amount of posts
     */
    @Override
    public long count(final String authorId) {
        return postRepository.count(authorId);
    }
}
