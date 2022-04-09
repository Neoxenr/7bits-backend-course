package it.sevenbits.eightworkshop.web.controllers;

import it.sevenbits.eightworkshop.core.model.Commentary;
import it.sevenbits.eightworkshop.web.model.request.commentaries.AddCommentaryRequest;
import it.sevenbits.eightworkshop.web.model.request.commentaries.UpdateCommentaryRequest;
import it.sevenbits.eightworkshop.web.model.response.commentaries.AllCommentariesMetaResponse;
import it.sevenbits.eightworkshop.web.model.response.commentaries.CommentariesMeta;
import it.sevenbits.eightworkshop.web.service.commentaries.ICommentaryService;
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
import java.util.List;
import java.util.Optional;

/**
 * Rest controller for commentaries
 */
@Controller
@RequestMapping("/commentaries")
public class CommentariesController {

    private static final int MIN_SIZE = 10;
    private static final int MAX_SIZE = 50;

    private final ICommentaryService commentaryService;

    /**
     * Create controller
     *
     * @param commentaryService service for commentaries
     */
    public CommentariesController(final ICommentaryService commentaryService) {
        this.commentaryService = commentaryService;
    }

    /**
     * Return all commentaries
     *
     * @param authorId (not required) id of author user
     * @param order    order for sorting
     * @param page     not required index page
     * @param size     not required size of one page
     * @return response with meta data and list of commentaries
     */
    @GetMapping
    @ResponseBody
    public ResponseEntity<AllCommentariesMetaResponse> getAllCommentaries(
            @RequestParam(required = false, defaultValue = "desc") final String order,
            @RequestParam(required = false) final String authorId,
            @RequestParam(required = false, defaultValue = "1") final Integer page,
            @Valid @RequestParam(required = false, defaultValue = "25") final Integer size) {
        if (!isValidOrder(order)) {
            return ResponseEntity.badRequest().build();
        }

        List<Commentary> commentaries = commentaryService.getAll(order, page, size, authorId);

        long totalMessages = commentaryService.count(authorId);

        CommentariesMeta meta = new CommentariesMeta(order, page, size, totalMessages);

        AllCommentariesMetaResponse response = new AllCommentariesMetaResponse(meta, commentaries);

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(response);
    }

    /**
     * Returns commentary by id
     *
     * @param commentaryId id commentary
     * @return commentary
     */
    @GetMapping(path = "/{commentaryId}")
    public ResponseEntity<Commentary> getCommentaryById(@PathVariable final String commentaryId) {
        if (!isUUID(commentaryId)) {
            return ResponseEntity.badRequest().build();
        }

        return Optional.ofNullable(commentaryService.getById(commentaryId))
                .map(commentary -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(commentary))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Create new commentary
     *
     * @param addCommentaryRequest model of commentary
     * @return status with empty body
     */
    @PostMapping
    public ResponseEntity<Commentary> createCommentary(@RequestBody @Valid final AddCommentaryRequest addCommentaryRequest) {
        Commentary commentary = commentaryService.create(addCommentaryRequest);

        URI location = UriComponentsBuilder.fromPath("/commentaries/").path(commentary.getId()).build().toUri();
        return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).body(commentary);
    }

    /**
     * Update commentary text
     *
     * @param commentaryId            id commentary
     * @param updateCommentaryRequest model of new status
     * @return returns status
     */
    @PatchMapping(path = "/{commentaryId}")
    public ResponseEntity<Commentary> updateText(@PathVariable final String commentaryId,
                                                 @RequestBody final UpdateCommentaryRequest updateCommentaryRequest) {

        String newText = updateCommentaryRequest.getText();

        if (newText == null || newText.isEmpty() || !isUUID(commentaryId)) {
            return ResponseEntity.badRequest().build();
        }

        return Optional.ofNullable(commentaryService.update(commentaryId, updateCommentaryRequest))
                .map(commentary -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(commentary))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Remove commentary from repository
     *
     * @param commentaryId id of commentary to delete
     * @return status
     */
    @DeleteMapping(path = "/{commentaryId}")
    public ResponseEntity<Commentary> deleteCommentary(@PathVariable final String commentaryId) {
        if (!isUUID(commentaryId)) {
            return ResponseEntity.badRequest().build();
        }

        return Optional.ofNullable(commentaryService.delete(commentaryId))
                .map(commentary -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(commentary))
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
