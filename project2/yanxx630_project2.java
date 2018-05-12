import java.util.Random;

//  CARD. A playing card. It's immutable.

final class Card //final means I can not change things of this class
{

//  RANK NAME. Printable names of card ranks. We don't use index 0.

  private static final String[] rankName =
  {
    "",        //   0
    "ace",     //   1
    "two",     //   2
    "three",   //   3
    "four",    //   4
    "five",    //   5
    "six",     //   6
    "seven",   //   7
    "eight",   //   8
    "nine",    //   9
    "ten",     //  10
    "jack",    //  11
    "queen",   //  12
    "king"     //  13
  };

  private int rank;  //  Card rank, between 1 and 13.

//  CARD. Constructor. Make a new CARD with a given RANK.

  public Card(int rank)
  {
    if (1 <= rank && rank <= 13)
    {
      this.rank = rank;
    }
    else
    {
      throw new IllegalArgumentException("Illegal rank.");
    }
  }

//  GET RANK. Return the RANK of this CARD.

  public int getRank()
  {
    return rank;
  }

//  TO STRING. Return a STRING that describes this CARD, for printing only.

  public String toString()
  {
    return rankName[rank];
  }

}

//class Deck
class Deck
{
  private Card[] cardArray= new Card[52];
  private int count = 0;

  public Deck()
  {
  for(int i =0; i < 4; i++)
   {
    for (int j=1; j <= 13; j++)
    {
      cardArray[count] = new Card(j);
      count ++;
    }
   }
  }

  public void shuffle()
  {
    Random r = new Random();
    for (int i = count -1; i >= 1; i --)
    {

      int j = Math.abs(r.nextInt()) % i+1; //note here
      Card temp = cardArray[i];
      cardArray[i] = cardArray[j];
      cardArray[j] = temp;
    }

  }

  public Card deal()
  {
    if (count >0)
    {
    Card temp = cardArray[count-1];
    count --;
    return temp;
    }
    else
    {
      throw new IllegalStateException("this is no good");
    }
  }

}

class Pile
{
  private class Layer
  {
    private Card card;
    private Layer next;
    private Layer(Card card, Layer next)
    {
      this.card = card;
      this.next = next;
    }
  }
  private Layer top;

  public Pile()
  {
    top = null;
  }

  public boolean isEmpty()
  {
    return top == null;
  }

  public void add(Card card)
  {
    top = new Layer(card, top);
  }

  public Card turn()
  {
    if(isEmpty())
    {
      throw new IllegalStateException("the layer is empty");
    }
    else
    {
      Layer temp = top;
      top = top.next;
      return temp.card;

    }
  }

}
class Tableau
{
    private Pile[] PileArray= new Pile[14];
    private int cnt = 1;
    public Tableau()
    {
      for (int i = 1; i < 14; i++)
      {
        PileArray[cnt] = new Pile();
        Deck deck = new Deck();
        deck.shuffle();
        for (int j = 1; j <= 4; j++)
        {
          Card temp = deck.deal();
          PileArray[cnt].add(temp);
        }
        cnt ++;
      }
    }
    public boolean hasWon()
    {
      for(int i = 1; i<14; i++)
      {
        if(PileArray[i].isEmpty())
         return false;
      }
      return true;
    }

    public void play()
    {
      int p = 1;
      while (!PileArray[p].isEmpty())
      {
        Card temp = PileArray[p].turn();
        p = temp.getRank();
        String pr = "Got " + temp.toString() + " from pile " + p;
        System.out.println(pr);

      }
      if(hasWon() == false)
      {
        System.out.println("Pile" + p +" is empty, you lose!");
      }
      else
      {
        System.out.println("You won!");
      }
    }
}

class Perditio
{
  public static void main(String[] args)
 {
   Tableau t = new Tableau();
   t.play();
 }

}
