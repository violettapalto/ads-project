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
            // Tree is empty
            node = new Node(value);
            return true;
        } else if (value < node.value) {
            // Value is smaller than the current node
            if (left == null) {
                left = new AuDSortedTreeImpl();
            }
            return left.add(value);
        } else if (value > node.value) {
            // Value is greater than the current node
            if (right == null) {
                right = new AuDSortedTreeImpl();
            }
            return right.add(value);
        } else {
            // Value already exists
            return false;
        }
    }

    @Override
    public boolean contains(int value) {
        if (node == null) {
            // Tree is empty
            return false;
        } else if (value < node.value) {
            // Value is smaller than the current node
            return left != null && left.contains(value);
        } else if (value > node.value) {
            // Value is greater than the current node
            return right != null && right.contains(value);
        } else {
            // Value is equal to the current node
            return true;
        }
    }

    @Override
    public boolean delete(int value) {
        if (node == null) {
            // Tree is empty
            return false;
        } else if (value < node.value) {
            // Value is smaller than the current node
            boolean deleted = false;
            if (left != null) {
                deleted = left.delete(value);
                garbageCollect();
            }
            return deleted;
        } else if (value > node.value) {
            // Value is greater than the current node
            boolean deleted = false;
            if (right != null) {
                deleted = right.delete(value);
                garbageCollect();
            }
            return deleted;
        } else {
            // Value is equal to the current node
            if (left == null && right == null) {
                // Node has no children
                node = null;
            } else if (left == null) {
                // Node has one child on the right
                node = right.node;
                left = right.left;
                right = right.right;
            } else if (right == null) {
                // Node has one child on the left
                node = left.node;
                right = left.right;
                left = left.left;
            } else {
                // Node has two children, replace with the minimum value from the right subtree
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
            boolean includeSelf = left == null || right == null;
            int[] leftLeaves = left == null ? new int[0] : left.getLeafs();
            int[] rightLeaves = right == null ? new int[0] : right.getLeafs();

            return includeSelf ? concat(leftLeaves, concat(new int[] { node.value }, rightLeaves))
                    : concat(leftLeaves, rightLeaves);
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
     * Removes the children of the current node if their node is null.
     */
    private void garbageCollect() {
        if (left != null && left.node == null) {
            left = null;
        }
        if (right != null && right.node == null) {
            right = null;
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
