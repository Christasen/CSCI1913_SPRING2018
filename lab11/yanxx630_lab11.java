class Deque <Base>
{
  //private class nodes;
  private class Node
  {
    private Base object;
    private Node right;
    private Node left;

    private Node(Base object, Node left, Node right)
    {
      this.object = object;
      this.right = right;
      this.left = left;
    }
  }

  private Node head;
  //constructor
  public Deque()
  {
    head = new Node(null, null, null);
    head.left = head;
    head.right = head;
  }

  public void enqueueFront (Base object)
  {
    Node t1 = new Node(object, head, head.right);
    head.right.left = t1;
    head.right = t1;


  }

  public void enqueueRear (Base object)
  {
    Node t1 = new Node(object, head.left, head);
    head.left.right = t1;
    head.left = t1;

  }

  public boolean isEmpty()
  {
    if (head.right == head && head.left == head)
    {
      return true;
    }

    return false;

  }

  public Base dequeueFront()
  {
    if(isEmpty())
    {
    throw new  IllegalStateException ("The queue is empty");

    }
    else
    {
      Node t1 = head.right;
      Base b1 = t1.object;
      head.right.right.left = head;
      head.right = head.right.right;

      return b1;
    }

  }

  public Base dequeueRear()
  {
    if(isEmpty())
    {
    throw new  IllegalStateException ("The queue is empty");

    }
    else
    {
      Node t1 = head.left;
      Base b1 = t1.object;
      head.left.left.right = head;
      head.left = head.left.left;

      return b1;
    }

  }


}



//  OBSERVATION DEQUE. Test the class DEQUE. 40 points total.

class ObservationDeque
{

//  MAIN. Test the DEQUE on various example arguments.

  public static void main(String [] args)
  {
    Deque<String> deque = new Deque<String>();

    System.out.println(deque.isEmpty());       // true                2 points.

    try
    {
      System.out.println(deque.dequeueFront());
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No dequeueFront.");  //  No dequeueFront.   2 points.
    }

    try
    {
      System.out.println(deque.dequeueRear());
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No dequeueRear.");   //  No dequeueRear.    2 points.
    }

//  Enqueueing to the rear and dequeueing from the rear makes the DEQUE act
//  like a stack.

    deque.enqueueRear("A");
    deque.enqueueRear("B");
    deque.enqueueRear("C");

    System.out.println(deque.isEmpty());       //  false              2 points.

    System.out.println(deque.dequeueRear());   //  C                  2 points.
    System.out.println(deque.dequeueRear());   //  B                  2 points.
    System.out.println(deque.dequeueRear());   //  A                  2 points.

    System.out.println(deque.isEmpty());       //  true               2 points.

//  Enqueueing to the rear and dequeueing from the front makes the DEQUE act
//  like a queue.

    deque.enqueueRear("A");
    deque.enqueueRear("B");
    deque.enqueueRear("C");

    System.out.println(deque.dequeueFront());  //  A                  2 points.
    System.out.println(deque.dequeueFront());  //  B                  2 points.
    System.out.println(deque.dequeueFront());  //  C                  2 points.

    System.out.println(deque.isEmpty());       //  true               2 points.

//  Enqueueing to the front and dequeueing from the front makes the DEQUE act
//  like a stack.

    deque.enqueueFront("A");
    deque.enqueueFront("B");
    deque.enqueueFront("C");

    System.out.println(deque.dequeueFront());  //  C                  2 points.
    System.out.println(deque.dequeueFront());  //  B                  2 points.
    System.out.println(deque.dequeueFront());  //  A                  2 points.

    System.out.println(deque.isEmpty());       //  true               2 points.

//  Enqueueing to the front and dequeueing from the rear makes the DEQUE act
//  like a queue.

    deque.enqueueFront("A");
    deque.enqueueFront("B");
    deque.enqueueFront("C");

    System.out.println(deque.dequeueRear());   //  A                  2 points.
    System.out.println(deque.dequeueRear());   //  B                  2 points.
    System.out.println(deque.dequeueRear());   //  C                  2 points.

    System.out.println(deque.isEmpty());       //  true               2 points.
  }
}


// true
// No dequeueFront.
// No dequeueRear.
// false
// C
// B
// A
// true
// A
// B
// C
// true
// C
// B
// A
// true
// A
// B
// C
// true
