// Virginia Tech Honor Code Pledge:
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the
// actions of those who do.
// -- Chris Nicoue Beglah (chrisn04)

package towerofhanoi;

import java.util.Observable;

/**
 * This class is where the puzzle is being solved
 * in the back end
 * 
 * @author Chris Nicoue Beglah (chrisn04)
 * @version 2023.10.17
 */
@SuppressWarnings("deprecation")
public class HanoiSolver extends Observable {
    private Tower left;
    private Tower right;
    private Tower middle;
    private int numDisk;

    /**
     * This is the Constructor for this class
     * and initializes the fields
     * @param numDisk takes in a integer for number of disk
     */
    public HanoiSolver(int numDisk) {
        this.numDisk = numDisk;
        left = new Tower(Position.LEFT);
        right = new Tower(Position.RIGHT);
        middle = new Tower(Position.MIDDLE);

    }


    /**
     * The method retirsthe number
     * 
     * @return the number of disk
     */
    public int disks() {
        return numDisk;
    }


    /**
     * Get the tower Depending on the position
     * requested, return either left, middle, or right.
     * 
     * @param pos
     *            takes in a position as a parameter
     * @return return the tower based on the position
     */
    public Tower getTower(Position pos) {
        switch (pos) {
            case LEFT:
                return left;
            case RIGHT:
                return right;
            case MIDDLE:
                return middle;
            default:
                return middle;

        }

    }


    /**
     * Takes the disk at each tower and turns it
     * Into a string
     * 
     * @return returns the width of the disk in string form
     */
    public String toString() {
        return left.toString() + middle.toString() + right.toString();

    }


    /**
     * A private method
     * Moves the disk from one tower to the another
     * 
     * @param source
     *            takes in a tower as a parameter
     * @param destination
     *            send the disk to certain tower
     */
    private void move(Tower source, Tower destination) {
        destination.push(source.pop());
        setChanged();
        notifyObservers(destination.position());

    }


    /**
     * A private recursive method that attempts to move the disk
     * from one pole to another and decreases the number of disk each time
     * 
     * @param currentDisks
     *            the number of disk
     * @param startPole
     *            takes in the left tower
     * @param tempPole
     *            takes in the middle tower
     * @param endPole
     *            takes in the right tower
     */
    private void solveTowers(
        int currentDisks,
        Tower startPole,
        Tower tempPole,
        Tower endPole) {
        if (currentDisks == 1) {
            move(startPole, endPole);

        }
        else {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            move(startPole, endPole);

            solveTowers(currentDisks - 1, tempPole, startPole, endPole);

        }

    }


    /**
     * Calls the recursive method SolevTowers and solves
     * the puzzle in the back end
     */
    public void solve() {
        solveTowers(numDisk, left, middle, right);

    }

}
