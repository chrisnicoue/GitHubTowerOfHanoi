/**
 * 
 */
package towerofhanoi;

import cs2.Shape;
import student.TestableRandom;
import java.awt.Color;

/**
 * 
 * 
 * This class creates the disk shapes and specific methods for it
 * 
 * @author Chris Nicoue Beglah (chrisn04)
 * @version 2023.10.17
 *
 * 
 */
public class Disk extends Shape implements Comparable<Disk> {

    /**
     * This is the constructor for this class
     * it initializes the fields and sets the disk to
     * be random colors
     * 
     * @param width
     *            take s in a width
     */
    public Disk(int width) {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        TestableRandom random = new TestableRandom();
        int red = random.nextInt(256);
        int blue = random.nextInt(256);
        int green = random.nextInt(256);
        this.setBackgroundColor(new Color(red, blue, green));

    }


    /**
     * Compares Disk to another disk and returns
     * 0 is they are the same size 1 this is bigger and -1
     * if this is smaller
     * 
     * @param otherDisk takes in a disk
     * @return return the size based on the if statements
     */
    @Override
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();

        }
        int size = 0;
        if (this.getWidth() == otherDisk.getWidth()) {
            size = 0;
        }
        if (this.getWidth() > otherDisk.getWidth()) {
            size = 1;
        }
        if (this.getWidth() < otherDisk.getWidth()) {
            size = -1;
        }

        return size;
    }


    /**
     * turns the width of the disk into a string
     * 
     * @return returns the width in string form
     */
    public String toString() {

        return "" + getWidth();

    }


    /**
     * This is the equals method for this class
     * 
     * @param obj
     *            takes in a object to compare
     * @return return a boolean on weather the two objects
     *         are truly equal to one another
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Disk disk = (Disk)obj;

        return disk.getWidth() == this.getWidth();

    }

}
