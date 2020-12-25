package linkedlist;

public interface LinkedList<T, R> {

    R add(T nodeToAdd);

    R add(T nodeToAdd, int position);

    R remove(int positionToRemove);

    Node get(int positionToGet);

    boolean contains(T nodeToCheck);

    void print();

    int size();
}
