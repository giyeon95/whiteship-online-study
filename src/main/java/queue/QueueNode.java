package queue;

public class QueueNode implements Queue {

    private final int[] dataHolder;
    private final boolean[] useFlag;
    private int size = 10;
    private int frontPos = 0;
    private int backPos = 0;

    public QueueNode() {
        useFlag = new boolean[size];
        dataHolder = new int[size];
    }

    public QueueNode(int queueSize) {
        this.size = queueSize;
        useFlag = new boolean[size];
        dataHolder = new int[size];
    }


    @Override
    public void push(int data) throws IndexOutOfBoundsException {
        int bp = backPos % size;

        if (useFlag[bp]) {
            throw new IndexOutOfBoundsException();
        }

        useFlag[bp] = true;
        dataHolder[bp] = data;

        backPos = bp + 1;
    }

    @Override
    public int pop() throws QueueEmptyException {
        int fp = frontPos % size;

        if (!useFlag[fp]) {
            throw new QueueEmptyException();
        }

        useFlag[fp] = false;
        int popData = dataHolder[fp];
        frontPos = fp + 1;

        return popData;
    }
}
