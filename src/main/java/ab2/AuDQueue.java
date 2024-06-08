package ab2;

public interface AuDQueue {

	// inserts an element into the queue
	public void enqueue(int value);

	// removes an element from the queue
	public int dequeue();

	// Type of the queue (relevant for the "dequeue" method)
	enum Type {
		FIFO, // First-In-First-Out
		LIFO; // Last-In-First-Out
	}
}
