/** LinkedList2.java
    doubly-linked list
    uses node2
*/

public class LinkedMatrices{

  protected Node head;

  public static void main(String[] args){
    LinkedMatrices l2 = new LinkedMatrices();
    GameOfLife newGame = new GameOfLife();
    int[][] newMatrix = GameOfLife.initializeMatrix(GameOfLife.p);
    l2.append(newMatrix);
    newMatrix = newGame.lifeCyle(newMatrix, GameOfLife.rows, GameOfLife.columns);
    l2.append(newMatrix);
    newMatrix = newGame.lifeCyle(newMatrix, GameOfLife.rows, GameOfLife.columns);
    l2.append(newMatrix);

    l2.iterate();
    // System.out.println();

    // Node result = l2.search(mat);
    // System.out.println(result.getPayload());
    // System.out.println();
    
    // l2.insertAfter(newMatrix, mat);
    // System.out.println();
    // l2.iterate();  
    
    // System.out.println();
    // l2.delete(mat);
    // l2.iterate();

  } // end main

  public LinkedMatrices(){
    head = null;
  } // end constructor

  public void append(int[][] newValue){
    //adds new value to end of list
    Node newNode = new Node(newValue, null, null);

    //move to end of list
    Node currentNode = head;
    // if we have an empty list, the new element is the head
    if (currentNode == null){
      head = newNode;
    } else {
      while (currentNode.getNext() != null){
        currentNode = currentNode.getNext();
      } // end while: by end, currentNode should be last
      currentNode.setNext(newNode);
      newNode.setPrevious(currentNode);
    } // end if
  } // end append

  public void iterate(){
    Node currentNode = head;
    while (currentNode != null){
      GameOfLife.getMatrix(currentNode.getPayload());
      currentNode = currentNode.getNext();
    } // end while
  } // end iterate

  public Node search(int[][] target){
    Node currentNode = head;
    Node result = null;

    while (currentNode != null){
      if (currentNode.getPayload().equals(target)){
        result = currentNode;
      } // end if
      currentNode = currentNode.getNext();
    } // end while
    return result;
  } // end search

  public void insertAfter(int[][] target, int[][] value){
    Node before = this.search(target);
    if (before == null){
      System.out.println("target not found");
    } else {
      Node after = before.getNext();
      Node newNode = new Node(value, before, after);
      before.setNext(newNode);
      after.setPrevious(newNode);
    } // end if
  } // end insertAfter

  public void delete(int[][] target){
    Node targetNode = this.search(target);
    if (targetNode == null){
      System.out.println("target not found");
    } else {
      Node before = targetNode.getPrevious();
      Node after = targetNode.getNext();
      before.setNext(after);
      after.setPrevious(before);
      // target node will be deleted by garbage collector (we hope)
    } // end if
  } // end delete
}