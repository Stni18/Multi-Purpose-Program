import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class skillGames extends gameFunctions implements ActionListener{

	
		private String decision;
		
	 
		//instance fields for GUI
		JFrame gameFrame; //frame for the skill games
		JPanel gamePanel; //Panel for skill game components
		JButton botton1; //Button to use to play the camel game
		JButton botton2; //Used for the hard version of camel game
		JButton botton3; //This button plays the word game 
		JButton botton4; //Used for the hard version of word game
		JButton botton5; //Returns to the main menu
		JLabel Instruction;
		
		//This class contains the sub-menu for the games
		public skillGames() throws FileNotFoundException
		{		
			
			gamePanel = new JPanel(null);
			
			botton1 = new JButton("A. Camel game");
			botton2 = new JButton("B. Camel game - [Hard Mode]");
			botton3 = new JButton("C. Word game");
			botton4 = new JButton("D. Word game - [Hard Mode]");
			botton5 = new JButton("E. Return to the main menu");
			
			
			botton1.addActionListener(this);
			botton1.setBounds(100, 60, 150, 30);
			
			botton2.addActionListener(this);
			botton2.setBounds(100, 100, 215, 30);
			
			botton3.addActionListener(this);
			botton3.setBounds(100, 140, 150, 30);
			
			botton4.addActionListener(this);
			botton4.setBounds(100, 180, 215, 30);
			
			botton5.addActionListener(this);
		    botton5.setBounds(100, 220, 216, 30);
//				
			
		    Instruction = new JLabel("Please click one of the following options");
			Instruction.setBounds(100,260, 300,30);
			
			//gameFrame.setLayout(null);
			gameFrame = new JFrame("Skill Games");
			
			
			//add the components to the frame
		   
			gamePanel.add(botton1);
			gamePanel.add(botton2);
			gamePanel.add(botton3);
			gamePanel.add(botton4);
			gamePanel.add(botton5);
			gamePanel.add(Instruction);
			gameFrame.add(gamePanel);
			
			
			
			//gameFrame.setLocationRelativeTo(null);
			gameFrame.setSize(500, 360);
			gameFrame.setVisible(true);
			mathExpression.probar = true;
	    }

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			mathExpression.probar= false;
			decision = e.getActionCommand();
			
			while(!mathExpression.probar)
			{
				
				if(decision.equals("A. Camel game"))
				{
					gameFrame.dispose();
					camelGame easy = new camelGame();
		           	easy.Camel();
		           	Menu.timesPlayed++;
		           
				}
				gameFrame.setVisible(true);
				mathExpression.probar= true;
			//---------------------------------------------------------------------	
				
				if(decision.equals("B. Camel game - [Hard Mode]"))
				{
					gameFrame.dispose();
					Camel();
		           	Menu.timesPlayed++;      
				}
				gameFrame.setVisible(true);
				mathExpression.probar= true;
				
				//-----------------------------------------------------------------
				if(decision.equals("C. Word game"))
				{
					gameFrame.dispose();
					//surround with try catch to use this method
					 try 
				   {
						Word(easyMode);
					} catch (FileNotFoundException e1) 
					 {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		           	Menu.timesPlayed++; 
		           	mathExpression.probar= true;
				}
				gameFrame.setVisible(true);
				
				
				//-----------------------------------------------------------------
				if(decision.equals("D. Word game - [Hard Mode]"))
				{
					gameFrame.dispose();
					//try catch is used to execute the word method
					try 
					{
						Word();
					} 
					catch (FileNotFoundException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		           	Menu.timesPlayed++;  
				}
				gameFrame.setVisible(true);
				mathExpression.probar= true;
				//----------------------------------------------------------------
				if(decision.equals("E. Return to the main menu"))
				{
					//try catch is used to return to main menu
					gameFrame.dispose();
					Menu x;
					try {
						x = new Menu();
						x.setVisible(true);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					mathExpression.probar= true;
				}
			
				
			}

		}
		
}
