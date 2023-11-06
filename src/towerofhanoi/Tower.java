// Virginia Tech Honor Code Pledge:
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the 
//actions of those who do.
// -- Chris Nicoue Beglah (chrisn04)
package towerofhanoi;

/**
 * This class creates the tower wich implements 
 * the extends the linked stack class
 * @author Chris Nicoue Beglah (chrisn04)
 * @version 2023.10.17
 */
public class Tower extends LinkedStack<Disk> {
    private Position position;

    /**
     * This is the constructor for this class
     * it initializes the fields
     * @param position takes in a position as a parameter
     * 
     */
    public Tower(Position position) {
        super();
        this.position = position;

    }


    /**
     * Gets the position of a disk
     * @return the position of the tower
     */
    public Position position() {
        return this.position;

    }


    /**
     * Pushes the disk onto the tower
     * is the valid conditions are met
     * and throws and exception if not met
     * 
     * @param disk
     *            takes in a disk as a parameter
     * 
     */
    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty() || disk.compareTo(this.peek()) == -1) {
            super.push(disk);

        }
        else {
            throw new IllegalStateException();

        }

    }

}
