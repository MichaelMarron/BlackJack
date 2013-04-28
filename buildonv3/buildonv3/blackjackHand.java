import java.util.*;

public class blackjackHand implements Hand
{
public ArrayList<Card> hand = new ArrayList<Card>();


    public Card getCard(int index){
        return hand.get(index);
    }


    public void addCard(Card card){
        hand.add(card);
    }


    public Card removeCard(int index){
        return (Card)hand.remove(index); //Return the Card which is removed
    }


    public void removeAllCards(){
		hand.clear();
    }


    public void sortCards(){
        //NOT CURRENTLY IMPLEMENTED
        //CODE TO SORT HAND BY RANK (ACE-KING)
        //ALSO SORT BY SUIT MAYBE
    }


    public int countCards(){
		return hand.size();
    }


    public boolean isCardColEmpty(){
        return hand.isEmpty();
    }


//Hand Speciffic Methods

    public int searchCard(Card card)
    {
        return hand.indexOf( card );
    }


    public boolean replaceCard(Card replacedCard, Card newCard){
        int location = searchCard(replacedCard);					//Location of card to be replaced
        if ( location <0)											//If card not found...
        {															//note: indexOf() method returns -1 if not found, hence 'index<0'
            return false;
        }
        hand.set(location, newCard);								// If card found, replace card at index 'location', with new card
        return true;
    }


    public int evaluateHand(){
		//ASSUMES A = 11 (ACE IS HIGH)!!
		int handVal = 0;

		//for all cards in the hand
		for (int i=0; i<countCards(); i++ )
		{
			//get the card
			Card card = getCard(i);

			/* compareTo() method is stated in the Rank Class
			 * cardVal is difference between ACE and that card, plus 1
			 * E.G:  TWO has a 'distance' of 1 and thus the value is 1+1
			 * E.G: NINE has a 'distance' of 8 and thus the value is 8+1 */
			int cardVal = card.getRank().compareTo(Rank.ACE)+1;

			//Since the game is blackjack, the max value is 10
			if (cardVal > 10){
				cardVal = 10;
			}

			//A cardVal of 1 would indicate 0+1 meaning the card is an ACE and thus 11
			if (cardVal == 1){
                cardVal = 11;
			}

			//Calculate a total of the two cards for a value of the hand
			handVal+=cardVal;


		}
		return handVal;
	}
	public String showHand(int cardNumber){
		int handVal = 0;

		//for all cards in the hand
		//for (int i=0; i<countCards(); i++ )
		//{
			//get the card
			Card card = getCard(cardNumber);
			String cardImage= "";
			String cardVal = card.getRankString();
			String cardSuit = card.getSuitString();
			
			
			if (cardVal == "10"){
			cardVal = "X";
			}	
			
			if (cardSuit == "Spades"){			
			cardImage = String.valueOf(cardVal) + "S";			
			}
			else if (cardSuit == "Hearts"){			
			cardImage = String.valueOf(cardVal) + "H";			
			}
			else if (cardSuit == "Clubs"){			
			cardImage = String.valueOf(cardVal) + "C";			
			} 
			else if (cardSuit == "Diamonds"){			
			cardImage = String.valueOf(cardVal) + "D";			
			} 
			
			//String cardImage = String.valueOf(cardVal) + cardSuit;
			

		return cardImage;
	}
	
	



}
