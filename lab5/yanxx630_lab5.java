//lab05
class Polygon
{
  private int[] sideLengths;
 //...means it can take zero or more extra integer arguments after the fist arguments
  public Polygon(int sides, int ... lengths)
  {
    int index = 0;
    sideLengths = new int[sides];
    for (int length: lengths)
    {
      sideLengths[index] = length;
      index += 1;
    }
  }

  public int side(int number)
  {
    return sideLengths[number];
  }

  public int perimeter()
  {
    int total = 0;
    for (int index = 0; index < sideLengths.length; index += 1)
    {
      total += side(index);
    }
    return total;
  }

}

class Rectangle extends Polygon
{

  public Rectangle(int a, int b)
  {
    super(4,a,b,a,b); //use the polygon constructor
  }

  public int area()
  {
    int area1 = side(0) * side(1);
    return area1;
  }

}

class Square extends Rectangle
{


  public Square(int a) {
    super(a,a); //use the polygon constructor
  }

}


  //  SHAPES. Public tests for the classes RECTANGLE and SQUARE. Comments show
  //  what each test must print, and how many points it is worth.

  class Shapes
  {
    public static void main(String[] args)
    {
      Rectangle wreck = new Rectangle(3, 5);

      System.out.println(wreck.side(0));      //  3   1 point.
      System.out.println(wreck.side(1));      //  5   1 point.
      System.out.println(wreck.side(2));      //  3   1 point.
      System.out.println(wreck.side(3));      //  5   1 point.
      System.out.println(wreck.area());       //  15  1 point.
      System.out.println(wreck.perimeter());  //  16  1 point.

      Square nerd = new Square(7);

      System.out.println(nerd.side(0));       //  7   1 point.
      System.out.println(nerd.side(1));       //  7   1 point.
      System.out.println(nerd.side(2));       //  7   1 point.
      System.out.println(nerd.side(3));       //  7   1 point.
      System.out.println(nerd.area());        //  49  1 point.
      System.out.println(nerd.perimeter());   //  28  1 point.
    }
  }
