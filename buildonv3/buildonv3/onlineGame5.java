import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import net.miginfocom.swing.MigLayout;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.net.*;
import java.util.*;
// Packages used in this program imported

public class onlineGame5 extends JFrame implements ActionListener
{

JPanel cards, logoPanel, cardPanel, cardPanel2,logoPanel2,adPanel;
JLabel logo, userNameLabel, passwordLabel, fName, lName, dOB, aLine1, aLine2;
JLabel city, postCode, eMail, cUsername, cPassword, welcomeLabel;
JLabel friendLabel, friendUsername, gamesMenuLabel, helpPageLabel, blackjackLabel;
JLabel blackjackRules, blackjackControls, pokerLabel, pokerRules, pokerControls;
JLabel blackjackBalance,adv;
JLabel ePuserNameLabel, ePAgeLabel, ePLocationLabel, ePBioLabel, ePPasswordLabel;
JLabel gameNameLabelP, maxPlayersLabel, jokerLabel, cardHandLabel, AceLabel, numofDecksLabel, ChooseLeaLabel, GameSelectorLabel, leagueNameLabel, SbindLabelP, BbindLabelP, NumOfRoundsPLabel, boardcardsLabel, gameNameLabelBJ, maxPlayersLabelBJ, StickNumLabelBJ, NumOfRoundsLabelBJ, StartCredLabelBJ, MinBetLabelBJ, MaxBetLabelBJ;
JTextField userNameField, fNameF, lNameF, dOBF, aLine1F, aLine2F, cityF;
JTextField postCodeF, eMailF, cUsernameF, cPasswordF;
JTextField blackjackRulesBox, blackjackControlsBox, pokerRulesBox, friendUsernameF, pokerControlsBox;
JTextField blackjackBalanceF;
JTextField viewProfileUserName, viewProfileAge, viewProfileLocation, viewProfileBio;
JTextField ePUsernameTF, ePAgeTF, ePLocationTF, ePBioTF, ePPasswordTF;
JTextField gameNameFieldP , gameNameFieldBJ , numofDecksField, LeagueNameField, SbindFieldP, BbindFieldP, StartCredFieldBJ, MinBetFieldBJ, MaxBetFieldBJ;
JButton submitLogin, register, submitRegister, registerBack, viewProfileB, gamesB;
JButton helpPage, leagueStatB, customB, logoutB, ppvB, vPBack, vPEdit, vPFindFriends, ePBack, ePSubmit;
JButton findFriend, findFriendBack;
JButton pokerHelpB, pokerCall, pokerCheck, pokerRaise, pokerFold, pokerBack;
JButton friendsSubmit, blackjack, texas, createAGame, newLeague, gamesBack, helpBack;
JButton blackjackBack, blackjackHelp, blackjackDeal, blackjackHit, blackjackStick;
JButton blackjackBet;
JButton blackjackRefresh2;
JScrollPane scrollPane;
JButton submitB;
JButton createLeaB, HomeB7, HomeB8, HomeB9, SubmitLea, submitBj, PokerB, BJB, BackBj, BackP;
JButton ePBackB, ePSubmitB;
JRadioButton JokerButton1, JokerButton2, JokerButton3, AceButton1, AceButton2, AceButton3;
JComboBox LeagueList, GameList, maxPlayersselectP, NumOfRoundsP, cardHandP, BoardHandP, maxPlayersselectBJ, StickNumBJ, NumOfRoundsBJ;
TitledBorder loginTitle, registerTitle, welcomeTitle, gameTitle, vLeagueTitle , cLeagueTitle, gameTitleP, gameTitleBJ;
TitledBorder friendTitle, gameMenuTitle, leaderBoardTitle, viewProfileTitle;
TitledBorder helpPageTitle, pokerTitle, blackjackTitle;
TitledBorder helpPageTitleB, gamesTitleBj;
JLabel helpPageLabelB;
JButton helpBackB;

JLabel selectlogoImage, chooseGame;
JButton logoImageB1, logoImageB2, logoImageB3, logoImageB4, logoImageB5, lobbySubmit, lobbyBack; //***
ImageIcon logoImage1, logoImage2, logoImage3, logoImage4, logoImage5; //**
JTable lobbyTable;

JLabel card1shell, card2shell, card3shell, card4shell, card5shell, card6shell;
JTextArea ConsoleOutput;
JTextArea UserInstructions;

ImageIcon cardBlank = new ImageIcon("Images/NoCard.png");
ImageIcon cardKS= new ImageIcon("Images/KingSpades.png");
ImageIcon cardQS= new ImageIcon("Images/QueenSpades.png");
ImageIcon cardJS= new ImageIcon("Images/JackSpades.png");
ImageIcon card10S= new ImageIcon("Images/10Spades.png");
ImageIcon card9S= new ImageIcon("Images/9Spades.png");
ImageIcon card8S= new ImageIcon("Images/8Spades.png");
ImageIcon card7S= new ImageIcon("Images/7Spades.png");
ImageIcon card6S= new ImageIcon("Images/6Spades.png");
ImageIcon card5S= new ImageIcon("Images/5Spades.png");
ImageIcon card4S= new ImageIcon("Images/4Spades.png");
ImageIcon card3S= new ImageIcon("Images/3Spades.png");
ImageIcon card2S= new ImageIcon("Images/2Spades.png");
ImageIcon cardAS= new ImageIcon("Images/AceSpades.png");

ImageIcon cardKC= new ImageIcon("Images/KingClubs.png");
ImageIcon cardQC= new ImageIcon("Images/QueenClubs.png");
ImageIcon cardJC= new ImageIcon("Images/JackClubs.png");
ImageIcon card10C= new ImageIcon("Images/10Clubs.png");
ImageIcon card9C= new ImageIcon("Images/9Clubs.png");
ImageIcon card8C= new ImageIcon("Images/8Clubs.png");
ImageIcon card7C= new ImageIcon("Images/7Clubs.png");
ImageIcon card6C= new ImageIcon("Images/6Clubs.png");
ImageIcon card5C= new ImageIcon("Images/5Clubs.png");
ImageIcon card4C= new ImageIcon("Images/4Clubs.png");
ImageIcon card3C= new ImageIcon("Images/3Clubs.png");
ImageIcon card2C= new ImageIcon("Images/2Clubs.png");
ImageIcon cardAC= new ImageIcon("Images/AceClubs.png");

ImageIcon cardKH= new ImageIcon("Images/KingHearts.png");
ImageIcon cardQH= new ImageIcon("Images/QueenHearts.png");
ImageIcon cardJH= new ImageIcon("Images/JackHearts.png");
ImageIcon card10H= new ImageIcon("Images/10Hearts.png");
ImageIcon card9H= new ImageIcon("Images/9Hearts.png");
ImageIcon card8H= new ImageIcon("Images/8Hearts.png");
ImageIcon card7H= new ImageIcon("Images/7Hearts.png");
ImageIcon card6H= new ImageIcon("Images/6Hearts.png");
ImageIcon card5H= new ImageIcon("Images/5Hearts.png");
ImageIcon card4H= new ImageIcon("Images/4Hearts.png");
ImageIcon card3H= new ImageIcon("Images/3Hearts.png");
ImageIcon card2H= new ImageIcon("Images/2Hearts.png");
ImageIcon cardAH= new ImageIcon("Images/AceHearts.png");

ImageIcon cardKD= new ImageIcon("Images/KingDiamonds.png");
ImageIcon cardQD= new ImageIcon("Images/QueenDiamonds.png");
ImageIcon cardJD= new ImageIcon("Images/JackDiamonds.png");
ImageIcon card10D= new ImageIcon("Images/10Diamonds.png");
ImageIcon card9D= new ImageIcon("Images/9Diamonds.png");
ImageIcon card8D= new ImageIcon("Images/8Diamonds.png");
ImageIcon card7D= new ImageIcon("Images/7Diamonds.png");
ImageIcon card6D= new ImageIcon("Images/6Diamonds.png");
ImageIcon card5D= new ImageIcon("Images/5Diamonds.png");
ImageIcon card4D= new ImageIcon("Images/4Diamonds.png");
ImageIcon card3D= new ImageIcon("Images/3Diamonds.png");
ImageIcon card2D= new ImageIcon("Images/2Diamonds.png");
ImageIcon cardAD= new ImageIcon("Images/AceDiamonds.png");

ImageIcon advert;
int[] adArray = new int[] {1,1,2,3,3,3};

JPasswordField passwordField;
JTable leaderBoard, table, table2, table3;
JTable friendsList;
String[] headers = {"Position","Name", "Score"};
String[] friendHeaders = {"Friends"};
int numbOfrows = 10;
JTableHeader friendsTableHeader, header;
swingBlackJack5 superswing = new swingBlackJack5();





//Networking
private ObjectInputStream sInput;		// to read from the socket
private ObjectOutputStream sOutput;		// to write on the socket
private Socket socket;
public boolean updating;
public String username = "Anonymous";
public int playerNumber;
//private String server;
//private int server;
private int port = 1500;
public String CurrentMessage;
public String userName ="Anonymous";
int portNumber = 1500;
String serverAddress = "localhost";//hardcoded in for now
private String server = "localhost";//hardcoded in for now
//Client client;
//superswing.numberOfPlayers=0;

//Database querying
databaseQuerying queryObject = new databaseQuerying();


public boolean ConnectToServer() //Connection Method
{
	try {
		socket = new Socket(server, port);
	}
	// if it failed not much I can so
	catch(Exception ec) {
		display("Error connectiong to server:" + ec);
		return false;
	}
	String msg = "Connection accepted " + socket.getInetAddress() + ":" + socket.getPort();
	display(msg);
	try
	{
		sInput  = new ObjectInputStream(socket.getInputStream());
		sOutput = new ObjectOutputStream(socket.getOutputStream());
	}
	catch (IOException eIO) {
		display("Exception creating new Input/output Streams: " + eIO);
		return false;
	}
	new ListenFromServer().start();
	try
	{
		sOutput.writeObject(username);
	}
	catch (IOException eIO) {
		display("Exception doing login : " + eIO);
		disconnect();
		return false;
	}



	return true;



}

private void display(String msg) {

		System.out.println(msg);      // println in console mode

}
void sendMessage(ChatMessage msg) {


	try {
		sOutput.writeObject(msg);
	}
	catch(IOException e) {
		display("Exception writing to server: " + e);
	}
}
private void disconnect() {
	try {
		if(sInput != null) sInput.close();
	}
	catch(Exception e) {}
	try {
		if(sOutput != null) sOutput.close();
	}
	catch(Exception e) {}
    try{
		if(socket != null) socket.close();
	}
	catch(Exception e) {}
}
class ListenFromServer extends Thread {

