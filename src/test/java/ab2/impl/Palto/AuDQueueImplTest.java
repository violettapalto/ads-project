package ab2.impl.palto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

/**
 * More in-depth test class for the implementation of the AuDQueue interface.
 */
public class AuDQueueImplTest {

    private AuDQueueImpl queue;

    @BeforeEach
    public void setUp() {
        queue = new AuDQueueImpl(AuDQueueImpl.Type.FIFO);
    }

    @Test
    public void testEnqueueAndDequeue() {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        assertEquals(10, queue.dequeue());
        assertEquals(20, queue.dequeue());
        assertEquals(30, queue.dequeue());
    }

    @Test
    public void testDequeueEmptyQueue() {
        assertThrows(NoSuchElementException.class, () -> {
            queue.dequeue();
        });
    }
}