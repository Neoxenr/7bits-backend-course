package it.sevenbits.workshop.queue;

import it.sevenbits.workshop.matrix.Matrix;

public class DoubleEndedQueue {
    private Node head, tail;

    public void addFirst(Matrix newMatrix) {
        if (head == null) {
            head = new Node(newMatrix, null, null);
            tail = head;
        }
        else {
            Node newNode = new Node(newMatrix, null, head);
            head = newNode;
            newNode = newNode.getNextNode();
            newNode.setPrevNode(head);
        }
    }

    public void addLast(Matrix newMatrix) {
        if (tail == null) {
            tail = new Node(newMatrix, null, null);
            head = tail;
        }
        else {
            Node newNode = new Node(newMatrix, tail, null);
            tail = newNode;
            newNode = newNode.getPrevNode();
            newNode.setNextNode(tail);
        }
    }

    public Matrix getFirst() {
        return head.getValue();
    }

    public Matrix getLast() {
        return tail.getValue();
    }

    @Override
    public String toString() {
        Node tempNode = head;
        StringBuilder sb = new StringBuilder();
        while (tempNode != null) {
            sb.append(tempNode.getValue()).append('\n');
            tempNode = tempNode.getNextNode();
        }
        return sb.toString();
    }
}
