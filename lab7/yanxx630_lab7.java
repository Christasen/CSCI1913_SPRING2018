class Map <Key, Value>
{
  private Key[] keys;
  private Value[] values; //define before use
  private int count = 0;
//constructor
  public Map(int length)
  {
    if (length < 0)
    {
      throw new  IllegalArgumentException ("length should be positive");
    }
    else
    {
      keys = (Key[]) new Object [length]; ///note!
      values = (Value[]) new Object [length]; //note!
    }
  }
//Search method
  public Value get(Key key)
  {
    for (int index = 0; index < keys.length; index += 1)
    {
      if (key == keys[index]) {

        return values[index];
      }
    }

    throw new  IllegalArgumentException ("The key doesn't exist");
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


// test keys
  public boolean isIn(Key key)
  {
    for (int index = 0; index < keys.length; index += 1)
    {
      if (key == keys[index])
      {
        return true;
      }

    }
    return false;
  }
//put method
public void put(Key key, Value value)

{
  boolean a = isIn(key);
  if (a)
  {
    int b = where(key);
    values[b] = value;
  }
  else
  {

    if (count >= keys.length)
    {
      throw new  IllegalStateException ("The dic is full");

    }

    else
    {
      keys[count] = key;
      values[count] = value;
      count = count + 1;
      }

  }
}


//int where

  private int where(Key key)
  {
    for (int index = 0; index < keys.length; index += 1)
    {
      if (key == keys[index])
      {
        return index;
      }

    }
    return -1;

  }

}




//test


//
//  Tests for CSci 1913 Lab 7
//  James Moen
//  07 Mar 17
//
//  The TRY-CATCH statements catch exceptions thrown by MAP's methods, so that
//  the program can continue to run even if a method fails. We haven't talked
//  about TRY-CATCH'es in lecture yet.
//
//  Each test has a comment that shows what it should print, and how many
//  points it is worth, for a total of 40 points.

//  HOGWARTS. The Hogwarts dating service.


class Hogwarts
{

//  MAIN. Make an instance of MAP and test it.

  public static void main(String [] args)
  {
    Map<String, String> map;

    try
    {
      map = new Map<String, String>(-5);
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No negatives");       //  No negatives  2 points.
    }

    map = new Map<String, String>(5);

    map.put("Harry",     "Ginny");
    map.put("Ron",       "Lavender");
    map.put("Voldemort", null);
    map.put(null,        "Wormtail");

    System.out.println(map.isIn("Harry"));      //  true          2 points.
    System.out.println(map.isIn("Ginny"));      //  false         2 points.
    System.out.println(map.isIn("Ron"));        //  true          2 points.
    System.out.println(map.isIn("Voldemort"));  //  true          2 points.
    System.out.println(map.isIn(null));         //  true          2 points.
    System.out.println(map.isIn("Joanne"));     //  false         2 points.

    System.out.println(map.get("Harry"));       //  Ginny         2 points.
    System.out.println(map.get("Ron"));         //  Lavender      2 points.
    System.out.println(map.get("Voldemort"));   //  null          2 points.
    System.out.println(map.get(null));          //  Wormtail      2 points.

    try
    {
      System.out.println(map.get("Joanne"));
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No Joanne");          //  No Joanne     2 points.
    }

    map.put("Ron",   "Hermione");
    map.put("Albus", "Gellert");
    map.put(null,    null);

    System.out.println(map.isIn(null));         //  true          2 points.
    System.out.println(map.isIn("Albus"));      //  true          2 points.

    System.out.println(map.get("Albus"));       //  Gellert       2 points.
    System.out.println(map.get("Harry"));       //  Ginny         2 points.
    System.out.println(map.get("Ron"));         //  Hermione      2 points.
    System.out.println(map.get("Voldemort"));   //  null          2 points.
    System.out.println(map.get(null));          //  null          2 points.

    try
    {
      map.put("Draco", "Pansy");
      map.put("x", "y");

    }
    catch (IllegalStateException minnesota)
    {
      System.out.println("No Draco");           //  No Draco      2 points.
    }
  }
}

// //output
// No negatives
// true
// false
// true
// true
// true
// false
// Ginny
// Lavender
// null
// Wormtail
// No Joanne
// true
// true
// Gellert
// Ginny
// Hermione
// null
// null
// No Draco
