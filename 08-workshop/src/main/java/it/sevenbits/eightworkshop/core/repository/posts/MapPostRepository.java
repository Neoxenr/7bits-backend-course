package it.sevenbits.eightworkshop.core.repository.posts;

import it.sevenbits.eightworkshop.core.model.Post;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Static post repository realization
 */
public class MapPostRepository implements IPostRepository {

    private final Map<String, Post> posts = new ConcurrentHashMap<>();

    /**
     * Create new post
     *
     * @param post new post
     */
    @Override
    public Post create(final Post post) {
        posts.put(post.getId(), post);
        return posts.get(post.getId());
    }


    /**
     * Returns tsk by id
     *
     * @param id id post
     * @return returns post
     */
    @Override
    public Post getById(final String id) {
        return posts.get(id);
    }

    /**
     * Update post by id
     *
     * @param post post with id
     */
    @Override
    public Post update(final Post post) {
        posts.put(post.getId(), post);
        return posts.get(post.getId());
    }

    /**
     * Remove post by id
     *
     * @param id id post
     */
    @Override
    public Post delete(final String id) {
        return posts.remove(id);
    }

    /**
     * Returns amount of all post by authorId
     *
     * @param authorId id of author User for filter
     * @return returns amount posts
     */
    @Override
    public long count(final String authorId) {

        Stream<Post> result = posts.values().stream();
        if (authorId != null) {
            result = result.filter(post -> post.getAuthorId().equalsIgnoreCase(authorId));
        }

        return result.count();
    }

    /**
     * Returns all posts in repository
     *
     * @return returns all posts
     */

    @Override
    public List<Post> getAll() {

        return posts.values().stream()
                .sorted(Comparator.comparing(Post::getCreatedAt))
                .collect(Collectors.toList());
    }

    /**
     * Returns all posts paginated
     *
     * @param page  offset post
     * @param size  limit post
     * @param order order of sorting result list
     * @return returns number of posts up to size
     */
    @Override
    public List<Post> getAll(final String order, final int page, final int size) {

        Stream<Post> result = posts.values().stream();

        if ("desc".equalsIgnoreCase(order)) {
            result = result.sorted(Comparator.comparing(Post::getCreatedAt).reversed());
        } else {
            result = result.sorted(Comparator.comparing(Post::getCreatedAt));
        }

        int pagesToSkip = Math.max(0, page - 1);

        result = result.skip(pagesToSkip * size).limit(size);

        return result.collect(Collectors.toList());
    }

    /**
     * Returns all posts paginated
     *
     * @param page  offset post
     * @param size  limit post
     * @param order order of sorting result list
     * @return returns number of posts up to size
     */
    @Override
    public List<Post> getAll(final String order, final int page, final int size, final String authorId) {

        Stream<Post> result = posts.values().stream();

        if ("desc".equalsIgnoreCase(order)) {
            result = result.sorted(Comparator.comparing(Post::getCreatedAt).reversed());
        } else {
            result = result.sorted(Comparator.comparing(Post::getCreatedAt));
        }

        if (authorId != null) {
            result = result.filter(post -> post.getAuthorId().equalsIgnoreCase(authorId));
        }

        int pagesToSkip = Math.max(0, page - 1);

        result = result.skip(pagesToSkip * size).limit(size);

        return result.collect(Collectors.toList());
    }

}
