package br.com.ifrn.ed.calculator;

import br.com.ifrn.ed.calculator.stack.MyStack;

public class Teste {

    public static void main(String[] args) {
        MyStack<Character> myStack = Calculator.createStack("(1+2)*(3+4)");

        while (!myStack.isEmpty()) {
            System.out.print(myStack.pop() + " ");
        }

    }
}