	public void run() {
		while(true) {
			try {
				String msg = (String) sInput.readObject();

				// if console mode print the message and add back the prompt


					CurrentMessage=msg;

					updating = false;



				if (msg.startsWith("C")){
					MatchCards(msg);
				}
				else if (msg.startsWith("X")){
					//ConsoleOutput.setText(msg.substring(1));
				}


				else{
					ConsoleOutput.setText(msg);
				}
			}
			catch(IOException e) {
				display("Server has close the connection: " + e);

				break;
			}
			catch(ClassNotFoundException e2) {
			}
		}
	}
}

public void ScanForChange(){
Scanner scan = new Scanner(System.in);
while(true) {
	String msg = scan.nextLine();


	}
}








public void logoPanel() //Logo panel constructor
{
logoPanel = new JPanel(new BorderLayout());
logoPanel.setPreferredSize(new Dimension(810, 100));
logoPanel.setBackground(Color.yellow);
ImageIcon icon = new ImageIcon("logo.png");
logo = new JLabel(icon);
logoPanel.add(logo);
getContentPane().add(logoPanel, BorderLayout.NORTH);
}

public void adPanel() //Ad panel constructor
{
adPanel = new JPanel(new BorderLayout());
adPanel.setPreferredSize(new Dimension(810, 50));
adPanel.setBackground(Color.yellow);
int rnd = new Random().nextInt(adArray.length);
if (adArray[rnd] ==1)
{
    advert = new ImageIcon("ad.png");
}
if (adArray[rnd] ==2)
{
    advert = new ImageIcon("ad2.png");
}
if (adArray[rnd] ==3)
{
    advert = new ImageIcon("ad3.png");
}
adv = new JLabel(advert);
adPanel.add(adv);
getContentPane().add(adPanel, BorderLayout.SOUTH);
}

public void Card1Constructor(JPanel card1) //Card1 constructor
{
loginTitle = new TitledBorder("Login");
userNameLabel = new JLabel("USERNAME:");
userNameLabel.setFont(new Font("WhipSmart", Font.BOLD, 28));
userNameLabel.setForeground(Color.white);
passwordLabel = new JLabel("PASSWORD:");
passwordLabel.setFont(new Font("WhipSmart", Font.BOLD, 28));
passwordLabel.setForeground(Color.white);
userNameField = new JTextField(25);
passwordField = new JPasswordField(25);
userNameField.setPreferredSize(new Dimension(0,28));
passwordField.setPreferredSize(new Dimension(0,28));
submitLogin = new JButton("SUBMIT");
register = new JButton("Register");
register.addActionListener(this);
submitLogin.addActionListener(this);
card1.setBorder(loginTitle);
card1.setBackground(Color.red);
card1.add(userNameLabel,"cell 0 0");
card1.add(userNameField, "cell 1 0");
card1.add(passwordLabel,"cell 0 1");
card1.add(passwordField,"cell 1 1");
card1.add(submitLogin, "cell 0 2");
card1.add(register, "cell 1 2");
}

public void Card2Constructor(JPanel card2) //Card2 constructor
{
registerTitle = new TitledBorder("Registeration Page");
registerTitle.setTitleColor(Color.white);
fName = new JLabel("First Name:");
lName = new JLabel("Surename:");
dOB = new JLabel("Age:");
aLine1 = new JLabel("Address Line 1:");
aLine2 = new JLabel("Address Line 2:");
city = new JLabel("City:");
postCode = new JLabel("Post Code:");
eMail = new JLabel("E-Mail Address:");
cUsername = new JLabel("Choose Username:");
cPassword = new JLabel("Choose Password:");
fNameF = new JTextField(25);
lNameF = new JTextField(25);
dOBF = new JTextField(25);
aLine1F = new JTextField(25);
aLine2F = new JTextField(25);
cityF = new JTextField(25);
postCodeF = new JTextField(25);
eMailF = new JTextField(25);
cUsernameF = new JTextField(25);
cPasswordF = new JTextField(25);
submitRegister = new JButton("SUBMIT REGISTERATION");
registerBack = new JButton("Back to Login");
registerBack.addActionListener(this);
submitRegister.addActionListener(this);
card2.setBorder(registerTitle);
card2.setBackground(Color.red);
card2.add(fName, "cell 1 1");
card2.add(fNameF, "cell 2 1");
card2.add(lName, "cell 1 2");
card2.add(lNameF, "cell 2 2");
card2.add(dOB, "cell 1 3");
card2.add(dOBF, "cell 2 3");
card2.add(aLine1, "cell 1 4");
card2.add(aLine1F, "cell 2 4");
card2.add(aLine2, "cell 1 5");
card2.add(aLine2F, "cell 2 5");
card2.add(city, "cell 1 6");
card2.add(cityF, "cell 2 6");
card2.add(postCode, "cell 1 7");
card2.add(postCodeF, "cell 2 7");
card2.add(eMail, "cell 1 8");
card2.add(eMailF, "cell 2 8");
card2.add(cUsername, "cell 1 9");
card2.add(cUsernameF, "cell 2 9");
card2.add(cPassword,"cell 1 10");
card2.add(cPasswordF, "cell 2 10");
card2.add(registerBack,"cell 0 0");
card2.add(submitRegister, "cell 2 11");
}



public void Card3Constructor(JPanel card3) //Card3 constructor
{
welcomeTitle = new TitledBorder("Main Page");
welcomeTitle.setTitleColor(Color.white);

welcomeLabel = new JLabel ("Welcome Back");

viewProfileB = new JButton ("View Profile");
viewProfileB.setPreferredSize(new Dimension(200, 100));
gamesB = new JButton("Games");
gamesB.setPreferredSize(new Dimension(200, 100));
leagueStatB = new JButton("League Statistics");
leagueStatB.setPreferredSize(new Dimension(200, 100));
customB = new JButton("Custom Settings");
customB.setPreferredSize(new Dimension(200, 100));
logoutB = new JButton("Logout");
logoutB.setPreferredSize(new Dimension(200, 100));
ppvB = new JButton("Purchase Premium Version");
ppvB.setPreferredSize(new Dimension(200, 100));
findFriend = new JButton("Find Friends");
findFriend.setPreferredSize(new Dimension(200, 100));

DefaultTableModel model = new DefaultTableModel(numbOfrows, headers.length) ;
model.setColumnIdentifiers(headers);


leaderBoard = new JTable(model);
JScrollPane scroll = new JScrollPane(leaderBoard);


ppvB.addActionListener(this);
leagueStatB.addActionListener(this);
gamesB.addActionListener(this);
viewProfileB.addActionListener(this);
customB.addActionListener(this);
logoutB.addActionListener(this);
findFriend.addActionListener(this);


card3.setBorder(welcomeTitle);
card3.setBackground(Color.red);

//welcomeLabel, viewProfileB, gamesB, leagueStatB, customB, logoutB, ppvB

card3.add(welcomeLabel, "cell 0 0");
card3.add(viewProfileB,"cell 1 4" );
card3.add(gamesB,"cell 1 1" );
card3.add(leagueStatB, "cell 1 3");
card3.add(logoutB,"cell 1 6");
card3.add(ppvB, "cell 1 2");
card3.add(findFriend, "cell 1 5");



}


public void Card4Constructor(JPanel card4) //Card3 constructor
{
viewProfileTitle = new TitledBorder("View Profile");
viewProfileTitle.setTitleColor(Color.white);
viewProfileUserName = new JTextField(15);
viewProfileAge = new JTextField(15);
viewProfileLocation = new JTextField(15);
viewProfileBio = new JTextField(15);
vPBack = new JButton("Home Page");
vPEdit = new JButton("Edit Profile");
vPFindFriends = new JButton("Find Friends");

vPBack.addActionListener(this);
vPEdit.addActionListener(this);
vPFindFriends.addActionListener(this);


        card4.setBorder(viewProfileTitle);
        card4.setBackground(Color.red);

        card4.add(viewProfileUserName, "cell 1 1");
        card4.add(viewProfileAge, "cell 1 2");
        card4.add(viewProfileLocation, "cell 1 3");
        card4.add(viewProfileBio, "cell 1 4");
        card4.add(vPBack, "cell 0 6");
        card4.add(vPEdit, "cell 0 0");
        card4.add(vPFindFriends, "cell 2 6");



}
public void Card5Constructor(JPanel card5) //Card3 constructor
{
JLabel ePuserNameLabel, ePAgeLabel, ePLocationLabel, ePBioLabel, ePPasswordLabel;
JTextField ePUsernameTF, ePAgeTF, ePLocationTF, ePBioTF, ePPasswordTF;
		ePuserNameLabel = new JLabel("Username");
		ePUsernameTF = new JTextField(15);
		ePAgeLabel = new JLabel("Age");
		ePAgeTF = new JTextField(15);
		ePLocationLabel = new JLabel("Location");
		ePLocationTF = new JTextField(15);
		ePBioLabel = new JLabel("Bio");
		ePBioTF = new JTextField(15);
		ePPasswordLabel = new JLabel("Password");
		ePPasswordTF = new JTextField(15);
		ePBackB = new JButton("Back");
		ePSubmitB = new JButton("Submit");


ePBackB.addActionListener(this);
ePSubmitB.addActionListener(this);


		card5.add(ePuserNameLabel);
		card5.add(ePUsernameTF);
		card5.add(ePAgeLabel);
		card5.add(ePAgeTF);
		card5.add(ePLocationLabel);
		card5.add(ePLocationTF);
		card5.add(ePBioLabel);
		card5.add(ePBioTF);
		card5.add(ePPasswordLabel);
		card5.add(ePPasswordTF);
		card5.add(ePBackB);
		card5.add(ePSubmitB);



}

public void Card6Constructor(JPanel card6) //Card6 constructor
{

String friendsData[][] = {
	{"User1991"}
};
friendTitle = new TitledBorder("Find Friends");
friendTitle.setTitleColor(Color.white);
friendLabel = new JLabel ("Find Friends");
findFriendBack = new JButton("Back");
friendsList = new JTable(friendsData, friendHeaders);
friendsTableHeader = friendsList.getTableHeader();
friendsTableHeader.setBackground(Color.yellow);
JScrollPane friendPane = new JScrollPane(friendsList);
friendsList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
friendsList.getColumnModel().getColumn(0).setPreferredWidth(100);
friendUsername = new JLabel ("Enter Username: ");
friendUsernameF = new JTextField(25);
friendsSubmit = new JButton("Submit");

friendsSubmit.addActionListener(this);

card6.setBorder(friendTitle);
card6.setBackground(Color.red);

card6.add(friendLabel, "growx, wrap");
card6.add(friendsList, "growx");
card6.add(friendUsername, "growx");
card6.add(friendUsernameF, "growx, wrap");
card6.add(findFriendBack, "growx");
card6.add(friendsSubmit, "growx, wrap");



}

public void Card7Constructor(JPanel card7) //Card7 constructor
{
gameMenuTitle = new TitledBorder("Game Menu");
gameMenuTitle.setTitleColor(Color.white);
gamesMenuLabel = new JLabel ("Games Menu");
blackjack = new JButton("Blackjack");
blackjack.setPreferredSize(new Dimension(200, 100));
texas = new JButton("Texas Hold 'Em");
texas.setPreferredSize(new Dimension(200, 100));
createAGame = new JButton("Create A Game");
createAGame.setPreferredSize(new Dimension(200, 100));
newLeague = new JButton("New League");
newLeague.setPreferredSize(new Dimension(200, 100));
gamesBack = new JButton("Home Page");
gamesBack.setPreferredSize(new Dimension(200, 100));

blackjack.addActionListener(this);
texas.addActionListener(this);
createAGame.addActionListener(this);
newLeague.addActionListener(this);
gamesBack.addActionListener(this);

card7.setBorder(gameMenuTitle);
card7.setBackground(Color.red);

card7.add(gamesMenuLabel, "cell 0 0");
card7.add(blackjack, "cell 1 4");
card7.add(texas, "cell 1 1");
card7.add(createAGame, "cell 1 3");
card7.add(newLeague, "cell 1 6");
card7.add(gamesBack, "cell 1 2");



}

public void Card8Constructor(JPanel card8) //Card8 constructor
{
pokerTitle = new TitledBorder("Poker Table");
pokerTitle.setTitleColor(Color.white);
pokerHelpB = new JButton("Help");
pokerCall = new JButton("Call");
pokerCheck = new JButton("Check");
pokerRaise = new JButton("Raise");
pokerFold = new JButton("Fold");
pokerBack = new JButton("ExitGame");

DefaultTableModel model = new DefaultTableModel(numbOfrows, headers.length) ;
model.setColumnIdentifiers(headers);


leaderBoard = new JTable(model);
JScrollPane scroll = new JScrollPane(leaderBoard);

pokerHelpB.addActionListener(this);
pokerCall.addActionListener(this);
pokerCheck.addActionListener(this);
pokerRaise.addActionListener(this);
pokerFold.addActionListener(this);
pokerBack.addActionListener(this);


card8.setBorder(pokerTitle);
card8.setBackground(Color.red);

card8.add(pokerHelpB, "growx, wrap");
card8.add(pokerCall, "growx");
card8.add(pokerCheck, "growx");
card8.add(pokerRaise, "growx");
card8.add(pokerFold,"growx, wrap");
card8.add(pokerBack, "growx, wrap");


}


public void Card9Constructor(JPanel card9) //Card9 constructor
{

blackjackTitle = new TitledBorder("Blackjack Table");
blackjackTitle.setTitleColor(Color.white);



card9.setBorder(blackjackTitle);
card9.setBackground(Color.white);


blackjackBack = new JButton("Exit Game");
blackjackHit = new JButton("Hit  ");
blackjackStick = new JButton("Stick");
blackjackDeal = new JButton("Deal ");
blackjackRefresh2 = new JButton("Refresh");
ConsoleOutput = new JTextArea();
UserInstructions = new JTextArea();
scrollPane = new JScrollPane(ConsoleOutput);

UserInstructions.setPreferredSize(new Dimension(250,10));
scrollPane.setPreferredSize(new Dimension(250, 300));
ConsoleOutput.setEditable(false);
UserInstructions.setEditable(false);
ConsoleOutput.setText("Console Output");
UserInstructions.setText("User Instructions");

blackjackHit.setVisible(true);
blackjackStick.setVisible(true);
blackjackDeal.setVisible(true);
blackjackRefresh2.setVisible(true);

blackjackDeal.addActionListener(this);
blackjackHit.addActionListener(this);
blackjackStick.addActionListener(this);
blackjackRefresh2.addActionListener(this);
blackjackBack.addActionListener(this);

card9.add(scrollPane, "growx, wrap 5");
card9.add(blackjackBack, "growx");
//card9.add(ConsoleOutput, "growx");
card9.add(blackjackDeal, "growx, wrap");
card9.add(blackjackHit, "growx");
card9.add(blackjackStick, "growx, wrap");
card9.add(blackjackRefresh2, "growx");
card9.add(UserInstructions, "growx, wrap");


cardPanel = new JPanel(new MigLayout("wrap 6","[70!]","[40!]"));
cardPanel.setPreferredSize(new Dimension(50, 200));
cardPanel.setBackground(Color.green);




card1shell = new JLabel(cardBlank);
card2shell = new JLabel(cardBlank);
card3shell = new JLabel(cardBlank);
card4shell = new JLabel(cardBlank);
card5shell = new JLabel(cardBlank);
card6shell = new JLabel(cardBlank);


cardPanel.add(card1shell);
cardPanel.add(card2shell);
cardPanel.add(card3shell);
cardPanel.add(card4shell);
cardPanel.add(card5shell);
cardPanel.add(card6shell);

//JPanel card9 = new JPanel(new MigLayout("wrap 5", "10[]790[]50[]50[]", "[50!]"));

card9.add(cardPanel, "growx");


}

