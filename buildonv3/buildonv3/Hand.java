

// Interface for a User's Hand of Cards
public interface Hand extends CardCollection
{

    //Search for first instance of specified card
    //@param: Card to search for
    //@return: Position of card in hand if found, else -1 (-1 as use .indexOf() method)
    public abstract int searchCard(Card card);


    //Replaces a card in person's hand with another
    //@param: Card to be replaced, new Card
    //@return: False if not found, true if found
    public abstract boolean replaceCard(Card oldCard, Card newCard);


	//Sum of the values of each card, value depends on game
	//Utilised CompareTo() method inside Rank
	//@return: returns value of hand
	public abstract int evaluateHand();




}



