public class LinkedMatrices{

  protected Node head;

  public static void main(String[] args){
    int i = 15, j = 15;
    float p = 0.20f;
    LinkedMatrices l2 = new LinkedMatrices();
    GameOfLife newGame = new GameOfLife(i, j, p);
    // int[][] newMatrix = {{0,0,0},
    //                       {1,1,1},
    //                     {0,0,0}};
    int[][] newMatrix = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                          {0,0,0,1,1,1,0,0,0,1,1,1,0,0,0},
                          {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                          {0,1,0,0,0,0,1,0,1,0,0,0,0,1,0},
                          {0,1,0,0,0,0,1,0,1,0,0,0,0,1,0},
                          {0,1,0,0,0,0,1,0,1,0,0,0,0,1,0},
                          {0,0,0,1,1,1,0,0,0,1,1,1,0,0,0},
                          {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                          {0,0,0,1,1,1,0,0,0,1,1,1,0,0,0},
                          {0,1,0,0,0,0,1,0,1,0,0,0,0,1,0},
                          {0,1,0,0,0,0,1,0,1,0,0,0,0,1,0},
                          {0,1,0,0,0,0,1,0,1,0,0,0,0,1,0},
                          {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                          {0,0,0,1,1,1,0,0,0,1,1,1,0,0,0},
                          {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};

    GameOfLife.getMatrix(newMatrix);
    for (int z = 0; z < 7; z++) {
      l2.append(newMatrix);
      newMatrix = newGame.lifeCyle(newMatrix);
      GameOfLife.getMatrix(newMatrix);
    }
    System.out.println("-----------------");

    int x = l2.findMatch(l2);

    
    System.out.println("iterator : " + x);

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
    if (currentNode == null) {
      head = newNode;
    } 
    else {
        while (currentNode.getNext() != null){
          currentNode = currentNode.getNext();
        } // end while: by end, currentNode should be last
        currentNode.setNext(newNode);
        newNode.setPrevious(currentNode);
    } // end if
  } // end append

  public int iterate(){
    Node currentNode = head;
    int count = 0;
    while (currentNode != null){
      // GameOfLife.getMatrix(currentNode.getPayload());
      // System.out.println(currentNode.getPayload());
      // System.out.println(currentNode.getPrevious());
      // System.out.println(currentNode.getNext());
      count++;
      currentNode = currentNode.getNext();
    } // end while
    return count;
  } // end iterate

  public Node GetNth(int index) { 
      Node currentNode = head; 
      Node nNode = null;
      int count = 0; /* index of Node we are 
                        currently looking at */
      while (currentNode != null) { 
          if (count == index) 
              nNode = currentNode; 
          count++; 
          currentNode = currentNode.getNext(); 
      } 

      /* if we get to this line, the caller was asking 
      for a non-existent element so we assert fail */
      assert(false);
      
      return nNode;
  }

  public Node search(Node target){
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

  public void insertAfter(Node target, int[][] value){
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

  public void delete(Node target){
    System.out.println(target);
    Node targetNode = this.search(target);
    System.out.println(targetNode);

    if (targetNode == null){
        System.out.println("target not found");
    } else {
        Node before = targetNode.getPrevious();
        Node after = targetNode.getNext();
        if (before == null){
          after.setPrevious(null);
          this.head = after;
        }
        else if (after == null ){
          before.setNext(null);
        }
        else {
          before.setNext(after);
          after.setPrevious(before);
        }
      // target node will be deleted by garbage collector (we hope)
    } // end if
  } // end delete

  public static int identical(int[][] A, int[][] B){
    int i, j;
    for (i = 0; i < GameOfLife.rows; i++) {
        for (j = 0; j < GameOfLife.columns; j++){
            if (A[i][j] != B[i][j]){
                return 0;
            }
        }
    }
    return 1; 

}

public int findMatch(LinkedMatrices lm){
    int count = 0;
    int i = lm.iterate();
    Node last = lm.GetNth(i-1);
    Node previous = last.getPrevious();
    while (previous != null ) {
      int x = identical(last.getPayload(), previous.getPayload());

      count++;

      if (x == 1) {
        return count;
      }
      previous = previous.getPrevious();
    }

    return count;
  }


}
