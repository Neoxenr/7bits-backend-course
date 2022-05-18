package it.sevenbits.eightworkshop.web.service.commentaries;

import it.sevenbits.eightworkshop.core.model.Commentary;
import it.sevenbits.eightworkshop.web.model.request.commentaries.AddCommentaryRequest;
import it.sevenbits.eightworkshop.web.model.request.commentaries.UpdateCommentaryRequest;

import java.util.List;

/**
 * Commentary service interface
 */
public interface ICommentaryService {


    /**
     * Returns all commentaries
     *
     * @return returns commentaries
     */
    List<Commentary> getAll();


    /**
     * Returns commentaries with pagination
     *
     * @param page  index page
     * @param size  size of one page
     * @param order order of sorting result list
     * @return returns commentaries
     */
    List<Commentary> getAll(String order, int page, int size);

    /**
     * Returns all commentaries paginated
     *
     * @param page  offset commentary
     * @param size  limit commentary
     * @param order order of sorting result
     * @param authorId author's id
     * @return returns number of commentaries up to size
     */
    List<Commentary> getAll(String order, int page, int size, String authorId);

    /**
     * Returns amount of commentaries authored by user
     *
     * @param authorId id of user
     * @return returns amount of commentaries
     */
    long count(String authorId);

    /**
     * Create new commentary
     *
     * @param addCommentaryRequest model of request of commentary
     * @return new commentary
     */
    Commentary create(AddCommentaryRequest addCommentaryRequest);

    /**
     * Returns commentary by ID
     *
     * @param commentaryId ID commentary
     * @return returns commentary
     */
    Commentary getById(String commentaryId);

    /**
     * Update commentary by ID
     *
     * @param id         id commentary
     * @param commentary updated commentary
     * @return returns  count updated rows
     */
    Commentary update(String id, UpdateCommentaryRequest commentary);

    /**
     * Remove commentary from repository
     *
     * @param commentaryId commentary for removing
     * @return return count deleted rows
     */
    Commentary delete(String commentaryId);
}
