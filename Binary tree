//
//  To run this, type the following to a Unix-like shell.
//
//    javac Traversals.java
//    java Traversals
//

import java.util.Vector;

//  QUEUE. Kludge up a queue using Java's VECTOR class.

class Queue<Base>
{
  private Vector<Base> vector;

//  Constructor. Make an empty QUEUE.

  public Queue()
  {
    vector = new Vector<Base>();
  }

//  DEQUEUE. Remove a BASE from the front of the QUEUE.

  public Base dequeue()
  {
    if (isEmpty())
    {
      throw new IllegalStateException("MTQ");
    }
    else
    {
      Base temp = vector.firstElement();
      vector.removeElementAt(0);
      return temp;
    }
  }

//  ENQUEUE. Add a BASE to the rear of the QUEUE.

  public void enqueue(Base base)
  {
    vector.addElement(base);
  }

//  IS EMPTY. Test if the QUEUE is empty.

  public boolean isEmpty()
  {
    return vector.isEmpty();
  }
}

//  TRAVERSALS. Demonstrate binary tree traversals. We made everyting STATIC so
//  we need not make an instance of this class.

class Traversals
{

//  NODE. A node in a binary tree.

  private static class Node
  {
    private String name;   //  Data at the root of a subtree.
    private Node   left;   //  The root's left child, or NULL.
    private Node   right;  //  The root's right child, or NULL.

//  Constructor. Make a NODE with specified slots.

    private Node(String name, Node left, Node right)
    {
      this.name  = name;
      this.left  = left;
      this.right = right;
    }
  }

//  BREADTH FIRST. Perform a breadth-first traversal of the binary tree ROOT.

  private static void breadthFirst(Node root)
  {
    Queue<Node> queue = new Queue<Node>();
    queue.enqueue(root);
    while (! queue.isEmpty())
    {
      Node subtree = queue.dequeue();
      if (subtree != null)
      {
        visit(subtree);
        queue.enqueue(subtree.left);
        queue.enqueue(subtree.right);
      }
    }
  }

//  INORDER. Perform an inorder traversal of the binary tree SUBTREE.

  private static void inorder(Node subtree)
  {
    if (subtree != null)
    {
      inorder(subtree.left);
      visit(subtree);
      inorder(subtree.right);
    }
  }

//  POSTORDER. Perform a postorder traversal of the binary tree SUBTREE.

  private static void postorder(Node subtree)
  {
    if (subtree != null)
    {
      postorder(subtree.left);
      postorder(subtree.right);
      visit(subtree);
    }
  }

//  PREORDER. Perform a preorder traversal of the binary tree SUBTREE.

  private static void preorder(Node subtree)
  {
    if (subtree != null)
    {
      visit(subtree);
      preorder(subtree.left);
      preorder(subtree.right);
    }
  }

//  VISIT. Visit the root of a SUBTREE.

  private static void visit(Node subtree)
  {
    System.out.print(subtree.name);
    System.out.print(' ');
  }

//  MAIN. Do it.

  public static void main(String[] args)
  {
    Node tree =
     new Node("A",
      new Node("B",
       new Node("D", null, null),
       new Node("E", null, null)),
      new Node("C",
       new Node("F", null, null),
       new Node("G", null, null)));

//  This is TREE.
//
//         A
//       /   \
//      B     C
//     / \   / \
//    D   E F   G
//
//  And here are its traversals. The comments show what will be printed.

    breadthFirst(tree); System.out.println();  //  A B C D E F G 
    inorder(tree);      System.out.println();  //  D B E A F C G 
    postorder(tree);    System.out.println();  //  D E B F G C A 
    preorder(tree);     System.out.println();  //  A B D E C F G 
  }
}
