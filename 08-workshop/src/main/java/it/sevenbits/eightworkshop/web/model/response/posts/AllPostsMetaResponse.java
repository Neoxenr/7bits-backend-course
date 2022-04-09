package it.sevenbits.eightworkshop.web.model.response.posts;

import com.fasterxml.jackson.annotation.JsonProperty;
import it.sevenbits.eightworkshop.core.model.Post;

import java.util.List;

/**
 * Response for get all posts
 */
public class AllPostsMetaResponse {

    @JsonProperty("_meta")
    private PostsMeta postsMeta;

    @JsonProperty("posts")
    private List<Post> posts;

    /**
     * Init response
     *
     * @param postsMeta meta data
     * @param posts     list of posts
     */
    public AllPostsMetaResponse(final PostsMeta postsMeta, final List<Post> posts) {
        this.postsMeta = postsMeta;
        this.posts = posts;
    }

    /**
     * Returns meta data
     *
     * @return returns meta data
     */
    public PostsMeta getMeta() {
        return postsMeta;
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
