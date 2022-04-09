package it.sevenbits.eightworkshop.web.model.response.commentaries;

import com.fasterxml.jackson.annotation.JsonProperty;
import it.sevenbits.eightworkshop.core.model.Commentary;

import java.util.List;

/**
 * Response for get all commentaries
 */
public class AllCommentariesMetaResponse {

    @JsonProperty("_meta")
    private CommentariesMeta commentariesMeta;

    @JsonProperty("commentaries")
    private List<Commentary> commentaries;

    /**
     * Init response
     *
     * @param commentariesMeta meta data
     * @param commentaries     list of commentaries
     */
    public AllCommentariesMetaResponse(final CommentariesMeta commentariesMeta, final List<Commentary> commentaries) {
        this.commentariesMeta = commentariesMeta;
        this.commentaries = commentaries;
    }

    /**
     * Returns meta data
     *
     * @return returns meta data
     */
    public CommentariesMeta getMeta() {
        return commentariesMeta;
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
