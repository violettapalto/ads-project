package ab2.impl.palto;

import ab2.Ab2;
import ab2.AuDHashSet;
import ab2.AuDQueue;
import ab2.AuDQueue.Type;
import ab2.AuDSortedTree;

public class Ab2Impl implements Ab2 {

    @Override
    public AuDHashSet emptyHashSet(int capacity) {
        return new AuDHashSetImpl(capacity);
    }

    @Override
    public AuDSortedTree emptyTree() {
        // TODO: Auto-generated method stub
        return null;
    }

    @Override
    public AuDQueue emptyQueue(Type type) {
        // TODO: Auto-generated method stub
        return null;
    }

}
