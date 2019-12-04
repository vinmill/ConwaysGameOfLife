import java.util.*;



public class DoubleKeyMap<Key1,Key2,Value> {
    private int key1;
    private int key2;
    private HashMap<key1,Value> indexes;

    public HashMap(int sizeRow, int sizeColumn) {
        mat = (value[][]) new Object[sizeRow][sizeColumn];
        indexes = new HashMap<>();
    }

    public void setIndex(String name, int index) {
        indexes.put(name, index);
    }

    public void set(String row, String column, value value) {
        mat[indexes.get(row)][indexes.get(column)] = value;
    }
    public value get(String row, String column) {
        return mat[indexes.get(row)][indexes.get(column)];
    }
}