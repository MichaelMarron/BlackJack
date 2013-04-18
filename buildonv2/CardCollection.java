

//Interface for Collection of Cards
//Deck, Burn_Deck/Discard_Pile and Hand Would extend this
public interface CardCollection
{



    //Get Card at specified position in a Deck
    //@param: position of card in Deck
    //@return: Card at position if found, else null
    public abstract Card getCard(int num);


    //Add Card to a Deck
    //@param: Card to add
    public abstract void addCard(Card card);


    //Remove Card at specified position in a Deck
    //@param: position of card in hand
    //@return: Card to be removed, else null
    public abstract Card removeCard(int index);

    //Empties the collection- Does not destroy object
    public abstract void removeAllCards();


    //Sorts cards in rank order (Hence Ace-King, etc)
	public abstract void sortCards();


	//Gets value of number of cards in collection
    //@return: cardinality of deck
    public abstract int countCards();


	//Checks if hand is empty
	//@return: true if empty, false if contains Card
    public abstract boolean isCardColEmpty();


}







/*









		//REMOVE CARD VARIATION CODE POSSIBILITY
		public Card removeCard(Card card)
		{
			int index = hand.indexOf(card);
			if ( index < 0 )
			{
				return null;
			}
			else
			{
				return (Card)hand.remove(index);
			}
		}
*/