

import java.util.*;

// Class for the ranks of cards including their values
// In certaun games for example Ace will have a higher rank than King
public class Rank implements Comparable
{

    protected String _rank_;
    protected boolean aceHigh = false;

    // Define methods for all ranks
    public final static Rank ACE = new Rank("A");
    public final static Rank TWO = new Rank("2");
    public final static Rank THREE = new Rank("3");
    public final static Rank FOUR = new Rank("4");
    public final static Rank FIVE = new Rank("5");
    public final static Rank SIX = new Rank("6");
    public final static Rank SEVEN = new Rank("7");
    public final static Rank EIGHT = new Rank( "8");
    public final static Rank NINE = new Rank("9");
    public final static Rank TEN = new Rank("10");
    public final static Rank JACK = new Rank("J");
    public final static Rank QUEEN = new Rank("Q");
    public final static Rank KING = new Rank("K");



   // List used for iteration in creation of a deck
   public final static List rank_list = Arrays.asList(new Rank[]
            {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING});


   // List used if KING is considered high for a game, used by the CompareTo() method
   public final static List king_high_list = Arrays.asList(new Rank[]
   			{ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING});

   // List used if ACE is considered high for a game, used by the CompareTo() method
   public final static List ace_high_list = Arrays.asList(new Rank[]
   			{TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE});


	//CompareTo must take an 'Object' as an argument
	//Thus a 'cast' is used on the object to type rank, instead of using the getRank() method
 	public int compareTo(Object otherRankObject)
 	{
		//Get Rank of the object to be compared
    	Rank otherRank = (Rank) otherRankObject;

		//If the aceHigh variable is true, then use ACE_HIGH List
    	if (aceHigh == true)
    	{
			//indexOf() returns first position of Rank in the list
			//Thus position1 - position2 = difference
        	return ace_high_list.indexOf(this) - ace_high_list.indexOf(otherRank);
		}

		//If the aceHigh variable is false, then use KING_HIGH List
    	else{
        	return king_high_list.indexOf(this) - king_high_list.indexOf(otherRank);
   		}
	}





    public Rank(String rank)
    {
        _rank_ = rank;
    }

    public String getRankValue()
    {
        return _rank_;
    }

}