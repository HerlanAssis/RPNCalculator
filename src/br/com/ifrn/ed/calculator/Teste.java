package br.com.ifrn.ed.calculator;

import br.com.ifrn.ed.calculator.stack.MyStack;

public class Teste {

    public static void main(String[] args) {
        MyStack<String> myStack = Calculator.createStack("(1*(2+(3*(4+(5*(6+7))))))");
        System.out.println(myStack);
        System.out.println(Calculator.calculeInfix(myStack));

    }
}
