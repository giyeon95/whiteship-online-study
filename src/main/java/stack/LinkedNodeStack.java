package stack;

import java.util.EmptyStackException;
import linkedlist.HeaderNode;
import linkedlist.Node;

public class LinkedNodeStack implements Stack {

    private HeaderNode linkedNode;
    private int pos = 0;

    public LinkedNodeStack() {
        this.linkedNode = new HeaderNode();
    }

    @Override
    public void push(int data) throws IndexOutOfBoundsException {
        linkedNode.add(new Node(data));
        pos++;
    }

    @Override
    public int pop() throws EmptyStackException {
        if (pos < 1) {
            throw new EmptyStackException();
        }

        int targetPos = --pos;
        Node node = linkedNode.get(targetPos);
        linkedNode.remove(targetPos);

        return node.getData();
    }
}
