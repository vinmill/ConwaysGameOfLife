import java.util.*;
import java.io.*;

// Create a simple game of life simulation that can 
public class GameOfLife {
	// Specify the number of rows and columns of the matrix
	// Specifiy the percentage of the space to be filled by random living cells
	public static int rows = 20;
	public static int columns = 50;
	public static float p = 0.20f;
	protected int[][] matrix;
	public static void main(String[] args) {
		float p = 0.20f;
		int i = 30;
		int j = 60;
		GameOfLife newGame = new GameOfLife(i, j, p);
		newGame.startSim();
	}

	public GameOfLife (int rows, int columns, float p) {
		GameOfLife.rows = rows;
		GameOfLife.columns = columns;
		GameOfLife.p = p;
	}

	// Start the game
	public void startSim() {
		Scanner s = new Scanner(System.in);
		int[][] m = initializeMatrix(p);
		getMatrix(m);
		String ch = s.nextLine();
		while(!ch.equalsIgnoreCase("sadasdfsd"))
		{
			m = lifeCyle(m);
			getMatrix(m);
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
	

	// Create a method to generate a new matrix
	public int[][] lifeCyle(int[][] matrix) {
 
		int[][] m = new int[rows][columns];
		int i, j;

		for(i = 0; i < rows; i++){
			for(j = 0; j < columns; j++){
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

	//Initialize a matrix with random integers throughout the entire matrix
	public static int[][] initializeMatrix(float percentageFill) {
		int[][] matrix = new int[rows][columns];

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
		return matrix;
	}

	//Print the array
	public static void getMatrix(int[][] matrix) {
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
 