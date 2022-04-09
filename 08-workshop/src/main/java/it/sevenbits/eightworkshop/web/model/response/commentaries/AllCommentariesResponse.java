package it.sevenbits.eightworkshop.web.model.response.commentaries;

import com.fasterxml.jackson.annotation.JsonProperty;
import it.sevenbits.eightworkshop.core.model.Commentary;

import java.util.List;

/**
 * Response for get all commentariess
 */
public class AllCommentariesResponse {


    @JsonProperty("commentaries")
    private List<Commentary> commentaries;

    /**
     * Init response
     *
     * @param commentaries list of commentaries
     */
    public AllCommentariesResponse(final List<Commentary> commentaries) {
        this.commentaries = commentaries;
    }

    /**
     * Returns list of commentaries
     *
     * @return returns list of commentaries
     */
    public List<Commentary> getCommentaries() {
        return commentaries;
    }
}
