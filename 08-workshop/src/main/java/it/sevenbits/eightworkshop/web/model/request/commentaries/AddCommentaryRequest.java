package it.sevenbits.eightworkshop.web.model.request.commentaries;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Model of request to add new commentary
 */
public class AddCommentaryRequest {

    @NotNull(message = "commentaries have to have text")
    @NotBlank(message = "Text of commentary can't be empty")
    private final String text;

    @NotNull(message = "commentaries have to have authorId")
    @NotBlank(message = "authorId of commentary can't be empty")
    private final String authorId;

    /**
     * Create commentary with text
     *
     * @param text text of commentary
     * @param authorId author's id
     */
    @JsonCreator
    public AddCommentaryRequest(@JsonProperty("text") final String text, @JsonProperty("authorId") final String authorId) {
        this.text = text;
        this.authorId = authorId;
    }

    /**
     * Returns text
     *
     * @return returns text
     */
    public String getText() {
        return text;
    }

    /**
     * Returns authorId
     *
     * @return returns authorId
     */
    public String getAuthorId() {
        return authorId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AddCommentaryRequest that = (AddCommentaryRequest) o;
        return Objects.equals(text, that.text) && Objects.equals(authorId, that.authorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, authorId);
    }

}
