
public class addObservation extends deleteObservation{
	
	//this method ads observations to the file
	public void add()
	{
		System.out.println("ADDING AN OBSERVATION");
		System.out.println("---------------------------------------------------"); 
		System.out.println("Enter an observation id: ");
		
		ID = Observation.nextLine();
		System.out.println("---------------------------------------------------"); 
		
		System.out.println("Enter state: ");
		State = Observation.nextLine();
		System.out.println("---------------------------------------------------");  
		
		System.out.println("Enter County: ");
		County = Observation.nextLine();
		System.out.println("---------------------------------------------------"); 
		
		System.out.println("Enter Total Votes: ");
		totalVotes = Observation.nextInt();
		
		System.out.println("---------------------------------------------------");  
		
		System.out.println("Enter Dem votes: ");
		demVotes = Observation.nextInt();
		
		System.out.println("---------------------------------------------------");  
		
		System.out.println("Enter Rep votes: ");
		repVotes = Observation.nextInt();
		
		
		
		System.out.println("---------------------------------------------------");  
		System.out.println("Enter Dem share: ");
		demShare = Observation.nextDouble();
		
		System.out.println("---------------------------------------------------");  
		
		for(int i = 0; i <= lines; i++)
		{
			if(ID.equals(id[i]) && readable[i] == true)
			{
				System.out.println("The observatioh " + ID + " already exist");
				break;
			}
			
			else if(!ID.equals(id[i]) && readable[i] == false)
		        {
				
		          id[i] = ID;
		          state[i] = State;
		          county[i] = County;
		          total_votes[i] = Integer.toString(totalVotes);
		          dem_Votes[i] = Integer.toString(demVotes);
		          rep_Votes[i] =  Integer.toString(repVotes);
		          dem_Share[i] =  Double.toString(demShare);
		          readable[i] = true;
		          
		         System.out.println(county[i] + " was added successfully!"); ;
		         System.out.println("---------------------------------------------------\n");
		         //Save();
		         break;
		        }
			
		}
	}
	
	
	
}
