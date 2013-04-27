import java.util.*;

public class blackJack
{

int numberOfCards = 2;			//Number of Cards is always 2, unless in custom game
int winningCond = 21;			//Hand Value for a win is always 21, unless in custom game

int moneyBet;					//Bet amount (from setupPhase)
int numberOfPlayers;			//Selected Number of players (from setupPhase)

Deck deck;						//Deck of cards (from dealInitialCards)
blackjackHand dealer;			//Dealer's Hand (from dealInitialCards)
blackjackHand[] players;		//Array containing hand objects for each player (from dealInitialCards)

String[] player_choice;  		//Array of player choices (Whether they stick or hit)
int[] finalValues;		 		//Array of the final hand values for all players




	//Method to create players, dealer and deck
	public void setup()
	{
		//[INPUT] SELECT NUMBER OF PLAYERS
		System.out.println("How many will be playing?");
		Scanner selectNumPlayers = new Scanner(System.in);
		numberOfPlayers = selectNumPlayers.nextInt();


		//CREATE PLAYERS AND DEALER
		dealer = new blackjackHand(); 				 	//Instantiates dealer hand
		players = new blackjackHand[numberOfPlayers];  //Creates array to hold players


		//For number of Players, instantiate them (i.e. player[0], player[1],..)
		for (int i=0; i<numberOfPlayers; i++)
		{
			players[i] = new blackjackHand();
			System.out.printf("Player %d Created!...\n", i+1);
		}


		//PLACE BET FOR EACH PLAYER
        //System.out.println("\nHow much would you like to bet?");
       // Scanner sc = new Scanner(System.in);
        //moneyBet = sc.nextInt();


		//CREATE AN NEW STANDARD DECK AND SHUFFLE
		System.out.println("\nCreating Deck...\n");
		StandardDeck tmpdeck = new StandardDeck();
        tmpdeck.shuffleCards();
        deck = tmpdeck;

		//Once Finished setting up game, call method to deal initial cards
        dealInitialCards();
	}



	 // Method to deal the intial cards to each player and the dealer
	 public void dealInitialCards()
	    {
			System.out.println("Dealing Initial cards...\n");

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
					System.out.printf("Player %s recieves: %s of %s\n", x+1,card.getRankString(), card.getSuitString());
				}

