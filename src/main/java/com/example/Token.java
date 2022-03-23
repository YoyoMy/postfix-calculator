package com.example;

public abstract class Token {
    private CalculatorVisitor visitor;
    public abstract void accept(CalculatorVisitor visitor);
}
