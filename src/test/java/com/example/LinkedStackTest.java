package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.*;

public class LinkedStackTest {
    LinkedStack stack;

    @BeforeEach
    public void setUp() {
        System.out.println("--> setUp()");
        this.stack = new LinkedStack();
    }

    @AfterEach
    public void tearDown() {
        System.out.println("<-- tearDown()");
    }

    @Test
    public void isEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void popNull() {
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    public void push() {
        stack.push("4563");
        stack.push(1235);
        stack.push('+');
        assertEquals( '+', this.stack.pop());
        assertEquals( 1235, this.stack.pop());
        assertEquals( "4563", this.stack.pop());
    }
}
