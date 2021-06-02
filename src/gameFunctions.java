
public class gameFunctions extends camelGame{

	//additional variables for Word method 
	int correct = 16 - errorCounter;
	int cnt = 0;
	
	//additional variables for the camelGame
		private int trap;
	    private final int Max_Trap = 300;
		private final int Min_Trap = 1;
		
		private int poisonSnake;
		private final int Max_Poison = 1000;
		private final int Min_Poison = 1;
		
	//This class Overrides the Camel method and increases the difficulty by adding traps 
	public void Camel() 
	{

		System.out.println("\nWelcome to the Camel game, you have stolen a camel to make your way");
		System.out.println("across the great Mobi dessert. The natives want their cammel back ");
		System.out.println("and are chasing you down! Survive your dessert trek and out run the natives.");
		
		while(!done)
		{
			System.out.println("\n=============================");
			System.out.println("***This is the camel game menu***");
			System.out.println("A. Drink from canteen");
			System.out.println("B. Ahead moderate speed");
			System.out.println("C. Ahead full speed");
			System.out.println("D. Stop for the night");
			System.out.println("E. Status Check");
			System.out.println("Your choice?");
			
			choice = Input.nextLine();
			
			switch(choice.toUpperCase())
			{
				case "A":
					if(canteen!= 0)
					{
						--canteen;
						thirst = 0;
						System.out.println("You have " + canteen + " canteens left");
					}
					else
					{
						System.out.println("You dont have any water left");
					}
					
					break;
					
				//---------------------------------------
				case "B":
					
					thirst++;
					camelTiredness++;
					miles = (int) (Math.random() * ((Max_Miles - Min_Miles + 1))) + Min_Miles;
					milesTraveled += miles;
					
					natives = (int) (Math.random() * ((MAX_NATIVE - MIN_NATIVE + 1))) + MIN_NATIVE;
					nativeDistance += natives;
					
					System.out.println("You traveled " + milesTraveled + " miles");
					
					//Determine whether the camel is tired or dies
					if(camelTiredness >=6 && camelTiredness <= 8)
					{
						System.out.println("your camel is getting tired");
					}
					else if(camelTiredness > 8)
					{
						System.out.println("Your camel is dead"); 
						done = true;
					}
					
					//Determine if the user is thirsty or dies of thirst
					if(thirst >= 5 && thirst <= 6)
					{
						System.out.println("You are thirsty");
					}
					else if(thirst > 6)
					{
						done = true;
						System.out.println("You died of thirst");
					}
					
					//Tells you if you are captured by the natives or if they are catching up
					if(nativeDistance >= milesTraveled)
					{
						System.out.println("You were captured by the natives");
						done = true;
					}
					else if(milesTraveled - nativeDistance < 15)
					{
						System.out.println("The natives are getting close!");
					}
					
					//chance of finding an oasis
					oasis = (int) (Math.random() * ((Max_Oasis - Min_Oasis+1))) + Min_Oasis;
					
					if(oasis % 20 == 0 && thirst <= 6 && camelTiredness <= 8)
					{
						System.out.println("You have found an oasis, all your stats willl be reset to 0");
						thirst = 0;
						camelTiredness = 0;
						canteen = 3;
					}
					
					//chances to getting  in a trap 
					trap = (int) (Math.random() * ((Max_Trap - Min_Trap+1))) +Min_Trap;
					
					if(trap % 30 == 0 && thirst <= 6 && camelTiredness <= 8)
					{
						System.out.println("You have been caught in a trap, the natives got closer while you escaped");
						natives = (int) (Math.random() * ((MAX_NATIVE - MIN_NATIVE + 1))) + MIN_NATIVE;
						nativeDistance += natives;
					}
					
					
					//chances of getting poisoned
					poisonSnake = (int) (Math.random() * ((Max_Poison - Min_Poison+1))) + Min_Poison;
					
					if(poisonSnake % 20 == 0 && thirst <= 6 && camelTiredness <= 8)
					{
						System.out.println("You were killed by a venomous snake");
						done = true;
					}
					
					//This statement tells the user if he escaped the desert 
					if(milesTraveled >= 200 && nativeDistance < milesTraveled && thirst <= 6 && camelTiredness <= 8)
					{
						System.out.println("Congratulations, you escaped the dessert!");
						done = true;
					}
					break;
					
					
				case "C":
					
					thirst++;
					tiredness = (int) (Math.random() * ((Max_Tiredness - Min_Tiredness + 1))) + Min_Tiredness;
					camelTiredness += tiredness;
					
					fullSpeed = (int) (Math.random() * ((Max_Speed - Min_Speed+1)))+ Min_Speed;
					milesTraveled += fullSpeed;
					
					natives = (int) (Math.random() *((MAX_NATIVE - MIN_NATIVE + 1))) + MIN_NATIVE;
					nativeDistance += natives;
					
					System.out.println("You traveled " + milesTraveled + " miles");
					
					//Determine whether the camel is tired or dies
					if(camelTiredness >=6 && camelTiredness <= 8)
					{
						System.out.println("your camel is getting tired");
					}
					else if(camelTiredness > 8)
					{
						System.out.println("Your camel is dead"); 
						done = true;
					}
					
					//Determine if the user is thirsty or dies of thirst
					if(thirst >= 5 && thirst <= 6)
					{
						System.out.println("You are thirsty");
					}
					else if(thirst > 6)
					{
						done = true;
						System.out.println("You died of thirst");
					}
					
					//Tells you if you are captured by the natives or if they are catching up
					if(nativeDistance >= milesTraveled)
					{
						System.out.println("You were captured by the natives");
						done = true;
					}
					else if(milesTraveled - nativeDistance < 15)
					{
						System.out.println("The natives are getting close!");
					}
					
					//chance of finding an oasis
					oasis = (int) (Math.random() * ((Max_Oasis - Min_Oasis+1))) + Min_Oasis;
					
					if(oasis % 20 == 0 && thirst <= 6 && camelTiredness <= 8)
					{
						System.out.println("You have found an oasis, all your stats willl be reset to 0");
						thirst = 0;
						camelTiredness = 0;
						canteen = 3;
					}
					
					//chances to getting  in a trap 
					trap = (int) (Math.random() * ((Max_Trap - Min_Trap+1))) +Min_Trap;
					
					if(trap % 30 == 0 && thirst <= 6 && camelTiredness <= 8)
					{
						System.out.println("You have been caught in a trap, the natives got closer while you escaped");
						natives = (int) (Math.random() * ((MAX_NATIVE - MIN_NATIVE + 1))) + MIN_NATIVE;
						nativeDistance += natives;
					}
					
					//chances of getting poisoned
					poisonSnake = (int) (Math.random() * ((Max_Poison - Min_Poison+1))) + Min_Poison;
					
					if(poisonSnake % 20 == 0 && thirst <= 6 && camelTiredness <= 8)
					{
						System.out.println("You were killed by a venomous snake");
						done = true;
					}
					
					//This statement tells the user if he escaped the desert 
					if(milesTraveled >= 200 && nativeDistance < milesTraveled && thirst <= 6 && camelTiredness <= 8)
					{
						System.out.println("Congratulations, you escaped the dessert!");
						done = true;
					}
					
					break;
					
				case "D":
					camelTiredness = 0;
					System.out.println("The camel is happy");
					
					//Tells you the distance the natives travel while resting 
					
					if(nativeDistance >= milesTraveled)
					{
						System.out.println("You were captured by the natives");
						done = true;
					}
					else if(milesTraveled - nativeDistance < 15)
					{
						System.out.println("The natives are getting close!");
					}
					break;
					
				case "E":
					System.out.println("Miles traveled " + milesTraveled);
					System.out.println("Drink in canteen " + canteen);
					System.out.println("The natives are " + nativeDistance + " miles behind you");
					
					break;
						
					
				default:
					 System.out.println("That option is not available in the menu. Please re-enter your choice.");
				     choice = Input.nextLine();
					break;
			}	
		}
	}
	
	

	}

