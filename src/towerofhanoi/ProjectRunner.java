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

/**
 * 
 */
public class ProjectRunner {

    /**
     * 
     */
    public ProjectRunner() {
        // TODO Auto-generated constructor stub
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        int disks = 6;
        if (args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }
        HanoiSolver solver = new HanoiSolver(disks);
        PuzzleWindow puzzWin = new PuzzleWindow(solver);

    }

}
