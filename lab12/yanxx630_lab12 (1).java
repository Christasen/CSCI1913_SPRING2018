class FamilyTree
{
  private class Node
  {
    private Node mother;
    private Node father;
    private String name;

    private Node(String name1, Node father1, Node mother1)
    {
      mother = mother1;
      father = father1;
      name = name1;
    }
  }
  private Node root;


  public FamilyTree(String ego)
	{
		root = new Node(ego, null, null);
	}

  private Node find(String name, Node root)
  {
      Node find1 = null;

      if(root.name.equals(name))
      {
        return root;
      }

      if(root.father != null)
      {
        find1 = find(name, root.father);
        if (find1 != null)
        {
            return find1;
        }

      }
      if(root.mother != null)
      {
        find1 = find(name, root.mother);
        if (find1 != null)
        {
            return find1;
        }

      }


      return null;

  }
	private Node find(String name)
	{
		return find(name, root);
	}

  private boolean isDescendant(Node root, Node ancestor)
  {
    if (root == null || ancestor == null)
    {
      return false;
    }
    Node newone = find(ancestor.name, root);

    return (newone != null);

  }

  public boolean isDescendant(String ego, String ancestor)
  {
    Node t1 = find(ego);
    Node t2 = find(ancestor);
    return isDescendant(t1, t2);
  }



	public void addParents(String ego, String father, String mother)
	{
		Node t1 = find(ego);
		if (t1 == null)
		{
			throw new IllegalArgumentException("It does not exist!");
		}
    else
    {
      t1.mother = new Node(mother, null, null);
  		t1.father = new Node(father, null, null);
    }

	}


}



//  POTTERY. Driver class.

class Pottery
{

//  MAIN. For testing. Each comment shows a point value (there's a total of 40
//  points) and what it should print.

  public static void main(String [] args)
  {
    FamilyTree family = new FamilyTree("Al");

    family.addParents("Al",    "Harry",  "Ginny");
    family.addParents("Harry", "James",  "Lily" );
    family.addParents("Ginny", "Arthur", "Molly");

    try
    {
      family.addParents("Joanne", "Peter", "Anne");
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No Joanne.");  //  2 No Joanne.
    }

    System.out.println(family.isDescendant("Joanne", "Joanne"));  //  2 false

    System.out.println(family.isDescendant("Al", "Al"));          //  2 true
    System.out.println(family.isDescendant("Al", "Harry"));       //  2 true
    System.out.println(family.isDescendant("Al", "Ginny"));       //  2 true
    System.out.println(family.isDescendant("Al", "James"));       //  2 true
    System.out.println(family.isDescendant("Al", "Lily"));        //  2 true
    System.out.println(family.isDescendant("Al", "Arthur"));      //  2 true
    System.out.println(family.isDescendant("Al", "Molly"));       //  2 true
    System.out.println(family.isDescendant("Al", "Joanne"));      //  2 false

    System.out.println(family.isDescendant("Harry", "Harry"));    //  2 true
    System.out.println(family.isDescendant("Harry", "Al"));       //  2 false
    System.out.println(family.isDescendant("Harry", "James"));    //  2 true
    System.out.println(family.isDescendant("Harry", "Lily"));     //  2 true
    System.out.println(family.isDescendant("Harry", "Ginny"));    //  2 false
    System.out.println(family.isDescendant("Harry", "Arthur"));   //  2 false
    System.out.println(family.isDescendant("Harry", "Molly"));    //  2 false
    System.out.println(family.isDescendant("Harry", "Joanne"));   //  2 false

    System.out.println(family.isDescendant("Ginny", "Arthur"));   //  2 true
    System.out.println(family.isDescendant("Arthur", "Ginny"));   //  2 false
  }
}


//
// No Joanne.
// false
// true
// true
// true
// true
// true
// true
// true
// false
// true
// false
// true
// true
// false
// false
// false
// false
// true
// false
