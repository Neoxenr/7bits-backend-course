package it.sevenbits.eightworkshop.core.repository.commentaries;

import it.sevenbits.eightworkshop.core.model.Commentary;

import java.util.List;

/**
 * Interface for repository of commentaries
 */
public interface ICommentaryRepository {

    /**
     * Returns commentary by id
     *
     * @param id id commentary
     * @return returns commentary
     */
    Commentary getById(String id);

    /**
     * Create new commentary
     *
     * @param commentary new commentary
     * @return created commentary
     */
    Commentary create(Commentary commentary);

    /**
     * Returns all commentaries in repository
     *
     * @return returns all commentaries
     */
    List<Commentary> getAll();

    /**
     * Returns all commentaries paginated
     *
     * @param page  offset commentary
     * @param size  limit commentary
     * @param order sort order
     * @return returns number of commentarys up to size
     */
    List<Commentary> getAll(String order, int page, int size);

    /**
     * Returns all commentaries with pagination and filter
     *
     * @param page     offset commentary
     * @param size     limit commentary
     * @param order    sort order
     * @param authorId authorId to filter result
     * @return returns number of commentaries up to size
     */
    List<Commentary> getAll(String order, int page, int size, String authorId);

    /**
     * Update commentary by id
     *
     * @param commentary commentary with id
     * @return returns count updated rows
     */
    Commentary update(Commentary commentary);

    /**
     * Remove commentary by id
     *
     * @param id id commentary
     * @return returns count deleted rows
     */
    Commentary delete(String id);

    /**
     * Returns amount of all commentary by authorId
     *
     * @param authorId id of author User for filter
     * @return returns amount commentaries
     */
    long count(String authorId);
}

