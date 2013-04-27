

//ArrayList and Iterator
import java.util.*;

public class StandardDeck implements Deck
{

public ArrayList<Card> deck = new ArrayList<Card>();

    public StandardDeck()
    {
        Iterator suitIterator = Suit.suit_list.iterator();
        while (suitIterator.hasNext())
        {
            Suit suit_obj = (Suit) suitIterator.next();
            Iterator rankIterator = Rank.rank_list.iterator();
            while (rankIterator.hasNext() )
            {
                Rank rank_obj = (Rank) rankIterator.next();
                deck.add(new StandardCard(rank_obj, suit_obj));
            }
         }
     }


    public Card getCard(int num){
        return deck.get(num);}


    public void addCard(Card card){
        deck.add(card);}


    public Card removeCard(int index){
        return (Card)deck.remove(index);
    }


    public void removeAllCards(){
		deck.clear();
	}

    public int DeckSize(){
        return deck.size();}


	public void sortCards(){
		//NOT CURRENTLY IMPLEMENTED
		//CODE TO SORT DECK BY RANK (ACE-KING)
	    //ALSO SORT BY SUIT MAYBE
    }


	public int countCards(){
		return deck.size();
	}


	public boolean isCardColEmpty(){
		return deck.isEmpty();
	}



//Deck Speciffic Methods
    public void shuffleCards(){
        Collections.shuffle(deck);
    }















}