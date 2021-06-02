import java.util.Scanner;
public class findState extends displayFrame{

	private String State;
    private boolean found = false;
    Scanner data = new Scanner(System.in);
    
    //searches for observations with a matching state 
	public void State()
	{	  
		  System.out.println("FINDING AN OBSERVATION BY STATE"); 
		  System.out.println("---------------------------------------------------");

		 System.out.println("Enter STATE name: ");
		 State = data.nextLine();
		 System.out.println("---------------------------------------------------");  
		 
		
		 //Displays header if condition is met 
		 for(int i = 0; i <= lines ; i++)
		  {
		    if(State.equals(state[i]) && readable[i]== true)
		    {
		    	System.out.printf("%4s", "ID ");
				System.out.printf(" %6s", "State");
				System.out.printf(" %21s", "County");
				System.out.printf(" %11s", "Total Votes");
				System.out.printf(" %9s", "Dem Votes");
				System.out.printf(" %9s", "Rep Votes");
				System.out.printf(" %9s\n", "Dem share");
		     System.out.println("---- ------ --------------------- ----------- --------- --------- ---------"); 
		     break;
		    }
		    
		   
		  } 
		 
		 for(int i = 0; i < 100 ; i ++)
		  {
			 if(State.equals(state[i]) && readable[i] == true)
			    {
		      
			 		System.out.printf("%4s", id[i]);
					System.out.printf(" %6s", state[i]);
					System.out.printf(" %21s", county[i]);
					System.out.printf(" %11s", total_votes[i]);
					System.out.printf(" %9s", dem_Votes[i]);
					System.out.printf(" %9s", rep_Votes[i]);
					System.out.printf(" %9s\n", dem_Share[i]);		
			    }
		 
		 	if(State.equals(state[i]) && readable[i] == true)
		 	{
		 		found = true;
		 	}
		  }
		 
		 if(found == true)
		  {
		    System.out.println("--------------------------------------------------------------------------"); 
		  }

		     if(found == false) 
		   {
		    System.out.println("Did not find an observation with that state!\n");  
		    System.out.println("---------------------------------------------------");  
		   }
	}
}
