
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class coreData extends findState implements ActionListener{

	
	JFrame coreFrame; //Contains the frame for this sub menu
	JPanel corePanel; //panel for the coredata sub menu
	JButton botton1; //This button loads the observations
	JButton botton2; //This button displays the observations
	JButton botton3; //This button searches a observation by state 
	JButton botton4; //Used to delete an observation
	JButton botton5; //Used to add a observation to the file
	JButton botton6; //Returns to the main menu
	JLabel Explination;
	
	String choice;
	
	public coreData() throws FileNotFoundException 
	{			
		corePanel = new JPanel(null);
		
		botton1 = new JButton("A. Load File");
		botton2 = new JButton("B. Display Observations");
		botton3 = new JButton("C. Find Observations by State");
		botton4 = new JButton("D. Delete a Observation");
		botton5 = new JButton("E. Add a Observation");
		botton6 = new JButton("F. Return to the main menu");
		
		
		botton1.addActionListener(this);
		botton1.setBounds(100, 60, 216, 30);
		
		botton2.addActionListener(this);
		botton2.setBounds(100, 100, 216, 30);
		
		botton3.addActionListener(this);
		botton3.setBounds(100, 140, 216, 30);
		
		botton4.addActionListener(this);
		botton4.setBounds(100, 180, 216, 30);
		
		botton5.addActionListener(this);
	    botton5.setBounds(100, 220, 216, 30);
			
		    
	    botton6.addActionListener(this);
	    botton6.setBounds(100, 260, 216, 30);
			
		     
	    Explination = new JLabel("Please click one of the following options");
		Explination.setBounds(100,300, 240,30);
		
		
		coreFrame = new JFrame("Core Data Analyzer Application");
		
	   
		corePanel.add(botton1);
		corePanel.add(botton2);
		corePanel.add(botton3);
		corePanel.add(botton4);
		corePanel.add(botton5);
		corePanel.add(botton6);
		corePanel.add(Explination);
		coreFrame.add(corePanel);
			
		
		coreFrame.setSize(500, 400);
		coreFrame.setVisible(true);
		mathExpression.probar = true;
		
		
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		mathExpression.probar= false;
		choice = e.getActionCommand();
		
		
		while(!mathExpression.probar)
		{
			
			if(choice.equals("A. Load File"))
			{
				coreFrame.dispose();
				System.out.println("LOADING FROM FILE");
        		System.out.println("------------------------------\n");
            	load();
            	Menu.Loaded++; //access the Loaded variable in a static way
	           	Menu.timesPlayed++;
	           	//condition = true;  
			}
			coreFrame.setVisible(true);
			mathExpression.probar= true;
			
			
			if(choice.equals("B. Display Observations"))
			{
				coreFrame.dispose();
				if(Menu.Loaded >0)
	            	{
	                display();
	            	}
	            	else 
	            	{
	            	  System.out.println("File has not been loaded"); 
	            	}
	           	Menu.timesPlayed++;
	           	
			}
			mathExpression.probar= true;
			coreFrame.setVisible(true);
			
			

			if(choice.equals("C. Find Observations by State"))
			{
				coreFrame.dispose();
				if(Menu.Loaded >0)
        		{
            	State();
        		}
                else 
            	{
            	  System.out.println("File has not been loaded"); 
            	}
	           	Menu.timesPlayed++;	
			}
			mathExpression.probar= true;
			coreFrame.setVisible(true);
			
			
			if(choice.equals("D. Delete a Observation"))
			{
				coreFrame.dispose();
				if(Menu.Loaded >0)
	         		{
	                delete();
	                Menu.timesPlayed++;
	         		}
	        		else 
	            	{
	            	  System.out.println("File has not been loaded"); 
	            	} 	
			}
			mathExpression.probar= true;
			coreFrame.setVisible(true);
			
			
			if(choice.equals("E. Add a Observation"))
			{
				coreFrame.dispose();
        		if(Menu.Loaded >0)
         		{
                add();
                Menu.timesPlayed++;
         		}
        		else 
            	{
            	  System.out.println("File has not been loaded"); 
            	}
			}
			mathExpression.probar= true;
			coreFrame.setVisible(true);
			
			if(choice.equals("F. Return to the main menu"))
			{
				coreFrame.dispose();
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
