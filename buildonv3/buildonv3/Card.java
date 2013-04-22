

//Interface for Cards
public interface Card
{

    //Gets Rank of Card
    //@return: Rank of specified Card
    public abstract Rank getRank();


    //Gets Suit of Card
    //@return: Suit of specified Card
    public abstract Suit getSuit();


    //Gets Rank of Card as a String
    //@param: position in deck (location) of card
    //@return: Rank value of specified card as a string (eg. "K" or "2")
    public abstract String getRankString();


    //Gets Suit of Card as a String
	//@param: position in deck (location) of card
    //@return: Suit value of specified card as a string (eg. "Hearts" or "Spades")
    public abstract String getSuitString();


    //NEED IMPLEMENTATION OF MORE CARD METHODS

}

