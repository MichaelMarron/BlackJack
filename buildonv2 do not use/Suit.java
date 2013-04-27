
import java.util.*;

//Class that defines the types of suit a card can be
public class Suit
{

public String _suit__;

// Types of Suit in a Standard Deck of cards
public static Suit CLUB = new Suit("Clubs");
public static Suit DIAMOND = new Suit("Diamonds");
public static Suit HEART = new Suit("Hearts");
public static Suit SPADE = new Suit("Spades");


// Constructor method to pass suit name
public Suit(String suit)
{
_suit__ = suit;
}


// Method to return suit name of card
public String getSuitValue()
{
return _suit__;
}

// Puts Suit Methods into Array for iteration
public final static List suit_list = Arrays.asList(new Suit[] {CLUB, DIAMOND, HEART, SPADE});

}