package it.sevenbits.eightworkshop.web.controllers;

import it.sevenbits.eightworkshop.core.model.Post;
import it.sevenbits.eightworkshop.web.model.request.posts.AddPostRequest;
import it.sevenbits.eightworkshop.web.model.request.posts.UpdatePostRequest;
import it.sevenbits.eightworkshop.web.model.response.posts.AllPostsMetaResponse;
import it.sevenbits.eightworkshop.web.model.response.posts.PostsMeta;
import it.sevenbits.eightworkshop.web.service.posts.IPostService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Rest controller for posts
 */
@Controller
@RequestMapping("/posts")
public class PostsController {

    private static final int MIN_SIZE = 10;
    private static final int MAX_SIZE = 50;

    private final IPostService postService;

    /**
     * Create controller
     *
     * @param postService service for posts
     */
    public PostsController(final IPostService postService) {
        this.postService = postService;
    }

    /**
     * Return all posts
     *
     * @param authorId (not required) id of author user
     * @param order    order for sorting
     * @param page     not required index page
     * @param size     not required size of one page
     * @return response with meta data and list of posts
     */

    @GetMapping
    @ResponseBody
    public ResponseEntity<AllPostsMetaResponse> getAllPosts(
            @RequestParam(required = false, defaultValue = "desc") final String order,
            @RequestParam(required = false) final String authorId,
            @RequestParam(required = false, defaultValue = "1") final Integer page,
            @Valid @RequestParam(required = false, defaultValue = "25") final Integer size) {
        if (!isValidOrder(order)) {
            return ResponseEntity.badRequest().build();
        }

        List<Post> posts = postService.getAll(order, page, size, authorId);

        long totalMessages = postService.count(authorId);

        PostsMeta meta = new PostsMeta(order, page, size, totalMessages);

        AllPostsMetaResponse response = new AllPostsMetaResponse(meta, posts);

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(response);
    }

    /**
     * Returns post by id
     *
     * @param postId id post
     * @return post
     */
    @GetMapping(path = "/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable final String postId) {
        if (!isUUID(postId)) {
            return ResponseEntity.badRequest().build();
        }

        return Optional.ofNullable(postService.getById(postId))
                .map(post -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(post))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Create new post
     *
     * @param addPostRequest model of post
     * @return status with empty body
     * @throws SQLException - sql exception
     */
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody @Valid final AddPostRequest addPostRequest) throws SQLException {
        Post post = postService.create(addPostRequest);

        URI location = UriComponentsBuilder.fromPath("/posts/").path(post.getId()).build().toUri();
        return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).body(post);
    }

    /**
     * Update post text
     *
     * @param postId            id post
     * @param updatePostRequest model of new status
     * @return returns status
     * @throws SQLException - sql exception
     */
    @PatchMapping(path = "/{postId}")
    public ResponseEntity<Post> updateText(@PathVariable final String postId,
                                           @RequestBody final UpdatePostRequest updatePostRequest) throws SQLException {

        String newText = updatePostRequest.getText();
        List<String> newList = updatePostRequest.getCommentaryIdList();

        if (((newText == null || newText.isEmpty()) && newList == null) || !isUUID(postId)) {
            return ResponseEntity.badRequest().build();
        }

        return Optional.ofNullable(postService.update(postId, updatePostRequest))
                .map(post -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(post))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Remove post from repository
     *
     * @param postId id of post to delete
     * @return status
     */
    @DeleteMapping(path = "/{postId}")
    public ResponseEntity<Post> deletePost(@PathVariable final String postId) {
        if (!isUUID(postId)) {
            return ResponseEntity.badRequest().build();
        }

        return Optional.ofNullable(postService.delete(postId))
                .map(post -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(post))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    private boolean isUUID(final String testUUID) {
        if (testUUID == null) {
            return false;
        }
        return java.util.regex.Pattern.compile("[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}")
                .matcher(testUUID).find();
    }

    private boolean isValidOrder(final String order) {
        return order.equalsIgnoreCase("desc") || order.equalsIgnoreCase("asc");
    }

}
