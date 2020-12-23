package linkedlist02;

public interface LinkedList<T, R> {

    R add(T nodeToAdd);

    R add(T nodeToAdd, int position);

    R remove(int positionToRemove);

    boolean contains(T nodeToCheck);

    void print();

    int size();
}
