package ab2.impl.palto;

import ab2.AuDSortedTree;

/**
 * An interface representing a sorted tree data structure.
 */
public class AuDSortedTreeImpl implements AuDSortedTree {

    /** The root node of the tree. */
    private Node node = null;
    /** The left child of the root node. */
    private AuDSortedTreeImpl left = null;
    /** The right child of the root node. */
    private AuDSortedTreeImpl right = null;

    @Override
    public boolean add(int value) {
        if (node == null) {
            node = new Node(value);
            return true;
        } else if (value < node.value) {
            if (left == null) {
                left = new AuDSortedTreeImpl();
            }
            return left.add(value);
        } else if (value > node.value) {
            if (right == null) {
                right = new AuDSortedTreeImpl();
            }
            return right.add(value);
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(int value) {
        if (node == null) {
            return false;
        } else if (value < node.value) {
            return left != null && left.contains(value);
        } else if (value > node.value) {
            return right != null && right.contains(value);
        } else {
            return true;
        }
    }

    @Override
    public boolean delete(int value) {
        if (node == null) {
            return false;
        } else if (value < node.value) {
            return left != null && left.delete(value);
        } else if (value > node.value) {
            return right != null && right.delete(value);
        } else {
            if (left == null && right == null) {
                node = null;
            } else if (left == null) {
                node = right.node;
                left = right.left;
                right = right.right;
            } else if (right == null) {
                node = left.node;
                right = left.right;
                left = left.left;
            } else {
                int min = right.min();
                node.value = min;
                right.delete(min);
            }
            return true;
        }
    }

    @Override
    public int[] toArray(Ordering order) {
        int root = node == null ? 0 : node.value;
        int[] leftArray = left == null ? new int[0] : left.toArray(order);
        int[] rightArray = right == null ? new int[0] : right.toArray(order);

        switch (order) {
            case LWR:
                return concat(leftArray, concat(new int[] { root }, rightArray));
            case RWL:
                return concat(rightArray, concat(new int[] { root }, leftArray));
            case LRW:
                return concat(concat(leftArray, rightArray), new int[] { root });
            case RLW:
                return concat(concat(rightArray, leftArray), new int[] { root });
            case WLR:
                return concat(new int[] { root }, concat(leftArray, rightArray));
            case WRL:
                return concat(new int[] { root }, concat(rightArray, leftArray));
            default:
                throw new IllegalArgumentException("Invalid ordering: " + order);
        }
    }

    @Override
    public int[] getLeafs() {
        if (node == null) {
            return new int[0];
        } else if (left == null && right == null) {
            return new int[] { node.value };
        } else {
            boolean isLeaf = left == null || right == null;
            int[] leftLeafs = left == null ? new int[0] : left.getLeafs();
            int[] rightLeafs = right == null ? new int[0] : right.getLeafs();
            return isLeaf ? concat(new int[] { node.value }, concat(leftLeafs, rightLeafs))
                    : concat(leftLeafs, rightLeafs);
        }
    }

    @Override
    public int min() {
        if (node == null) {
            throw new IllegalStateException("Tree is empty");
        } else if (left == null) {
            return node.value;
        } else {
            return left.min();
        }
    }

    @Override
    public int max() {
        if (node == null) {
            throw new IllegalStateException("Tree is empty");
        } else if (right == null) {
            return node.value;
        } else {
            return right.max();
        }
    }

    /**
     * Concatenates two arrays.
     * 
     * @param a the first array
     * @param b the second array
     * @return the concatenated array
     * @author Anuta1409
     * @see https://github.com/Anuta1409/AutomationQA
     */
    private int[] concat(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    /**
     * Represents a node in the tree.
     */
    private static class Node {
        /** The value of the node. */
        int value;

        /**
         * Constructs a new Node object with the specified value.
         *
         * @param value the value of the node
         */
        Node(int value) {
            this.value = value;
        }
    }

}
