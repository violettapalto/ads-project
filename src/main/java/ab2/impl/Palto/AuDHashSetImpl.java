package ab2.impl.Palto;

import ab2.AuDHashSet;

public class AuDHashSetImpl implements AuDHashSet {
    
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private Entry[] table;
    private int size;

    public AuDHashSetImpl() {
        table = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    public AuDHashSetImpl(int capacity) {
        table = new Entry[capacity];
        size = 0;
    }

    private static class Entry {
        long key;
        Entry next;

        Entry(long key) {
            this.key = key;
            this.next = null;
        }
    }

    private int hash(long key) {
        return (int) (key % table.length);
    }

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
}
