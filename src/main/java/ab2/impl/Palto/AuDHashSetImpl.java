package ab2.impl.palto;

import ab2.AuDHashSet;

/**
 * Implementation of the AuDHashSet interface.
 */
public class AuDHashSetImpl implements AuDHashSet {

    /** The initial capacity of the hash set, used upon construction when no capacity is specified. */
    private static final int INITIAL_CAPACITY = 16;
    /** The load factor of the hash set, used to determine when to resize the table. */
    private static final double LOAD_FACTOR = 0.75;

    /** The table of entries. */
    private Entry[] table;
    /** The number of entries in the hash set. */
    private int size;

    /**
     * Constructs a new AuDHashSetImpl object with the initial capacity of 16.
     */
    public AuDHashSetImpl() {
        table = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Constructs a new AuDHashSetImpl object with the specified capacity.
     *
     * @param capacity the initial capacity of the hash set
     */
    public AuDHashSetImpl(int capacity) {
        table = new Entry[capacity];
        size = 0;
    }

    /**
     * Calculates the hash value for the given key.
     *
     * @param key the key to calculate the hash value for
     * @return the hash value
     */
    private int hash(long key) {
        // Scramble bits using multiplication with a prime and bitwise XOR
        key ^= 0x8DEB83FL;
        key *= 0x3F4B3D4BL;

        // Combine higher and lower 32 bits for better distribution
        key ^= key >>> 32;
        key *= 0xDEADBEEFL;
        key ^= key >>> 16;
        return (int) (key & (table.length - 1));
    }

    /**
     * Adds a value to the hash set.
     *
     * @param value the value to add
     */
    @Override
    public void add(long value) {
        int index = hash(value);
        Entry entry = new Entry(value);

        if (table[index] == null) {
            table[index] = entry;
        } else {
            Entry current = table[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = entry;
        }

        size++;

        if (size >= table.length * LOAD_FACTOR) {
            resizeTable();
        }
    }

    /**
     * Checks if the hash set contains a value.
     *
     * @param value the value to check
     * @return true if the value is found, false otherwise
     */
    @Override
    public boolean contains(long value) {
        int index = hash(value);
        Entry current = table[index];

        while (current != null) {
            if (current.key == value) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    /**
     * Resizes the hash set table when the load factor is exceeded.
     */
    private void resizeTable() {
        int newCapacity = table.length * 2;
        Entry[] newTable = new Entry[newCapacity];

        for (Entry entry : table) {
            while (entry != null) {
                Entry next = entry.next;
                int newIndex = hash(entry.key);
                entry.next = newTable[newIndex];
                newTable[newIndex] = entry;
                entry = next;
            }
        }

        table = newTable;
    }

    
    /**
     * Represents an entry in the hash set.
     */
    private static class Entry {
        /** The key of the entry. */
        long key;
        /** The next entry in the chain. */
        Entry next;

        /**
         * Constructs a new Entry object with the specified key.
         *
         * @param key the key of the entry
         */
        Entry(long key) {
            this.key = key;
            this.next = null;
        }
    }
}
