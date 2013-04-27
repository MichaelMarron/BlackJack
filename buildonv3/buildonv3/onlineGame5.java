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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
// Packages used in this program imported

public class onlineGame5 extends JFrame implements ActionListener
{

JPanel cards, logoPanel, cardPanel, logoPanel2;
JLabel logo, userNameLabel, passwordLabel, fName, lName, dOB, aLine1, aLine2;
JLabel city, postCode, eMail, cUsername, cPassword, welcomeLabel;
JLabel friendLabel, friendUsername, gamesMenuLabel, helpPageLabel, blackjackLabel;
JLabel blackjackRules, blackjackControls, pokerLabel, pokerRules, pokerControls;
JLabel blackjackBalance;
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



JTextArea ConsoleOutput;
JTextArea UserInstructions;

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
					System.out.println(msg);

					ConsoleOutput.setText(msg);

					System.out.print("> ");



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
getContentPane().add(logoPanel);
}

public void Card1Constructor(JPanel card1) //Card1 constructor
{
loginTitle = new TitledBorder("Login");
userNameLabel = new JLabel("USERNAME:");
userNameLabel.setFont(new Font("WhipSmart", Font.BOLD, 40));
userNameLabel.setForeground(Color.white);
passwordLabel = new JLabel("PASSWORD:");
passwordLabel.setFont(new Font("WhipSmart", Font.BOLD, 40));
passwordLabel.setForeground(Color.white);
userNameField = new JTextField(25);
passwordField = new JPasswordField(25);
userNameField.setPreferredSize(new Dimension(0,40));
passwordField.setPreferredSize(new Dimension(0,40));
submitLogin = new JButton("SUBMIT");
register = new JButton("Register");
register.addActionListener(this);
submitLogin.addActionListener(this);
card1.setBorder(loginTitle);
card1.setBackground(Color.magenta);
card1.add(userNameLabel);
card1.add(userNameField, "wrap");
card1.add(passwordLabel);
card1.add(passwordField,"wrap");
card1.add(submitLogin);
card1.add(register);
}

public void Card2Constructor(JPanel card2) //Card2 constructor
{
registerTitle = new TitledBorder("Registeration Page");
registerTitle.setTitleColor(Color.white);
fName = new JLabel("First Name:");
lName = new JLabel("Surename:");
dOB = new JLabel("Date of Birth");
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
card2.setBackground(Color.magenta);
card2.add(fName);
card2.add(fNameF, "wrap");
card2.add(lName);
card2.add(lNameF, "wrap");
card2.add(dOB);
card2.add(dOBF, "wrap");
card2.add(aLine1);
card2.add(aLine1F, "wrap");
card2.add(aLine2);
card2.add(aLine2F, "wrap");
card2.add(city);
card2.add(cityF, "wrap");
card2.add(postCode);
card2.add(postCodeF, "wrap");
card2.add(eMail);
card2.add(eMailF, "wrap");
card2.add(cUsername);
card2.add(cUsernameF, "wrap");
card2.add(cPassword);
card2.add(cPasswordF, "wrap");
card2.add(registerBack);
card2.add(submitRegister);
}



