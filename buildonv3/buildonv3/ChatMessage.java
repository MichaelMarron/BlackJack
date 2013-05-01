
import java.io.*;
/*
 * This class defines the different type of messages that will be exchanged between the
 * Clients and the Server.
 * When talking from a Java Client to a Java Server a lot easier to pass Java objects, no
 * need to count bytes or to wait for a line feed at the end of the frame
 */
public class ChatMessage implements Serializable {

	protected static final long serialVersionUID = 1112122200L;

	// The different types of message sent by the Client
	// WHOISIN to receive the list of the users connected
	// MESSAGE an ordinary message
	// LOGOUT to disconnect from the Server
	static final int WHOISIN = 0, MESSAGE = 1, LOGOUT = 2, SETUSERNAME =3, ARRAY=4, RETRIEVE=5, CHANGE=6, LEAVE=7, DRAW =8, CHAT=9, NEW=10, JOIN=11, LIST=12;
	private int type;
	private String message;
	private String arrayname;
	private int value;
	private int target;

	// constructor
	ChatMessage(int type, String message, String arrayname, int target, int value) {
		this.type = type;
		this.message = message;
		this.arrayname = arrayname;
		this.target = target;
		this.value = value;

	}



	// getters
	int getType() {
		return type;
	}
	String getMessage() {
		return message;
	}
	String getArrayname() {
			return arrayname;
	}
	int getTarget() {
		return target;
	}
	int getValue() {
		return value;
	}
}

