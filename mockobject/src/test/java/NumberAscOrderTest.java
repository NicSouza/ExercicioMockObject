import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import br.edu.fatec.CustomStack;
import br.edu.fatec.NumberAscOrder;
import br.edu.fatec.StackEmptyException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NumberAscOrderTest {

    @InjectMocks
    private NumberAscOrder<Integer> numberAscOrder;

    @Mock
    private CustomStack<Integer> stack;

    private Integer[] unsortedNumbers = { 6, 2, 1, 4, 3, 5 };
    private Integer[] sortedNumbers = { 1, 2, 3, 4, 5, 6 };

    private List<Integer> sortedList = Arrays.asList(sortedNumbers);
    private List<Integer> emptyList = new ArrayList<>();

    private int index = 0;

    @BeforeEach
    public void setup() {
        numberAscOrder = new NumberAscOrder<>(stack);
        index = 0;
    }

    @Test
    public void shouldSortStackWithSixElements() throws StackEmptyException {
        Mockito.when(stack.size()).thenReturn(6);
        Mockito.when(stack.pop()).thenAnswer(invocation -> unsortedNumbers[index++]);

        List<Integer> result = numberAscOrder.sort();

        assertEquals(sortedList, result, "A lista deveria estar ordenada.");
    }

    @Test
    public void shouldReturnEmptyListForEmptyStack() throws StackEmptyException {
        Mockito.when(stack.size()).thenReturn(0);

        List<Integer> result = numberAscOrder.sort();

        assertEquals(emptyList, result, "A lista deveria estar vazia.");
    }
}