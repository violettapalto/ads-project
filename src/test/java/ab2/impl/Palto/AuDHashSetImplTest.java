package ab2.impl.palto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

/**
 * More in-depth test class for the implementation of the AuDHashSet interface.
 */
public class AuDHashSetImplTest {

    private AuDHashSetImpl instance;

    @BeforeEach
    public void setUp() {
        instance = new AuDHashSetImpl();
    }
    
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

    @Test
    public void testAddDuplicate() {
        instance.add(1);
        instance.add(1);
        assertTrue(instance.contains(1));
    }

    @Test
    public void testAddMany() {
        for (int i = 0; i < 100; i++) {
            instance.add(i);
        }
        for (int i = 0; i < 100; i++) {
            assertTrue(instance.contains(i));
        }
    }

    @Test
    public void testAddManyDuplicate() {
        for (int i = 0; i < 100; i++) {
            instance.add(i);
            instance.add(i);
        }
        for (int i = 0; i < 100; i++) {
            assertTrue(instance.contains(i));
        }
    }

    @Test
    public void testResize() {
        AuDHashSetImpl instance = new AuDHashSetImpl(1);
        for (int i = 0; i < 100; i++) {
            instance.add(i);
        }
        for (int i = 0; i < 100; i++) {
            assertTrue(instance.contains(i));
        }
    }

    @Test
    public void testLargeValues() {
        instance.add(Long.MAX_VALUE);
        assertTrue(instance.contains(Long.MAX_VALUE));
    }

}
