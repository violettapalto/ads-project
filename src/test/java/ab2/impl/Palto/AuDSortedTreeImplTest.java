package ab2.impl.palto;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * More in-depth test class for the implementation of the AuDSortedTree
 * interface.
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
    public void testContainsEmptyTree() {
        assertFalse(tree.contains(5)); // Tree is empty, should return false
    }

    @Test
    public void testContainsSingleNodeTree() {
        tree.add(5);
        assertTrue(tree.contains(5)); // Tree contains the value, should return true
        assertFalse(tree.contains(10)); // Tree does not contain the value, should return false
    }

    @Test
    public void testContainsMultipleNodesTree() {
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        assertTrue(tree.contains(5)); // Tree contains the value, should return true
        assertTrue(tree.contains(3)); // Tree contains the value, should return true
        assertTrue(tree.contains(7)); // Tree contains the value, should return true
        assertTrue(tree.contains(2)); // Tree contains the value, should return true
        assertTrue(tree.contains(4)); // Tree contains the value, should return true
        assertTrue(tree.contains(6)); // Tree contains the value, should return true
        assertTrue(tree.contains(8)); // Tree contains the value, should return true
        assertFalse(tree.contains(1)); // Tree does not contain the value, should return false
        assertFalse(tree.contains(9)); // Tree does not contain the value, should return false
    }

    @Test
    public void testDeleteEmptyTree() {
        assertFalse(tree.delete(5)); // Deleting from empty tree should return false
    }

    @Test
    public void testDeleteSingleNodeTree() {
        tree.add(5);
        assertTrue(tree.delete(5));
        assertFalse(tree.contains(5)); // Value should be deleted
    }

    @Test
    public void testDeleteNodeWithRightChild() {
        tree.add(5);
        tree.add(3);
        tree.add(4);
        tree.add(1);
        tree.add(0);
        tree.add(2);
        tree.add(15);
        tree.add(10);
        tree.add(13);

        assertTrue(tree.delete(10));
        assertFalse(tree.contains(10)); // Value should be deleted
        assertTrue(tree.contains(5)); // Value should still exist
        assertTrue(tree.contains(3)); // Value should still exist
        assertTrue(tree.contains(4)); // Value should still exist
        assertTrue(tree.contains(1)); // Value should still exist
        assertTrue(tree.contains(0)); // Value should still exist
        assertTrue(tree.contains(2)); // Value should still exist
        assertTrue(tree.contains(15)); // Value should still exist
    }

    @Test
    public void testDeleteNodeWithLeftChild() {
        tree.add(5);
        tree.add(3);
        tree.add(4);
        tree.add(1);
        tree.add(0);
        tree.add(2);
        tree.add(15);
        tree.add(10);

        assertTrue(tree.delete(15));
        assertFalse(tree.contains(15)); // Value should be deleted
        assertTrue(tree.contains(5)); // Value should still exist
        assertTrue(tree.contains(3)); // Value should still exist
        assertTrue(tree.contains(4)); // Value should still exist
        assertTrue(tree.contains(1)); // Value should still exist
        assertTrue(tree.contains(0)); // Value should still exist
        assertTrue(tree.contains(2)); // Value should still exist
        assertTrue(tree.contains(10)); // Value should still exist
    }

    @Test
    public void testDeleteNodeWithTwoChildren() {
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);

        assertTrue(tree.delete(5));
        assertFalse(tree.contains(5)); // Value should be deleted
        assertTrue(tree.contains(3)); // Value should still exist
        assertTrue(tree.contains(7)); // Value should still exist
        assertTrue(tree.contains(2)); // Value should still exist
        assertTrue(tree.contains(4)); // Value should still exist
        assertTrue(tree.contains(6)); // Value should still exist
        assertTrue(tree.contains(8)); // Value should still exist
    }

    @Test
    public void testToArrayLWR() {
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        int[] result = tree.toArray(AuDSortedTreeImpl.Ordering.LWR);
        assertArrayEquals(new int[] { 2, 3, 4, 5, 6, 7, 8 }, result);
    }

    @Test
    public void testToArrayRWL() {
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        int[] result = tree.toArray(AuDSortedTreeImpl.Ordering.RWL);
        assertArrayEquals(new int[] { 8, 7, 6, 5, 4, 3, 2 }, result);
    }

    @Test
    public void testToArrayLRW() {
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        int[] result = tree.toArray(AuDSortedTreeImpl.Ordering.LRW);
        assertArrayEquals(new int[] { 2, 4, 3, 6, 8, 7, 5 }, result);
    }

    @Test
    public void testToArrayRLW() {
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        int[] result = tree.toArray(AuDSortedTreeImpl.Ordering.RLW);
        assertArrayEquals(new int[] { 8, 6, 7, 4, 2, 3, 5 }, result);
    }

    @Test
    public void testToArrayWLR() {
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        int[] result = tree.toArray(AuDSortedTreeImpl.Ordering.WLR);
        assertArrayEquals(new int[] { 5, 3, 2, 4, 7, 6, 8 }, result);
    }

    @Test
    public void testToArrayWRL() {
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        int[] result = tree.toArray(AuDSortedTreeImpl.Ordering.WRL);
        assertArrayEquals(new int[] { 5, 7, 8, 6, 3, 4, 2 }, result);
    }

    @Test
    public void testGetLeafs() {
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        int[] leafs = tree.getLeafs();
        assertArrayEquals(new int[] { 2, 4, 6, 8 }, leafs);
    }

    @Test
    public void testGetLeafsEmptyTree() {
        int[] leafs = tree.getLeafs();
        assertArrayEquals(new int[] {}, leafs);
    }

    @Test
    public void testGetLeafsSingleNodeTree() {
        tree.add(5);
        int[] leafs = tree.getLeafs();
        assertArrayEquals(new int[] { 5 }, leafs);
    }

    @Test
    public void testGetLeafsMultipleLeafs() {
        tree.add(5);
        tree.add(3);
        tree.add(4);
        tree.add(1);
        tree.add(0);
        tree.add(2);
        tree.add(15);
        tree.add(10);
        int[] leafs = tree.getLeafs();
        assertArrayEquals(new int[] { 0, 2, 4, 10, 15 }, leafs);
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