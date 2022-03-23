package com.example;

public class Operator extends Token{
    private Operation operation;
    private CalculatorVisitor visitor;

    public Operator(CalculatorVisitor visitor)
    {
        this.visitor = visitor;
    }
    public Operator() 
    {
        this(new CalculatorVisitor());
    }

    public void accept(CalculatorVisitor visitor)
    {
        visitor.visit(this);
    }

    public Operation getOperation() {
        return operation;
    }
    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
