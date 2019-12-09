import java.util.*;
import java.io.*;

public class Configuration implements Serializable {
    public static int index = 0;
    private int cfgIndex;
    private int rows;
    private int columns;
    private int[][] initArray;
    private int generations;
    private int maxPeriod;

    public Configuration(){

    }

    public Configuration(int r, int c, int[][] arr, int gens, int maxP) {
        setCfgIndex();
        setRows(r);
        setColumns(c);
        setInitArray(arr);
        setGenerations(gens);
        setMaxPeriod(maxP);

    }
    /**
     * @param cfgIndex the cfgIndex to set
     */
    public void setCfgIndex() {
        ArrayList<Configuration> m = Main.deSerialArray();
        int index = m.size();
        this.cfgIndex = index;
        
    }

    /**
     * @return the cfgIndex
     */
    public int getCfgIndex() {
        return cfgIndex;
    }


    /**
     * @return the columns
     */
    public int getColumns() {
        return columns;
    }
    
    /**
     * @param columns the columns to set
     */
    public void setColumns(int columns) {
        this.columns = columns;
    }
    /**
     * @return the rows
     */
    public int getRows() {
        return rows;
    }
    /**
     * @param rows the rows to set
     */
    public void setRows(int rows) {
        this.rows = rows;
    }
    /**
     * @param initArray the initArray to set
     */
    public void setInitArray(int[][] initArray) {
        this.initArray = initArray;
    }
    /**
     * @return the initArray
     */
    public int[][] getInitArray() {
        return initArray;
    }
    /**
     * @return the generations
     */
    public int getGenerations() {
        return generations;
    }
    /**
     * @param generations the generations to set
     */
    public void setGenerations(int generations) {
        this.generations = generations;
    }
    /**
     * @return the maxPeriod
     */
    public int getMaxPeriod() {
        return maxPeriod;
    }
    /**
     * @param maxPeriod the maxPeriod to set
     */
    public void setMaxPeriod(int maxPeriod) {
        this.maxPeriod = maxPeriod;
    }


}