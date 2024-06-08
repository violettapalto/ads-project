package ab2;
/**
 * An interface representing a HashSet.
 */
public interface AuDHashSet {

	/**
	 * Adds an element to the HashSet.
	 *
	 * @param value the value to be inserted
	 */
	public void add(long value);

	/**
	 * Checks if the HashSet contains the specified value.
	 *
	 * @param value the value to be searched
	 * @return true if the HashSet contains the value, false otherwise
	 */
	public boolean contains(long value);
}
