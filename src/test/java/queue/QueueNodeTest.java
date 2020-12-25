package queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QueueNodeTest {

    Queue queue = new QueueNode();


    @Test
    @DisplayName("push / pop 테스트")
    void pushPopTest() {
        for (int i = 0; i < 10; i++) {
            queue.push(i);
        }

        for(int i = 0 ; i< 10 ; i++) {
            assertEquals(queue.pop(), i);
        }
    }

    @Test
    @DisplayName("push / pop 번갈아가며 테스트")
    void randomPushPopTest() {
        for (int i = 0; i < 5; i++) {
            queue.push(i);
        }

        for(int i = 0 ; i< 5 ; i++) {
            assertEquals(queue.pop(), i);
        }

        for (int i = 0; i < 10; i++) {
            queue.push(i);
        }

        for(int i = 0 ; i< 10 ; i++) {
            assertEquals(queue.pop(), i);
        }

    }
}