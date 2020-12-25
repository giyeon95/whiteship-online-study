package stack03;

import java.util.EmptyStackException;

public class StackNode implements Stack {

    int[] dataHolder;
    int size = 10;
    int pos = 0;

    public StackNode() {
        dataHolder = new int[size];
    }

    public StackNode(int size) {
        this.size = size;
        dataHolder = new int[size];
    }

    @Override
    public void push(int data) throws IndexOutOfBoundsException {
        if (size <= pos) {
            throw new IndexOutOfBoundsException("Out Of Stack Capacity Space!");
        }
        dataHolder[pos++] = data;
    }

    @Override
    public int pop() throws EmptyStackException {
        if (pos < 1) {
            throw new EmptyStackException();
        }

        return dataHolder[--pos];
    }
}
