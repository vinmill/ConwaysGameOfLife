import java.util.*;
import java.io.*;

public class Main implements Serializable{
    public static void main(String[] args){
        MainMenu();
    }

    public static void startSim(int i, int j, float p) {
        
		Scanner s = new Scanner(System.in);
		LinkedMatrices l2 = new LinkedMatrices();
		GameOfLife newGame = new GameOfLife(i, j, p);
        int[][] newMatrix = GameOfLife.initializeMatrix();
        int[][] initialMatrix = newMatrix;

        int counter = 0;
        l2.append(newMatrix);
        GameOfLife.getMatrix(newMatrix);
        System.out.println("Would you like to continue? (enter)");
        String ch = s.nextLine();
        Boolean keepGoing = true;
        int x = 0;
		while(keepGoing)
		{
            newMatrix = newGame.lifeCyle(newMatrix);
            l2.append(newMatrix);
            x = l2.findMatch(l2);
            GameOfLife.getMatrix(newMatrix);
            counter++;
            if (counter > 15) {
                l2.delete(l2.GetNth(0));
            }
            if (x != 0) {
                keepGoing = false;
                System.out.print("Simulation reached a stable state after " + counter + " generations.");
                System.out.print("The terminating state contained at least one period " + x + " oscillator.");
            }
        }
        AddConfigMenu(i, j, initialMatrix, counter, x);
        s.close();
    }

    public static void AddConfigMenu(int row, int column, int[][] array, int generations, int maxPeriod){
        Scanner q = new Scanner(System.in);
        System.out.println("Would you like to save the initial matrix used for this simulation?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int r = q.nextInt();
        if (r == 1) {
            ArrayList<Configuration> cfg = deSerialArray();
            Configuration c = new Configuration(row, column, array, generations, maxPeriod);
            cfg.add(c);
            serialArray(cfg);
        } else if (r == 2) {
            System.out.println("Goodbye");
        }
    }

    public static void startNewSim(int i, int j, int[][] newMatrix) {
        
		Scanner s = new Scanner(System.in);
		LinkedMatrices l2 = new LinkedMatrices();
        GameOfLife newGame = new GameOfLife(i,j,newMatrix);

        int counter = 0;
        l2.append(newMatrix);
        GameOfLife.getMatrix(newMatrix);
        System.out.println("Would you like to continue? (enter)");
        String ch = s.nextLine();
        Boolean keepGoing = true;
		while(keepGoing)
		{
            newMatrix = newGame.lifeCyle(newMatrix);
            l2.append(newMatrix);
            int x = l2.findMatch(l2);
            GameOfLife.getMatrix(newMatrix);
            counter++;
            if (counter > 15) {
                l2.delete(l2.GetNth(0));
            }
            if (x != 0) {
                keepGoing = false;
                System.out.print("Simulation reached a stable state after " + counter + " generations.");
                System.out.print("The terminating state contained at least one period " + x + " oscillator.");
            }
		}
        s.close();
    }

    public static int MainMenu() {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to Conway's game of life. A simulation of cellular automata.");
        System.out.println("1. Generate a new simulation with specific initial conditions.");
        System.out.println("2. Choose an existing configuration from a previous simulation.");
        System.out.println("3. Exit.");
        int ch = s.nextInt();
        System.out.println();    

        if (ch == 1) {
            NewSimMenu();
        } else if (ch == 2) {
            ConfigMenu();
        } else if (ch == 3) {
            System.out.println("Goodbye.");
        } else {
            System.out.println("Invalid input. Try again.");
            return 0; 
        }

        return 1;

    }

    public static void NewSimMenu() {
        Scanner q = new Scanner(System.in);
        System.out.println("Enter the specifications of your new matrix.");

        System.out.println("Rows:");
        int r = q.nextInt();
        System.out.println("Columns:");
        int c = q.nextInt();
        System.out.println("Percentage of living cells:");
        float p = q.nextFloat();
        startSim(r, c, p);

        System.out.println();    

    }

    public static void ConfigMenu() {
        getConfigs();
        Scanner q = new Scanner(System.in);
        System.out.println("Enter the index of the config that you want to use.");
        int r = q.nextInt();
        Configuration c = setConfig(r);
        startNewSim(c.getRows(), c.getColumns(), c.getInitArray());
        System.out.println(); 

    }

    public static void getConfigs(){
        Configuration c = new Configuration();
        ArrayList<Configuration> cfgs = deSerialArray();
        for (int i = 0; i < cfgs.size(); i++){
            c = cfgs.get(i);
            System.out.println("Index:" + c.getCfgIndex() + ",  Max Period:" + c.getMaxPeriod() + ",  Generations:" + c.getGenerations() + ",  Dimensions:" + c.getRows() + " x " + c.getColumns());   
        } 
        System.out.println();    

    }

    public static Configuration setConfig(int i) {
        ArrayList<Configuration> cfgs = deSerialArray();
        Configuration c = cfgs.get(i);
        serialArray(cfgs);

        return c;

    }

    public static void serialArray(ArrayList<Configuration> cfgs) {
        try {
            FileOutputStream fileOtptStrm = new FileOutputStream("configs.ser");
            ObjectOutputStream objectOtptStrm = new ObjectOutputStream(fileOtptStrm);
            objectOtptStrm.writeObject(cfgs);
            objectOtptStrm.close();
            fileOtptStrm.close();
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<Configuration> deSerialArray() {
        ArrayList<Configuration> cfgs = new ArrayList<Configuration>();
        try {
            FileInputStream fileInptStrm = new FileInputStream("configs.ser");
            ObjectInputStream objectInptStrm = new ObjectInputStream(fileInptStrm);
            cfgs = (ArrayList) objectInptStrm.readObject();
            objectInptStrm.close();
            fileInptStrm.close();
        } 
        catch (IOException ex) {
            ex.printStackTrace();
            return(cfgs);
        } 
        catch (ClassNotFoundException cnf) {
            System.out.println("Class not found");
            cnf.printStackTrace();
            return(cfgs);
        }
        
        return(cfgs);
    }
    
}