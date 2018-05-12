class RunnyStack<Base>
{
  private class Run
  {
    private Base object;
    private Run next;
    private int length;
    private Run(Base object, int length, Run next)
    {
      this.object = object;
      this.length = length;
      this.next = next;
    }
  }
  private Run top;
  private int r;
  private int dep;
  public RunnyStack()
  {
    top = null;
  }

  public boolean isEmpty ()
  {
    return top == null;
  }


  public int depth()
  {
    return dep;

  }
  public int runs()
  {
    return r;
  }

  public Base peek()
  {
    if(isEmpty())
    {
      throw new  IllegalStateException ("IT SHOULD NOT BE EMPTY");
    }
    else
    {
      return top.object;
    }
  }

  public void pop()
  {
    if(isEmpty())
    {
      throw new  IllegalStateException ("IT SHOULD NOT BE EMPTY");
    }
    else
    {
      if (top.length > 1)
      {
        top.length -= 1;
        dep -= 1;
      }
      else
      {
        top = top.next;
        r -= 1;
        dep -= 1;

      }
    }
  }

  public void push(Base object)
  {
    if(isEmpty())
    {
      top = new Run(object, 1, top);
      r += 1;
      dep += 1;
    }
    else
    {
      if (isEqual(object, top.object))
      {
        top.length += 1;
        dep += 1;
      }
      else
      {
        top = new Run(object, 1, top);
        r += 1;
        dep += 1;
      }

    }
  }

  private boolean isEqual(Base object1, Base object2)
  {
    if (object1 == null | object2 == null)
    {
      return object1 == object2;
    }
    else
      return object1.equals(object2);
  }

}
//
//  Tests for CSci 1913 Lab 8
//  James Moen
//  20 Mar 17
//
//  The TRY-CATCH statements catch exceptions thrown by RUNNY STACK's methods,
//  so that the program can continue to run even if a method fails. We still
//  haven't talked about TRY-CATCH'es in the lectures yet.
//
//  Most tests have comments that show what they should print, and how many
//  points they are worth, for a total of 40 points.
//
//  Camembert is a soft French cheese. It may be runny. It can be stacked.
//

class Camembert
{
  public static void main(String [] args)
  {
    RunnyStack<String> s = new RunnyStack<String>();

    System.out.println(s.isEmpty());         //  true       1 point
    System.out.println(s.depth());           //  0          1 point
    System.out.println(s.runs());            //  0          1 point

    try
    {
      s.pop();
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No pop");          //  No pop     1 point
    }

    try
    {
      System.out.println(s.peek());
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No peek");         //  No peek    1 point
    }

    s.push("A");
    System.out.println(s.peek());            //  A          1 point
    System.out.println(s.depth());           //  1          1 point
    System.out.println(s.runs());            //  1          1 point

    System.out.println(s.isEmpty());         //  false      1 point

    s.push("B");
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  2          1 point
    System.out.println(s.runs());            //  2          1 point

    s.push("B");
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  3          1 point
    System.out.println(s.runs());            //  2          1 point

    s.push("B");
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  4          1 point
    System.out.println(s.runs());            //  2          1 point

    s.push("C");
    System.out.println(s.peek());            //  C          1 point
    System.out.println(s.depth());           //  5          1 point
    System.out.println(s.runs());            //  3          1 point

    s.push("C");
    System.out.println(s.peek());            //  C          1 point
    System.out.println(s.depth());           //  6          1 point
    System.out.println(s.runs());            //  3          1 point

    s.pop();
    System.out.println(s.peek());            //  C          1 point
    System.out.println(s.depth());           //  5          1 point
    System.out.println(s.runs());            //  3          1 point

    s.pop();
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  4          1 point
    System.out.println(s.runs());            //  2          1 point

    s.pop();
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  3          1 point
    System.out.println(s.runs());            //  2          1 point

    s.pop();
    s.pop();
    System.out.println(s.peek());            //  A          1 point
    System.out.println(s.depth());           //  1          1 point
    System.out.println(s.runs());            //  1          1 point

    s.pop();
    System.out.println(s.isEmpty());         //  true       1 point
    System.out.println(s.depth());           //  0          1 point
    System.out.println(s.runs());            //  0          1 point

    try
    {
      System.out.println(s.peek());
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No peek");         //  No peek    1 point
    }
  }
}


// output
// true
// 0
// 0
// No pop
// No peek
// A
// 1
// 1
// false
// B
// 2
// 2
// B
// 3
// 2
// B
// 4
// 2
// C
// 5
// 3
// C
// 6
// 3
// C
// 5
// 3
// B
// 4
// 2
// B
// 3
// 2
// A
// 1
// 1
// true
// 0
// 0
// No peek
