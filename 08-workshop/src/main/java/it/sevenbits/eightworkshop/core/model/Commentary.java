package it.sevenbits.eightworkshop.core.model;

import java.util.Objects;

/**
 * Model of Commentary
 */
public class Commentary {
    private String id;
    private String text;
    private String authorId;
    private String createdAt;

    /**
     * Create new Commentary
     *
     * @param id        id of commentary
     * @param text      text of commentary
     * @param authorId  id of User that wrote this commentary
     * @param createdAt time when commentary was created
     */
    public Commentary(final String id, final String text, final String authorId, final String createdAt) {
        this.id = id;
        this.text = text;
        this.authorId = authorId;
        this.createdAt = createdAt;
    }

    /**
     * @return returns id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id new id of Commentary
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @return returns text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text new text of Commentary
     */
    public void setText(final String text) {
        this.text = text;
    }

    /**
     * @return returns authorId
     */
    public String getAuthorId() {
        return authorId;
    }

    /**
     * @param authorId new authorId of Commentary
     */
    public void setAuthorId(final String authorId) {
        this.authorId = authorId;
    }

    /**
     * @return returns time when Commentary was created
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Set time
     *
     * @param createdAt time when Commentary was created
     */
    public void setCreatedAt(final String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Commentary commentary = (Commentary) o;
        return Objects.equals(id, commentary.id) &&
                Objects.equals(text, commentary.text) &&
                Objects.equals(authorId, commentary.authorId) &&
                Objects.equals(createdAt, commentary.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, authorId, createdAt);
    }
}

