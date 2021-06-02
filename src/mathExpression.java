import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class mathExpression extends JFrame implements ActionListener{
	
	//private String decision;
	
	String choice;
	String baseNumber;  //Decimal converted to n Base
	int number;     //Decimal number
	int base;       //Base in which the number will be converted 
	public static boolean probar = false;
	Scanner keyboard = new Scanner(System.in);
	boolean tried = false;
	
	//instance fields for GUI
	JPanel panel;
	JButton botton1; //Button to use Octal to decimal function
	JButton botton2; //Button to use Decimal to Octal function
	JButton botton3; //Button to convert Hexadecimal to Decimal 
	JButton botton4; //Button to convert from Hexadecimal to Decimal
	JButton botton5; //Button to convert from Decimal to Binary
	JButton botton6; //Button to convert from Binary to Decimal
	JButton botton7; //Button to return to the Main Menu JFrame
	JLabel message; //used to tell the user to pick an option and the number of times the program was used
	
	//instance fields for the conversion
	JFrame conversionLogic;
	JLabel Insert;
	TextField enter;
	JLabel result;
	JPanel logicsPanel;
	JButton Convert;
	JButton Close;

	public mathExpression() throws FileNotFoundException 
	{
		//first panel	
		panel = new JPanel(null);	
		botton1 = new JButton("A. Octal to decimal");
		botton2 = new JButton("B. Decimal to octal");
		botton3 = new JButton("C. Hexadecimal to decimal");
		botton4 = new JButton("D. Decimal to hexadecimal");
		botton5 = new JButton("E. Decimal to Binary");
		botton6 = new JButton("F. Binary to decimal");
		botton7 = new JButton("G. Return to the main menu");
		
		botton1.addActionListener(this);
		botton1.setBounds(110, 20, 190, 30);
		
		botton2.addActionListener(this);
		botton2.setBounds(110, 60, 190, 30);
		
		botton3.addActionListener(this);
		botton3.setBounds(110, 100, 190, 30);
		
		botton4.addActionListener(this);
		botton4.setBounds(110, 140, 190, 30);
		
		botton5.addActionListener(this);
		botton5.setBounds(110, 180, 190, 30);
		
		botton6.addActionListener(this);
		botton6.setBounds(110, 220, 190, 30);
		
		botton7.addActionListener(this);
		botton7.setBounds(110, 260, 190, 30);
		
		message = new JLabel("Click to execute a Logical Conversion");
		message.setBounds(110,300,216,30);
		
		//add the components to the panel
		panel.add(botton1);
		panel.add(botton2);
		panel.add(botton3);
		panel.add(botton4);
		panel.add(botton5);
		panel.add(botton6);
		panel.add(botton7);
		panel.add(message);
		
		this.add(panel);
		
		
        setTitle("Mathemathic Expression");
		
		setSize(520,450);
		setVisible(true);
		
		
		
		//Second panel to implement conversions
		logicsPanel = new JPanel();
		logicsPanel.setLayout(new FlowLayout());//add components from left to right
		
		conversionLogic = new JFrame("Logic Conversion");
		conversionLogic.setSize(400,300);
		
		Convert = new JButton("Convert");
		Convert.addActionListener(this); //allows this button to execute a function
		
		Close = new JButton("Close");
		Close.addActionListener(this); //allows the conversion to be stopped
		
		Insert = new JLabel();
		
		
		enter = new TextField(" ", 5);
		
		
		result = new JLabel();
		
		
		logicsPanel.add(Insert);
		logicsPanel.add(enter);
		logicsPanel.add(Convert);
		logicsPanel.add(result);
		logicsPanel.add(Close);
		conversionLogic.add(logicsPanel);
		
		probar = true;		
	}

	//-------------------------------------------------------------------------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		
		probar = false;
		choice = e.getActionCommand();
			
			if (choice.equals("A. Octal to decimal"))
			 {
				//conversionLogic.dispose();
				dispose(); //close the sub menu frame
				
				Insert.setText("Insert your Octal Number: ");
			   
				
				enter.setText(baseNumber);	
				conversionLogic.setVisible(true);
				Convert.setText("Convert");
			 }
			
				if(choice.equals("Convert")) 
				{
					baseNumber = enter.getText();
					decimalConvert decimal = new decimalConvert(8);
					number = decimal.base2Dec(baseNumber);
					result.setText("Octal to Decimal: " + number);
					Menu.timesPlayed++; 
					Close.setText("Close");
				}
				
				
				if(choice.equals("Close"))
				{
					conversionLogic.dispose();
					setVisible(true);
         			probar = true;
				}
				
				
	//----------------------------------------------------------------------------------------			
						
		  if (choice.equals("B. Decimal to octal"))
		 {
		   dispose();
		   Insert.setText("Insert your Decimal Number: ");
		   conversionLogic.setVisible(true); 
		   Convert.setText("Convert B");
		   enter.setText(baseNumber);
		 }
		  		
			if(choice.equals("Convert B")) 
			{  
			   number = Integer.parseInt(enter.getText());
			 
			  BaseConvert Base_convert = new BaseConvert(8);
		      baseNumber = Base_convert.dec2Base(number);
		      result.setText("Decimal to Octal: " +  Base_convert.dec2Base(number));
		      Menu.timesPlayed++;
		      Close.setText("Close B");
		   }
			
			 
			if(choice.equals("Close B"))
			{
				conversionLogic.dispose();
				setVisible(true);
				probar = true;
			}
//		//---------------------------------------------------------------------------------------
		
		if (choice.equals("C. Hexadecimal to decimal"))
		 {
			dispose();
			
			  Insert.setText("Insert a Hexadecimal value: ");
			  enter.setText(baseNumber);	
			 conversionLogic.setVisible(true);
			 Convert.setText("Convert C");
		      
		 }
			if(choice.equals("Convert C"))
			{
				baseNumber = enter.getText();
				decimalConvert dec = new decimalConvert(16);//Convert Base to Decimal
				  
				number = dec.base2Dec(baseNumber);
				result.setText("Hexadecimal to Decimal: " + number);
				Menu.timesPlayed++;
				Close.setText("Close C");
			 }
			
			if(choice.equals("Close C"))
				{
				  conversionLogic.dispose();
					setVisible(true);
					probar = true;
				}
		
		
		//--------------------------------------------------------------------------
		
		
		if (choice.equals("D. Decimal to hexadecimal"))
		 {
			dispose();
			
              Insert.setText("Insert your Decimal value: ");
			  conversionLogic.setVisible(true);
			  
			  enter.setText(baseNumber);
			  Convert.setText("Convert D");
		 }
		
			if(choice.equals("Convert D"))
			 {
				 number = Integer.parseInt(enter.getText());
				  BaseConvert base_convert = new BaseConvert(16); //Convert Decimal to Base
			      result.setText("Decimal to Hexadecimal: " + base_convert.num2Letter(number));
			      Menu.timesPlayed++;
			      Close.setText("Close D");
			 }
			
			if(choice.equals("Close D"))
			 {
				conversionLogic.dispose();
		 		setVisible(true);
		 		probar = true;
			 }
	//---------------------------------------------------------------------------------------		
		
		if (choice.equals("E. Decimal to Binary"))
		 {
			dispose();
			
		      Insert.setText("Insert your Decimal number: ");
		      
		      conversionLogic.setVisible(true);
			  
			  enter.setText(baseNumber);
			  Convert.setText("Convert E");
		 }
			  
		if(choice.equals("Convert E"))
		{
			number = Integer.parseInt(enter.getText());
		  BaseConvert Base = new BaseConvert(2); //Convert Decimal to Base
	      
	      baseNumber = Base.dec2Base(number);
	      
	      
	      result.setText("Decimal to Binary: " +  Base.dec2Base(number));
	      Menu.timesPlayed++;
	      Close.setText("Close E");
		 }
		
		if(choice.equals("Close E"))
		{
			conversionLogic.dispose();
			setVisible(true);
			probar = true;
		}
		 
//-----------------------------------------------------------------------------------------------		
		
		if (choice.equals("F. Binary to decimal"))
		{
			dispose(); 
			Insert.setText("Insert a Binary value: ");
		    enter.setText(baseNumber);
		    conversionLogic.setVisible(true);
		    Convert.setText("Convert F");
		 }
		
		if(choice.equals("Convert F")) 
		{
			baseNumber = enter.getText();
		    decimalConvert deci = new decimalConvert(2);//Convert Base to Decimal
			number = deci.base2Dec(baseNumber);
			result.setText("Binary to Decimal: " + number);
			Menu.timesPlayed++;
			Close.setText("Close F");
		 }
		
		if(choice.equals("Close F"))
		{
		   conversionLogic.dispose();
			setVisible(true);
			probar = true;
		}
		
		
	//--------------------------------------------------------------------------------------	
		if (choice.equals("G. Return to the main menu"))
		 {
			dispose();
			Menu x;
			try {
				x = new Menu();
				x.setVisible(true);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			probar = true;
		 }
		
		
	}

	
}
