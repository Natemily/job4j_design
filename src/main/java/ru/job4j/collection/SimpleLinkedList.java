package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements LinkedList<E> {
    private int size = 0;
    private Node<E> first;
    private Node<E> last;
    private int modCount;

    @Override
    public void add(E value) {
        Node<E> newLast = new Node<>(value, null);
        modCount++;
        size++;
        if (first == null) {
            first = newLast;
        } else {
            last.setNext(newLast);
        }
        last = newLast;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> next = first;
        E value = null;
        for (int i = 0; i <= index; i++) {
            value = next.getValue();
            next = next.getNext();
        }
        return value;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> res = first;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return res != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E prev = res.getValue();
                res = res.getNext();
                return prev;
            }
        };
    }
}