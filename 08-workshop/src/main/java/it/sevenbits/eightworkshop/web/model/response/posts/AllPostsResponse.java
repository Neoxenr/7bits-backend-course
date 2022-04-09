package it.sevenbits.eightworkshop.web.model.response.posts;

import com.fasterxml.jackson.annotation.JsonProperty;
import it.sevenbits.eightworkshop.core.model.Post;

import java.util.List;

/**
 * Response for get all posts
 */
public class AllPostsResponse {


    @JsonProperty("posts")
    private List<Post> posts;

    /**
     * Init response
     *
     * @param posts list of posts
     */
    public AllPostsResponse(final List<Post> posts) {
        this.posts = posts;
    }

    /**
     * Returns list of posts
     *
     * @return returns list of posts
     */
    public List<Post> getPosts() {
        return posts;
    }
}
