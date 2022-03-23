package com.example;

import com.example.exceptions.*;

public class CalculatorVisitor implements Visitor, Calculator{

    private LinkedStack<Token> tolkenStack;

    public CalculatorVisitor()
    {
        tolkenStack = new LinkedStack<Token>();
    }

    public void pushOperand(Operand operand)
    {
        tolkenStack.push(operand);
    }

    public void performOperation(Operator operator) throws MalformedExpressionException
    {
        Operand firstOperand = (Operand)tolkenStack.pop();
        Operand secondOperand = (Operand)tolkenStack.pop();

        int result = 0;
         switch(operator.getOperation())
         {
             case ADD: result = firstOperand.getValue() + secondOperand.getValue(); break;
             case SUBTRACT: result = secondOperand.getValue() - firstOperand.getValue(); break;
             case DIVIVE: result = secondOperand.getValue() / firstOperand.getValue(); break;
             case MULTIPY: result = secondOperand.getValue() * firstOperand.getValue(); break;
         }
         Operand resultOperand = new Operand();
         resultOperand.setValue(result);
         tolkenStack.push(resultOperand);

    }

    @Override
    public int getResult() throws MalformedExpressionException {
        Operand result = (Operand) tolkenStack.pop();
        return result.getValue();
    }

    @Override
    public void visit(Operand operand) {
       pushOperand(operand);
        
    }

    @Override
    public void visit(Operator operator) {
        try {
            performOperation(operator);
        } catch (MalformedExpressionException e) {
            e.printStackTrace();
        }
        
    }
    
}
