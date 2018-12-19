package linkedlist;

public class Node<E> {
    Node<E> prev;
    Node<E> next;
    E value;

    public E getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public void setValue(E value) {
        this.value = value;
    }

    Node(E value, Node<E> next, Node<E> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    Node(E value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}