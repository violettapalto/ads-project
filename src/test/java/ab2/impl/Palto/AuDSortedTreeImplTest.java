package ab2.impl.palto;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * More in-depth test class for the implementation of the AuDSortedTree interface.
 */
public class AuDSortedTreeImplTest {

    private AuDSortedTreeImpl tree;

    @BeforeEach
    public void setUp() {
        tree = new AuDSortedTreeImpl();
    }

    @Test
    public void testAdd() {
        assertTrue(tree.add(5));
        assertTrue(tree.add(10));
        assertFalse(tree.add(5)); // Adding duplicate value should return false
    }

    @Test
    public void testContains() {
        assertFalse(tree.contains(5));
        tree.add(5);
        tree.add(10);
        assertTrue(tree.contains(5));
        assertTrue(tree.contains(10));
        assertFalse(tree.contains(15));
    }

    @Test
    public void testDelete() {
        assertFalse(tree.delete(5)); // Deleting from empty tree should return false
        tree.add(5);
        tree.add(3);
        tree.add(4);
        tree.add(2);
        tree.add(10);
        tree.add(15);
        assertTrue(tree.delete(5));
        assertFalse(tree.contains(5)); // Value should be deleted
        assertFalse(tree.delete(20)); // Deleting non-existing value should return false
        assertTrue(tree.delete(3));
        assertFalse(tree.contains(3)); // Value should be deleted
    }

    @Test
    public void testToArray() {
        tree.add(5);
        tree.add(10);
        tree.add(15);
        int[] lwr = tree.toArray(AuDSortedTreeImpl.Ordering.LWR);
        int[] rwl = tree.toArray(AuDSortedTreeImpl.Ordering.RWL);
        assertArrayEquals(new int[]{5, 10, 15}, lwr);
        assertArrayEquals(new int[]{15, 10, 5}, rwl);
    }

    @Test
    public void testGetLeafs() {
        tree.add(5);
        tree.add(10);
        tree.add(15);
        int[] leafs = tree.getLeafs();
        assertArrayEquals(new int[]{5, 10, 15}, leafs);
    }

    @Test
    public void testMin() {
        tree.add(5);
        tree.add(10);
        tree.add(15);
        assertEquals(5, tree.min());
    }

    @Test
    public void testMax() {
        tree.add(5);
        tree.add(10);
        tree.add(15);
        assertEquals(15, tree.max());
    }
}