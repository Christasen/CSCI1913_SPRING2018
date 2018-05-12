class PriorityQueue<Base>
{
  private class Node
  {
    private Base object;
    private int  rank;
    private Node left;
    private Node right;

    private Node(Base object, int rank)
    {
      this.object = object;
      this.rank = rank;
      left = null;
      right = null;
    }
  }

  private Node root;  //  Root node of the BST.

  public PriorityQueue()
  {

      root = new Node(null,8);

  }
  public boolean isEmpty()
  {
    if (root.right == null && root.left == null)
    {
      return true;
    }

    return false;
  }

  public Base dequeue()
  {
    if(isEmpty())
    {
        throw new IllegalStateException("Wrong input.");
    }

    else
    {
      Node above = root;
      Node below = root.left;

      while (below.left != null)
      {
        above = below;
        below = below.left;
      }

      above.left = below.right;
      return below.object;

    }


  }

  public void enqueue (Base object, int rank)
  {
    if (rank < 0)
    {
      throw new IllegalArgumentException("Wrong input.");
    }
    else
    {
      Node t = root;

      while(t != null)
      {
        if (rank <= t.rank)
        {
          if (t.left == null)
          {
            Node temp = new Node(object, rank);
            t.left = temp;
            return;  //exit the loop
          }
          else
            t = t.left;
        }

        else if (rank > t.rank)
        {
          if (t.right == null)
          {
            Node temp = new Node(object, rank);
            t.right = temp;
            return;
          }
          else
          {
            t = t.right;
          }
        }
    }

  }
}

}



//  SNOBBERY. How the aristocracy behaves in a queue. 20 points.

class Snobbery
{

//  MAIN. Queue them up.

  public static void main(String[] args)
  {
    PriorityQueue<String> queue = new PriorityQueue<String>();

    System.out.println(queue.isEmpty());  //  true        2 points

    try
    {
      System.out.println(queue.dequeue());
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("Blimey!");      //  Blimey!     2 points
    }

    queue.enqueue("Lancelot",  5);
    queue.enqueue("Fawlty",    7);
    queue.enqueue("Elizabeth", 0);
    queue.enqueue("Charles",   1);
    queue.enqueue("Turing",    7);

    try
    {
      queue.enqueue("Zeus", -100);
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No gods!");     //  No gods!    2 points
    }

    System.out.println(queue.isEmpty());  //  false       2 points

    System.out.println(queue.dequeue());  //  Elizabeth   2 points
    System.out.println(queue.dequeue());  //  Charles     2 points
    System.out.println(queue.dequeue());  //  Lancelot    2 points
    System.out.println(queue.dequeue());  //  Turing      2 points
    System.out.println(queue.dequeue());  //  Fawlty      2 points

//  It's OK if Fawlty comes out before Turing, but both must come out last.

    System.out.println(queue.isEmpty());  //  true        2 points.
  }

}

// true
// Blimey!
// No gods!
// false
// Elizabeth
// Charles
// Lancelot
// Turing
// Fawlty
// true
