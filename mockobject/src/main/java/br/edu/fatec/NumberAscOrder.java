package br.edu.fatec;

import java.util.ArrayList;
import java.util.List;

public class NumberAscOrder<T extends Number> {
    private CustomStack<T> customStack;

    public NumberAscOrder(CustomStack<T> customStack) {
        this.customStack = customStack;
    }

    public List<T> sort() throws StackEmptyException {
        List<T> ordenar = new ArrayList<>();
        if (customStack.size() == 0) {
            return ordenar;
        }

        int numeroDeElementos = customStack.size();
        for (int i = 0; i < numeroDeElementos; i++) {
            T valor = customStack.pop();
            ordenar.add(valor);
        }
        ordenar.sort(null);
        return ordenar;
    }
}