public void Card3Constructor(JPanel card3) //Card3 constructor
{
welcomeTitle = new TitledBorder("Main Page");
welcomeTitle.setTitleColor(Color.white);

welcomeLabel = new JLabel ("Welcome Back");

viewProfileB = new JButton ("View Profile");
gamesB = new JButton("Games");
leagueStatB = new JButton("League Statistics");
customB = new JButton("Custom Settings");
logoutB = new JButton("Logout");
ppvB = new JButton("Purchase Premium Version");
findFriend = new JButton("Find Friends");

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

JPanel card3LeaderBoard= new JPanel(new MigLayout ("insets 0 10 10 20"));
card3LeaderBoard.setBorder(welcomeTitle);
card3LeaderBoard.setPreferredSize(new Dimension(500, 400));
card3LeaderBoard.add(scroll);


card3.setBorder(welcomeTitle);
card3.setBackground(Color.magenta);

//welcomeLabel, viewProfileB, gamesB, leagueStatB, customB, logoutB, ppvB

card3.add(welcomeLabel, "growx, wrap");
card3.add(viewProfileB,"growx" );
card3.add(gamesB,"growx, wrap" );
card3.add(leagueStatB, "growx, wrap");
card3.add(logoutB,"growx, wrap");
card3.add(ppvB, "growx");
card3.add(findFriend, "growx, wrap");
card3.add(card3LeaderBoard);



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


        card4.setBorder(registerTitle);
        card4.setBackground(Color.magenta);

        card4.add(viewProfileUserName);
        card4.add(viewProfileAge);
        card4.add(viewProfileLocation);
        card4.add(viewProfileBio);
        card4.add(vPBack);
        card4.add(vPEdit);
        card4.add(vPFindFriends);



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
card6.setBackground(Color.magenta);

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
texas = new JButton("Texas Hold 'Em");
createAGame = new JButton("Create A Game");
newLeague = new JButton("New League");
gamesBack = new JButton("Home Page");

blackjack.addActionListener(this);
texas.addActionListener(this);
createAGame.addActionListener(this);
newLeague.addActionListener(this);
gamesBack.addActionListener(this);

card7.setBorder(gameMenuTitle);
card7.setBackground(Color.magenta);

card7.add(gamesMenuLabel, "growx, wrap");
card7.add(blackjack, "growx");
card7.add(texas, "growx, wrap");
card7.add(createAGame, "growx");
card7.add(newLeague, "growx, wrap");
card7.add(gamesBack, "growx");



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
card8.setBackground(Color.magenta);

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

UserInstructions.setPreferredSize(new Dimension(250,100));
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
card9.add(blackjackBack, "growx, wrap");
//card9.add(ConsoleOutput, "growx");
card9.add(blackjackDeal, "growx, wrap");
card9.add(blackjackHit, "growx, wrap");
card9.add(blackjackStick, "growx, wrap");
card9.add(blackjackRefresh2, "growx, wrap");
card9.add(UserInstructions, "growx, wrap");


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

card10.setBackground(Color.magenta);



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
card11.setBackground(Color.magenta);

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
card12.setBackground(Color.magenta);



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
card13.setBackground(Color.magenta);



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
card14.setBackground(Color.magenta);

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

card15.setBackground(Color.magenta);


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














public onlineGame5() //This is the CONSTRUCTOR method
{



//The entry point into your program
setLayout(new FlowLayout()); //Use this for now.
setSize(810, 640); //Set the size of the JFrame
setTitle("Generic Online Card Game"); //Put Title on top of JFrame
getContentPane().setBackground(Color.black);
setResizable(true);


//LOGO PANEL
logoPanel();


cards = new JPanel(new CardLayout());
cards.setPreferredSize(new Dimension(810, 500));



JPanel card1 = new JPanel(new MigLayout());
JPanel card2 = new JPanel(new MigLayout());
JPanel card3 = new JPanel(new MigLayout("wrap 5","[200!]","[50!]"));
JPanel card4 = new JPanel(new MigLayout());
JPanel card5 = new JPanel(new MigLayout());
JPanel card6 = new JPanel(new MigLayout("wrap 5", "[200!]", "[50!]"));
JPanel card7 = new JPanel(new MigLayout("wrap 5", "[200!]", "[50!]"));
JPanel card8 = new JPanel(new MigLayout("wrap 5", "[200!]", "[50!]"));
//JPanel card9 = new JPanel(new MigLayout());
JPanel card9 = new JPanel(new MigLayout("wrap 1", "[800!]", "[::200]"));
JPanel card10 = new JPanel(new MigLayout(	      "",           // Layout Constraints
	      "20[]20[]20[]20[]20[]20[]20[]20[]20[]",   // Column constraints
	      "[]20[]20[]20[]20[]20[]20[]20[]20[]20[]"));
JPanel card11 = new JPanel(new MigLayout("wrap 5", "[200!]", "[50!]"));
JPanel card12 = new JPanel(new MigLayout(	      "",           // Layout Constraints
	      "20[]20[]20[]20[]20[]20[]20[]20[]100[]",   // Column constraints
	      "[]20[]20[]20[]20[]20[]20[]20[]20[]20[]"));
JPanel card13 = new JPanel(new MigLayout(	      "",           // Layout Constraints
	      "20[]20[]20[]20[]20[]20[]20[]20[]50[]",   // Column constraints
	      "[]20[]20[]20[]20[]20[]20[]20[]20[]20[]"));
JPanel card14 = new JPanel(new MigLayout(	      "",           // Layout Constraints
	      "20[]20[]20[]20[]20[]20[]20[]20[]20[]",   // Column constraints
	      "[]20[]20[]20[]20[]20[]20[]20[]20[]20[]"));
JPanel card15 = new JPanel(new MigLayout(	      "",           // Layout Constraints
	      "20[]20[]20[]20[]20[]20[]20[]20[]20[]",   // Column constraints
	      "[]20[]20[]20[]20[]20[]20[]20[]20[]20[]"));

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
cards.add(card14, "createAgameBlackjack");
cards.add(card15, "createAgamePoker");



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
                System.out.println("Correct username & password");
                Boolean Attempt =  ConnectToServer();
                if (Attempt == true){
                    cardLayout.show(cards, "welcome");
                }
            }
            else
            {
                System.out.println("Wrong username & password");
            }
	}
	if (eventtype== register){
	cardLayout.show(cards, "register");}
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

	if (eventtype== findFriend){
	cardLayout.show(cards, "find-friends");}

	if (eventtype== findFriendBack){
	cardLayout.show(cards, "welcome");}

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
		UpdateState();
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



	public void UpdateState(){
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
