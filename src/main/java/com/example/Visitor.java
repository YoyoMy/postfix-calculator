package com.example;

public interface Visitor {
    public void visit(Operand operand);
    public void visit(Operator operator);
}
