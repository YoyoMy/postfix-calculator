package com.example;

public class Node<T> {
    private T data;
    private Node next;

    public Node(T data)
    {
        setData(data);
    }
    public void setData(T data) {
        this.data = data;
    }
    public T getData() {
        return data;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public Node getNext() {
        return next;
    }
}
