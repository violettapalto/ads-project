package ab2;

public interface Ab2 {

	// returns an empty instance of your implementation of the AuDHashSet class
	//   capacity: the maximum required capacity
	public AuDHashSet emptyHashSet(int capacity);

	// returns an empty instance of your implementation of the AuDSortedTree class
	public AuDSortedTree emptyTree();

	// returns an empty instance of your implementation of the AuDQueue class
	//   type: LIFO or FIFO - provide a corresponding AuDQueue instance
	public AuDQueue emptyQueue(AuDQueue.Type type);

}
