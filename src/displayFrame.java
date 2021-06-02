//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner; //used to read the file
public class displayFrame extends addObservation{

	
	
	public void display()
	{
		System.out.printf("%4s", "ID");
		System.out.printf(" %6s", "State");
		System.out.printf(" %21s", "County");
		System.out.printf(" %11s", "Total Votes");
		System.out.printf(" %9s", "Dem Votes");
		System.out.printf(" %9s", "Rep Votes");
		System.out.printf(" %9s\n", "Dem share");
		System.out.println("---- ------ --------------------- ----------- --------- --------- ---------");
		for(int i = 0; i <= lines; i++)
		{
			if(readable[i] == true)
			{
			System.out.printf("%4s", id[i]);
			System.out.printf(" %6s", state[i]);
			System.out.printf(" %21s", county[i]);
			System.out.printf(" %11s", total_votes[i]);
			System.out.printf(" %9s", dem_Votes[i]);
			System.out.printf(" %9s", rep_Votes[i]);
			System.out.printf(" %9s\n", dem_Share[i]);
			}
		}
		
	  }
	
   }



	


