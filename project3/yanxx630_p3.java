class HBST<Key, Value>
{

  private class ValueNode
  {
    private Value value;
    private ValueNode next;
    private Key key;

    public ValueNode(Key key, Value value)
    {
      this.value = value;
      this.key = key;
      next = null;

    }
  }
  private class TreeNode
  {
    private int key;
    private ValueNode value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int key, ValueNode value)
    {
      this.key = key;
      this.value = value;
      left = null;
      right = null;
    }
  }


  private TreeNode root;  //  Root node of the HBST.

  public HBST()
  {
    root = new TreeNode (-1, null);
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

  public Value get(Key key)
{
    int hashkey = hash(key);

    TreeNode temp = root;

      while(true)
      {

        if (hashkey < temp.key)
        {
          temp = temp.left;
        }

        else if (hashkey > temp.key )
        {
          temp = temp.right;
        }

        else
        {
          ValueNode temp1 = temp.value;

          while(temp1 != null)
          {

            if (isEqual(key, temp1.key))
            {
              return temp1.value;
            }

            else
            {
              temp1 = temp1.next;
             }

          }

          throw new IllegalArgumentException("Wrong input.");

        }
      }


}

//
// public Value get(Key key)
// {
//   TreeNode subtree = root;
//   int hashkey = hash(key);
//   while (subtree != null)
//   {
//
//     if (subtree.key > hashkey)
//     {
//       subtree = subtree.left;
//     }
//     else if (subtree.key < hashkey)
//     {
//       subtree = subtree.right;
//     }
//     else
//     {
//       ValueNode temp1 = subtree.value;
//
//      while(temp1.next != null)
//      {
//
//        if (isEqual(key, temp1.key))
//        {
//          return temp1.value;
//        }
//
//        else
//        {
//          temp1 = temp1.next;
//         }
//
//       }
//     }
//   }
//   throw new IllegalArgumentException("No such key.");
//
// }

  private int hash(Key key)
  {
    if (key == null)
      return 0;
    else {
      int num = key.hashCode();//hash part
      num = Math.abs(num);
      return num;
    }
  }



  public int height()
  {
      return heighting(root.right);
  }

  private int heighting(TreeNode root)
  {
    if (root == null)
    {
      return 0;
    }
    else
    {
      int left  = heighting(root.left);
      int right = heighting(root.right);
      if (left > right)
      {
        return left + 1;
      }
      else
      {
        return right + 1;
      }
    }
  }

  public void put(Key key, Value value)
  {

    // if (root == null)
    // {
    //   int num = hash(key);
    //   root = new TreeNode(num, value);
    // }
    //
    // else
    // {
      TreeNode subtree = root;
      int hashkey = hash(key);
      while (true)
      {
        if (subtree.key > hashkey)
        {
          if (subtree.left == null)
          {
            ValueNode v1 = new ValueNode(key, value);
            subtree.left = new TreeNode(hashkey, v1);
            return;
          }
          else
          {
            subtree = subtree.left;
          }
        }
        else if (subtree.key < hashkey)
        {
          if (subtree.right == null)
          {
            ValueNode v1 = new ValueNode(key, value);
            subtree.right = new TreeNode(hashkey, v1);
            return;
          }
          else
          {
            subtree = subtree.right;
          }
        }
        else
        {
          ValueNode temp1 = subtree.value;
          while (temp1 != null)
          {
          if (isEqual(key, temp1.key))
            {
              temp1.value = value;
            }
            else
            {
              temp1 = temp1.next;
            }

          }
          ValueNode temp2 = subtree.value;
        subtree.value = new ValueNode(key, value);
        subtree.value.next = temp2;
      }


}

}
}



class HBSTifier
{
  private final static String[] keys =
   { "abstract",     "assert",       "boolean",     "break",
     "byte",         "case",         "catch",       "char",
     "class",        "const",        "continue",    "default",
     "do",           "double",       "else",        "extends",
     "false",        "final",        "finally",     "float",
     "for",          "goto",         "if",          "implements",
     "import",       "instanceof",   "int",         "interface",
     "long",         "native",       "new",         "null",
     "package",      "private",      "protected",   "public",
     "return",       "short",        "static",      "super",
     "switch",       "synchronized", "this",        "throw",
     "throws",       "transient",    "true",        "try",
     "var",          "void",         "volatile",    "while" };

  public static void main(String [] args)
  {
    HBST<String, Integer> hbst = new HBST<String, Integer>();

    for (int index = 0; index < keys.length; index += 1)
    {
      hbst.put(keys[index], index);
    }

    System.out.println(hbst.height());

    for (int index = 0; index < keys.length; index += 1)
    {
      System.out.format("%02d %s", hbst.get(keys[index]), keys[index]);
      System.out.println();
    }
  }
}
