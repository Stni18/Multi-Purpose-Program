
public class decimalConvert
{
	/*Constructor: 
    Input: 1
       base: represents the base n in which the number will be converted to decimal
 */        
 private int base;
  
 public decimalConvert (int base)
 {
    this.base = base; //Will invoke the constructor from BaseConvert Class
 }
 
 /* Method: base2Dec
    Description: Converts from a base n number to a base n where 0 < n < 10 (binary and octal)
    Inputs: 1
       number: represents the base n number that will be converted
    Outputs: 1
       number: At the end, the variable number will be the number converted to the decimal
 */
 public int base2Dec (String number)
 {
    char numArray[] = number.toCharArray();
    int numLength = numArray.length - 1,
        decimal = 0;
    int digit;    
      
    for (int i = 0; i < numArray.length; i++)
    {
       //Will convert from char to int
       if (Character.isLetter(numArray[i]))
       {
          digit = Integer.valueOf(Character.toUpperCase(numArray[i])) - 55;
       }
       else
       {
          digit = Integer.valueOf(String.valueOf(numArray[i]));
       }
        
       decimal += (digit * Math.pow(base, numLength));
       numLength--;
    }
    
    return decimal;
 }
}
