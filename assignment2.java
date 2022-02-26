
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Bot extends JFrame{
	private JTextArea area = new JTextArea(); //Chat Area
	private JTextField field = new JTextField();//Chat Field
	private JButton button = new JButton();// The Button
	private JLabel label = new JLabel();// A label for the button (i.e., "return")
		
	Bot(){
		JFrame frame = new JFrame();
		frame.setSize(500,500); //SCREEN SIZE
		frame.setResizable(false); 
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.getContentPane();
		
		frame.setTitle("Team 30 - A COSC310 Virtual Assistant"); //Title

		//Adding the different methods - area, field, button, label
		frame.add(area);
		frame.add(field);
		frame.add(button);
		
		//AREA SETTINGS
		area.setSize(500,420); //SIZE
		area.setLocation(0,0); //LOCATION
		area.setBackground(Color.black); //BACKGROUND COLOR
		
		//FIELD SETTTINGS
		field.setSize(401,20);
		field.setLocation(1,420);
		
		//BUTTON SETTINGS
		button.setSize(500,60); //SIZE
		button.setLocation(400,420); //LOCATION
		
		//LABEL SETTING
		label.setText("RETURN"); //TEXT
		label.setAlignmentY(button.getAlignmentY()-2);
		button.add(label); //Assigning the Label to the Bottom 
		
		
		area.append("Welcome to Team 30's chatBot! Type 'menu' to see our options!"+"\n");
	
		//Adding Action Listener for the Button
		button.addActionListener((ActionListener) new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				//Getting text from user once BUTTON is pressed
				if(e.getSource()==button) {
					area.setForeground(Color.WHITE); //TEXT COLOR
					String userText = field.getText().toLowerCase();
					area.append("You: " + userText + "\n");
					field.setText("");
					
					
				
					//Greeting - Opening Message (0.0)
					if(userText.contains("hi")||userText.contains("hey")||userText.contains("hello")
							||userText.contains("howdy")||userText.contains("greetings")){
						reply("Hello! I am Team 30's Virtual Assistant"+"\n" + 
							"Chatbot: How can I help you today?"); //Opening REPLY
					}
					
					else if(userText.contains("menu")) {
						menu();
					}
					
					//TERMINATE PROGRAM
					else if(userText.contains("exit") || userText.contains("done")) { //keywords ('done' , 'exit')
						System.exit(10);  //Closing the program
					}
					
					//Forgot Password (1.0)
					else if(userText.contains("forgot") && userText.contains("password")) {
						select();
						email();
					}
					else if(userText.contains("@")) { //1.1 & 4.1
						reply("I just sent out the email! Please check your INBOX and SPAM folder");
						reply("is there anhing else I can help you with today?" +"n");
						reply("if NO, responde 'done' or 'exit' to terminate the program"); //0.0
						
					}
					
					//ORDERING A RIDE (2.0)
					else if(userText.contains("order") && userText.contains("ride")) {
						reply("Where would you like to order your ride from?" 
						+"\n"+"     Uber" //2.1
						+"\n"+"     Lyft" //2.2
						+"\n"+"     Cab"); //2.3
					}
					else if(userText.contains("Uber")) { //2.1
						reply("That's an excellent choice! Please answer a couple questions and we will book your request!"
								+"\n" +"Location - (for current - reply 'current location'" 
								+"\n" + "Time - (reply 'uber now' or alphabetical time");
					}
					else if(userText.contains("uber")||userText.contains("now")) { //2.1.1
						reply("Your UBER has been booked and is on its way!!"+"/n"+
								"is there anhing else I can help you with today?" +"n");
						reply("if NO, responde 'done' or 'exit' to terminate the program"); //0.0
					}
					else if(userText.contains("uber")||userText.contains("now")) { //2.1.1
						reply("Your UBER has been booked and is on its way!!"+"/n"+
								"is there anhing else I can help you with today?" +"n");
						reply("if NO, responde 'done' or 'exit' to terminate the program"); //0.0
					}
					
					//ORDERING FOOD (3.0)
					else if(userText.contains("order")&&userText.contains("food")) {
						reply("Where would you like to order your food from? (Reply with keyword (razor, tim, dora)'" 
						+"\n"+"(kelowna)     Skip the Dishes" //3.1
						+"\n"+"(seattle)     Uber Eats" //3.2
						+"\n"+"(berlin)   DoorDash"); //3.3
					}
					else if(userText.contains("seattle")||userText.contains("berlin")||userText.contains("kelowna")) { 
						reply("That's an excellent choice! A couple questions and we will book your request!"
								+"\n" +"Type of food: - (pizza, burger, indian food, or mexican food)'" //3.0.1, 3.0.2, 3.0.3, 3.0.4
								+"\n" + "Time - (reply  now' or alphabetical time"); //3.0.4
					}
					else if(userText.contains("pizza")&&userText.contains("now")) { //3.0.1
						reply("Your pizza is on its way!z");
						reply("If NO, respond 'done' or 'exit' to terminate the program"); //0.0
					}
					else if(userText.contains("burger")&&userText.contains("now")) { //3.0.2
						reply("Your burger is on its way! Is there anything else I can help you with?\"");
						reply("If NO, respond 'done' or 'exit' to terminate the program"); //0.0
					}
					else if(userText.contains("indian food")&&userText.contains("now")) { //3.0.3
						reply("Your indian food is on its way! Is there anything else I can help you with?");
						reply("If NO, respond 'done' or 'exit' to terminate the program"); //0.0
					}
					else if(userText.contains("mexican food")&&userText.contains("now")) { //3.0.4
						reply("Your mexican food is on its way! Is there anything else I can help you with?");
						reply("If NO, respond 'done' or 'exit' to terminate the program"); //0.0
					}
					
					//ACTIVATION LINK (4.0)
					else if(userText.contains("send activation link")) { 
						email();
					}
					
					//SPEAK TO REPRESENTATIVE (5.0)
					else if(userText.contains("speak") || userText.contains("representative")) { 
						reply("Sounds good! Let me see what your estimated wait time is");
						reply("Your estimated wait time is about 8 min! Would you like to proceed?");
						reply("If yes, please reply with the keyword ORANGE"); //5.1
					}
					else if(userText.contains("orange")) { //Simple keyword for specific path ('Orange') (5.2)
							reply("Sounds good, please input your phone number in the following format: "
									+"\n"+  "(XXX) XXX-XXXX "+"\n"+"and the next avaialable agent will get back to you " 
									+ "as soon as possible!");
					}
					else if(userText.contains("(") && userText.contains(")")){ //5.2.1
						reply("An agent will reach out to you shortly! Is there anything else I can help you with?");
						reply("If NO, respond 'done' or 'exit' to terminate the program"); //0.0
					}
					
					else 
						reply("Sorry, I had trouble understanding you there. " + "\n" + "Chatbot: Try rephrasing.");//INAVLID INPUT
				}
				
			}
			
		}); //CLOSING BRACKET for the function that adds the Action Listener to the button
		
	}
	//SELECT-one-of-the-following method
	public void select() {
		area.append("Chatbot: Sure!"+"\n");
	}
	//The REPLY METHOD
	public void reply(String input) {area.append("Chatbot: " + input + "\n");}
	
	//Email address
	public void email() {
		reply("Sounds good, please input your e-mail address.");
	}
	
	//Menu method
	public void menu() {
		area.append("     forgot my password"+"\n"); //1.0
		area.append("     order food"+"\n"); //2.0
		area.append("     order a ride"+"\n"); //3.0
		area.append("     send activation link"+"\n"); //4.0
		area.append("     speak to representative"+"\n"); //5.0
	}
}

public class assignment2  {
	public static void main (String[] args) {
		new Bot();
	}
	

	
}