        //Add a panel or similar element that can have images of cards added/removed from it on request from the server. When the game card values are parsed for each user.
        //TODOLIST

        //Individual username to be added to top of screen, possibly on all screens once logged in successfully, saying "welcome: user"
        //Then game networking needs to be updated so that particular users are shown their cards, game chat can be done and a list of who is in each game can be created.
        //TODOLIST



public void Card10Constructor(JPanel card10) //Card10 constructor
{
HomeB8 = new JButton("Home");
//border title
gameTitle = new TitledBorder("Create a Game");
gameTitle.setTitleColor(Color.white);

// add in menu buttons

PokerB = new JButton("Poker");
BJB = new JButton("BlackJack");

PokerB.addActionListener(this);
BJB.addActionListener(this);


card10.setBorder(gameTitle);

// Insert Game Menu
card10.add(BJB, "cell 1 5");
card10.add(PokerB, "cell 1 3");

card10.add(HomeB8, "cell 1 9");

card10.setBackground(Color.red);



}



public void Card11Constructor(JPanel card11) //Card11 constructor
{

helpPageTitle = new TitledBorder("Help Page");
helpPageTitle.setTitleColor(Color.white);
helpPageLabel = new JLabel("Help Page");
blackjackLabel = new JLabel("Blackjack");
blackjackRules = new JLabel("Rules: ");
blackjackRulesBox = new JTextField(100);
blackjackControls = new JLabel("Controls: ");
blackjackControlsBox = new JTextField(50);
pokerLabel = new JLabel("Poker");
pokerRules = new JLabel("Rules: ");
pokerRulesBox = new JTextField(100);
pokerControls = new JLabel("Controls: ");
pokerControlsBox = new JTextField(50);
helpBack = new JButton("Back");

helpBack.addActionListener(this);


card11.setBorder(helpPageTitle);
card11.setBackground(Color.red);

card11.add(blackjackLabel, "growx, wrap");
card11.add(blackjackRules, "growx");
card11.add(blackjackRulesBox, "growx, wrap");
card11.add(blackjackControls, "growx");
card11.add(blackjackControlsBox, "growx, wrap");
card11.add(pokerLabel, "growx, wrap");
card11.add(pokerRules, "growx");
card11.add(pokerRulesBox, "growx, wrap");
card11.add(pokerControls, "growx");
card11.add(pokerControlsBox, "growx, wrap");
card11.add(helpBack, "growx");


}



public void Card12Constructor(JPanel card12) //Card3 constructor
{

cLeagueTitle = new TitledBorder("Create a League");
cLeagueTitle.setTitleColor(Color.white);
HomeB9 = new JButton("Home");

String data2[][] = {
           {"001","Replace"},
           {"002","with"},
           {"003","Names"},
           {"004","From"},
           {"005","the"},
           {"006","Database"},
           {"picture","Name"},
           {"picture","Name"},
           {"picture","Name"},
           {"picture","Name"}
           };
          String col2[] = {"Picture","Name"};
          table2 = new JTable(data2,col2);
          header = table2.getTableHeader();
          header.setBackground(Color.yellow);
          JScrollPane pane2 = new JScrollPane(table2);
          table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
          table2.getColumnModel().getColumn(0).setPreferredWidth(100);
          table2.getColumnModel().getColumn(1).setPreferredWidth(310);



//name of the League
LeagueNameField = new JTextField(15);
leagueNameLabel = new JLabel("League Name:");

//name of the League
GameSelectorLabel = new JLabel("Select a Game:");
String[] GameStrings = { "This", "is", "Example", "Data", "Please", "Replace" };
GameList = new JComboBox(GameStrings);
GameList.setSelectedIndex(0);

String data3[][] = {
           {"001","Replace"},
           {"002","with"},
           {"003","Names"},
           {"004","From"},
           {"005","the"},
           {"006","Database"},
           {"007","Name"},
           {"008","Name"},
           };
          String col3[] = {"Position","Name"};
          table3 = new JTable(data3,col3);
          header = table3.getTableHeader();
          header.setBackground(Color.yellow);
          JScrollPane pane3 = new JScrollPane(table3);
          table3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
          table3.getColumnModel().getColumn(0).setPreferredWidth(50);
          table3.getColumnModel().getColumn(1).setPreferredWidth(100);



SubmitLea = new JButton("Submit");

HomeB9.addActionListener(this);


card12.setBorder(cLeagueTitle);


card12.add(leagueNameLabel, "cell 5 1 ");
card12.add(LeagueNameField, "cell 6 1 ");
card12.add(pane2, "cell 5 5 2 1");
card12.add(GameSelectorLabel, "cell 5 2 ");
card12.add(GameList, "cell 6 2 ");
card12.add(SubmitLea, "cell 8 9");
card12.add(HomeB9, "cell 1 9");
card12.setBackground(Color.red);


}

public void Card13Constructor(JPanel card13) //Card3 constructor
{

HomeB7 = new JButton("Home");

vLeagueTitle = new TitledBorder("View League Statistics");
vLeagueTitle.setTitleColor(Color.white);

ChooseLeaLabel = new JLabel("Choose a League:");

String[] LeagueStrings = { "This", "is", "Example", "Data", "Please", "Replace" };
LeagueList = new JComboBox(LeagueStrings);
LeagueList.setSelectedIndex(0);



String data[][] = {
           {"001","Replace"},
           {"002","with"},
           {"003","Names"},
           {"004","From"},
           {"005","the"},
           {"006","Database"},
           {"picture","Name"},
           {"picture","Name"},
           {"picture","Name"},
           {"picture","Name"}
           };
          String col[] = {"Picture","Name"};
          table = new JTable(data,col);
          header = table.getTableHeader();
          header.setBackground(Color.yellow);
          JScrollPane pane = new JScrollPane(table);
          table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
          table.getColumnModel().getColumn(0).setPreferredWidth(100);
          table.getColumnModel().getColumn(1).setPreferredWidth(310);

          createLeaB = new JButton ("Create League");

HomeB7.addActionListener(this);


card13.setBorder(vLeagueTitle);

card13.add(ChooseLeaLabel, "split 2");
card13.add(LeagueList);
JScrollPane pane3 = new JScrollPane(table3);
card13.add(pane, "cell 0 5");
card13.add(pane3, "cell 5 2 2 7");
card13.add(createLeaB, "cell 8 9");

card13.add(HomeB8, "cell 1 9");
card13.setBackground(Color.red);



}
/*
public void Card14Constructor(JPanel card14) //Card3 constructor
{//BlackJack
gameTitleBJ = new TitledBorder("Create a Game of Black Jack");
gameTitle.setTitleColor(Color.white);
//name of the game
gameNameFieldBJ = new JTextField(10);
gameNameLabelBJ = new JLabel("Game Name:");
String[] LeagueStrings = { "This", "is", "Example", "Data", "Please", "Replace" };
//submit button
submitBj = new JButton ("Submit");

//max players (dropdown)
String[] PNumBJ = { "2", "3", "4", "5", "6", "7", "8", "9" };
maxPlayersselectBJ = new JComboBox(LeagueStrings);
maxPlayersselectBJ.setSelectedIndex(0);
maxPlayersLabelBJ = new JLabel("Maximum Number of Players:");

//Dealer Stick Number
String[] RoundsBJ = { "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21" };
NumOfRoundsBJ = new JComboBox(LeagueStrings);
NumOfRoundsBJ.setSelectedIndex(0);
NumOfRoundsLabelBJ = new JLabel("Dealers Minimum Sticking Point");

//How many rounds (dropdown)
String[] BJstickNum = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
StickNumBJ = new JComboBox(LeagueStrings);
StickNumBJ.setSelectedIndex(0);
StickNumLabelBJ = new JLabel("How Many Rounds:");

//Starting Credits
StartCredFieldBJ = new JTextField(10);
StartCredLabelBJ = new JLabel("Starting Credits:");

//min bet
MinBetFieldBJ = new JTextField(10);
MinBetLabelBJ = new JLabel("Minimum Bet:");

//max bet
MaxBetFieldBJ = new JTextField(10);
MaxBetLabelBJ = new JLabel("Maximum Bet:");

//back
BackBj = new JButton ("Back");

//BackBJ.addActionListener(this);

card14.setBorder(gameTitleP);
//game name
card14.add(gameNameLabelP, "cell 4 2 ");
card14.add(gameNameFieldP, "cell 5 2 2 1");

//max players
card14.add(maxPlayersLabel, "cell 4 3");
card14.add(maxPlayersselectP, "cell 5 3 2 1");

//Small Bind
card14.add(SbindLabelP, "cell 4 4");
card14.add(SbindFieldP, "cell 5 4 2 1");

//Big Bind
card14.add(BbindLabelP, "cell 4 5");
card14.add(BbindFieldP, "cell 5 5 2 1");


//How many Rounds (dropdown)
card14.add(NumOfRoundsPLabel, "cell 4 6");
card14.add(NumOfRoundsP, "cell 5 6 2 1");


//number of cards per hand (dropdown)
card14.add(cardHandLabel, "cell 4 7");
card14.add(cardHandP, "cell 5 7 2 1");


//number of dealt to board (dropdown)
card14.add(boardcardsLabel, "cell 4 8");
card14.add(BoardHandP, "cell 5 8 2 1");

card14.add(submitB, "cell 9 10");

card14.add(BackP, "cell 1 10");
card14.setBackground(Color.red);

}

public void Card15Constructor(JPanel card15) //Card3 constructor
{

gameTitleP = new TitledBorder("Create a Game of Poker");
gameTitle.setTitleColor(Color.white);
String[] LeagueStrings = { "This", "is", "Example", "Data", "Please", "Replace" };
//name of the game
gameNameFieldP = new JTextField(10);
gameNameLabelP = new JLabel("Game Name:");

//submit button
submitB = new JButton ("Submit");

//max players (dropdown?)

String[] PNumPoker = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
maxPlayersselectP = new JComboBox(LeagueStrings);
maxPlayersselectP.setSelectedIndex(0);
maxPlayersLabel = new JLabel("Maximum Number of Players:");

// Small Bind
SbindFieldP = new JTextField(10);
SbindLabelP = new JLabel("Small Bind:");
//Big Bind
BbindFieldP = new JTextField(10);
BbindLabelP = new JLabel("Big Bind:");

//How many Rounds (dropdown)
String[] RoundPoker = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
NumOfRoundsP = new JComboBox(LeagueStrings);
NumOfRoundsP.setSelectedIndex(0);
NumOfRoundsPLabel = new JLabel("How Many Rounds:");

//number of cards per hand (dropdown)
String[] HandPoker = { "1", "2", "3"};
cardHandP = new JComboBox(LeagueStrings);
cardHandP.setSelectedIndex(0);
cardHandLabel = new JLabel("Amount of cards Dealt to each Player:");

//number of dealt to board (dropdown)
String[] BoardPoker = { "1", "2", "3"};
BoardHandP = new JComboBox(LeagueStrings);
BoardHandP.setSelectedIndex(0);
boardcardsLabel = new JLabel("Amount of cards Dealt to the Board:");

//back
BackP = new JButton ("Back");

submitB.addActionListener(this);


card15.setBorder(gameTitleBJ);

card15.add(gameNameLabelBJ, "cell 4 2 ");
card15.add(gameNameFieldBJ, "cell 5 2 2 1");

//max players
card15.add(maxPlayersLabelBJ, "cell 4 3");
card15.add(maxPlayersselectBJ, "cell 5 3 2 1");

//Dealer Stick Number
card15.add(NumOfRoundsLabelBJ, "cell 4 4");
card15.add(NumOfRoundsBJ, "cell 5 4 2 1");

//How many rounds (dropdown)
card15.add(StickNumLabelBJ, "cell 4 5");
card15.add(StickNumBJ, "cell 5 5 2 1");

//Starting Credits
card15.add(StartCredLabelBJ, "cell 4 6");
card15.add(StartCredFieldBJ, "cell 5 6 2 1");

//min bet
card15.add(MinBetLabelBJ, "cell 4 7");
card15.add(MinBetFieldBJ, "cell 5 7 2 1");


//max bet
card15.add(MaxBetLabelBJ, "cell 4 8");
card15.add(MaxBetFieldBJ, "cell 5 8 2 1");


card15.add(submitBj, "cell 9 10");
card15.add(BackBj, "cell 1 10");

card15.setBackground(Color.red);


}
*/


// These cards have been broken since I got them and give errors when compiled with a constructor. Anyone on frontend know about it?
// TODOLIST

