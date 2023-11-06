// Virginia Tech Honor Code Pledge:
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the
// actions of those who do.
// -- Chris Nicoue Beglah (chrisn04)
package towerofhanoi;

import student.TestCase;

/**
 * This class is where the test methods for the hanoi
 * solver class is located
 * 
 * @author Chris Nicoue Beglah (chrisn04)
 * @version 2023.10.17
 * 
 */
public class HanoiSolverTest extends TestCase {
    private HanoiSolver solve;
    private Tower left;
    private Tower middle;
    private Tower right;
    private Tower def;
    private Disk tinyDisk;
    private Disk disk;
    private Disk largeDisk;

    /**
     * This is the constructor for the test c;lass
     * 
     */
    public HanoiSolverTest() {
        // This is usually Blank
    }


    /**
     * Initializes all the fields
     */
    public void setUp() {
        solve = new HanoiSolver(3);
        left = solve.getTower(Position.LEFT);
        middle = solve.getTower(Position.MIDDLE);
        right = solve.getTower(Position.RIGHT);
        def = solve.getTower(Position.DEFAULT);

        tinyDisk = new Disk(1);
        disk = new Disk(50);
        largeDisk = new Disk(200);

    }


    /**
     * Makes sure the get tower method
     * returns the right position
     */
    public void testGetTower() {
        assertEquals(Position.RIGHT, right.position());
        assertEquals(3, solve.disks());
        assertEquals(Position.MIDDLE, middle.position());
        assertEquals(Position.LEFT, left.position());

    }


    /**
     * Test To string when each tower has a disk
     * and solve
     */
    public void testToString() {
        right.push(disk);
        left.push(largeDisk);
        def.push(tinyDisk);
        assertEquals("[200][1][50]", solve.toString());

    }


    /**
     * Test To string when only one Tower has
     * all the disk on it
     */
    public void testToString2() {
        left.push(largeDisk);
        left.push(disk);
        left.push(tinyDisk);
        assertEquals("[1, 50, 200][][]", solve.toString());

    }


    /**
     * Test the solve towers method and also solve the
     * two private methods move and solve towers
     */
    public void testSolve() {
        left.push(largeDisk);
        left.push(disk);
        left.push(tinyDisk);
        assertEquals("[1, 50, 200][][]", solve.toString());
        solve.solve();
        assertEquals("[][][1, 50, 200]", solve.toString());

    }

}
