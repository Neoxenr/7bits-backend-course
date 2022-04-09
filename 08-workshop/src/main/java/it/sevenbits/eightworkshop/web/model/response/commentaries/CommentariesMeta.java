package it.sevenbits.eightworkshop.web.model.response.commentaries;

import org.springframework.web.util.UriComponentsBuilder;

import java.util.function.Function;

/**
 * Meta date for commentaries response
 */
public class CommentariesMeta {

    private long total;
    private int page;
    private int size;
    private String next;
    private String prev;
    private String first;
    private String last;

    /**
     * Init meta
     *
     * @param order order for sorting
     * @param page  current page
     * @param size  size of one page
     * @param total amount all tasks
     */
    public CommentariesMeta(final String order, final int page, final int size, final long total) {
        this.page = page;
        this.size = size;
        this.total = total;

        int lastPage = (int) Math.ceil((double) total / size);
        lastPage = Math.max(1, lastPage);

        Function<Integer, String> getUri = queryPage -> UriComponentsBuilder
                .fromPath("/commentaries")
                .queryParam("order", order)
                .queryParam("size", String.valueOf(size))
                .queryParam("page", String.valueOf(queryPage))
                .toUriString();

        this.next = page >= lastPage ? "" : getUri.apply(this.page + 1);
        this.prev = page <= 1 ? "" : getUri.apply(this.page - 1);
        this.first = getUri.apply(1);
        this.last = getUri.apply(lastPage);
    }


    /**
     * Returns total rows
     *
     * @return returns total rows
     */
    public long getTotal() {
        return total;
    }

    /**
     * Returns pages
     *
     * @return returns pages
     */
    public int getPage() {
        return page;
    }

    /**
     * Returns size one page
     *
     * @return returns size one page
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns link to next page
     *
     * @return returns link to next page
     */
    public String getNext() {
        return next;
    }

    /**
     * Returns link to previous page
     *
     * @return returns link to previous page
     */
    public String getPrev() {
        return prev;
    }

    /**
     * Returns link to first page
     *
     * @return returns link to first page
     */
    public String getFirst() {
        return first;
    }

    /**
     * Returns link to last page
     *
     * @return returns link to last page
     */
    public String getLast() {
        return last;
    }

    /**
     * Set total rows
     *
     * @param total amount rows
     */
    public void setTotal(final long total) {
        this.total = total;
    }

    /**
     * Set current page
     *
     * @param page index page
     */
    public void setPage(final int page) {
        this.page = page;
    }

    /**
     * Set size
     *
     * @param size size
     */
    public void setSize(final int size) {
        this.size = size;
    }

    /**
     * Set link to next page
     *
     * @param next next page
     */
    public void setNext(final String next) {
        this.next = next;
    }

    /**
     * Set link to next page
     *
     * @param prev next page
     */
    public void setPrev(final String prev) {
        this.prev = prev;
    }

    /**
     * Set link to next page
     *
     * @param first next page
     */
    public void setFirst(final String first) {
        this.first = first;
    }

    /**
     * Set link to next page
     *
     * @param last next page
     */
    public void setLast(final String last) {
        this.last = last;
    }
}
