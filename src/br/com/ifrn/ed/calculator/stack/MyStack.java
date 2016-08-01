package br.com.ifrn.ed.calculator.stack;

import java.util.EmptyStackException;

/**
 *
 * @author Herlan Assis & Sávio Rennan
 * @param <T> Esta classe implementa uma pilha dinâmica.
 */
public class MyStack<T> implements Stack<T> {

    private Node top;
    private int size;

    public MyStack() {
        top = null;
        size = 0;
    }

    /**
     * Verifica se a pilha contém algum elemento.
     *
     * @return verdadeiro para vazio ou false caso contenha algum elemento.
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Verifica a quantidade de elementos existentes na pilha.
     *
     * @return tamanho da fila.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Realiza a operação de inserção de elemento na pilha.
     *
     * @param element objeto dinâmico.
     */
    @Override
    public void push(T element) {
        if (isEmpty()) {
            top = new Node(element);
        } else {
            Node node = new Node(element, top);
            top = node;
        }
        size++;
    }

    /**
     * Remove o elemento do topo da pilha.
     *
     * @return element.
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node node = new Node(top.getElement());
        top = top.getProxNode();
        size--;
        return (T) node.getElement();
    }

    /**
     * Retorna o ultimo elemento da pilha sem remove-lo.
     *
     * @return element.
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) top.getElement();
    }

    /**
     * Inverte uma pilha de objetos.
     *
     * @param stack
     * @return reverse stack.
     */
    public static MyStack reverse(MyStack stack) {
        MyStack myStack = new MyStack();
        while (!stack.isEmpty()) {
            myStack.push(stack.pop());
        }
        return myStack;
    }

    /**
     * Converte a pilha em uma única string sem espaços.
     *
     * @return String com todos os elementos da pilha.
     */
    @Override
    public String toString() {
        String result = "";

        Node aux = top;

        while (aux != null) {
            result += aux.getElement();
            aux = aux.getProxNode();
        }

        return result;
    }
}
