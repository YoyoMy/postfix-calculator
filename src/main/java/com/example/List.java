package com.example;


import com.example.exceptions.*;

public interface List<T> {
    public boolean isEmpty();
    public int size();
    public void addToFront(T data);
    public T removeFirst() throws EmptyListException;
}
