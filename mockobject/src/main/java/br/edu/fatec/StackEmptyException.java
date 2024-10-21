package br.edu.fatec;

public class StackEmptyException extends Exception {
    public StackEmptyException() {
        super("A pilha está vazia.");
    }
}
