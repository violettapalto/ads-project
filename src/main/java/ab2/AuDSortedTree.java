package ab2;

/**
 * An interface representing a sorted tree data structure.
 */
public interface AuDSortedTree {

	/**
	 * Inserts an element into the TreeSet and returns "true" if successful,
	 * and "false" if the value already exists.
	 *
	 * @param value the value to be inserted
	 * @return true if the element was successfully inserted, false if the value
	 *         already exists
	 */
	boolean add(int value);

	/**
	 * Returns true if the TreeSet contains the specified value; otherwise, returns
	 * false.
	 *
	 * @param value the value to be searched
	 * @return true if the TreeSet contains the value, false otherwise
	 */
	boolean contains(int value);

	/**
	 * Deletes an element from the TreeSet and returns true if successful,
	 * and false if the value doesn't exist.
	 *
	 * @param value the value to be deleted
	 * @return true if the element was successfully deleted, false if the value
	 *         doesn't exist
	 */
	boolean delete(int value);

	/**
	 * Converts the TreeSet into an array based on the specified traversal order.
	 *
	 * @param order the traversal order for the array conversion
	 * @return an array representation of the TreeSet
	 */
	int[] toArray(Ordering order);

	/**
	 * Returns all values that are located in the leaf nodes of the tree as an
	 * array.
	 * The order is irrelevant here.
	 *
	 * @return an array of values located in the leaf nodes of the tree
	 */
	int[] getLeafs();

	/**
	 * Returns the smallest value in the TreeSet.
	 *
	 * @return the smallest value in the TreeSet
	 */
	int min();

	/**
	 * Returns the largest value in the TreeSet.
	 *
	 * @return the largest value in the TreeSet
	 */
	int max();

	/**
	 * An enum representing the traversal orders for the TreeSet.
	 */
	enum Ordering {
		/** Left-Root-Right */
		LWR,
		/** Right-Root-Left */
		RWL,
		/** Left-Right-Root */
		LRW,
		/** Right-Left-Root */
		RLW,
		/** Root-Left-Right */
		WLR,
		/** Root-Right-Left */
		WRL,
	}
}
