public class Node {
  protected int[][] payload;
  protected Node previous;
  protected Node next;

  public Node(int[][] payload, Node previous, Node next){
    this.payload = payload;
    this.previous = previous;
    this.next = next;
  } // end constructor

  // payload accessors
  public int[][] getPayload(){
    return this.payload;
  } // end getPayload

  public void setPayload(int[][] payload){
    this.payload = payload;
  } // end setPayload

  // previous accessors
  public Node getPrevious(){
    return this.previous;
  } // end getPrevious

  public void setPrevious(Node previous){
    this.previous = previous;
  } // end setPrevious

  // next accessors
  public Node getNext(){
    return this.next;
  } // end getNext

  public void setNext(Node next){
    this.next = next;
  } // end setNext

} // end class def