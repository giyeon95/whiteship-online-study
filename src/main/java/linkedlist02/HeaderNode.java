package linkedlist02;


public class HeaderNode implements LinkedList<Node, HeaderNode> {

    private Node next;
    private int size;

    @Override
    public HeaderNode add(Node nodeToAdd) {
        if (next == null) {
            next = nodeToAdd;
            size++;
            return this;
        }

        Node preNode = next;
        for (int i = 0; i < size - 1; i++) {
            preNode = preNode.getNext();
        }

        preNode.setNext(nodeToAdd);
        size++;
        return this;
    }

    @Override
    public HeaderNode add(Node nodeToAdd, int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("position out of index");
        }

        Node preNode = next;

        for (int i = 1; i < position; i++) {
            preNode = preNode.getNext();
        }

        if (position == 0) {
            this.next = nodeToAdd;
            nodeToAdd.setNext(preNode);
        } else {
            nodeToAdd.setNext(preNode.getNext());
            preNode.setNext(nodeToAdd);
        }
        size++;

        return this;
    }

    @Override
    public HeaderNode remove(int positionToRemove) {
        if (positionToRemove < 0 || positionToRemove >= size) {
            throw new IndexOutOfBoundsException("position out of index");
        }

        Node preNode = next;

        for (int i = 1; i < positionToRemove; i++) {
            preNode = preNode.getNext();
        }

        Node removeTargetNode = preNode.getNext();
        preNode.setNext(removeTargetNode.getNext());

        return this;
    }

    @Override
    public boolean contains(Node nodeToCheck) {
        Node preNode = next;

        while (preNode != null) {
            if (preNode.getData() == nodeToCheck.getData()) {
                return true;
            }

            preNode = preNode.getNext();
        }

        return false;
    }

    @Override
    public void print() {
        int index = 0;
        Node preNode = next;
        while (preNode != null) {
            System.out.println("index: " + index + ", data: " + preNode.getData());
            preNode = preNode.getNext();
            index++;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

}
