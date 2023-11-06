// Virginia Tech Honor Code Pledge:
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the 
//actions of those who do.
// -- Chris Nicoue Beglah (chrisn04)
/**
 * 
 * 
 */
package towerofhanoi;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Michael Peters (mpeters01)

import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * The main front-end work and the view for the Tower of Hanoi puzzle
 *
 * @author Chris Nicoue-Beglah
 * @version 10.17.2023
 */
public class PuzzleWindow implements Observer {

    private HanoiSolver game;
    private Shape left;
    private Shape middle;
    private Shape right;
    private Window window;
    private Button solve;
    /**
     * A factor in which the width of the disks are multiplied by
     */
    public static final int WIDTH_FACTOR = 15;
    /**
     * The vertical gap between each disk on the tower
     */
    public static final int DISK_GAP = 0;
    /**
     * The height of each disk on the tower
     */
    public static final int DISK_HEIGHT = 15;

    /**
     * Creates a new PuzzleWindow view for a given HanoiSolver game
     *
     * @param g
     *            the game to create a view for
     */
    public PuzzleWindow(HanoiSolver g) {
        this.game = g;
        game.addObserver(this);
        window = new Window();
        window.setTitle("Tower of Hanoi");
        int poleHeight = 400;
        int poleY = (window.getGraphPanelHeight() / 2) - (poleHeight / 2);
        left = new Shape((200 - 15 / 2), poleY, 15, poleHeight, new Color(50,
            50, 50));
        middle = new Shape(((window.getGraphPanelWidth() / 2) - 15 / 2), poleY,
            15, poleHeight, new Color(50, 50, 50));
        right = new Shape(((window.getGraphPanelWidth() - 200) - 15 / 2), poleY,
            15, poleHeight, new Color(50, 50, 50));
        for (int width = (game.disks() + 1)
            * WIDTH_FACTOR; width > WIDTH_FACTOR; width -= WIDTH_FACTOR) {
            Disk newDisk = new Disk(width);
            window.addShape(newDisk);
            game.getTower(Position.LEFT).push(newDisk);
            moveDisk(Position.LEFT);

        }
        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);
        solve = new Button("Solve");
        window.addButton(solve, WindowSide.NORTH);
        solve.onClick(this, "clickedSolve");

    }


    /**
     * This method updates the front-end, after 
     * the back-end has been changed.
     * 
     * @param position
     *            takes in a position as a parameter
     */
    private void moveDisk(Position position) {
        Disk currentDisk = game.getTower(position).peek();
        Shape currentPole = left;
        if (position.equals(Position.LEFT)) {
            currentPole = left;
        }
        else if (position.equals(Position.RIGHT)) {
            currentPole = right;

        }
        else if (position.equals(Position.MIDDLE)) {
            currentPole = middle;
        }
        int newX = currentPole.getX() - (currentDisk.getWidth() - currentPole
            .getWidth()) / 2;
        int newY = currentPole.getY() + currentPole.getHeight() - game.getTower(
            position).size() * DISK_HEIGHT;

        currentDisk.moveTo(newX, newY);

    }


    /**
     * Updates the view whenever a disk is moved in the back-end
     *
     * @param o
     *            The observable that triggered the update
     * @param arg
     *            arguments sent by the game; should be a position
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg.getClass() == Position.class) {
            Position position = (Position)arg;
            moveDisk(position);
            sleep();
            
            

        }
    }


    /**
     * Runs when the Solve button is clicked, tells the puzzle to start solving
     *
     * @param button
     *            the button that was clicked
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }


    /**
     * method provides a means to pause between Disk movements.
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }
}
