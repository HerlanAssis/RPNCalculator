package br.com.ifrn.ed.calculator.stack;

/**
 * Classe nó dinâmico, pronto para ser usado em qualquer estrutura de encadeamento simples;
 * @author Herlan && Sávio
 * @param <T> 
 */
public class Node<T> {
    private T element;
    private Node proxNode;
    
    public Node (T element){
        this.element = element;
        proxNode = null;
    }
    
    public Node (T element, T proxNode){
        this.element = element;
        this.proxNode = (Node) proxNode;
    }    

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node getProxNode() {
        return proxNode;
    }

    public void setProxNode(Node proxNode) {
        this.proxNode = proxNode;
    }        
}