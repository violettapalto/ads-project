package ab2.impl.palto;

import java.util.NoSuchElementException;

import ab2.AuDQueue;

/**
 * Implementation of the AuDQueue interface.
 */
public class AuDQueueImpl implements AuDQueue {
    /** The chunk size of the queue. A higher value means less frequent resizing, which is faster but consumes more memory. */
    private static final int CHUNK_SIZE = 200;

    /** The queue. */
    private int[] queue = new int[CHUNK_SIZE];
    /** The start index of the queue. */
    private int start = -1;
    /** The end index of the queue. */
    private int end = -1;
    /** The type of the queue. */
    private Type type = Type.FIFO;

    /**
     * Constructs a new AuDQueueImpl object.
     *
     * @param type the type of the queue
     */
    public AuDQueueImpl(Type type) {
        this.type = type;
    }

    @Override
    public void enqueue(int value) {
        resizeQueue();

        end++;
        queue[end] = value;
    }

    @Override
    public int dequeue() {
        if (start == end) {
            throw new NoSuchElementException("Queue is empty");
        }

        switch (type) {
            case FIFO:
                return dequeueFIFO();
            case LIFO:
                return dequeueLIFO();
            default:
                throw new IllegalStateException("Unknown queue type");
        }
    }

    /**
     * Removes an element from the queue in FIFO order.
     *
     * @return the removed element from the queue
     */
    private int dequeueFIFO() {
        resizeQueue();

        start++;
        return queue[start];
    }

    /**
     * Removes an element from the queue in LIFO order.
     *
     * @return the removed element from the queue
     */
    private int dequeueLIFO() {
        resizeQueue();

        end--;
        return queue[end + 1];
    }

    /**
     * Resizes the queue if necessary.
     * This is a garbage collection method to prevent the queue from growing indefinitely.
     */
    private void resizeQueue() {
        if (end == queue.length - 1) {
            int[] newQueue = new int[queue.length + CHUNK_SIZE];
            System.arraycopy(queue, 0, newQueue, 0, queue.length);
            queue = newQueue;
        }
        if(end < queue.length - CHUNK_SIZE - 1) {
            int[] newQueue = new int[queue.length - CHUNK_SIZE];
            System.arraycopy(queue, 0, newQueue, 0, queue.length - CHUNK_SIZE);
            queue = newQueue;
        }
        if (start > CHUNK_SIZE + 1) {
            int[] newQueue = new int[queue.length - CHUNK_SIZE];
            System.arraycopy(queue, CHUNK_SIZE, newQueue, 0, queue.length - CHUNK_SIZE);
            queue = newQueue;
            start -= CHUNK_SIZE;
            end -= CHUNK_SIZE;
        }
    }
}
