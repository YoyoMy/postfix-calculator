package com.example;

import com.example.exceptions.*;

public class LinkedList<T> implements List<T>{
    private Node head;
    private int size;

    public LinkedList()
    {
        head = null;
        size = 0;
    }
    
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addToFront(T data) {
        Node<T> newNode = new Node<T>(data);
        newNode.setNext(head);
        head = newNode;
        size++;
        
    }

    @Override
    public T removeFirst() throws EmptyListException{
        if(head == null) throw new EmptyListException();
        Node toRemove = head;
        head = head.getNext();
        size--;
        return (T) toRemove.getData();
    }
    
}
