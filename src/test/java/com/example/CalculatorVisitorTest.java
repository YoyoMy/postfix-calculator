package com.example;


import java.util.EmptyStackException;

import com.example.exceptions.MalformedExpressionException;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorVisitorTest {
    CalculatorVisitor visitor;

    @BeforeEach
    public void setUp() {
        System.out.println("--> setUp()");
        this.visitor = new CalculatorVisitor();
    }

    @AfterEach
    public void tearDown() {
        System.out.println("<-- tearDown()");
    }
    @Test
    void getResultEmpty()
    {
        assertThrows(EmptyStackException.class, () ->  visitor.getResult());
    }
    @Test
    void getResultOne() throws MalformedExpressionException
    {
        Operand op = new Operand();
        op.setValue(2);
        visitor.pushOperand(op);
        assertEquals(2, visitor.getResult());
        assertThrows(EmptyStackException.class, () ->  visitor.getResult());
    }
    @Test
    void getResultCalculated() throws MalformedExpressionException
    {
        Operand op = new Operand();
        op.setValue(2);
        visitor.pushOperand(op);
        Operand op1 = new Operand();
        op1.setValue(2);
        visitor.pushOperand(op);
        Operator or = new Operator();
        or.setOperation(Operation.DIVIVE);
        visitor.performOperation(or);
        assertEquals(1, visitor.getResult());
        assertThrows(EmptyStackException.class, () ->  visitor.getResult());
    }
}
