package com.example;

import com.example.exceptions.*;

public interface Calculator {
    public int getResult() throws MalformedExpressionException;
}
