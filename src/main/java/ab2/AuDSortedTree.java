package ab2;

public interface AuDSortedTree {

	// Inserts an element into the TreeSet and returns "true" if successful,
	// and "false" if the value already exists.
	//   value: the value to be inserted
	boolean add(int value);

	// Returns "true" if your TreeSet contains the value; otherwise, returns "false".
	//   value: the value to be searched
	boolean contains(int value);

	// Deletes an element from the TreeSet and returns "true" if successful,
	// and "false" if the value doesn't exist.
	boolean delete(int value);

	// Converts the TreeSet into an array based on the specified traversal order.
	int[] toArray(Ordering order);

	// Returns all values that are located in the leaf nodes of the tree as an array.
	// The order is irrelevant here.
	int[] getLeafs();

	// Returns the smallest value in the TreeSet.
	int min();

	// Returns the largest value in the TreeSet.
	int max();

	// Enum of traversal orders.
	enum Ordering {
	LWR, RWL, LRW, RLW, WLR, WRL
	}
}