    //working constructor with a list box of instances of game types needs to be created. Generally, just make a front-end screen with the logo, some join/back buttons and a listbox so that it can be accessed and Then the networking code can be hooked up to it, rather than everyone joining just one blackjack game.
    //TODOLIST

    //Method for creating games. Reminder to use "new superswing" with a unique id, but use superswing as a variable and change it depending on use.
    //TODOLIST

    //Method for joining particular game lobbies. Reminder to parse game choices into listbox then increment player count on that game and rejoin users.
    //TODOLIST


public void Card17Constructor(JPanel card17) // Card17 constructor ****
{

card17.setBackground(Color.red);
TitledBorder gLobby = new TitledBorder("G Lobby");
card17.setBorder(gLobby);
gLobby.setTitleColor(Color.white);



String[] columnNames = {"Game",
                        "Players",
                        "Extras"}; //**
Object[][] data = {
                                    {"BlackJack", "2-4 Players", "None"},
                                    {"Texas Hold em", "4-6 Players", "None"},
                                    {"Hearts", "2-5 Players", "None"},
                                    {"Solatire", "1-2 Players", "None"}
                                    };      //**

JTable lobbyTable = new JTable(data, columnNames);
lobbyTable.setFont(new Font("Serif", Font.BOLD, 20));
lobbyTable.setMinimumSize(new Dimension(400,200));


selectlogoImage  = new JLabel("Please Select your desired logo: ");
chooseGame = new JLabel("Please Select Game: ");

logoImage1 = new ImageIcon("kiss.jpeg");
logoImage2 = new ImageIcon("kiss.jpeg");
logoImage3 = new ImageIcon("kiss.jpeg");
logoImage4 = new ImageIcon("kiss.jpeg");
logoImage5 = new ImageIcon("kiss.jpeg");

logoImageB1 = new JButton(logoImage1);

logoImageB2 = new JButton(logoImage2);
logoImageB3 = new JButton(logoImage3);
logoImageB4 = new JButton(logoImage4);
logoImageB5 = new JButton(logoImage5);

lobbySubmit = new JButton("Submit");
lobbyBack = new JButton("Back");

card17.add(selectlogoImage, "cell 0 0 2 1");
card17.add(logoImageB1,  "cell 0 1");
card17.add(logoImageB2,  "cell 1 1 ");
card17.add(logoImageB3,  "cell 2 1 ");
card17.add(logoImageB4,  "cell 3 1 ");
card17.add(logoImageB5,  "cell 4 1 ");
card17.add(chooseGame,   "cell 0 2 ");
card17.add(new JScrollPane(lobbyTable), "cell 0 4 8 2");

card17.add(lobbyBack, "cell 0 6");
card17.add(lobbySubmit, "cell 1 6");

lobbySubmit.addActionListener(this);
lobbyBack.addActionListener(this);


}

public onlineGame5() //This is the CONSTRUCTOR method
{



//The entry point into your program
setLayout(new BorderLayout()); //Use this for now.
setSize(810, 690); //Set the size of the JFrame
setTitle("Generic Online Card Game"); //Put Title on top of JFrame
getContentPane().setBackground(Color.black);
setResizable(false);


//LOGO PANEL
logoPanel();


cards = new JPanel(new CardLayout());
cards.setPreferredSize(new Dimension(810, 500));

JPanel card1 = new JPanel(new MigLayout(         "",           // Layout Constraints
          "130[]20[]80",   // Column constraints
          "100[]20[]20[]50"));
JPanel card2 = new JPanel(new MigLayout(         "",           // Layout Constraints
          "20[]130[]20[]100",   // Column constraints
          "20[]20[]20[]20[]20[]20[]20[]20[]20[]20[]20[]20[]20"));
JPanel card3 = new JPanel(new MigLayout(         "",           // Layout Constraints
          "20[]180[]100",   // Column constraints
          "20[]20[]20[]20[]20[]20[]20[]20"));
JPanel card4 = new JPanel(new MigLayout(         "",           // Layout Constraints
          "20[]20[]250[]",   // Column constraints
          "20[]30[]20[]20[]20[]20[]200[]20"));
JPanel card5 = new JPanel(new MigLayout());
JPanel card6 = new JPanel(new MigLayout("wrap 5", "[200!]", "[50!]"));
JPanel card7 = new JPanel(new MigLayout(         "",           // Layout Constraints
          "20[]180[]100",   // Column constraints
          "20[]20[]20[]20[]20[]20[]20[]20"));
JPanel card8 = new JPanel(new MigLayout("wrap 5", "[200!]", "[50!]"));
JPanel card9 = new JPanel(new MigLayout("wrap 1", "[800!]", "[::200]"));

JPanel card10 = new JPanel(new MigLayout(         "",           // Layout Constraints
          "20[]20[]20[]20[]20[]20[]20[]20[]20[]",   // Column constraints
          "[]20[]20[]20[]20[]20[]20[]20[]20[]20[]"));
JPanel card11 = new JPanel(new MigLayout("wrap 5", "[200!]", "[50!]"));
JPanel card12 = new JPanel(new MigLayout(         "",           // Layout Constraints
          "20[]20[]20[]20[]20[]20[]20[]20[]100[]",   // Column constraints
          "[]20[]20[]20[]20[]20[]20[]20[]20[]20[]"));
JPanel card13 = new JPanel(new MigLayout(         "",           // Layout Constraints
          "20[]20[]20[]20[]20[]20[]20[]20[]50[]",   // Column constraints
          "[]20[]20[]20[]20[]20[]20[]20[]20[]20[]"));
JPanel card14 = new JPanel(new MigLayout(         "",           // Layout Constraints
          "20[]20[]20[]20[]20[]20[]20[]20[]20[]",   // Column constraints
          "[]20[]20[]20[]20[]20[]20[]20[]20[]20[]"));
JPanel card15 = new JPanel(new MigLayout(         "",           // Layout Constraints
          "20[]20[]20[]20[]20[]20[]20[]20[]20[]",   // Column constraints
          "[]20[]20[]20[]20[]20[]20[]20[]20[]20[]"));
JPanel card17 = new JPanel(new MigLayout(         "",           // Layout Constraints
          "20[]20[]20[]20[]20[]20[]20[]20[]20[]",   // Column constraints
          "[]20[]20[]20[]20[]20[]20[]20[]20[]20[]"));

setLayout(new BorderLayout()); //Use this for now.
setSize(810, 690); //Set the size of the JFrame
setTitle("Generic Online Card Game"); //Put Title on top of JFrame
getContentPane().setBackground(Color.black);
setResizable(false);

Card1Constructor(card1);
Card2Constructor(card2);
Card3Constructor(card3);
Card4Constructor(card4);
Card5Constructor(card5);
Card6Constructor(card6);
Card7Constructor(card7);
Card8Constructor(card8);
Card9Constructor(card9);
Card10Constructor(card10);
Card11Constructor(card11);
Card12Constructor(card12);
Card13Constructor(card13);
//Card14Constructor(card14);
//Card15Constructor(card15);
Card17Constructor(card17);





cards.add(card1, "login");
cards.add(card2, "register");
cards.add(card3, "welcome");
cards.add(card4, "profile");
cards.add(card5, "edit-profile");
cards.add(card6, "find-friends");
cards.add(card7, "Games");
cards.add(card8, "poker");
cards.add(card9, "blackjackC");
cards.add(card10, "createAgameMenu");
cards.add(card11, "helpPageC");
cards.add(card12, "createAnewLeague");
cards.add(card13, "viewLeague");
//cards.add(card14, "createAgameBlackjack");
//cards.add(card15, "createAgamePoker");
cards.add(card17, "Globby");



//Action Listeners
/*
//register.addActionListener(this);
registerBack.addActionListener(this);
//submitLogin.addActionListener(this);
findFriend.addActionListener(this);
gamesB.addActionListener(this);
findFriendBack.addActionListener(this);
blackjack.addActionListener(this);
texas.addActionListener(this);
createAGame.addActionListener(this);
newLeague.addActionListener(this);
gamesBack.addActionListener(this);
pokerHelpB.addActionListener(this);
pokerCall.addActionListener(this);
pokerCheck.addActionListener(this);
pokerRaise.addActionListener(this);
pokerFold.addActionListener(this);
pokerBack.addActionListener(this);
blackjackHelp.addActionListener(this);
blackjackHit.addActionListener(this);
blackjackStick.addActionListener(this);
blackjackDeal.addActionListener(this);
blackjackBet.addActionListener(this);
blackjackBack.addActionListener(this);
helpBack.addActionListener(this);
leagueStatB.addActionListener(this);
createLeaB.addActionListener(this);
HomeB7.addActionListener(this);
HomeB8.addActionListener(this);
HomeB9.addActionListener(this);
PokerB.addActionListener(this);
BJB.addActionListener(this);
BackP.addActionListener(this);
BackBj.addActionListener(this);
viewProfileB.addActionListener(this);
vPEdit.addActionListener(this);
vPBack.addActionListener(this);
ePBackB.addActionListener(this);
ePSubmitB.addActionListener(this);
logoutB.addActionListener(this);



//Create the panel that contains the "cards".
*/


//getContentPane().add(logoPanel);
getContentPane().add(cards);

setVisible(true); //Make JFrame visible
}

public void layoutmaker(CardLayout layout1, Object eventtype){
CardLayout cardLayout = (CardLayout) cards.getLayout();
	if (eventtype== submitLogin)
	{

	//Currently this connection to server also adds a player to the blackjack game, but this can be easily modified if there is a game lobby screen.
	//Some database entry here to parse the login fields, send them to the mysql server and then allow login is needed. Might make sense to do it in a seperate method similar to "ConnectToServer()".
	//Similarly, an isolated method for connecting to the database server would be useful for server update     s etc.

            //TODOLIST



	if(queryObject.login(userNameField.getText(), passwordField.getText()) == 1)
            {
            	username = userNameField.getText();
                System.out.println("Correct username & password");
                Boolean Attempt =  ConnectToServer();
                if (Attempt == true){
                    cardLayout.show(cards, "welcome");
                }
            }
           	else
            {
            	userNameLabel.setText("INCORRECT USERNAME:");
            	passwordLabel.setText("INCORRECT PASSWORD:");
                System.out.println("Wrong username & password");
            }
	}
	if (eventtype== register){
	cardLayout.show(cards, "register");}
	if (eventtype== submitRegister){


	queryObject.registerPlayer(cUsernameF.getText(), cPasswordF.getText(), eMailF.getText(), Integer.parseInt(dOBF.getText()), 10, cityF.getText());



	cardLayout.show(cards, "login");
	}

	if (eventtype== vPFindFriends){
	cardLayout.show(cards, "find-friends");}

	if (eventtype== newLeague){
	cardLayout.show(cards, "createAnewLeague");}

	if (eventtype== helpBackB){
	cardLayout.show(cards, "blackjackC");}

	if (eventtype== registerBack){
	cardLayout.show(cards, "login");}

	if (eventtype== gamesB){
	cardLayout.show(cards, "Games");}


	if (eventtype== leagueStatB){
	cardLayout.show(cards, "viewLeague");}

	if (eventtype== viewProfileB){
	cardLayout.show(cards, "profile");}

	if (eventtype== logoutB){
	cardLayout.show(cards, "login");}

	if (eventtype== vPEdit){
	cardLayout.show(cards, "edit-profile");}

	if (eventtype== vPBack){
	cardLayout.show(cards, "welcome");}

	if (eventtype== ePBackB){
	cardLayout.show(cards, "profile");}

	if (eventtype== createAGame){
	cardLayout.show(cards, "createAgameMenu");}

	if (eventtype== findFriend){
	cardLayout.show(cards, "find-friends");}

	if (eventtype== findFriendBack){
	cardLayout.show(cards, "welcome");}

	if (eventtype== gamesBack){
    cardLayout.show(cards, "welcome");}

    if (eventtype== blackjack){

    cardLayout.show(cards, "Globby"); }


    if (eventtype== lobbySubmit){

    cardLayout.show(cards, "blackjackC");}

    if (eventtype== lobbyBack){

    cardLayout.show(cards, "Games");
	if (eventtype== blackjackHelp){
	cardLayout.show(cards, "helpPageB");}

	//if (eventtype== findFriendSubmit){
	//"CODE FOR SEARCHING FOR FRIENDS"
	//}
	if (eventtype== gamesBack){
	cardLayout.show(cards, "welcome");}

	if (eventtype== blackjack){

	cardLayout.show(cards, "blackjackC");



	//Networking stuff

	String msg = "New Player has joined the game ";
	sendMessage(new ChatMessage(ChatMessage.MESSAGE, msg, null, 0, 0));
	UpdateState();

	}
	if (eventtype== blackjackStick){
		PlayerStickRequest();

	}

	if (eventtype== blackjackHit){
		PlayerHitRequest();

	}
	if (eventtype== blackjackDeal){
		PlayerDealRequest();

	}


	if (eventtype== blackjackRefresh2){
		UpdateCards();
		//UpdateState();
	}



if (eventtype== texas){
    cardLayout.show(cards, "poker");}

    if (eventtype== pokerBack){
    cardLayout.show(cards, "Games");}

    if (eventtype== pokerHelpB){
    cardLayout.show(cards, "helpPageC");}

    if (eventtype== blackjackHelp){
    cardLayout.show(cards, "helpPageC");}

    if (eventtype== blackjackBack){
    sendMessage(new ChatMessage(ChatMessage.LOGOUT, "", null, 0, 0));
    cardLayout.show(cards, "Games");}

    if (eventtype== HomeB7){
    cardLayout.show(cards, "welcome");}

    if (eventtype== PokerB){
    cardLayout.show(cards, "createAgamePoker");}

    if (eventtype== BJB){
    cardLayout.show(cards, "createAgameBlackjack");}

    if (eventtype== helpBack){
    cardLayout.show(cards, "poker");}

    if (eventtype== HomeB9){
    cardLayout.show(cards, "welcome");}

    if (eventtype== HomeB8){
    cardLayout.show(cards, "welcome");}

    if (eventtype== createLeaB){
    cardLayout.show(cards, "createAnewLeague");}

    if (eventtype== BackBj){
    cardLayout.show(cards, "Games");}

    if (eventtype== BackP){
    cardLayout.show(cards, "Games");}

}
}


