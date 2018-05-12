class AssociationList <Key, Value>
{
  //private class nodes;
  private class Node
  {
    private Key key;
    private Value value;
    private Node next;

    private Node(Key key, Value value, Node n)
    {
      this.key = key;
      this.value = value;
      next = n;
    }

  }
  private Node head;
//constructor
  public AssociationList()
  {
    head = new Node(null, null, null);

  }

  // test if it is equal
  private boolean isEqual(Key leftKey, Key rightKey)
  {
    if (leftKey == null||rightKey == null)
    {
      return leftKey == rightKey; //memory location
    }
    return leftKey.equals(rightKey); //check the value itself
  }

//Search method
  public Value get(Key key)
  {
    Node Temp = head.next;
    while (Temp != null)
    {
      if (isEqual(Temp.key, key))
      {
        return Temp.value;
      }
      else
      {
        Temp = Temp.next;
      }
    }

    throw new  IllegalArgumentException ("The key doesn't exist");
  }



// test keys
  public boolean isIn(Key key)
  {
    Node Temp = head.next;
    while (Temp != null)
    {
      if (isEqual(Temp.key, key))
      {
        return true;
      }
      else
      {
        Temp = Temp.next;
      }
    }
    return false;
}
//put method
  public void put(Key key, Value value)
  {
    Node t1 = head.next;
    while (t1 != null)
    {
      if (isEqual(t1.key, key))
      {
        t1.value = value;
        return;
      }
      else
      {
        t1 = t1.next;
      }
    }
    head.next = new Node (key, value, head.next);
  }
// delete method
  public void delete(Key key)
  {
    Node t1 = head;
    Node t2 = head.next;//When this is equal to key, set t1.next = t2.next
    while (t1.next != null)
    {
      if (isEqual(t2.key, key))
      {
        t1.next = t2.next;
        return;
      }
      else
      {
        t1 = t2;
        t2 = t2.next;
      }
    }
  }
}

//
//  Tests for CSci 1913 Lab 10
//  James Moen
//  14 Nov 17
//
//  The TRY-CATCH statements catch exceptions thrown by ASSOCIATION LIST's
//  methods, so that the program can continue to run even if a method fails.
//  We still haven't talked about TRY-CATCH'es in lecture yet.
//
//  Each test has a comment that shows what it should print and how many points
//  it is worth, for a total of 40 points.

//  HOGWARTS. The Hogwarts dating service again.

class Hogwarts
{

//  MAIN. Make an instance of ASSOCIATION LIST and test it.

  public static void main(String[] args)
  {
    AssociationList<String,String> list = new AssociationList<String,String>();

    System.out.println(list.isIn(null));         //  false         2 points.

    try
    {
      System.out.println(list.get(null));
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No null");             //  No null       2 points.
    }

    list.put(null,        "Wormtail");
    list.put("Ron",       "Lavender");
    list.put("Voldemort", null);
    list.put("Dean",      "Ginny");

    System.out.println(list.isIn("Dean"));       //  true          2 points.
    System.out.println(list.isIn("Ginny"));      //  false         2 points.
    System.out.println(list.isIn("Ron"));        //  true          2 points.
    System.out.println(list.isIn("Voldemort"));  //  true          2 points.
    System.out.println(list.isIn(null));         //  true          2 points.
    System.out.println(list.isIn("Joanne"));     //  false         2 points.

    System.out.println(list.get("Ron"));         //  Lavender      2 points.
    System.out.println(list.get("Dean"));        //  Ginny         2 points.
    System.out.println(list.get("Voldemort"));   //  null          2 points.
    System.out.println(list.get(null));          //  Wormtail      2 points.

    try
    {
      System.out.println(list.get("Joanne"));
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No Joanne");           //  No Joanne     2 points.
    }

    list.delete(null);

    System.out.println(list.isIn(null));         //  false         2 points.

    list.put(null,    null);
    list.put("Harry", "Ginny");
    list.put("Ron",   "Hermione");

    System.out.println(list.isIn(null));         //  true          2 points.
    System.out.println(list.get(null));          //  null          2 points.
    System.out.println(list.get("Harry"));       //  Ginny         2 points.
    System.out.println(list.get("Dean"));        //  Ginny         2 points.
    System.out.println(list.get("Ron"));         //  Hermione      2 points.

    list.delete("Dean");

    try
    {
      System.out.println(list.get("Dean"));
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No Dean");             //  No Dean       2 points.
    }
  }
}
// output
// false
// No null
// true
// false
// true
// true
// true
// false
// Lavender
// Ginny
// null
// Wormtail
// No Joanne
// false
// true
// null
// Ginny
// Ginny
// Hermione
// No Dean
