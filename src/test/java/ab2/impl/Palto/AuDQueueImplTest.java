package ab2.impl.palto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

/**
 * More in-depth test class for the implementation of the AuDQueue interface.
 */
public class AuDQueueImplTest {

    private AuDQueueImpl fifoQueue;
    private AuDQueueImpl lifoQueue;

    @BeforeEach
    public void setUp() {
        fifoQueue = new AuDQueueImpl(AuDQueueImpl.Type.FIFO);
        lifoQueue = new AuDQueueImpl(AuDQueueImpl.Type.LIFO);
    }

    @Test
    public void testFifoQueueEnqueue() {
        fifoQueue.enqueue(1);
        fifoQueue.enqueue(2);
        fifoQueue.enqueue(3);

        assertEquals(1, fifoQueue.dequeue());
        assertEquals(2, fifoQueue.dequeue());
        assertEquals(3, fifoQueue.dequeue());
    }

    @Test
    public void testLifoQueueEnqueue() {
        lifoQueue.enqueue(1);
        lifoQueue.enqueue(2);
        lifoQueue.enqueue(3);

        assertEquals(3, lifoQueue.dequeue());
        assertEquals(2, lifoQueue.dequeue());
        assertEquals(1, lifoQueue.dequeue());
    }

    @Test
    public void testFifoQueueDequeueEmpty() {
        assertThrows(NoSuchElementException.class, () -> {
            fifoQueue.dequeue();
        });
    }

    @Test
    public void testLifoQueueDequeueEmpty() {
        assertThrows(NoSuchElementException.class, () -> {
            lifoQueue.dequeue();
        });
    }
}