package br.edu.fatec;

public class StackFullException extends Exception {
    public StackFullException() {
        super("A pilha está cheia.");
    }
}
