package edu.kis.vh.nursery.storage;

public class IntLinkedList implements IntStorage {

    private class Node {

        private int value;
        private Node prev;
        private Node next;

        public Node(final int i) {
            setValue(i);
        }

        public int getValue() {
            return value;
        }

        public void setValue(final int value) {
            this.value = value;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(final Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(final Node next) {
            this.next = next;
        }

    }

    private Node last;
    private int i;

    @Override
    public void push(final int i) {
        if (last == null)
            last = new Node(i);
        else {
            last.setNext(new Node(i));
            last.getNext().setPrev(last);
            last = last.getNext();
        }
    }

    @Override
    public boolean isEmpty() {
        return last == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int top() {
        if (isEmpty())
            return -1;
        return last.getValue();
    }

    @Override
    public int pop() {
        if (isEmpty())
            return -1;
        int ret = last.getValue();
        last = last.getPrev();
        return ret;
    }

}
