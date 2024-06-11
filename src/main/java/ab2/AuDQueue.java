package ab2;

/**
 * This interface represents a queue in AuD (Algorithmen und Datenstrukturen) project.
 * It provides methods to insert and remove elements from the queue.
 */
public interface AuDQueue {

	/**
	 * Inserts an element into the queue.
	 *
	 * @param value the value to be inserted into the queue
	 */
	public void enqueue(int value);

	/**
	 * Removes an element from the queue.
	 *
	 * @return the removed element from the queue
	 */
	public int dequeue();

	/**
	 * Type of the queue (relevant for the "dequeue" method).
	 */
	enum Type {
		/** First-In-First-Out */
		FIFO, 
		/** Last-In-First-Out */
		LIFO;
	}
}
