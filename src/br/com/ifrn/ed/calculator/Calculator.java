package br.com.ifrn.ed.calculator;

import br.com.ifrn.ed.calculator.stack.MyStack;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Recebe uma expressão válida para criar a pilha e realizar o cálculo. Valores
 * Aceitos: Dígitos; operadores: ^,%,*,%,+,-; Números reais de uma casa decimal
 * e Parentêses ();
 *
 * @author Herlan Assis & Sávio Rennan
 */
public class Calculator {

    private static int priorityElements(char element) {
        int priority = 0;

        switch (element) {
            case '(':
                priority = 1;
                break;

            case '+':
            case '-':
                priority = 2;
                break;

            case '*':
            case '/':
                priority = 3;
        }

        return priority;
    }

    public static double calculeInfix(MyStack<String> myStack) {
        MyStack<String> auxStack = new MyStack<>();
        double result = 0;

        while (!myStack.isEmpty()) {
            if (myStack.size() == 1) {
                break;
            }

            double a = Double.parseDouble(myStack.pop());
            double b = Double.parseDouble(myStack.pop());;
            if (!isOperator(myStack.peek())) {
                while (!isOperator(myStack.peek())) {
                    double aux = a;
                    a = b;
                    b = aux;

                    auxStack.push(String.valueOf(b));

                    b = Double.parseDouble(myStack.pop());
                }
            }

            result = operations(a, b, myStack.pop());
            myStack.push(String.valueOf(result));
            while (!auxStack.isEmpty()) {
                myStack.push(auxStack.pop());
            }
        }

        result = Double.parseDouble(myStack.pop());

        return result;
    }

    public static MyStack createStack(String expression) {
        MyStack<Character> myStack = new MyStack<>();
        ArrayList<Character> myArrayList = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.') {
                myArrayList.add(expression.charAt(i));
            } else if (myStack.isEmpty() || expression.charAt(i) == '(') {
                myStack.push(expression.charAt(i));
            } else if (expression.charAt(i) == ')') {
                while (myStack.peek() != '(') {
                    myArrayList.add(myStack.pop());
                }
                myStack.pop();
            } else {
                while (myStack.isEmpty()
                        && priorityElements(myStack.peek()) >= priorityElements(expression.charAt(i))) {
                    myArrayList.add(myStack.pop());
                }
                myStack.push(expression.charAt(i));
            }
        }

        while (!myStack.isEmpty()) {
            myArrayList.add(myStack.pop());//retorno todos os elemtos para o ArrayList, dando a "ordem correta".
        }
        Collections.reverse(myArrayList);//inverto o ArryList para que a quando a pilha receber os elementos 
        //eles estejam na ordem correta;
        for (Character character : myArrayList) {
            myStack.push(character);//Recebo todos os elementos na pilha
        }

        MyStack<String> finalStack = new MyStack<>();//preparo para criar os elementos double

        finalStack = convertToFinalStack(myStack);//pilha final com os elementos double já criados

        return finalStack;
    }

    private static MyStack convertToFinalStack(MyStack<Character> myStack) {
        MyStack<String> finalStack = new MyStack();
        String aux = new String();
        while (!myStack.isEmpty()) {
            aux += myStack.pop();//recebe o primeiro elemento
            if (!myStack.isEmpty()) {
                if (myStack.peek() == '.') {//caso o proximo seja um ponto indica um valor double, 
                    //então os proximos dois elementos pertentem a esse número.
                    aux += myStack.pop();
                    aux += myStack.pop();
                }
            }
            finalStack.push(aux);//recebe o elemento
            aux = new String();//esvazia a String
        }
        finalStack = MyStack.reverse(finalStack);
        return finalStack;
    }

    /**
     * Realiza a operação entre dois números e o seu operador.
     *
     * @param a primeiro número,
     * @param b segundo número.
     * @param operator em String;
     * @return resultado da operação.
     */
    private static double operations(double a, double b, String operator) {
        double result = 0;

        switch (operator) {
            case "%":
                result += a % b;
                break;
            case "^":
                result += Math.pow(a, b);
                break;
            case "*":
                result += a * b;
                break;
            case "/":
                result += a / b;
                break;
            case "+":
                result += a + b;
                break;
            case "-":
                result += a - b;
                break;
        }

        return result;
    }

    /**
     * Verifica se o elemento é um operador.
     *
     * @param value que será verificado.
     * @return verdadeiro caso seja um operador e falso caso não.
     */
    private static boolean isOperator(String value) {
        return (value.equals("%") || value.equals("^") || value.equals("*") || value.equals("/") || value.equals("+") || value.equals("-"));
    }
}