	public void PlayerHitRequest(){


	String gamename = "BlackJack";
	sendMessage(new ChatMessage(ChatMessage.CHANGE, username, gamename, 0, 1));
	UpdateState();
	}
	public void PlayerDealRequest(){


	String gamename = "BlackJack";
	sendMessage(new ChatMessage(ChatMessage.CHANGE, username, gamename, 0, 3));
	UpdateState();
	}

	public void PlayerStickRequest(){


	String gamename = "BlackJack";
	sendMessage(new ChatMessage(ChatMessage.CHANGE, username, gamename, 0, 2));
	UpdateState();
	}

	public void UpdateCards(){

	String gamename = "BlackJack";
	sendMessage(new ChatMessage(ChatMessage.DRAW, username, gamename, 0, 0));


	}

	public void MatchCards(String msg){


	int first =3;
	int last = 5;
	int handsize = Integer.parseInt(msg.substring(2,3));
	int position =1;
	int i =0;

	card1shell.setIcon(cardBlank);
	card2shell.setIcon(cardBlank);
	card3shell.setIcon(cardBlank);
	card4shell.setIcon(cardBlank);
	card5shell.setIcon(cardBlank);


	while (i <handsize){
		String value = msg.substring(first,last-1);
		String suit = msg.substring(first+1,last);



		DrawCards(value,suit,position);
		System.out.println(value + suit);

		first = first +3;
		last = last +3;
		position++;
		i++;
	}


	}

