import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args){
        Main m = new Main();
        m.startSim();
    
    }

    public void startSim() {
        float p = 0.20f;
		int i = 30;
        int j = 60;
        
		Scanner s = new Scanner(System.in);
		LinkedMatrices l2 = new LinkedMatrices();
		GameOfLife newGame = new GameOfLife(i, j, p);
        int[][] newMatrix = GameOfLife.initializeMatrix(GameOfLife.p);

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