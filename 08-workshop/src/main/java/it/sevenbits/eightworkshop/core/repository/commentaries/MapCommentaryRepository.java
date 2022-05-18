package it.sevenbits.eightworkshop.core.repository.commentaries;

import it.sevenbits.eightworkshop.core.model.Commentary;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Repository of commentaries based by hashMap
 */
public class MapCommentaryRepository implements ICommentaryRepository {

    private final Map<String, Commentary> commentaries = new ConcurrentHashMap<>();

    /**
     * Create new commentary
     *
     * @param commentary new commentary
     */
    @Override
    public Commentary create(final Commentary commentary) {
        commentaries.put(commentary.getId(), commentary);
        return commentaries.get(commentary.getId());
    }


    /**
     * Returns tsk by id
     *
     * @param id id commentary
     * @return returns commentary
     */
    @Override
    public Commentary getById(final String id) {
        return commentaries.get(id);
    }

    /**
     * Update commentary by id
     *
     * @param commentary commentary with id
     */
    @Override
    public Commentary update(final Commentary commentary) {
        commentaries.put(commentary.getId(), commentary);
        return commentaries.get(commentary.getId());
    }

    /**
     * Remove commentary by id
     *
     * @param id id commentary
     */
    @Override
    public Commentary delete(final String id) {
        return commentaries.remove(id);
    }

    /**
     * Returns amount of all commentary by authorId
     *
     * @param authorId id of author User for filter
     * @return returns amount commentaries
     */
    @Override
    public long count(final String authorId) {

        Stream<Commentary> result = commentaries.values().stream();
        if (authorId != null) {
            result = result.filter(post -> post.getAuthorId().equalsIgnoreCase(authorId));
        }

        return result.count();
    }

    /**
     * Returns all commentaries in repository
     *
     * @return returns all commentaries
     */

    @Override
    public List<Commentary> getAll() {
        return commentaries.values().stream()
                .sorted(Comparator.comparing(Commentary::getCreatedAt))
                .collect(Collectors.toList());
    }

    /**
     * Returns all commentaries paginated
     *
     * @param page  offset commentary
     * @param size  limit commentary
     * @param order order of sorting result list
     * @return returns number of commentaries up to size
     */
    @Override
    public List<Commentary> getAll(final String order, final int page, final int size) {

        Stream<Commentary> result = commentaries.values().stream();

        if ("desc".equalsIgnoreCase(order)) {
            result = result.sorted(Comparator.comparing(Commentary::getCreatedAt).reversed());
        } else {
            result = result.sorted(Comparator.comparing(Commentary::getCreatedAt));
        }

        int pagesToSkip = Math.max(0, page - 1);

        result = result.skip(pagesToSkip * size).limit(size);

        return result.collect(Collectors.toList());
    }

    /**
     * Returns all commentaries paginated
     *
     * @param page  offset commentary
     * @param size  limit commentary
     * @param order order of sorting result list
     * @return returns number of commentaries up to size
     */
    @Override
    public List<Commentary> getAll(final String order, final int page, final int size, final String authorId) {

        Stream<Commentary> result = commentaries.values().stream();

        if ("desc".equalsIgnoreCase(order)) {
            result = result.sorted(Comparator.comparing(Commentary::getCreatedAt).reversed());
        } else {
            result = result.sorted(Comparator.comparing(Commentary::getCreatedAt));
        }

        if (authorId != null) {
            result = result.filter(commentary -> commentary.getAuthorId().equalsIgnoreCase(authorId));
        }

        int pagesToSkip = Math.max(0, page - 1);

        result = result.skip(pagesToSkip * size).limit(size);

        return result.collect(Collectors.toList());
    }

}