	public void DrawCards(String value, String suit, int position){
		if (position == 1){
			DrawCards2(card1shell,value,suit);
		}
		if (position == 2){
			DrawCards2(card2shell,value,suit);
		}
		if (position == 3){
			DrawCards2(card3shell,value,suit);
		}
		if (position == 4){
			DrawCards2(card4shell,value,suit);
		}
		if (position == 5){
			DrawCards2(card5shell,value,suit);
		}
	}

	public void DrawCards2(JLabel Label, String value,String suit){

		if (value.equals("K") && suit.equals("S")){
		Label.setIcon(cardKS);}if (value.equals("Q") && suit.equals("S")){
		Label.setIcon(cardQS);}if (value.equals("J") && suit.equals("S")){
		Label.setIcon(cardJS);}if (value.equals("X") && suit.equals("S")){
		Label.setIcon(card10S);}if (value.equals("9") && suit.equals("S")){
		Label.setIcon(card9S);}if (value.equals("8") && suit.equals("S")){
		Label.setIcon(card8S);}if (value.equals("7") && suit.equals("S")){
		Label.setIcon(card7S);}if (value.equals("6") && suit.equals("S")){
		Label.setIcon(card6S);}if (value.equals("5") && suit.equals("S")){
		Label.setIcon(card5S);}if (value.equals("4") && suit.equals("S")){
		Label.setIcon(card4S);}if (value.equals("3") && suit.equals("S")){
		Label.setIcon(card3S);}if (value.equals("2") && suit.equals("S")){
		Label.setIcon(card2S);}if (value.equals("A") && suit.equals("S")){
		Label.setIcon(cardAS);}

		if (value.equals("K") && suit.equals("C")){
		Label.setIcon(cardKC);}if (value.equals("Q") && suit.equals("C")){
		Label.setIcon(cardQC);}if (value.equals("J") && suit.equals("C")){
		Label.setIcon(cardJC);}if (value.equals("X") && suit.equals("C")){
		Label.setIcon(card10C);}if (value.equals("9") && suit.equals("C")){
		Label.setIcon(card9C);}if (value.equals("8") && suit.equals("C")){
		Label.setIcon(card8C);}if (value.equals("7") && suit.equals("C")){
		Label.setIcon(card7C);}if (value.equals("6") && suit.equals("C")){
		Label.setIcon(card6C);}if (value.equals("5") && suit.equals("C")){
		Label.setIcon(card5C);}if (value.equals("4") && suit.equals("C")){
		Label.setIcon(card4C);}if (value.equals("3") && suit.equals("C")){
		Label.setIcon(card3C);}if (value.equals("2") && suit.equals("C")){
		Label.setIcon(card2C);}if (value.equals("A") && suit.equals("C")){
		Label.setIcon(cardAC);}

		if (value.equals("K") && suit.equals("H")){
		Label.setIcon(cardKH);}if (value.equals("Q") && suit.equals("H")){
		Label.setIcon(cardQH);}if (value.equals("J") && suit.equals("H")){
		Label.setIcon(cardJH);}if (value.equals("X") && suit.equals("H")){
		Label.setIcon(card10H);}if (value.equals("9") && suit.equals("H")){
		Label.setIcon(card9H);}if (value.equals("8") && suit.equals("H")){
		Label.setIcon(card8H);}if (value.equals("7") && suit.equals("H")){
		Label.setIcon(card7H);}if (value.equals("6") && suit.equals("H")){
		Label.setIcon(card6H);}if (value.equals("5") && suit.equals("H")){
		Label.setIcon(card5H);}if (value.equals("4") && suit.equals("H")){
		Label.setIcon(card4H);}if (value.equals("3") && suit.equals("H")){
		Label.setIcon(card3H);}if (value.equals("2") && suit.equals("H")){
		Label.setIcon(card2H);}if (value.equals("A") && suit.equals("H")){
		Label.setIcon(cardAH);}

		if (value.equals("K") && suit.equals("D")){
		Label.setIcon(cardKD);}if (value.equals("Q") && suit.equals("D")){
		Label.setIcon(cardQD);}if (value.equals("J") && suit.equals("D")){
		Label.setIcon(cardJD);}if (value.equals("X") && suit.equals("D")){
		Label.setIcon(card10D);}if (value.equals("9") && suit.equals("D")){
		Label.setIcon(card9D);}if (value.equals("8") && suit.equals("D")){
		Label.setIcon(card8D);}if (value.equals("7") && suit.equals("D")){
		Label.setIcon(card7D);}if (value.equals("6") && suit.equals("D")){
		Label.setIcon(card6D);}if (value.equals("5") && suit.equals("D")){
		Label.setIcon(card5D);}if (value.equals("4") && suit.equals("D")){
		Label.setIcon(card4D);}if (value.equals("3") && suit.equals("D")){
		Label.setIcon(card3D);}if (value.equals("2") && suit.equals("D")){
		Label.setIcon(card2D);}if (value.equals("A") && suit.equals("D")){
		Label.setIcon(cardAD);}


	}



	public void UpdateState(){
	UpdateCards();
	String gamename = "BlackJack";
	updating = true;

	sendMessage(new ChatMessage(ChatMessage.RETRIEVE, username, gamename, 0, 0));


	String reply = CurrentMessage;

	ConsoleOutput.setText(reply);



	}





public void actionPerformed(ActionEvent e)
{
CardLayout cardLayout = (CardLayout) cards.getLayout();
Object eventtype = e.getSource();
layoutmaker(cardLayout, eventtype);

}
public static void main(String args[])
{

new onlineGame5(); // This calls the constructor and runs it

}


}
