package com.example;

import com.example.exceptions.EmptyListException;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    LinkedList list;

    @BeforeEach
    public void setUp() {
        System.out.println("--> setUp()");
        this.list = new LinkedList();
    }

    @AfterEach
    public void tearDown() {
        System.out.println("<-- tearDown()");
    }

    @Test
    public void isEmpty() {
        assertTrue(list.isEmpty());
    }

    @Test
    public void size()
    {
        assertEquals(0, list.size());
        list.addToFront(1);
        assertEquals(1, list.size());
        list.addToFront(2);
        assertEquals(2, list.size());
    }

    /**remove when empty */
    @Test
    public void removeFirstEmpty() throws EmptyListException
    {
        assertThrows(EmptyListException.class, () -> this.list.removeFirst());
    }

    @Test
    public void removeFirstNotEmpty() throws EmptyListException
    {
        Operand op = new Operand();
        this.list.addToFront(op);
        this.list.removeFirst();
    }

    /**add nulls */
    @Test
    public void addFrontValueZero()throws EmptyListException
    {
        Operand op = new Operand();
        this.list.addToFront(op);
        assertEquals( op, this.list.removeFirst());
    }

    @Test
    public void addFrontNum()throws EmptyListException
    {
        Operand op = new Operand();
        op.setValue(2);
        this.list.addToFront(op);
        assertEquals( op, this.list.removeFirst());
    }

    @Test
    public void removeFirst() throws EmptyListException
    {
        Operand op = new Operand();
        this.list.addToFront(op);
        this.list.removeFirst();
        assertThrows(EmptyListException.class, () -> this.list.removeFirst());
    }
}
