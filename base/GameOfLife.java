import java.util.*;
import java.io.*;

// Create a simple game of life simulation that can 
public class GameOfLife {
	// Specify the number of rows and columns of the matrix
	// Specifiy the percentage of the space to be filled by random living cells
	private static int rows = 20;
	private static int columns = 50;
	private static float p = 0.20f;
	public static void main(String[] args) {
		GameOfLife newGame = new GameOfLife();
		int[][] newMatrix = new int[rows][columns];
		newGame.startSim(newMatrix,rows,columns);
	}

	// Start the game
	public void startSim(int[][] matrix,int rows, int columns) {
		Scanner s = new Scanner(System.in);
		setMatrix(matrix, p);
		getMatrix(matrix);
		String ch = s.nextLine();
		while(!ch.equalsIgnoreCase("sadasdfsd"))
		{
			matrix = lifeCyle(matrix,rows,columns);
			getMatrix(matrix);
			try {
				Thread.sleep(1000);
			}
			catch(Exception e){
				System.out.println("Error.");
			}
 
		}
		s.close();
		System.out.println("Game Over");
	}
	

	// Create a method to generate a new matrix
	public int[][] lifeCyle(int[][] matrix, int rows, int columns) {
 
		int[][] m = new int[rows][columns];

		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				m[i][j] = godMode(matrix, i, j);
			}
		}
		return m;
	}


	//Count the number of living cell neighboring a cell at the given coordinate
	public int around(int[][] matrix, int i, int j) {
		int count = 0, x, y;
		for(x = i - 1; x <= i + 1; x++){
			for(y = j - 1; y <= j + 1; y++)
			{
				if (x == i && y == j){
					continue;
				}
				else {
					count+=eval(matrix,x,y);
				}
			}
		}
		return count;
	}

	//Create a godMode that will take a matrix and position variables and will return either a dead or alive cell
	public int godMode(int[][] matrix, int i, int j) {
		int count = around(matrix, i, j);

		if (matrix[i][j] == 1){
			if (count < 2 || count > 3) {
				return 0;
			}
			return 1;
		}
		else {
			if (count == 3) {
				return 1;
			}
			return 0;
		}
	}

	//Evaluate the matrix with 
	public int eval(int[][] matrix, int i, int j) {
		int val = 0;
		if(i < 0 || j < 0 || i == rows || j == columns) {
			return val = 0;
		}

		if (matrix[i][j] == 1) {
			return val = 1;
		}
		return val;
	}

	//Initialize an array
	public void setMatrix(int[][] matrix, float percentageFill) {
		for(int i = 0; i < matrix.length;i++){
			int[] array = matrix[i];
			for(int j = 0; j < array.length; j++) {
				if (Math.random() < percentageFill) {
					array[j] = 1;
				}
				else {
					array[j] = 0;
				}
			}
		}
	}

	//Print the array
	public void getMatrix(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++){
			int[] array = matrix[i];
			for(int j = 0; j < array.length; j++){
				System.out.print(array[j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
 