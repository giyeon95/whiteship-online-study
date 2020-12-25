package stack03;

import java.util.EmptyStackException;

public interface Stack {

    void push(int data) throws IndexOutOfBoundsException;
    int pop() throws EmptyStackException;
}
