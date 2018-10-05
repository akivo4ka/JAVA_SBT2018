package com.company;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Iterable<E> {
    private Node<E> _head;
    private Node<E> _tail;

    public Integer size = 0;

    public void add(E e) {
        Node<E> node = new Node(e);

        if (_head == null) {
            _head = node;
            _tail = node;
            _head.prev = null;
            _tail.prev = null;
            _head.next = null;
            _tail.next = null;
        } else {
            node.next = null;
            node.prev = _tail;
            node.prev.next = node;
            _tail = node;
        }

        size++;
    }

    public void add(int index, E e) {
        Node<E> temp = _head;
        if (index >= size) throw new java.lang.IndexOutOfBoundsException();
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        temp.setValue(e);
    }

    public E get(int index) {
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

    public E remove(int index) {
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
}



