package com.example;

import java.util.EmptyStackException;

import com.example.exceptions.EmptyListException;

public class LinkedStack<T> implements Stack {

    private LinkedList list; 

    public LinkedStack()
    {
        list = new LinkedList<>();
    }
    
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(Object elm) {
        this.list.addToFront(elm);
        
    }

    @Override
    public Object pop() throws EmptyStackException {
        try {
            return  this.list.removeFirst();
        } catch (EmptyListException e) {
            throw new EmptyStackException();
        }
    }
    
}
