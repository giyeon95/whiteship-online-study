package stack;

import java.util.EmptyStackException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StackNodeTest {

    Stack stack;

    @BeforeEach
    public void initStackNode() {
        stack = new StackNode();
    }

    @Test
    @DisplayName("스택 push Exception 테스트")
    public void stackPushExceptionTest() {
        int defaultSize = 10;
        for (int i = 0; i < defaultSize; i++) {
            stack.push(i);
        }
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> stack.push(11));
    }

    @Test
    @DisplayName("스택 pop Exception 테스트")
    public void stackPopExceptionTest() {
        Assertions.assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    @DisplayName("스택 push / pop 테스트")
    public void stackPushTest() {
        stack.push(3);
        stack.push(4);
        stack.push(5);

        int pop5 = stack.pop();
        int pop4 = stack.pop();
        int pop3 = stack.pop();
        Assertions.assertEquals(pop5, 5);
        Assertions.assertEquals(pop4, 4);
        Assertions.assertEquals(pop3, 3);
    }

}

