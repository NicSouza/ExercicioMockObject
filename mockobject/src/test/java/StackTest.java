import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.edu.fatec.Calculable_Strategy;
import br.edu.fatec.CustomStack;
import br.edu.fatec.StackEmptyException;
import br.edu.fatec.StackFullException;

@ExtendWith(MockitoExtension.class)
public class StackTest {

    private CustomStack<Double> stack;

    @Mock
    private Calculable_Strategy<Double> calculableStrategy;

    @BeforeEach
    public void setup() {
        stack = new CustomStack<>(5, calculableStrategy);
    }

    @Test
    public void shouldPushOneElementOntoStack() {
        Double elementValue = 5.0;
        Mockito.when(calculableStrategy.calculateValue(Mockito.anyDouble())).thenReturn(5.0);

        try {
            stack.push(elementValue);
            assertFalse(stack.isEmpty(), "A pilha não deveria estar vazia.");
            assertEquals(elementValue, stack.top(), "O topo da pilha deveria ser o elemento inserido.");
            assertEquals(1, stack.size(), "O tamanho da pilha deveria ser 1.");
            Double value = stack.pop();
            assertEquals(elementValue, value, "O valor removido deveria ser igual ao elemento inserido.");
            assertEquals(0, stack.size(), "O tamanho da pilha deveria ser 0 após remover o elemento.");
        } catch (StackEmptyException | StackFullException ex) {
            fail("Não deveria ter lançado uma exceção.");
        }

        Mockito.verify(calculableStrategy, Mockito.times(1)).calculateValue(Mockito.anyDouble());
    }

    @Test
    public void shouldThrowExceptionForPushNullElement() {
        Mockito.when(calculableStrategy.calculateValue(Mockito.isNull())).thenThrow(NullPointerException.class);

        assertThrows(NullPointerException.class, () -> stack.push(null),
                "Deveria lançar NullPointerException ao inserir null.");
        assertTrue(stack.isEmpty(), "A pilha deveria estar vazia.");
        assertEquals(0, stack.size(), "O tamanho da pilha deveria ser 0.");

        Mockito.verify(calculableStrategy, Mockito.times(1)).calculateValue(Mockito.isNull());
    }

    @Test
    public void shouldHandlePushTwoElementsAndPopOne() {
        Double firstValue = 5.0;
        Double secondValue = 10.0;
        Mockito.when(calculableStrategy.calculateValue(Mockito.anyDouble())).thenReturn(secondValue);

        try {
            stack.push(firstValue);
            stack.push(secondValue);
            assertFalse(stack.isEmpty(), "A pilha não deveria estar vazia.");
            assertEquals(secondValue, stack.top(), "O topo da pilha deveria ser o segundo elemento inserido.");
            assertEquals(2, stack.size(), "O tamanho da pilha deveria ser 2.");
            Double value = stack.pop();
            assertEquals(secondValue, value, "O valor removido deveria ser o segundo elemento inserido.");
            assertEquals(1, stack.size(), "O tamanho da pilha deveria ser 1 após remover o elemento.");
        } catch (StackEmptyException | StackFullException ex) {
            fail("Não deveria ter lançado uma exceção.");
        }
    }

    @Test
    public void shouldThrowExceptionWhenPoppingFromEmptyStack() {
        Double value = 10.0;
        Mockito.when(calculableStrategy.calculateValue(Mockito.anyDouble())).thenReturn(value);

        try {
            stack.push(value);
            stack.pop();
        } catch (StackEmptyException | StackFullException ex) {
            fail("Não deveria ter lançado uma exceção.");
        }

        assertTrue(stack.isEmpty(), "A pilha deveria estar vazia.");
        assertEquals(0, stack.size(), "O tamanho da pilha deveria ser 0.");
        assertThrows(StackEmptyException.class, () -> stack.pop(),
                "Deveria lançar StackEmptyException ao tentar remover de uma pilha vazia.");
    }

    @Test
    public void shouldThrowExceptionWhenPushingBeyondStackLimit() {
        stack = new CustomStack<>(1, calculableStrategy);
        Mockito.when(calculableStrategy.calculateValue(Mockito.anyDouble())).thenReturn(20.0);

        try {
            stack.push(5.0);
        } catch (StackFullException ex) {
            fail("Não deveria ter lançado StackFullException ao inserir o primeiro elemento.");
        }

        assertThrows(StackFullException.class, () -> stack.push(10.0),
                "Deveria lançar StackFullException ao tentar inserir além do limite.");
    }
}
