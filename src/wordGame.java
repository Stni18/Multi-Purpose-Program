import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class wordGame {
	
	//initialization fields for wordGame
	//change encapsulation types to protected for when overriding   
	protected int errorCounter = 0;
	protected int easyMode = 10;
	protected boolean play = true;
	protected String answer;
	Scanner Input = new Scanner(System.in);
	
	//This method executes the wordGame, it was based on a previous project and part of its code was derived from a tutorial
	public void Word() throws FileNotFoundException
	{
		//errorCounter = 0;
			System.out.println("\nWelcome to the wordgame where you can be a millionare!");
			System.out.println("Think you got what it takes? The game is simple, it consist");
			System.out.println("of 21 rounds, if you have no failed attempts you will win one"); 
			System.out.println("million dollars. However, the prize money can vary pending on");
			System.out.println("the amount of wrong answers. This can vary from $1,000,000" );
			System.out.println("with no wrong answers. $500,000 with 3 wrongs or less and $250,000 with 4");
			System.out.println("to 5 wrong answers.\n");
					
			String fileName = "lettergame.csv";
			File file = new File(fileName);   //To read about file
			
			try
			{
				Scanner inputStream = new Scanner(file); 
				inputStream.nextLine(); //ignores the first line
				while(inputStream.hasNext()  && play == true )
				{
					String data = inputStream.nextLine(); //gets a whole line
					String values[] = data.split(",");
					System.out.println(values[0]);
					
					answer = Input.nextLine();
					int length = values.length;
					int n = 1;
						
						//if the answer is correct, while loop will not execute
						while(!values[n].equals(answer.toLowerCase()) && n < length)
						{
							n++;
							if(n == length)
							{
								break;
							}
						}
						//If the answer is correct, n should be less than the amount of answers.
						 if(n < length)
						{
							System.out.println("You are correct\n");
						}
						
						else
						{
							System.out.println("You got it wrong\n");
							errorCounter++;
						}	
						 
						if(errorCounter == 6)
						{
							System.out.println("You lose!");
							play = false;	
						}	
					}
					
				
				if(errorCounter == 0)
				{
					System.out.println("\nCongratulations You win $1000,000,000 ");
				}
				
				else if(errorCounter >=1 && errorCounter <= 3)
				{
					System.out.println("\nYou win $500,000 ");
				}
				
				if(errorCounter >= 4 && errorCounter < 6 )
				{
					System.out.println("\nYou win $250,000 ");
				}
				
				inputStream.close();
				
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
		}
		
	
		
		//Overload the Word method with easyMode variable, this limits it to 10 questions
		public void Word(int easy) throws FileNotFoundException 
		{
			errorCounter = 0;
			easy = easyMode;
			int cnt = 0;
			System.out.println("\nWelcome to the wordgame where you can be a millionare!");
			System.out.println("Think you got what it takes? The game is simple, ");
			System.out.println("It consist of 10 rounds, if you guess correctly and have "); 
			System.out.println("less than 3 failed attempts you win $250,000\n");
			
			
			String fileName = "lettergame.csv";
			File file = new File(fileName);        //To read about file
			
			
			try
			{
				Scanner inputStream = new Scanner(file); 
				inputStream.nextLine(); //ignores the first line
				while(inputStream.hasNext()&& cnt < easy && play == true && errorCounter <= 3)
				{
					String data = inputStream.nextLine(); //gets a whole line
					String values[] = data.split(",");
					System.out.println(values[0]);
					answer = Input.nextLine();
					
					int length = values.length;
				    int n = 1;
					
					while(!values[n].equals(answer.toLowerCase()) && n < length)
					{
						n++;
						if(n == length)
						{
							break;
						}
					}
					//If the answer is correct, n should be lower than the possible answers.
					if(n < length)
					{
						System.out.println("You are correct\n");
					}
					
					else
					{
						System.out.println("You got it wrong\n");
						errorCounter++;
					}	
					if(errorCounter == 3)
					{
						System.out.println("Too bad, you lose!");
						play = false;	
					}
					
					cnt++;
				}
				
			
			if(errorCounter < 3 )
			{
				System.out.println("\nContratulations, You win $250,000!");
			}
			
			inputStream.close();
					
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
		}
}
