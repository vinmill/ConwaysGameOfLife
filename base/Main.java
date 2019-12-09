import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args){
        Main m = new Main();
        float p = 0.20f;
        m.startSim(70,100,p);
    
    }

    public void startSim(int i, int j, float p) {
        
		Scanner s = new Scanner(System.in);
		LinkedMatrices l2 = new LinkedMatrices();
		GameOfLife newGame = new GameOfLife(i, j, p);
        int[][] newMatrix = GameOfLife.initializeMatrix();

        int counter = 0;
        l2.append(newMatrix);
        GameOfLife.getMatrix(newMatrix);
        String ch = s.nextLine();
        Boolean keepGoing = true;
		while(keepGoing)
		{
            newMatrix = newGame.lifeCyle(newMatrix);
            l2.append(newMatrix);
            int x = l2.findMatch(l2);
            GameOfLife.getMatrix(newMatrix);
            counter++;
            if (x != 0) {
                keepGoing = false;
                System.out.print("Simulation reached a stable state after " + counter + " generations.");
                System.out.print("The terminating state contained at least one period " + x + " oscillator.");
            }
		}
		s.close();
		System.out.println("Game Over");
	}
    
    // Method to compare matrices returns 1 if equal
}