package com.example;

import java.util.ArrayList;
import com.example.exceptions.*;

public class Client {
    private CalculatorVisitor calculatorVisitor;

    public int evaluateExpresion(ArrayList<Token> tokenExpression) throws MalformedExpressionException{
        calculatorVisitor = new CalculatorVisitor();
        for (Token t : tokenExpression) {
            t.accept(calculatorVisitor);
        }
        try {
            return calculatorVisitor.getResult();
        } catch (Exception e) {
            throw new MalformedExpressionException();
        }
        
    }

}
