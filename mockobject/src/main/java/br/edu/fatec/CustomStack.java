package br.edu.fatec;

import java.util.ArrayList;
import java.util.List;

public class CustomStack<T extends Number> {
    private final int limit;
    private int index = 0;
    private List<T> elements;
    private Calculable_Strategy<T> calculableStrategy;

    public CustomStack(int limit, Calculable_Strategy<T> calculableStrategy) {
        this.limit = limit;
        this.elements = new ArrayList<>();
        this.calculableStrategy = calculableStrategy;
    }

    public void push(T element) throws StackFullException {
        if (this.size() == this.limit) {
            throw new StackFullException();
        }
        this.elements.add(calculableStrategy.calculateValue(element));
        ++index;
    }

    public T pop() throws StackEmptyException {
        if (this.isEmpty()) {
            throw new StackEmptyException();
        }
        return this.elements.remove(--index);
    }

    public List<T> toList() {
        return new ArrayList<>(this.elements);
    }

    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    public T top() {
        return this.elements.get(index - 1);
    }

    public int size() {
        return this.elements.size();
    }
}
