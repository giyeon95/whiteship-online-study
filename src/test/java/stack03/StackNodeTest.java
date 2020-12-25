package stack03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StackNodeTest {

    Stack defaultSizeStack;

    @BeforeEach
    public void initStackNode() {
        defaultSizeStack = new StackNode();
    }

    @Test
    @DisplayName("스택 push Exception 테스트")
    public void stackPushExceptionTest() {
        int defaultSize = 10;
        for (int i = 0; i < defaultSize; i++) {
            defaultSizeStack.push(i);
        }
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> defaultSizeStack.push(11));
    }

    @Test
    @DisplayName("스택 pop Exception 테스트")
    public void stackPopExceptionTest() {
        Assertions.assertThrows(EmptyStackException.class, () -> defaultSizeStack.pop());
    }

    @Test
    @DisplayName("스택 push / pop 테스트")
    public void stackPushTest() {
        defaultSizeStack.push(3);
        defaultSizeStack.push(4);
        defaultSizeStack.push(5);

        int pop5 = defaultSizeStack.pop();
        int pop4 = defaultSizeStack.pop();
        int pop3 = defaultSizeStack.pop();
        Assertions.assertEquals(pop5, 5);
        Assertions.assertEquals(pop4, 4);
        Assertions.assertEquals(pop3, 3);
    }

}

