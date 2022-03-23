package com.example;

public class Operand extends Token{
    private int value;
    private CalculatorVisitor visitor;

    public Operand(CalculatorVisitor visitor)
    {
        this.visitor = visitor;
    }
    public Operand() 
    {
        this(new CalculatorVisitor());
    }

    public void accept(CalculatorVisitor visitor)
    {
        visitor.visit(this);
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
