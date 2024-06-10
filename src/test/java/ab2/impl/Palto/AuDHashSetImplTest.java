package ab2.impl.Palto;

import ab2.Ab2;
import ab2.AuDHashSet;
import ab2.AuDQueue;
import ab2.AuDQueue.Type;
import ab2.AuDSortedTree;
import ab2.AuDSortedTree.Ordering;
import ab2.impl.Palto.Ab2Impl;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class AuDHashSetImplTest {

    private AuDHashSetImpl instance = new AuDHashSetImpl();
    
    @Test
    public void testContains() {
        instance.add(1);
        assertTrue(instance.contains(1));
        assertFalse(instance.contains(2));
    }

    @Test
    public void testAdd() {
        instance.add(1);
        assertTrue(instance.contains(1));
    }

}
