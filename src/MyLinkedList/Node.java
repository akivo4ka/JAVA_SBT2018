package MyLinkedList;

public class Node<E> {
    public Node<E> prev;
    public Node<E> next;
    public E value;

    public E getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
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
    }
}