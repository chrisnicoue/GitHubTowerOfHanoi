// Virginia Tech Honor Code Pledge:
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the 
//actions of those who do.
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
 * This class is where the test for the tower class is located
 * 
 * @author Chris Nicoue Beglah (chrisn04)
 * @version 2023.10.17
 * 
 */
public class TowerTest extends TestCase {
    private Tower tower;
    private Disk disk;
    private Disk disk2;

    /**
     * 
     */
    public TowerTest() {
        //This is usally empty

    }


    /**
     * This is the setUp() method it initializes the
     * Fields
     * 
     */
    public void setUp() {
        tower = new Tower(Position.LEFT);
        disk = new Disk(5);
        disk2 = new Disk(10);

    }


    /**
     * Test the position of the tower
     */
    public void testPosition() {
        tower.position();
        assertEquals(Position.LEFT, tower.position());

    }


    /**
     * This test that the method throws
     * an exception because disk is null
     */
    public void testPushExcpetion() {
        Exception exception = null;
        
        try {
            tower.push(null);
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("push is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);

    }


    /**
     * Test push when the tower is empty
     */
    public void testPush() {
        tower.push(disk);
        assertEquals(disk, tower.peek());
        assertEquals(1, tower.size());

    }


    /**
     * Test Push when the disk that
     * is being pushed is smaller than the
     * disk that was already pushed
     */
    public void testPush2() {
        tower.push(disk2);
        tower.push(disk);
        assertEquals(disk, tower.peek());
        assertEquals(2, tower.size());

    }


    /**
     * Test the push method when the disk
     * your trying to push is bigger than the
     * disk that was already pushed
     */
    public void testPushException3() {
        Exception exception = null;
        try {
            tower.push(disk);
            tower.push(disk2);
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("push is throwing the wrong type of exceptions",
            exception instanceof IllegalStateException);

    }

}
