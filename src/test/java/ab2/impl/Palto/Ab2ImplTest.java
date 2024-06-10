package ab2.impl.palto;

import ab2.AuDHashSet;
import ab2.AuDQueue;
import ab2.AuDQueue.Type;
import ab2.AuDSortedTree;
import ab2.AuDSortedTree.Ordering;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class provided with the assignment. It covers most basic test cases and
 * provides a good starting point for testing the implementation.
 */
public class Ab2ImplTest {

	public static final int DATA_SIZE = 1_000_000;

	private Random rand = new Random(System.currentTimeMillis());

	private Ab2Impl instance = new Ab2Impl();

	/**************** Queue (4 Pts) ****************/

	@Test
	public void fifo() {
		fifoSimple();
		fifoExtended();
	}

	private void fifoSimple() {
		int[] data = random(DATA_SIZE);

		AuDQueue queue = instance.emptyQueue(Type.FIFO);

		for (int d : data) {
			queue.enqueue(d);
		}

		for (int i = 0; i < DATA_SIZE; i++) {
			assertEquals(data[i], queue.dequeue());
		}

	}

	private void fifoExtended() {

		int[] data = random(DATA_SIZE);

		AuDQueue queue = instance.emptyQueue(Type.FIFO);

		for (int d : data) {
			queue.enqueue(d);
			assertEquals(d, queue.dequeue());
		}

	}

	@Test
	public void lifo() {
		lifoSimple();
		lifoExtended();
	}

	private void lifoSimple() {
		int[] data = random(DATA_SIZE);

		AuDQueue queue = instance.emptyQueue(Type.LIFO);

		for (int d : data) {
			queue.enqueue(d);
		}

		for (int i = DATA_SIZE - 1; i >= 0; i--) {
			assertEquals(data[i], queue.dequeue());
		}

	}

	private void lifoExtended() {

		int[] data = random(DATA_SIZE);

		AuDQueue queue = instance.emptyQueue(Type.LIFO);

		queue.enqueue(24);
		for (int d : data) {
			queue.enqueue(d);
			assertEquals(d, queue.dequeue());
		}
		assertEquals(24, queue.dequeue());

	}

	/**************** HashSet (4 Pts) ****************/

	@Test
	public void hashSetAddAndContains() {
		hashSetAddAndContainsBasic();
		hashSetAddAndContainsExtended();
	}

	private void hashSetAddAndContainsBasic() {
		AuDHashSet hashSet = instance.emptyHashSet(DATA_SIZE);
		HashSet<Long> hashSetRef = new HashSet<>();

		for (int i = 0; i < DATA_SIZE; i++) {
			long val = rand.nextLong() % DATA_SIZE;

			hashSet.add(val);
			hashSetRef.add(val);

			long val2 = rand.nextLong() % DATA_SIZE;

			assertEquals(hashSet.contains(val2), hashSetRef.contains(val2));
		}

	}

	private void hashSetAddAndContainsExtended() {

		AuDHashSet hashSet = instance.emptyHashSet(DATA_SIZE);
		HashSet<Long> hashSetRef = new HashSet<>();

		for (int i = 0; i < DATA_SIZE; i++) {
			long val = rand.nextLong() % DATA_SIZE;

			hashSet.add(val);
			hashSet.add(val);
			hashSet.add(val);
			hashSetRef.add(val);
			hashSetRef.add(val);
			hashSetRef.add(val);

			long val2 = rand.nextLong() % DATA_SIZE;

			assertEquals(hashSetRef.contains(val), hashSet.contains(val));
			assertEquals(hashSetRef.contains(val2), hashSet.contains(val2));
		}

	}

	@Test
	public void hashSetAddAndContainsSpeed() {
		AuDHashSet hashSet = instance.emptyHashSet(DATA_SIZE);
		HashSet<Long> hashSetRef = new HashSet<>();

		long[] data = randomLong(DATA_SIZE);
		long[] data2 = randomLong(DATA_SIZE);

		long start = System.currentTimeMillis();
		int i = 0;
		for (long d : data) {
			hashSet.add(d);

			long val2 = data2[i];

			hashSet.contains(val2);

			i++;
		}
		long end = System.currentTimeMillis();

		long timeHashSet = end - start;

		start = System.currentTimeMillis();
		i = 0;
		for (long d : data) {
			hashSetRef.add(d);

			long val2 = data2[i];

			hashSetRef.contains(val2);

			i++;
		}
		end = System.currentTimeMillis();

		long timeHashSetRef = end - start;

		assertTrue(timeHashSet < timeHashSetRef * 3);

		for (long val : data2)
			assertEquals(hashSetRef.contains(val), hashSet.contains(val));

	}

	/**************** SortedTree (7 Pts) ****************/

	@Test
	public void sortedTreeAddDeleteAndContains() {
		int[] data = random(DATA_SIZE);
		AuDSortedTree tree = instance.emptyTree();
		Set<Integer> refTree = new TreeSet<>();

		for (int i : data) {
			tree.add(i);
			refTree.add(i);
		}

		for (int i = 0; i < DATA_SIZE; i++) {
			int r = rand.nextInt();

			assertEquals(refTree.contains(r), tree.contains(r));
		}

	}

	@Test
	public void sortedTreeToArray() {
		int[] data = random(DATA_SIZE);
		AuDSortedTree tree = instance.emptyTree();
		Set<Integer> refTree = new TreeSet<>();

		for (int i : data) {
			tree.add(i);
			refTree.add(i);
		}

		int[] rwl = tree.toArray(Ordering.RWL);
		int[] lwr = tree.toArray(Ordering.LWR);

		List<Integer> rwlList = Arrays.stream(rwl).mapToObj(i -> i).collect(Collectors.toList());
		List<Integer> lwrList = Arrays.stream(lwr).mapToObj(i -> i).collect(Collectors.toList());

		List<Integer> refOrdering = refTree.stream().collect(Collectors.toList());
		refOrdering.sort(Comparator.comparing(e -> (int) e));

		assertEquals(refOrdering, lwrList);

		refOrdering.sort(Comparator.comparing(e -> -((int) e)));

		assertEquals(refOrdering, rwlList);

	}

	@Test
	public void sortedTreeMinMax() {
		int[] data = random(DATA_SIZE);
		AuDSortedTree tree = instance.emptyTree();

		for (int i : data) {
			tree.add(i);
		}

		int min = tree.min();
		int max = tree.max();

		int minRef = Arrays.stream(data).min().getAsInt();
		int maxRef = Arrays.stream(data).max().getAsInt();

		assertEquals(minRef, min);
		assertEquals(maxRef, max);

	}

	@Test
	public void sortedTreeExtra() {

		int[] data = random(DATA_SIZE);
		AuDSortedTree tree = instance.emptyTree();

		for (int i : data) {
			tree.add(i);
		}

		int[] wrl = tree.toArray(Ordering.WRL);
		int[] lrw = tree.toArray(Ordering.LRW);

		assertEquals(data[0], wrl[0]);
		assertEquals(data[0], lrw[lrw.length - 1]);

	}

	/**************** Helper Methods ****************/
	private long[] randomLong(int n) {
		long[] arr = new long[n];

		for (int i = 0; i < n; i++) {
			arr[i] = rand.nextLong();
		}

		return arr;
	}

	private int[] random(int n) {
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = rand.nextInt(10 * n);
		}

		return arr;
	}
}
