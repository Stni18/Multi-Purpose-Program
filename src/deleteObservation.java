
import java.io.FileWriter; //allows to write to the file
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter; //Extension of file writer
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class deleteObservation extends saveObservation implements loadFile
{
	
	//Variables to delete file 
	 protected String  ID;
	 protected String State;
	 protected String County;
	 protected int totalVotes;
	 protected int demVotes;
	 protected int repVotes;
	 protected double demShare;
	  int lines; //This variable specifies the amount of observations found in the file
	  boolean found = false;
	  
	//variables to load the file
		protected String id[] = new String[200];
		protected String state[] = new String[200];
		protected String county[] = new String[200];
		protected String total_votes[] = new String[200];
		protected String dem_Votes[] = new String[200];
		protected String rep_Votes[] = new String[200];
		protected String dem_Share[] = new String[200];
		int i = 0;
		protected boolean readable[] = new boolean[200];
	 
	  //used to enter info
	  Scanner Observation = new Scanner(System.in);
	
	  //This method is gained from the interface loadFile
	  //File has a limit of 200 observations
	@Override
	public void load() 
	{
		// TODO Auto-generated method stub

		String fileName = "swingStatesDF.csv";
		File file = new File(fileName);        //To read about file
		
		try
		{
			Scanner inputStream = new Scanner(file); 
		
			while(inputStream.hasNext())
			{
				String data = inputStream.nextLine(); //gets a whole line
				String values[] = data.split(",");
				
				id[i] = values[0];
				state[i] = values[1];
				county[i] = values[2];
				total_votes[i] = values[3];
				dem_Votes[i] = values[4];
				rep_Votes[i] = values[5];
				dem_Share[i] = values[6];
				readable[i] = true;	
			    i++;
			    lines++; //counts the number of observations
			}
			System.out.println("\nObservations were loaded successfully\n");
			inputStream.close();
		}
		catch (FileNotFoundException e) //Throws exception error if file is not found
		{
			System.out.println("Could not load the file");
			e.printStackTrace();
		}
	}
	
	
	

	//This method deletes the observations from the swingStatesDF.csv file
	public void delete()
	{
//		load();
		System.out.println("DELETING AN OBSERVATION");
		System.out.println("---------------------------------------------------");  
		System.out.println("Enter an observation id: ");
		ID = Observation.next();
		System.out.println("---------------------------------------------------");  
		
		for(int i =0 ;i <= lines ;i++)
		{
			if(ID.equals(id[i]) && readable[i] == true)
			{
				readable[i] = false;
				System.out.printf("Deleting ");
				System.out.printf( state[i] + ", ");
				System.out.printf(county[i] + ", ");
				System.out.println(total_votes[i] + "... Done!" );	
				found = true;
			}
		}

			if(found == false)
			{
				System.out.println("Did not find that observation id");
				System.out.println("---------------------------------------------------");  
			}
	 Save();
	}

	//This method changes the observations in the file
	
			@Override
			public void Save()
			{
				// TODO Auto-generated method stub
				String filePath = "swingStatesDF.csv";
				String tempFile = "temp.csv"; //where the contents will be temporarily stored 
					
				
				try 
				{
					FileWriter Write = new FileWriter(tempFile, true);
					BufferedWriter buff = new BufferedWriter(Write);
					PrintWriter pw = new PrintWriter(buff);
					Observation = new Scanner(new File(filePath)); //reads all observations
					Observation.useDelimiter("[,\n]"); //tells program to write to other file separated by commas and new lines
					
					
					for(int i = 0; i < lines; i++)
					{
					
						if(Observation.hasNext() && readable[i] == true)
						{
							
							pw.printf(id[i] + "," + state[i] + "," + county[i] + "," + total_votes[i] + "," + dem_Votes[i] + ",");
							pw.println(rep_Votes[i] + "," + dem_Share[i]);	
						}	
						
					}
					
					
					//Erase contents of original file
					  PrintWriter wrote = new PrintWriter(filePath);
					  wrote.print("");
		     	      wrote.close();
				  

					  pw.flush(); //makes sure the data is written to the file
					  pw.close(); //closes the file stream
					  
		//---------------------------------------------------------------------------------------
					  FileReader fr = new FileReader("temp.csv");
					  BufferedReader br = new BufferedReader(fr);
					  FileWriter fw = new FileWriter("swingStatesDF.csv", true);
					  BufferedWriter Buff = new BufferedWriter(fw);
					  PrintWriter Print = new PrintWriter(Buff);
					  String s;
					  
					    while((s = br.readLine()) !=null)
					  {
					    	
					    Print.println(s);
							  
					  }
					    Print.flush();
					    Print.close();
					    
					   //Erase contents of copy file
						  PrintWriter erase = new PrintWriter(tempFile);
						  erase.print("");
			     	      erase.close();
			     	      br.close();

					System.out.println("Record Saved");
				}
				catch(Exception E)
				{
					System.out.println("Error, record not saved");
				}
					
			}
	
	
}
