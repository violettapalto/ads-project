package ab2;
/**
 * This interface represents the Ab2 class.
 */
public interface Ab2 {

	/**
	 * Returns an empty instance of your implementation of the AuDHashSet class.
	 *
	 * @param capacity the maximum required capacity
	 * @return an empty AuDHashSet instance
	 */
	public AuDHashSet emptyHashSet(int capacity);

	/**
	 * Returns an empty instance of your implementation of the AuDSortedTree class.
	 *
	 * @return an empty AuDSortedTree instance
	 */
	public AuDSortedTree emptyTree();

	/**
	 * Returns an empty instance of your implementation of the AuDQueue class.
	 *
	 * @param type the type of the queue (LIFO or FIFO)
	 * @return an empty AuDQueue instance
	 */
	public AuDQueue emptyQueue(AuDQueue.Type type);

}
