
public class BaseConvert 
{
	 //Parameters
	   private int base;
	   
	   /* Constructor: 
	      Input: 1
	         base: represents the base n in which the decimal will be converted
	   */         
	   public BaseConvert (int base)
	   {
	      this.base = base;
	   }
	   
	   
	   /* Method: dec2Base
	      Description: Converts from a decimal number to a base n where 0 < n < 10 (binary and octal)
	      Inputs: 1
	         number: represents the decimal number that will be converted
	      Outputs: 1
	         number: At the end, the variable number will be the number converted to the base n
	   */
	   public String dec2Base(int number)
	   {
	      String num2Str = "";
	      int digits = baseDigits(number); //calculate how many digits has before decimal point based on its base.
	          
	      String residue[] = new String[digits];
	      
	      String new_number;
	      
	      for(int i = 0; i < digits; i++) //register residue
	      {
	         
	         
	         if (number % base >= 10)
	         {
	            residue[i] = String.valueOf(num2Letter(number % base));
	         }
	         
	         else
	         {
	            residue[i] = String.valueOf(number % base);
	         }
	         
	         number = number / base;
	      }
	      
	      for(int j = digits - 1; j >= 0; j--) //will put in order the converted number
	      {
	         num2Str = num2Str + String.valueOf(residue[j]);
	      }
	      
	      new_number = num2Str;
	      return(new_number);
	   }
	   
	   /* Method: baseDigits
	      Description: will determine how many digits are required for the conversion
	      Inputs: 1
	         number: represents the decimal number that will be converted
	      Output: 1
	         count: represents the total of digits required for the conversion
	   */
	   public int baseDigits (int number)
	   {
	      int count = 0;
	      boolean repeat = true;
	      do
	      {
	         if (number < (Math.pow(base, count)))
	         {
	            repeat = false;
	         }
	         else
	         {
	            count++;
	         }
	      } while (repeat);
	      
	      return (count);
	   }
	   
	   /* Method: num2Letter
	      Description: convert a number to a letter
	      Inputs: 1
	         number: represents the decimal number that will be converted
	      Output: 1
	         letter: represents the letter in which the number is converted to.
	   */
	   public String num2Letter (int numb)
	   {
		  int number = numb;
		  int reminder;
	      
	      char[] hexa = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	      String hexaValue = " ";
	      
	      while(number > 0)
	      {
	    	  reminder = number%16;
	    	  hexaValue = hexa[reminder] + hexaValue;
	    	  number  = number/16;
	      }

		 return hexaValue;
	   }

}
