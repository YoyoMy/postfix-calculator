package com.example;



import java.util.ArrayList;
import java.util.EmptyStackException;

import com.example.exceptions.MalformedExpressionException;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {
    Client client;
    ArrayList<Token> tokens;

    @BeforeEach
    public void setUp() {
        System.out.println("--> setUp()");
        this.client = new Client();
        tokens = new ArrayList<>();
    }

    @AfterEach
    public void tearDown() {
        System.out.println("<-- tearDown()");
    }

    @Test
    public void perform() throws MalformedExpressionException {
        Operand op = new Operand();
        Operand op1 = new Operand();
        Operand op2 = new Operand();
        Operator or = new Operator();
        Operator or1 = new Operator();
        op.setValue(2);
        tokens.add(op);
        op1.setValue(3);
        tokens.add(op1);
        op2.setValue(10);
        tokens.add(op2);
        or.setOperation(Operation.ADD);
        tokens.add(or);
        or1.setOperation(Operation.MULTIPY);
        tokens.add(or1);
        int result = client.evaluateExpresion(tokens);
        assertEquals(26, result);
    }

    @Test
    public void performNull() throws MalformedExpressionException {
        assertThrows(MalformedExpressionException.class, () -> client.evaluateExpresion(tokens));
    }

    @Test
    public void performOneNum() throws MalformedExpressionException {
        Operand op = new Operand();
        op.setValue(2);
        tokens.add(op);
        assertEquals(op.getValue(), client.evaluateExpresion(tokens));
        //assertThrows(MalformedExpressionException.class, () -> client.evaluateExpresion(tokens));
    }

    @Test
    public void performOneNumOneOperator() throws MalformedExpressionException {
        Operand op = new Operand();
        op.setValue(2);
        tokens.add(op);
        Operator or = new Operator();
        or.setOperation(Operation.ADD);
        tokens.add(or);
        assertThrows(EmptyStackException.class, () -> client.evaluateExpresion(tokens));
    }
    @Test
    public void performOneOperator() throws MalformedExpressionException {
        Operator or = new Operator();
        or.setOperation(Operation.ADD);
        tokens.add(or);
        assertThrows(EmptyStackException.class, () -> client.evaluateExpresion(tokens));
    }

    @Test
    public void performTwoNum() throws MalformedExpressionException {
        Operand op = new Operand();
        op.setValue(2);
        tokens.add(op);
        Operand op1 = new Operand();
        op1.setValue(6);
        tokens.add(op1);
        System.out.println(client.evaluateExpresion(tokens));
        //assertThrows(MalformedExpressionException.class, () -> client.evaluateExpresion(tokens));
    }

    @Test
    public void performTwoOperators() throws MalformedExpressionException {
        Operator or = new Operator();
        or.setOperation(Operation.ADD);
        tokens.add(or);
        Operator or1 = new Operator();
        or1.setOperation(Operation.ADD);
        tokens.add(or1);
        assertThrows(EmptyStackException.class, () -> client.evaluateExpresion(tokens));
    }
    @Test
    public void performDIV() throws MalformedExpressionException {
        Operand op = new Operand();
        Operand op1 = new Operand();
        Operand op2 = new Operand();
        Operator or = new Operator();
        Operator or1 = new Operator();
        op.setValue(10);
        tokens.add(op);
        op1.setValue(20);
        tokens.add(op1);
        op2.setValue(10);
        tokens.add(op2);
        or.setOperation(Operation.DIVIVE);
        tokens.add(or);
        or1.setOperation(Operation.DIVIVE);
        tokens.add(or1);
        int result = client.evaluateExpresion(tokens);
        assertEquals(5, result);
    }

    @Test
    public void performDIVZero() throws MalformedExpressionException {
        Operand op = new Operand();
        Operand op1 = new Operand();
        Operand op2 = new Operand();
        Operator or = new Operator();
        Operator or1 = new Operator();
        op.setValue(10);
        tokens.add(op);
        op1.setValue(2);
        tokens.add(op1);
        op2.setValue(10);
        tokens.add(op2);
        or.setOperation(Operation.DIVIVE);
        tokens.add(or);
        or1.setOperation(Operation.DIVIVE);
        tokens.add(or1);
        assertThrows(ArithmeticException.class, () -> client.evaluateExpresion(tokens));
    }

}
