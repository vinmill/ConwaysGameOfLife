import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args){
        Main m = new Main();
        float p = 0.20f;
        m.startSim(10,10,p);
    
    }

    public void startSim(int i, int j, float p) {
        
		Scanner s = new Scanner(System.in);
		LinkedMatrices l2 = new LinkedMatrices();
		GameOfLife newGame = new GameOfLife(i, j, p);
        int[][] newMatrix = GameOfLife.initializeMatrix();

        GameOfLife.getMatrix(newMatrix);
        newMatrix = newGame.lifeCyle(newMatrix);
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
            if (x != 0) {
                keepGoing = false;
                System.out.print("iterator : " + x);
            }
			try {
				Thread.sleep(400);
			}
			catch(Exception e){
				System.out.println("Error.");
			}
 
		}
		s.close();
		System.out.println("Game Over");
	}
    
    // Method to compare matrices returns 1 if equal
}