package it.sevenbits.eightworkshop.core.model;

import java.util.List;
import java.util.Objects;

/**
 * Model of Post
 */

public class Post {
    private String id;
    private String text;
    private String authorId;
    private String createdAt;
    private List<String> commentaryIdList;

    /**
     * Create new Post
     *
     * @param id               id of post
     * @param text             text of post
     * @param authorId         id of User that wrote this post
     * @param createdAt        time when post was created
     * @param commentaryIdList list of Commentary objects for this post
     */
    public Post(final String id, final String text, final String authorId, final String createdAt, final List<String> commentaryIdList) {
        this.id = id;
        this.text = text;
        this.authorId = authorId;
        this.createdAt = createdAt;
        this.commentaryIdList = commentaryIdList;
    }

    /**
     * @return returns id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id new id of Post
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
     * @param text new text of Post
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
     * @param authorId new authorId of Post
     */

    public void setAuthorId(final String authorId) {
        this.authorId = authorId;
    }

    /**
     * @return returns time when Post was created
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt new createdAt of Post
     */

    public void setCreatedAt(final String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return returns commentaryIdList
     */
    public List<String> getCommentaryIdList() {
        return commentaryIdList;
    }

    /**
     * @param commentaryIdList new commentaryIdList of Post
     */

    public void setCommentaryIdList(final List<String> commentaryIdList) {
        this.commentaryIdList = commentaryIdList;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return Objects.equals(id, post.id) &&
                Objects.equals(text, post.text) &&
                Objects.equals(authorId, post.authorId) &&
                Objects.equals(createdAt, post.createdAt) &&
                Objects.equals(commentaryIdList, post.commentaryIdList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, authorId, createdAt, commentaryIdList);
    }
}

