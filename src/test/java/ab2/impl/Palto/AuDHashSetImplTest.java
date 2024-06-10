package ab2.impl.palto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * More in-depth test class for the implementation of the AuDHashSet interface.
 */
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
