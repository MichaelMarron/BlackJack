import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class swingBlackJack5
{
int moneyBet;					//Bet amount (NOT IMPLEMENTED MONEY YET)
int numberOfCards = 2;			//Number of Cards is always 2, unless in custom game
int winningCond = 21;			//Hand Value for a win is always 21, unless in custom game

int numberOfPlayers;			//Selected Number of players (from setup)
Deck deck;						//Deck of cards (from dealInitialCards)
blackjackHand dealer;			//Dealer's Hand (from dealInitialCards)
blackjackHand[] players;		//Array containing hand objects for each player (from dealInitialCards)
String[] player_choice;  		//Array of player choices (Whether they stick or hit)
int[] finalValues;		 		//Array of the final hand values for all players
int playerCount = -1; 			//Value that acts as pointer to position in players[] when repeating game method
boolean finish = false;			//Switch that activates when the game should end

boolean ResultsDisplayed = false;
boolean StillPlaying = true;
String GameState = ""; //String for printing state of game, cards, etc. Is added to when progress in game is made.
String[] PlayerState; //String that holds player's card overall value. To be used for retrieving data for card ui's
String[] PlayerCardsState; //String that holds the player's individual card values. To be used for retrieving data for card ui's

//Comboboxes, Buttons, Labels, Text, etc...
JTextArea UserInstructions = new JTextArea();


//Instantiate panel
JPanel p = new JPanel();

	public swingBlackJack5()
	{

	}

	public void resetGame()
	{		//function just clears some game functions for a new game to be dealt.
			GameState = "";
			int playerCount = -1;
			boolean finish = false;
			StillPlaying = true;
			ResultsDisplayed = false;
	}




	///Method to create players, dealer and deck
	public void setup()
	{
		//DEBUG
		GameState = "";

		//Creates Players and Dealer
		dealer = new blackjackHand();
		players = new blackjackHand[numberOfPlayers];

		//For number of Players, instantiate them (i.e. player[0], player[1],..)
		for (int i=0; i<numberOfPlayers; i++)
		{
			players[i] = new blackjackHand();
			String player = "Player " + (i+1) + " Created\n";

		}


		//Create a new standard deck
		StandardDeck tmpdeck = new StandardDeck();


		//Shuffles Deck
		tmpdeck.shuffleCards();
	    deck = tmpdeck;


		//Once Finished setting up game, call method to deal initial cards
        dealInitialCards();
	}


	 // Method to deal the intial cards to each player and the dealer
	 public void dealInitialCards()
	 {
	 	if (numberOfPlayers >0){

		PlayerState = new String[numberOfPlayers];
		PlayerCardsState = new String[numberOfPlayers];

		// Give a card to each player THEN dealer, so many times
		for (int i=0; i<numberOfCards; i++)
		{
			Card card;

			//For each player in players array, give a card
			for (int x=0; x<numberOfPlayers; x++)
			{
				card = deck.getCard(0);
				players[x].addCard(card);
				deck.removeCard(0);
				GameState = GameState + "Player " + (x+1) + " recieves " + card.getRankString() + " of " + card.getSuitString() + "\n";
				PlayerCardsState[x] = PlayerCardsState[x] + "Player " + (x+1)+ " has " + card.getRankString() + " of "+ card.getSuitString() + "\n";

			}
			card = deck.getCard(0);
			dealer.addCard(card);
			deck.removeCard(0);
			PlayerCardsState[0] = PlayerCardsState[0] + "Dealer has " + card.getRankString() + " of "+ card.getSuitString() + "\n";
			GameState = GameState + "Dealer recieves " + card.getRankString() + " of " + card.getSuitString() + "\n\n";
		}

		//Instantiate Array to hold players choices (Hit or Stick)
		//Instantiate Array to hold the final hand values of each player
		player_choice = new String[numberOfPlayers];
		finalValues = new int[numberOfPlayers];


		//If the player has a winning hand: stick and print this, else just print their result
		for (int c=0; c<players.length; c++)
		{
		
			player_choice[c]="w";//set all players status to be waiting for input
			int playVal = players[c].evaluateHand();
			checkPlayerValue(c,playVal);
				
			GameState = GameState + "\nPlayer " + (c+1) + "'s hand now has a value of " + playVal + "\n";
			
		}

		//Same as above for dealer
		int dealVal = dealer.evaluateHand();
		checkDealerValue(dealVal);
		
				
		int newDealVal = dealer.evaluateHand();
		GameState = GameState + "\nDealer's hand now has a value of " + newDealVal + "\n";
		
		game();
		
		
		}
    }
	
	//event function. Is called by the server on the game instance when a request is made to the server. Can be modified for individual game classes to provide different functionality for different events. Largely checks the state of the game, determines the event, the desired repsonse, and whether that response should be committed.
	public void event(int player, int eventnumber)
	{
	int playerNum = player -1;
	
	//System.out.println("Player event number " + eventnumber); //debug
	
	//Event number 3 = Redeal. 
	if (eventnumber ==3){
	//check if players are still playing.
		if (StillPlaying == false){		
			//redeal game if it is over.
			resetGame();
			setup();
		}
	}

	//System.out.println("Player " + player_choice[playerNum]);
	
	//Stops game from repeatedly printing results over and over when all players are waiting to redeal.
	if (player_choice[(playerNum)] == "win" || player_choice[(playerNum)] == "lose" || player_choice[(playerNum)] == "drew"){
	//Game is over. User can not do certain requests in this game.
	}
	else{
		if (player_choice[(playerNum)] != "s"){
			//players can only hit if they have not stuck already.
				if (eventnumber ==2){
					//stick
					player_choice[playerNum] = "s2"; //temporary stick status to indicate a player has just stuck.
					game();
				}
			
				
				if (eventnumber ==1){
					//hit
					player_choice[playerNum] = "h";
					game();
				}
	
		}
	}
}



	//Game method that does game-speciffic logic, is called from various methods at different states. Determines logic of what happens when a player's state changes. E.g. when a player hits and has a hit status, gives them a card and then resets their status to waiting.
	public void game()
	{	
		//CHECK FOR A WINNER. If winner found, player automatically sticks.
		for (int i=0; i<numberOfPlayers; i++)
		{
			int playVal=players[i].evaluateHand();
			checkPlayerValue(i, playVal);
		}
		int newDealVal = dealer.evaluateHand();
		checkDealerValue(newDealVal);
		
		//CHECK IF PLAYERS ARE WAITING
		StillPlaying= false;
		for (int i=0; i<player_choice.length; i++)
		{	
			//if there is a player with a waiting status, they are still playing.
			if (player_choice[i] == "w")
			{
				StillPlaying= true;
			}
			//if there is a player with a hit request status, they are still playing.
			//hit for a card.
			if (player_choice[i] == "h")
			{
				StillPlaying= true;
				hit(i);
				player_choice[i] = "w";
			}
			//player sticks
			if (player_choice[i] == "s2")
			{
				GameState = GameState + "Player " + (i+1) + " has stuck.";
				player_choice[i] = "s";
			}
			if (player_choice[i] == "s")
			{
				//do nothing		
			}
		}
		
		//Check if game is concluded.
		if (StillPlaying ==false){
		results();
		
		}
	}

			//Adds a card to the user requesting a hit and checks if the user has won.
			public int hit(int playerNum)
			{
				GameState = GameState + "Player " + (playerNum+1) + "Has Hit!\n";
				

				Card card = deck.getCard(0);
				players[playerNum].addCard(card);
				deck.removeCard(0);
				
				GameState = GameState + "\nPlayer " + (playerNum+1) + " recieves: " + card.getRankString() + " of " + card.getSuitString();
				
				PlayerCardsState[playerNum] = PlayerCardsState[playerNum] + "\nPlayer " + (playerNum+1) + " recieves: " + card.getRankString() + " of " + card.getSuitString();

				int newPlayVal = players[playerNum].evaluateHand();
				GameState = GameState + "\nPlayer " + (playerNum+1) + "'s hand now has a value of " + newPlayVal + "\n";
				PlayerState[playerNum] = PlayerState[playerNum] + "\nPlayer " + (playerNum+1) + " recieves: " + card.getRankString() + " of " + card.getSuitString();

				checkPlayerValue(playerNum, newPlayVal);
				return newPlayVal;
			}


			//CHECK IF PLAYER HAS winningCond 
			public void checkPlayerValue(int playerNum, int playerVal)
			{
				if (playerVal == winningCond)
				{
					UserInstructions.append("Player " + (playerNum+1) + " Has got Blackjack! :)\n");
					PlayerState[playerNum] = "Player " + (playerNum+1) + " Has got Blackjack!\n";
					UserInstructions.setText("###########\nPlayer " + (playerNum+1) + "\n###########\n Score: " + playerVal);
					finalValues[playerNum] = playerVal;
					player_choice[playerNum] = "s";
					playerCount++;

				}

				if (playerVal > winningCond)
				{
					
					PlayerState[playerNum] = "Player " + (playerNum+1) + " Has Bust!\n";
					UserInstructions.setText("###########\nPlayer " + (playerNum+1) + "\n###########\n Has Bust!! :(");
					finalValues[playerNum] = playerVal;
					player_choice[playerNum] = "s";
					playerCount++;
				}
				if (playerVal < winningCond)
				{
					finalValues[playerNum] = playerVal;
					playerCount++;
				}
				
			}


			//CHECK IF DEALER GETS blackjack or busts
			public void checkDealerValue(int dealVal)
			{
				if (dealVal == winningCond)
				{
					PlayerState[0] = "\nDealer HAS GOT blackjack, EVERYONE LOSES!";
					UserInstructions.setText("\nDealer HAS GOT blackjack, EVERYONE LOSES!");
					finish = true;
				}

				if (dealVal > winningCond)
				{
					PlayerState[0] = "\nDealer Has gone bust, EVERYONE WINS!\n";
					UserInstructions.setText("\nDealer HAS GOT blackjack, EVERYONE WINS!");
					finish = true;
				}
			}


			//Is called when all players have stuck or lost. Goes through and does the mathsy stuff. Deals out dealer logic then applies victory or loss to each player.
			public void results()
			{
				while (dealer.evaluateHand() < 16)
				{
					
					Card card = deck.getCard(0);
					dealer.addCard(card);
					deck.removeCard(0);
					PlayerCardsState[0] = PlayerCardsState[0] + "\nDealer recieves: " + card.getRankString() + " of " + card.getSuitString();
					GameState = GameState + "\nDealer recieves: " + card.getRankString() + " of " + card.getSuitString();
					

					int newDealVal = dealer.evaluateHand();
					PlayerState[0] = "\nDealer hand now has a value of " + newDealVal;
					newDealVal = dealer.evaluateHand();				
					GameState = GameState + "\nDealer hand now has a value of " + newDealVal;
					checkDealerValue(newDealVal);
				}
				
				if (ResultsDisplayed ==false){
					for (int i=0; i<numberOfPlayers; i++)
					{
						if (player_choice[i] == "s"){
							int playVal=players[i].evaluateHand();
							if (playVal > winningCond)
							{
								GameState = GameState + "\n\nPlayer "+ (i+1) + " Lost\n";
								UserInstructions.append("\n\nPlayer "+ (i+1) + " Lost\n");
								player_choice[i] ="lose";
							}
						
						
							if (playVal < dealer.evaluateHand() && dealer.evaluateHand() <=winningCond)
							{
								GameState = GameState + "\n\nPlayer "+ (i+1) + " LOST to the dealer\n";
								UserInstructions.append("\n\nPlayer "+ (i+1) + " LOST to the dealer\n");
								player_choice[i] ="lose";
							}
						
							if (playVal < dealer.evaluateHand() && dealer.evaluateHand() > winningCond)
							{
								GameState = GameState + "\n\nPlayer "+ (i+1) + " BEAT the dealer\n";
								UserInstructions.append("\n\nPlayer "+ (i+1) + " BEAT  the dealer\n");
								player_choice[i] ="win";
							}

							if (playVal > dealer.evaluateHand() && playVal <=winningCond)
							{
								GameState = GameState + "\n\nPlayer "+ (i+1) + " BEAT the dealer\n";
								UserInstructions.append("\n\nPlayer "+ (i+1) + " BEAT  the dealer\n");
								player_choice[i] ="win";
							}

							if (playVal == dealer.evaluateHand())
							{
								GameState = GameState + "\n\nPlayer "+ (i+1) + " DREW withs the dealer\n";
								UserInstructions.append("\n\nPlayer "+ (i+1) + " DREW with the dealer\n");
								player_choice[i] ="drew";
							}

						}
					}
				}
				ResultsDisplayed = true;
				
				/* debug
				for (int i=0; i<numberOfPlayers; i++)
				{
					System.out.println(ShowHand(i));
				}
				*/
				
				StillPlaying = false;

			}
			
			
			//method needed to connect to the mysql server when an instance of the game is run? Or maybe just lob a connection in to the main server
			//method needed to parse the respective usernames and wins for each player in the game and then send the data to the Mysql server.
			//TODOLIST
	
	public String ShowHand(int playernumber){
		
		int handsize = players[playernumber].countCards();
		String playVal = "";
		playVal = playVal+handsize;
		for (int j=0; j<handsize; j++){
			playVal= playVal + players[playernumber].showHand(j) + " ";
			
		}
	
		return playVal;
	}
	






	public static void main(String[] args)
	{
		new swingBlackJack5();
	}

}
