
import java.io.FileNotFoundException;


//import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener{
	
	//instance fields 
	private String option;
	public static int timesPlayed = 0; //This variable will be used to determine the number of times program is used
	protected static int Loaded = 0;
	public boolean test = false;
	
	//instance fields for the GUI
	JPanel panel;   //Panel for the main menu
	JButton boton1; //Button for the first option
	JButton boton2; //Button for the second sub-menu
	JButton boton3; //Button for the third sub-menu
	JButton boton4; //Button to exit the program
	JLabel message; //used to tell the user to pick an option and the number of times the program was used
	
	
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		// TODO Auto-generated method stub
		option = event.getActionCommand();
		
	     
		while(!test)
		{
			 if (option.equals("A. Mathematical Expressions"))
			 {
				dispose();
				 //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 try {
					 
					mathExpression z = new mathExpression();
					
					}
				 
				catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 test = mathExpression.probar;
				 	 
			 }
			 
			 else if(option.equals("B. Skill Games"))
			 {
				 
				 dispose();
			 
			  
				 try {
						skillGames a = new skillGames();
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				 test = mathExpression.probar;
				
			 }
			 
			 else if(option.equals("C. Core Data Analyzer Application"))
			 {
				 //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 dispose();
				 try {
					 	coreData w = new coreData();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				 test = mathExpression.probar;
			 }
			 
			 else if(option.equals("D. Exit"))
			 {
				JOptionPane.showMessageDialog(panel,"You used the program " + timesPlayed + " time(s)");
				System.exit(0); //this stops the code from running
				 //test = true;
				
			 }
			
		}
			
		}
	
	//This is the main menu of the program
		public Menu() throws FileNotFoundException 
		{
			
			panel = new JPanel(null);	
			boton1 = new JButton("A. Mathematical Expressions");
			boton2 = new JButton("B. Skill Games");
			boton3 = new JButton("C. Core Data Analyzer Application");
			boton4 = new JButton("D. Exit");
			
			boton1.addActionListener(this);
			boton1.setBounds(110, 20, 210, 30);
			
			boton2.addActionListener(this);
			boton2.setBounds(110, 60, 150, 30);
			
			boton3.addActionListener(this);
			boton3.setBounds(110, 100, 230, 30);
			
			boton4.addActionListener(this);
			boton4.setBounds(110, 140, 150, 30);
			
			message = new JLabel("Please click an option");
			message.setBounds(110, 180,150 ,30);
			
			
			panel.add(boton1);
			panel.add(boton2);
			panel.add(boton3);
			panel.add(boton4);
			panel.add(message);
			
			//window.add(panel,BorderLayout.CENTER);
			this.add(panel);
			
	        setTitle("Main Menu");
			
			setSize(500,250);	
		}

	
		
	
	//This static method counts the amount of times the program is used throughout the different sub-menus
		public static int timesPlayed()
		{
			return timesPlayed; 
		}
	
		
}
