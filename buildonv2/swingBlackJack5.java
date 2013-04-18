import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class swingBlackJack5 implements ActionListener
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
boolean startLogic = false;		//Switch that activates once players have finished their initial turns
boolean finish = false;			//Switch that activates when the game should end

boolean StillPlaying = true;
String GameState = "";
String[] PlayerState;
String[] PlayerCardsState;

//Comboboxes, Buttons, Labels, Text, etc...
String[] numPlayersRange = {"","1","2","3","4","5","6","7","8","9"};
JComboBox numPlayers = new JComboBox(numPlayersRange);
JLabel numPlayersLabel = new JLabel("Select Number of Players");
JButton blackjackHit = new JButton("Hit  ");
JButton blackjackStick = new JButton("Stick");
JButton blackjackDeal = new JButton("Deal ");
JButton blackjackRefresh = new JButton("Refresh ");

JTextArea ConsoleOutput = new JTextArea();
JTextArea UserInstructions = new JTextArea();
JScrollPane scrollPane = new JScrollPane(ConsoleOutput);

//Instantiate panel
JPanel p = new JPanel();

	public swingBlackJack5()
	{
		//ActionListeners
		//blackjackHit.addActionListener(this);
		//blackjackStick.addActionListener(this);
		//blackjackDeal.addActionListener(this);
		//blackjackRefresh.addActionListener(this);

		//numPlayers.addActionListener(this);

		//Add objects to frame
		//p.add(scrollPane);
		//p.add(blackjackDeal);
		//p.add(blackjackHit);
		//p.add(blackjackStick);
		//p.add(blackjackRefresh);
		//p.add(numPlayersLabel);
		//p.add(numPlayers);

		//p.add(UserInstructions);



		//Hide Hit and Stick button untill game has begun
		//blackjackHit.setVisible(false);
		//blackjackStick.setVisible(false);

		//Set Size of Console Outputs
		//UserInstructions.setPreferredSize(new Dimension(250,170));
		//scrollPane.setPreferredSize(new Dimension(250, 170));

		//Set Console window to non-editable and set dimensions
		//ConsoleOutput.setEditable(false);
		//UserInstructions.setEditable(false);
	}


	//Creates blackjack panel within existing panel (WEIRD INTEGRATION CODE STUFF- NEEDS EXPLAINING)
	/*
	public void swingtime (JPanel masterPanel)
	{
			masterPanel.add(p);
			masterPanel.setVisible(true);
	}
	*/


	public void resetGame()
	{
			GameState = "";

			//ConsoleOutput.setText("");
			//UserInstructions.setText("");
			/*
			numPlayersLabel.setVisible(true);
			numPlayers.setVisible(true);
			blackjackDeal.setVisible(true);
			blackjackHit.setVisible(false);
			blackjackStick.setVisible(false);
			*/
			int playerCount = -1;
			boolean startLogic = false;
			boolean finish = false;
			StillPlaying = true;



			//setup();

	}




	///Method to create players, dealer and deck
	public void setup()
	{
		//DEBUG
		System.out.println("Setup() called Successfully");
		GameState = "";

		//Creates Players and Dealer
		dealer = new blackjackHand();
		players = new blackjackHand[numberOfPlayers];

		//For number of Players, instantiate them (i.e. player[0], player[1],..)
		for (int i=0; i<numberOfPlayers; i++)
		{
			players[i] = new blackjackHand();
			String player = "Player " + (i+1) + " Created\n";
			//ConsoleOutput.append(player);
		}


		//Create a new standard deck
		StandardDeck tmpdeck = new StandardDeck();
		//ConsoleOutput.append("\nDeck Created...\n");

		//Shuffles Deck
		tmpdeck.shuffleCards();
	    deck = tmpdeck;
		//ConsoleOutput.append("Deck Shuffled...\n");

		//Once Finished setting up game, call method to deal initial cards
        dealInitialCards();
	}


	 // Method to deal the intial cards to each player and the dealer
	 public void dealInitialCards()
	 {
	 	if (numberOfPlayers >0){

		PlayerState = new String[numberOfPlayers];
		PlayerCardsState = new String[numberOfPlayers];
		//System.out.println("dealInitialCards() Called Successfully");
	 	//ConsoleOutput.append("\nDealing Initial Cards...\n..............\n");

	 	//GameState = GameState + "Dealing Initial Cards ";

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
				//ConsoleOutput.append("Player " + (x+1) + " recieves " + card.getRankString() + " of " + card.getSuitString() + "\n");
				GameState = GameState + "Player " + (x+1) + " recieves " + card.getRankString() + " of " + card.getSuitString() + "\n";
				PlayerCardsState[x] = PlayerCardsState[x] + "Player " + (x+1)+ " has " + card.getRankString() + " of "+ card.getSuitString() + "\n";

			}
			card = deck.getCard(0);
			dealer.addCard(card);
			deck.removeCard(0);
			//ConsoleOutput.append("Dealer recieves " + card.getRankString() + " of " + card.getSuitString() + "\n\n");
			PlayerCardsState[0] = PlayerCardsState[0] + "Dealer has " + card.getRankString() + " of "+ card.getSuitString() + "\n";
			GameState = GameState + "Dealer recieves " + card.getRankString() + " of " + card.getSuitString() + "\n\n";
		}

		//Instantiate Array to hold players choices (Hit or Stick)
		//Instantiate Array to hold the final hand values of each player
		player_choice = new String[numberOfPlayers];
		finalValues = new int[numberOfPlayers];




	   //Print out player and dealer results after initial deal
	   //ConsoleOutput.append("\nResults after Deal:\n..................\n");
		//GameState = GameState + "\nResults after Deal:\n..................\n";

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

	public void event(int player, int eventnumber)
	{
	int playerNum = player -1;
	//System.out.println("Player event choice " + player_choice[playerNum]);
	System.out.println("Player event number " + eventnumber);
	if (eventnumber ==3){
		System.out.println("Stillplaying: "+ StillPlaying);
		if (StillPlaying == false){
		
			//redeal game if it is over.
			System.out.println("Game redealt ");
			resetGame();
			setup();
		}
	}
	
	
	
	if (player_choice[(playerNum)] != "s"){
		//players can only hit if they have not stuck already.
			if (eventnumber ==2){
				//stick
				player_choice[playerNum] = "s2";
				System.out.println("Player stuck ");
				game();
			}
			
	
			if (eventnumber ==1){
				//hit
				System.out.println("Player Hit ");
				player_choice[playerNum] = "h";
				game();
			}


	
		}
	//System.out.println("Player after event choice " + player_choice[playerNum]);
	}
	
	
	
	//SET TO CHANGING PLAYER CHOICE
	/*
		playerCount =(player-1);
		if (eventnumber ==1){
			//hit
			if (startLogic == true)
				{
					System.out.println("Hit");
					GameState = GameState + "Player " + (playerCount+1) + "Has Hit!\n";
					int hitScore = hit(playerCount);
					game();
				}

				//Logic for initial dealing phase
				if (startLogic == false)
				{
					//If all players have not selected their initial choice...
					if (Arrays.asList(player_choice).contains(null))
					{
						
						System.out.println("Hit");
						GameState = GameState + "Player " + (playerCount+1) + "Has Hit!\n";
						player_choice[playerCount] = "h";

						if (Arrays.asList(player_choice).contains(null))
						{
							initialChoice();
						}
					}

					if (!Arrays.asList(player_choice).contains(null))
					{
						System.out.println("Last person hit, entering game logic stage...");
						playerCount =0;
						game();
					}
			}


		}

		*/
	


	//ActionListener Methods
	public void actionPerformed(ActionEvent e)
	{


		//Listener for 'Stick' button
		if (e.getSource()==blackjackStick)
		{
			//Logic for after initial dealing phase
			if (startLogic == true)
			{
				System.out.println("Player " + (playerCount+1) + " has stuck, their turn should end");
				GameState = GameState + "Player " + (playerCount+1) + "Has stuck ending their turn\n";
				player_choice[playerCount] = "s";
				finalValues[playerCount] = players[playerCount].evaluateHand();
				playerCount++;
				game();
			}

			//Logic for initial dealing phase
			if (startLogic == false)
			{
				//If all players have not selected their initial choice...
				if (Arrays.asList(player_choice).contains(null))
				{
					System.out.println("Stick");
					GameState = GameState + "Player " + (playerCount+1) + "Has Chosen to Stick\n";
					player_choice[playerCount] = "s";
					finalValues[playerCount] = players[playerCount].evaluateHand();

					//If all players still have not selected their initial choice, then ask again
					if (Arrays.asList(player_choice).contains(null))
					{
						initialChoice();
					}
				}

				//If all players have not selected their choice then move to game method
				if (!Arrays.asList(player_choice).contains(null))
				{
					System.out.println("Last person stuck, entering game logic stage...");
					playerCount = 0;
					game();
				}
			}
		}

		//Listener for Hit Button
		if (e.getSource()==blackjackHit)
		{
			//Logic for after initial dealing phase
			if (startLogic == true)
			{
				System.out.println("Hit");
				GameState = GameState + "Player " + (playerCount+1) + "Has Hit!\n";
				int hitScore = hit(playerCount);
				game();
			}

			//Logic for initial dealing phase
			if (startLogic == false)
			{
				//If all players have not selected their initial choice...
				if (Arrays.asList(player_choice).contains(null))
				{
					System.out.println("Hit");
					GameState = GameState + "Player " + (playerCount+1) + "Has Hit!\n";
					player_choice[playerCount] = "h";

					if (Arrays.asList(player_choice).contains(null))
					{
						initialChoice();
					}
				}

				if (!Arrays.asList(player_choice).contains(null))
				{
					System.out.println("Last person hit, entering game logic stage...");
					playerCount =0;
					game();
				}
			}
		}
	}

	// Method for logic for initial choice of players
	
	public void initialChoice()
	{
		if(playerCount < numberOfPlayers)
		{
			playerCount++;
			//UserInstructions.setText("Player " + (playerCount+1) + " Please Stick or Hit\n");
			//UserInstructions.setText("###########\nPlayer " + (playerCount+1) + "\n###########\n Score: " + players[playerCount].evaluateHand() + "\n Please Stick or Hit");
		}

		if(playerCount >= numberOfPlayers)
		{
			//If all players have made initial choice, tell them no more players
			//DEBUG: If this appears then something has gone wrong
			//UserInstructions.setText("There is no Player " + (playerCount+1) + "\n");
		}
	}
	


	//Game method that does game-speciffic logic, is called from various methods at different states
	public void game()
	{	
		//CHECK FOR A WINNER
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
			System.out.println("Player " +i +" Choice: " + player_choice[i]);
			if (player_choice[i] == "w")
			{
				StillPlaying= true;
			}
			
			if (player_choice[i] == "h")
			{
				StillPlaying= true;
				hit(i);
				player_choice[i] = "w";
			}
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
		System.out.println("Game is over");
		results();
		
		}
	}
	
	
	
	
		/*
		if (startLogic == false)
		{
			//RUN ONCE
			//FOR EACH PLAYER in player_choice,
			//IF choice is s then nothing, if hit then run hit
			for (int i=0; i<player_choice.length; i++)
			{
				if (player_choice[i] == "h")
				{
					int tempPlayerCount = playerCount;
					hit(i);
					playerCount = tempPlayerCount;
				}
			}
			startLogic = true;
		}


		if (playerCount >= numberOfPlayers)
		{
			results();
			playerCount--;
			finish = true;

			//As game has ended, hide buttons and display button to ask user if they would like to play again
			blackjackHit.setVisible(false);
			blackjackStick.setVisible(false);
			blackjackDeal.setVisible(true);
		}


		if (finish == false)
		{
			//DEBUG: PRINT OUT FINAL VALUE (if stored) player's choice and players current score
			for (int i = 0; i<finalValues.length; i++)
			{
				System.out.print(finalValues[i] + ", ");
			}
			System.out.println();

			for (int i = 0; i<player_choice.length; i++)
			{
				System.out.print(player_choice[i] + ", ");
			}
			System.out.println();


			if (playerCount < numberOfPlayers)
			{
				if (player_choice[playerCount] =="s")
				{
					System.out.println("Accessed with playercount being " + playerCount +"\n");
					//UserInstructions.append("\nPlayer " + (playerCount+1) + " Has Stuck");
					//ConsoleOutput.append("Player" + (playerCount+1) + " Has Stuck.....\n");
					GameState = GameState + "Player" + (playerCount+1) + " Has Stuck.....\n";
					playerCount++;
					game();

				}

				if (player_choice[playerCount] =="h")
				{
					GameState = GameState + "###########\nPlayer " + (playerCount+1) + "\n###########\n Score: " + players[playerCount].evaluateHand() + "\n Please Stick or Hit";
					//UserInstructions.setText("###########\nPlayer " + (playerCount+1) + "\n###########\n Score: " + players[playerCount].evaluateHand() + "\n Please Stick or Hit");
					}
				}
			}
		}
	*/

			public int hit(int playerNum)
			{
				GameState = GameState + "Player " + (playerNum+1) + "Has Hit!\n";
				

				Card card = deck.getCard(0);
				players[playerNum].addCard(card);
				deck.removeCard(0);
				
				GameState = GameState + "\nPlayer " + (playerNum+1) + " recieves: " + card.getRankString() + " of " + card.getSuitString();
				
				//ConsoleOutput.append("\nPlayer " + (playerNum+1) + " recieves: " + card.getRankString() + " of " + card.getSuitString());
				PlayerCardsState[playerNum] = PlayerCardsState[playerNum] + "\nPlayer " + (playerNum+1) + " recieves: " + card.getRankString() + " of " + card.getSuitString();

				int newPlayVal = players[playerNum].evaluateHand();
				//ConsoleOutput.append("\nPlayer " + (playerNum+1) + "'s hand now has a value of " + newPlayVal + "\n");
				GameState = GameState + "\nPlayer " + (playerNum+1) + "'s hand now has a value of " + newPlayVal + "\n";
				PlayerState[playerNum] = PlayerState[playerNum] + "\nPlayer " + (playerNum+1) + " recieves: " + card.getRankString() + " of " + card.getSuitString();

				checkPlayerValue(playerNum, newPlayVal);
				//ConsoleOutput.append("\n");
				return newPlayVal;
			}


			//CHECK IF PLAYER HAS winningCond
			public void checkPlayerValue(int playerNum, int playerVal)
			{
				if (playerVal == winningCond)
				{
					UserInstructions.append("Player " + (playerNum+1) + " Has got Blackjack! :)\n");
					//ConsoleOutput.append("Player " + (playerNum+1) + " Has got Blackjack!\n");
					PlayerState[playerNum] = "Player " + (playerNum+1) + " Has got Blackjack!\n";
					UserInstructions.setText("###########\nPlayer " + (playerNum+1) + "\n###########\n Score: " + playerVal);
					finalValues[playerNum] = playerVal;
					player_choice[playerNum] = "s";
					playerCount++;

				}

				if (playerVal > winningCond)
				{
					//ConsoleOutput.append("Player " + (playerNum+1) + " Has Bust!\n");
					PlayerState[playerNum] = "Player " + (playerNum+1) + " Has Bust!\n";
					UserInstructions.setText("###########\nPlayer " + (playerNum+1) + "\n###########\n Has Bust!! :(");
					finalValues[playerNum] = playerVal;
					player_choice[playerNum] = "s";
					playerCount++;
				}
				if (playerVal < winningCond)
				{
					finalValues[playerNum] = playerVal;
					//player_choice[playerNum] = "w";
					playerCount++;
				}
				
			}


			//CHECK IF DEALER GETS blackjack or busts
			public void checkDealerValue(int dealVal)
			{
				if (dealVal == winningCond)
				{
					//ConsoleOutput.append("\nDealer HAS GOT blackjack, EVERYONE LOSES!");
					PlayerState[0] = "\nDealer HAS GOT blackjack, EVERYONE LOSES!";
					UserInstructions.setText("\nDealer HAS GOT blackjack, EVERYONE LOSES!");
					blackjackDeal.setVisible(false);
					blackjackHit.setVisible(true);
					finish = true;
				}

				if (dealVal > winningCond)
				{
					//ConsoleOutput.append("\nDealer Has gone bust, EVERYONE WINS!\n");
					PlayerState[0] = "\nDealer Has gone bust, EVERYONE WINS!\n";
					UserInstructions.setText("\nDealer HAS GOT blackjack, EVERYONE WINS!");
					blackjackDeal.setVisible(false);
					blackjackHit.setVisible(true);
					finish = true;
				}
			}



			public void results()
			{
				System.out.println(dealer.evaluateHand());
				while (dealer.evaluateHand() < 16)
				{
					//ConsoleOutput.append("\nDealer hits!\n");

					Card card = deck.getCard(0);
					dealer.addCard(card);
					deck.removeCard(0);
					//ConsoleOutput.append("\nDealer recieves: " + card.getRankString() + " of " + card.getSuitString());
					PlayerCardsState[0] = PlayerCardsState[0] + "\nDealer recieves: " + card.getRankString() + " of " + card.getSuitString();
					GameState = GameState + "\nDealer recieves: " + card.getRankString() + " of " + card.getSuitString();
					

					int newDealVal = dealer.evaluateHand();
					//GameState = GameState + "\nDealer hand now has a value of " + newDealVal;
					//ConsoleOutput.append("\nDealer hand now has a value of " + newDealVal);
					PlayerState[0] = "\nDealer hand now has a value of " + newDealVal;
					newDealVal = dealer.evaluateHand();				
					GameState = GameState + "\nDealer hand now has a value of " + newDealVal;
					checkDealerValue(newDealVal);
				}
				
				
				for (int i=0; i<numberOfPlayers; i++)
				{
					if (player_choice[i] == "s"){
						int playVal=players[i].evaluateHand();
						if (playVal > winningCond)
						{
							//ConsoleOutput.append("\n\nPlayer " + (i+1) + " DREW with the dealer\n");
							GameState = GameState + "\n\nPlayer "+ (i+1) + " Lost\n";
							UserInstructions.append("\n\nPlayer "+ (i+1) + " Lost\n");
							player_choice[i] ="lose";
						}
						
						
						if (playVal < dealer.evaluateHand() && dealer.evaluateHand() <=winningCond)
						{
							//ConsoleOutput.append("\n\nPlayer "+ (i+1) + " LOST to the dealer\n");
							GameState = GameState + "\n\nPlayer "+ (i+1) + " LOST to the dealer\n";
							UserInstructions.append("\n\nPlayer "+ (i+1) + " LOST to the dealer\n");
							player_choice[i] ="lose";
						}
						
						if (playVal < dealer.evaluateHand() && dealer.evaluateHand() > winningCond)
						{
							//ConsoleOutput.append("\n\nPlayer " + (i+1) + " BEAT the dealer\n");
							GameState = GameState + "\n\nPlayer "+ (i+1) + " BEAT the dealer\n";
							UserInstructions.append("\n\nPlayer "+ (i+1) + " BEAT  the dealer\n");
							player_choice[i] ="win";
						}

						if (playVal > dealer.evaluateHand() && playVal <=winningCond)
						{
							//ConsoleOutput.append("\n\nPlayer " + (i+1) + " BEAT the dealer\n");
							GameState = GameState + "\n\nPlayer "+ (i+1) + " BEAT the dealer\n";
							UserInstructions.append("\n\nPlayer "+ (i+1) + " BEAT  the dealer\n");
							player_choice[i] ="win";
						}

						if (playVal == dealer.evaluateHand() && dealer.evaluateHand() != winningCond)
						{
							//ConsoleOutput.append("\n\nPlayer " + (i+1) + " DREW with the dealer\n");
							GameState = GameState + "\n\nPlayer "+ (i+1) + " DREW withs the dealer\n";
							UserInstructions.append("\n\nPlayer "+ (i+1) + " DREW with the dealer\n");
							player_choice[i] ="drew";
						}

					}
				}
				
				StillPlaying = false;

			}











	public static void main(String[] args)
	{
		new swingBlackJack5();
	}

}
