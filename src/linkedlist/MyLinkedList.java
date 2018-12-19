package linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Iterable<E> {
    private Node<E> _head;
    private Node<E> _tail;

    Integer size = 0;

    void add(E e) {
        Node<E> node = new Node(e);

        if (_head == null) {
            _head = node;
            _tail = node;
        } else {
            node.next = null;
            node.prev = _tail;
            node.prev.next = node;
            _tail = node;
        }
        size++;
    }

    void add(int index, E e) {
        if (index >= size || index < 0) throw new java.lang.IndexOutOfBoundsException();
        Node<E> temp = new Node<>(e);
        Node<E> curr = _head;
        int i = index;
        while (i > 0) {
            curr = curr.next;
            i--;
        }
        temp.next = curr;
        temp.prev = curr.prev;
        if (curr.prev != null) {
            curr.prev.next = temp;
        }
        curr.prev = temp;
        if (index == 0) {
            this._head = temp;
        }
        size++;
    }

    E get(int index) {
        Node<E> temp = _head;
        E value = null;
        if (index >= size || index < 0) throw new java.lang.IndexOutOfBoundsException();
        while (index >= 0) {
            value = temp.value;
            temp = temp.next;
            index--;
        }
        return value;
    }

    E remove(int index) {
        Node<E> temp = _head;
        if (_head == null) {
            return null;
        }
        E value = _head.value;
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();
        while (index > 0) {
            temp = temp.next;
            value = temp.value;
            index--;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        } else {
            _tail = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            _head = temp.next;
        }
        size--;
        return value;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> temp = _head;

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E value = temp.value;
                temp = temp.next;
                return value;
            }

            @Override
            public boolean hasNext() {
                return temp != null;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<E> it = this.iterator();
        while (true) {
            E e = it.next();
            sb.append(e);
            if (!it.hasNext()) {
                sb.append("];");
                return sb.toString();
            }
            sb.append(", ");
        }
    }

    boolean addAll(MyLinkedList<? extends E> list) {
        if (list.size == 0) return false;
        for (E e : list) {
            this.add(e);
        }
        return true;
    }

    boolean copy(MyLinkedList<? extends E> list) {
        MyLinkedList<E> temp = new MyLinkedList<E>();
        for (E e : list) {
            temp.add(e);
        }
        this._head = temp._head;
        this._tail = temp._tail;
        size = temp.size;
        return true;
    }
}



