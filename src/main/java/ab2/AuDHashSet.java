package ab2;

public interface AuDHashSet {

	// adds an element to the HashSet
	//   value: the value to be inserted
	public void add(long value);

	// returns "true" if your HashSet contains the value; otherwise "false"
	//   value: the value to be searched
	public boolean contains(long value);
}
