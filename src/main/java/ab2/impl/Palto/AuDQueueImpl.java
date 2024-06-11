package ab2.impl.palto;

import java.util.NoSuchElementException;

import ab2.AuDQueue;

/**
 * Implementation of the AuDQueue interface.
 */
public class AuDQueueImpl implements AuDQueue {


    /** The head of the queue. */
    private Node head;
    /** The tail of the queue. */
    private Node tail;
    /** The type of the queue. */
    private Type type = Type.FIFO;

    /**
     * Constructs a new AuDQueueImpl object.
     */
    public AuDQueueImpl() {
        head = null;
        tail = null;
    }

    /**
     * Constructs a new AuDQueueImpl object with the specified type.
     *
     * @param type the type of the queue
     */
    public AuDQueueImpl(Type type) {
        this();
        this.type = type;
    }

    @Override
    public void enqueue(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    @Override
    public int dequeue() {
        if (head == null) {
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
        int value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }

    /**
     * Removes an element from the queue in LIFO order.
     *
     * @return the removed element from the queue
     */
    private int dequeueLIFO() {
        int value = tail.value;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node current = head;
            while (current.next != tail && current.next != null) {
                current = current.next;
            }
            tail = current;
            tail.next = null;
        }
        return value;
    }

    /**
     * Represents a node in the queue.
     */
    private static class Node {
        /** The value of the node. */
        private int value;
        /** The next node in the queue. */
        private Node next;

        /**
         * Constructs a new Node object with the specified value.
         *
         * @param value the value of the node
         */
        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