				card = deck.getCard(0);
				dealer.addCard(card);
				deck.removeCard(0);
				System.out.printf("_Dealer_ recieves: %s of %s\n\n", card.getRankString(), card.getSuitString());
			}


			//Instantiate Array to hold players choices (Hit or Stick)
			player_choice = new String[numberOfPlayers];


			for (int i=0; i < player_choice.length; i++)
			{
				player_choice[i] = "x";
				System.out.println(player_choice[i]);
			}

			//Instantiate Array to hold the final hand values of each player
			finalValues = new int[numberOfPlayers];

			//Check results of both player and dealer after the initial deal
			System.out.println();
			System.out.println("#################################");
			System.out.println("PLAYER RESULTS AFTER INITIAL DEAL");
			System.out.println("#################################");
		   /*
			* Get value of players hand
			* If the value is 21 then player has a perfect hand
				* store 21 as the final value for this player in the array
				* automatically set player to stick
				* print out that player has a perfect hand
			* If the value is not 21
				* Just print out the players current hand
			*/
			for (int c=0; c<players.length; c++)
			{
				int playVal = players[c].evaluateHand();
				if(playVal == 21)
				{
					System.out.printf("\nPlayer %s's has a perfect hand of %d", c+1, playVal);
					player_choice[c] = "s";
					finalValues[c] = playVal;
				}
				else
				{
					System.out.printf("\nPlayer %s's hand has a value of %d", c+1, playVal);
				}
			}

			System.out.println("\n");
			System.out.println("#################################");
			System.out.println("DEALER RESULTS AFTER INITIAL DEAL");
			System.out.println("#################################");
			/*
			 * Get value of dealers hand
			 * If the value is 21 then the dealer has a perfect hand
				 * end the game as dealer has won
			 * Else if he doesn't then just print out the value of his hand
			*/
			int dealVal = dealer.evaluateHand();
			if (dealVal == 21)
			{
				System.out.println("\nThe Dealer has a perfect hand!....GAME OVER");
				return;
			}
			else
			{
				System.out.printf("\nThe Dealer's hand has a value of %d\n", dealVal);

		}


    	}

		// Method for main game
		public void game()
		{
			System.out.println("");
			System.out.println("#################################");
			System.out.println("     PLAYER INTERACTION PHASE    ");
			System.out.println("#################################");
			System.out.println();

		   /*
		   	* If the user did not previously stick (by getting a 21)
			* Ask each player if they want to stick or twist (user input)
			* If user selects s or h (stick or hit)
				* Print out decision
				* Add decision to the array of decisions
			* If user selects option that is not s or h
				* repeat until they do
			*/





			for (int i=0; i<players.length; i++)
			{
				if (player_choice[i] != "s")
				{
					System.out.printf("\nPlayer %d please Stick(s) or Hit(h)\n", i+1);
					Scanner sc = new Scanner(System.in);
					String decision = sc.nextLine();

					if (decision.equals("s"))
					{
						finalValues[i] = players[i].evaluateHand();
					}

					while (!decision.equals("s") && !decision.equals("h"))
					{
						System.out.println("Not a valid option");
						sc = new Scanner(System.in);
						decision = sc.nextLine();
					}
					player_choice[i] = decision;
				}
			}



		   /*
			* While the array of decisions still contains a hit request
			* If the player has stuck
				* Print out that the player has stuck
				* Add the value of their hand value to the array final values
			* If the player has hit
				* Call the hit() method which draws another card and repeats hit or stick question
				* Checks if the player has hit or stuck after that turn
				* If they have hit, then repeat hit() method
				* Else mark them as stuck and add their hand value to the array of values
		    */
			while (Arrays.asList(player_choice).contains("h"))
			{
				for (int i=0; i<player_choice.length; i++)
				{
					if (player_choice[i].equals("s"))
					{
						System.out.printf("\nPlayer %d sticks!\n", i+1);
						finalValues[i] = players[i].evaluateHand();
					}

					if (player_choice[i].equals("h"))
					{
						hit(i);
						while (player_choice[i].equals("h"))
						{
							System.out.printf("\nPlayer %d please Stick(s) or Hit(h)\n", i+1);
							Scanner sc = new Scanner(System.in);
							String decision = sc.nextLine();

							if (decision.equals("s"))
							{
								System.out.printf("\nPlayer %d sticks!\n", i+1);
								finalValues[i] = players[i].evaluateHand();
								player_choice[i] = decision;
							}

							else
							{
								hit(i);
							}
						}
					}
				}
			}

			System.out.println("\n");
			System.out.println("#################################");
			System.out.println("          FINAL VALUES           ");
			System.out.println("#################################");
			System.out.println();

			// Prints out players final values for conveinaince
			for (int t=0; t<finalValues.length;t++)
			{
				System.out.printf("\nPlayer %d has a final value of %d\n", t+1, finalValues[t]);
			}

			System.out.printf("\nDealer had a value of %d\n", dealer.evaluateHand());


		}


			public int hit(int playerNum)
			{
				System.out.printf("\nPlayer %d hits!\n", playerNum+1);

				Card card = deck.getCard(0);
				players[playerNum].addCard(card);
				deck.removeCard(0);
				System.out.printf("Player %s recieves: %s of %s\n", playerNum+1, card.getRankString(), card.getSuitString());

				int newPlayVal = players[playerNum].evaluateHand();
				System.out.printf("Player %s's hand now has a value of %d\n", playerNum+1, newPlayVal);

				checkPlayerValue(playerNum, newPlayVal);
				return newPlayVal;
			}




			public void checkPlayerValue(int playerNum, int playerVal)
			{

				if (playerVal == 21)
				{
					System.out.printf("Player %s HAS GOT 21!!!", playerNum+1);
					finalValues[playerNum] = playerVal;
					player_choice[playerNum] = "s";

				}

				if (playerVal > 21)
				{
					System.out.printf("Player %s HAS BUST\n", playerNum+1);
					finalValues[playerNum] = playerVal;
					player_choice[playerNum] = "s";
				}

			}



			public void checkDealerValue(int dealVal)
			{

				if (dealVal == 21)
				{
					System.out.printf("Dealer HAS GOT 21, EVERYONE LOSES MWAHAHA...END GAME!!!");
				}

				if (dealVal > 21)
				{
					System.out.printf("Dealer HAS GONE BUST\n");
				}

			}


			public void results()
			{
				while (dealer.evaluateHand() < 16)
				{

					System.out.println("\nDealer hits!\n");

					Card card = deck.getCard(0);
					dealer.addCard(card);
					deck.removeCard(0);
					System.out.printf("Dealer recieves: %s of %s\n", card.getRankString(), card.getSuitString());

					int newDealVal = dealer.evaluateHand();
					System.out.printf("Dealer hand now has a value of %d\n",newDealVal);
					checkDealerValue(newDealVal);
				}

				for (int i=0; i<finalValues.length; i++)
				{
					if (finalValues[i] < dealer.evaluateHand() && dealer.evaluateHand() <=21)
					{
						System.out.printf("\nPlayer %s lost to the dealer\n", i+1);
					}

					if (finalValues[i] > dealer.evaluateHand() && finalValues[i] <=21)
					{
						System.out.printf("\nPlayer %s BEAT THE DEALER!!!!\n", i+1);
					}

					if (finalValues[i] == dealer.evaluateHand() && dealer.evaluateHand() != 21)
					{
						System.out.printf("\nPlayer %s drew with the dealer\n", i+1);
					}
				}
			}















	public blackJack()
	{
		setup();
		//dealInitialCards();
		//game();
		results();
	}


    public static void main(String[] args)
    {
		System.out.println("Welcome to blackjack v3!");
		new blackJack();
	}

    }


