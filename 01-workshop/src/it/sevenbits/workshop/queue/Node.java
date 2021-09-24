package it.sevenbits.workshop.queue;

import it.sevenbits.workshop.matrix.Matrix;

public class Node {
    private Matrix matrix;

    private Node prev, next;

    public Node(Matrix matrix, Node prev, Node next) {
        this.matrix = matrix;
        this.prev = prev;
        this.next = next;
    }

    public Matrix getValue() {
        return matrix;
    }

    void setPrevNode(Node prev) {
        this.prev = prev;
    }

    void setNextNode(Node next) {
        this.next = next;
    }

    Node getNextNode() {
        return next;
    }

    Node getPrevNode() {
        return prev;
    }
}
