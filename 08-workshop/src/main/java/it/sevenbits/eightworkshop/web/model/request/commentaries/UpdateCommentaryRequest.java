package it.sevenbits.eightworkshop.web.model.request.commentaries;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Model of request to update existing commentary
 */
public class UpdateCommentaryRequest {

    private final String text;

    /**
     * Create model
     *
     * @param text text of commentary
     */
    @JsonCreator
    public UpdateCommentaryRequest(@JsonProperty(value = "text") final String text) {
        this.text = text;
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
        UpdateCommentaryRequest that = (UpdateCommentaryRequest) o;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
