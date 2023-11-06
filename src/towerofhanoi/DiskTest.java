// Virginia Tech Honor Code Pledge:
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the
// actions of those who do.
// -- Chris Nicoue Beglah (chrisn04)
/**
 * 
 * 
 */
/**
 * 
 */
package towerofhanoi;

import student.TestCase;

/**
 * This class is where the test for the disk class are located
 * 
 * @author Chris Nicoue Beglah (chrisn04)
 * @version 2023.10.17
 * 
 */
public class DiskTest extends TestCase {
    private Disk disk;
    private Disk disk2;
    private Disk disk3;
    private Disk disk4;

    /**
     * 
     */
    public DiskTest() {
        //Usually blank
    }

    /**
     * Sets up the fields
     */
    public void setUp() {
        disk = new Disk(5);
        disk2 = new Disk(5);
        disk3 = new Disk(1);
        disk4 = new Disk(10);
    }


    /**
     * Test the to string to make sure it is returning
     * the right string
     */
    public void testToString() {
        String str = "5";

        assertEquals(str, disk.toString());

    }


    /**
     * Test the Compare to method when the parameter
     * is null
     */
    public void testCompareToNull() {
        Exception thrown = null;
        try {
            disk.compareTo(null);
        }
        catch (Exception exception) {
            thrown = exception;
        }

        assertNotNull(thrown);

        assertTrue(thrown instanceof IllegalArgumentException);

    }


    /**
     * Test the compare to method when the
     * disk are equal, when disk 1 is smaller
     * and when disk 1 is bigger.
     */
    public void testCompareTo() {
        assertEquals(0, disk.compareTo(disk2));
        assertEquals(1, disk.compareTo(disk3));
        assertEquals(-1, disk.compareTo(disk4));

    }


    /**
     * Test the equals method to make sure
     * it returns the correct boolean value
     */
    public void testEquals() {
        assertTrue(disk.equals(disk));
        assertFalse(disk.equals(null));
        assertFalse(disk.equals("John"));
        assertTrue(disk.equals(disk2));
        assertFalse(disk.equals(disk4));

    }

}
