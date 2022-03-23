package com.example;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Scanner;

import com.example.exceptions.MalformedExpressionException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello World!");
        Client client = new Client();
        System.out.println("Write expression to be calculated, separated by space:\nType \'END\' to exit.");
        String line =  scanner.nextLine();
        while(!line.equals("END"))
        {
            System.out.println("Write expression to be calculated, separated by space:\nType \'END\' to exit.");
            String[] input = line.split(" ");
            ArrayList<Token> tolkens = new ArrayList<>();
            for (int i = 0; i < input.length; i++) {
                if (input[i].equals("+")) {
                    Operator or = new Operator();
                    or.setOperation(Operation.ADD);
                    tolkens.add(or);
                } else if (input[i].equals("-")) {
                    Operator or = new Operator();
                    or.setOperation(Operation.SUBTRACT);
                    tolkens.add(or);
                } else if (input[i].equals("*")) {
                    Operator or = new Operator();
                    or.setOperation(Operation.MULTIPY);
                    tolkens.add(or);
                } else if (input[i].equals("/")) {
                    Operator or = new Operator();
                    or.setOperation(Operation.DIVIVE);
                    tolkens.add(or);
                } else{
                    try{
                        Operand op = new Operand();
                        op.setValue(Integer.parseInt(input[i]));
                        tolkens.add(op);
                    } catch(Exception e)
                    {
                        System.out.println("Incorrect values, please write the expression as following: 2 3 5 + - 5 *");
                    }
                }
    
            }
            try {
                int res = client.evaluateExpresion(tolkens);
                System.out.println(res);
            } catch (Exception e) {
                if(e.getClass().equals(MalformedExpressionException.class) || e.getClass().equals(EmptyStackException.class)) System.out.println("Incorrect values, please write the expression as following: 2 3 5 + - 5 *");
                if(e.getClass().equals(ArithmeticException.class)) System.out.println("You cannot divide by 0.");
                //e.printStackTrace();
            }
            line =  scanner.nextLine();
        }
        scanner.close();
        
    }
}
