package it.sevenbits.eightworkshop.web.model.request.posts;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

/**
 * Model of request to update existing post
 */
public class UpdatePostRequest {
    private final List<String> commentaryIdList;
    private final String text;

    /**
     * Create model
     *
     * @param text             text of post
     * @param commentaryIdList list of commentaries id of post
     */
    @JsonCreator
    public UpdatePostRequest(@JsonProperty(value = "commentaryIdList", required = false) final List<String> commentaryIdList,
                             @JsonProperty(value = "text", required = false) final String text) {
        this.commentaryIdList = commentaryIdList;
        this.text = text;
    }

    /**
     * Get commentaryIdList field
     *
     * @return returns commentaryIdList
     */
    public List<String> getCommentaryIdList() {
        return commentaryIdList;
    }

    /**
     * Get text field
     *
     * @return returns text
     */
    public String getText() {
        return text;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdatePostRequest that = (UpdatePostRequest) o;
        return Objects.equals(commentaryIdList, that.commentaryIdList) &&
                Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentaryIdList, text);
    }
}
