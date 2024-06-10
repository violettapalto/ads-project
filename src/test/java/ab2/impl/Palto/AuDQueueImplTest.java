package ab2.impl.palto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

/**
 * More in-depth test class for the implementation of the AuDHashSet interface.
 */
public class AuDQueueImplTest {

    @Test
    public void testEnqueueAndDequeue() {
        AuDQueueImpl queue = new AuDQueueImpl();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        assertEquals(10, queue.dequeue());
        assertEquals(20, queue.dequeue());
        assertEquals(30, queue.dequeue());
    }

    @Test
    public void testDequeueEmptyQueue() {
        AuDQueueImpl queue = new AuDQueueImpl();

        assertThrows(NoSuchElementException.class, () -> {
            queue.dequeue();
        });
    }
}