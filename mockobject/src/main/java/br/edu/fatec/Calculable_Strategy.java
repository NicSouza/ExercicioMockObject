package br.edu.fatec;

public interface Calculable_Strategy<T extends Number> {
    T calculateValue(T value) throws NullPointerException;
}