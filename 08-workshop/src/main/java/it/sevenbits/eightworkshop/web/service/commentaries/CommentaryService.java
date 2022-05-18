package it.sevenbits.eightworkshop.web.service.commentaries;


import it.sevenbits.eightworkshop.core.model.Commentary;
import it.sevenbits.eightworkshop.core.repository.commentaries.ICommentaryRepository;
import it.sevenbits.eightworkshop.web.model.request.commentaries.AddCommentaryRequest;
import it.sevenbits.eightworkshop.web.model.request.commentaries.UpdateCommentaryRequest;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

/**
 * Service for commentary resource
 */
public class CommentaryService implements ICommentaryService {

    private final ICommentaryRepository commentaryRepository;

    /**
     * Create service
     *
     * @param commentaryRepository repository of commentaries
     */
    public CommentaryService(final ICommentaryRepository commentaryRepository) {
        this.commentaryRepository = commentaryRepository;
    }

    /**
     * Returns all commentaries
     *
     * @return returns commentaries
     */
    @Override
    public List<Commentary> getAll() {
        return commentaryRepository.getAll();
    }

    /**
     * Returns commentaries with pagination
     *
     * @param page index page
     * @param size size of one page
     * @return returns commentaries
     */

    @Override
    public List<Commentary> getAll(final String order, final int page, final int size) {
        return commentaryRepository.getAll(order, page, size);
    }

    /**
     * Returns all commentaries with pagination and filter
     *
     * @param page     offset commentary
     * @param size     limit commentary
     * @param authorId authorId to filter result
     * @return returns number of commentaries up to size
     */
    @Override
    public List<Commentary> getAll(final String order, final int page, final int size, final String authorId) {
        return commentaryRepository.getAll(order, page, size, authorId);
    }

    /**
     * Returns amount of commentaries authored by user
     *
     * @param authorId id of user
     * @return returns amount of commentaries
     */
    @Override
    public long count(final String authorId) {
        return commentaryRepository.count(authorId);
    }

    /**
     * Create new commentary
     *
     * @param addCommentaryRequest model of request of commentary
     * @return new commentary
     */
    @Override
    public Commentary create(final AddCommentaryRequest addCommentaryRequest) {
        String id = UUID.randomUUID().toString();
        String currentDate = getCurrentDate();
        Commentary commentary = new Commentary(id, addCommentaryRequest.getText(),
                addCommentaryRequest.getAuthorId(), currentDate);

        return commentaryRepository.create(commentary);
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
     * Returns commentary by ID
     *
     * @param commentaryId ID commentary
     * @return returns commentary
     */
    @Override
    public Commentary getById(final String commentaryId) {
        return commentaryRepository.getById(commentaryId);
    }

    /**
     * Update commentary by ID
     *
     * @param updateRequest updated commentary
     * @return returns count updated commentary
     */
    @Override
    public Commentary update(final String id, final UpdateCommentaryRequest updateRequest) {
        Commentary commentary = commentaryRepository.getById(id);

        if (commentary == null) {
            return null;
        }

        if (updateRequest.getText() != null) {
            commentary.setText(updateRequest.getText());
        }

        return commentaryRepository.update(commentary);
    }

    /**
     * Remove commentary from repository
     *
     * @param commentaryId commentaryId for removing
     */
    @Override
    public Commentary delete(final String commentaryId) {
        return commentaryRepository.delete(commentaryId);
    }

}
