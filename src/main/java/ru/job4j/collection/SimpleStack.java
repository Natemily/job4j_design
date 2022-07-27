package ru.job4j.collection;

public class SimpleStack<T> {

    private ForwardLinked<T> linked = new ForwardLinked<T>();
    private Node<T> head;

    public T pop() {
       return linked.deleteFirst();
    }

    public void push(T value) {
        linked.addFirst(value);
    }
}